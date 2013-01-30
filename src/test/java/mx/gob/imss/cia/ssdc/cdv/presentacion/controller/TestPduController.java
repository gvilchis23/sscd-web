/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestPduController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form.PanelForm;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.PduForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.servicios.PduService;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.RegistroCdvPaavVo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.richfaces.component.html.HtmlDataTable;

public class TestPduController extends UnitTest {

	@InjectMocks
	private PduController pduController = new PduController();
	@Mock
	private ActionEvent e;
	@Mock
	private PduForm pduForm;
	@Mock
	private PanelForm panelForm;
	@Mock
	private BackingBeanTable backingTable;
	@Mock
	private PduService pduService;
	@Mock
	private HtmlDataTable htmlDataTable;
	@Mock
	private RegistroCdvPaavVo registrosCdvPaav;
	@Mock
	private Date fecha;
	@Mock
	private BusquedaService busquedaService;

	private List<RegistroCdvPaavVo> list;

	@Before
	public void preparaListaTabla() {
		list = new ArrayList<RegistroCdvPaavVo>();
		list.add(registrosCdvPaav);
		list.add(registrosCdvPaav);
		list.add(registrosCdvPaav);
	}

	@Test
	public void debieraExistirPduController() throws Exception {
		assertNotNull(pduController);
	}

	@Test
	public void deberiaInicializarLosCombos() throws Exception {
		when(backingTable.getTableBinding()).thenReturn(htmlDataTable);
		pduController.init();
		// verify(pduController).llenarTablaCdvPaav();
	}

	@Test
	public void deberiaLlenarTablaCdvPaav() throws Exception {
		when(pduService.obtenListadoRegistroCdvPaav(0, 0, 0, 0)).thenReturn(
		        list);
		when(registrosCdvPaav.getId()).thenReturn(1);
		when(registrosCdvPaav.getEstatus()).thenReturn("estatus");
		when(registrosCdvPaav.getNombre()).thenReturn("nombre");
		when(registrosCdvPaav.getTipo()).thenReturn("tipo");
		when(registrosCdvPaav.getFecha()).thenReturn(fecha);
		when(registrosCdvPaav.getReporte()).thenReturn("../../images/pdf.png");
		pduController.llenarTablaCdvPaav();
		verify(pduService).obtenListadoRegistroCdvPaav(0, 0, 0, 0);
		verify(pduForm, times(3)).setId(new Long(1));
		verify(pduForm, times(3)).setEstatusTabla("estatus");
		verify(pduForm, times(3)).setNombre("nombre");
		verify(pduForm, times(3)).setTipoTabla("tipo");
		verify(pduForm, times(3)).setFecha(fecha);
		verify(pduForm, times(3)).setImgReporte("../../images/pdf.png");

	}

	@Test
	public void deberiaFiltrarComboporTipoRegistro() throws Exception {
		List<EstatusVo> listaEstatus = new ArrayList<EstatusVo>();
		EstatusVo vo = new EstatusVo();
		listaEstatus.add(vo);
		listaEstatus.add(vo);
		when(busquedaService.obtieneListadoEstatusPorTipoRegistro(new Long(0)))
		        .thenReturn(listaEstatus);
		pduController.filtrarComboEstatus();
		verify(busquedaService).obtieneListadoEstatusPorTipoRegistro(
		        new Long(0));
		verify(panelForm).setComboEstatus(any(List.class));
	}

	@Test
	public void deberiaGenerarInforme() {
		String imgReporte = "../../images/pdf.png";
		pduController.generarInforme(e);
		verify(pduForm).setImgReporte(imgReporte);
	}

	@Test
	public void deberiaCrearCdv() {
		pduController.crearCdv();
		verify(pduService).crearCdv(new Long(0), new Long(0), new Long(0),
		        new Long(0));
	}

	@Test
	public void deberiaEnviarCdv() {
		pduController.enviarCdv();
		verify(pduService).enviarCdv(new Long(0));

	}

	@Test
	public void deberiaEliminarCdv() {
		pduController.eliminarCdv();
		verify(pduService).eliminarCdv(new Long(0));
	}

}
