/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestDlgController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form.PanelForm;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.DlgForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.servicios.DlgService;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;
import mx.gob.imss.cia.ssdc.cdv.vo.CdvDatoGeneralVo;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.RegistroCdvPaavVo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.richfaces.component.html.HtmlDataTable;

public class TestDlgController extends UnitTest {

	@InjectMocks
	private DlgController dlgController = new DlgController();

	@Mock
	private DlgForm dlgForm;

	@Mock
	private PanelForm panelForm;
	@Mock
	private BusquedaService busquedaService;

	@Mock
	private BackingBeanTable backingTable;

	@Mock
	private DlgService dlgService;
	@Mock
	private RegistroCdvPaavVo registrosCdvPaav;
	@Mock
	private CdvDatoGeneralVo detalleCdv;
	@Mock
	private Date fecha;
	@Mock
	private HtmlDataTable htmlDataTable;
	@Mock
	private List<RegistroCdvPaavVo> list;
	@Mock
	private ActionEvent e;

	@Before
	public void preparaLista() {
		list = new ArrayList<RegistroCdvPaavVo>();
		list.add(new RegistroCdvPaavVo());
		list.add(new RegistroCdvPaavVo());
		list.add(new RegistroCdvPaavVo());
		fecha = new Date();
	}

	@Test
	public void debieraExistirDlgController() throws Exception {
		assertNotNull(dlgController);
	}

	@Test
	public void deberiaInicializarDatosDePantalla() throws Exception {
		when(backingTable.getTableBinding()).thenReturn(htmlDataTable);
		dlgController.init();

	}

	@Test
	public void deberiaLlenarTablaCdvPaav() throws Exception {
		when(dlgService.obtenListadoRegistroCdvPaav(0, 0, 0, 0, 0)).thenReturn(
				list);
		when(registrosCdvPaav.getId()).thenReturn(1);
		when(registrosCdvPaav.getEstatus()).thenReturn("estatus");
		when(registrosCdvPaav.getNombre()).thenReturn("nombre");
		when(registrosCdvPaav.getTipo()).thenReturn("tipo");
		when(registrosCdvPaav.getFecha()).thenReturn(fecha);
		when(registrosCdvPaav.getReporte()).thenReturn("../../images/pdf.png");
		dlgController.llenarTablaCdvPaav();
		verify(dlgService).obtenListadoRegistroCdvPaav(0, 0, 0, 0, 0);
		List<RegistroCdvPaavVo> registroList = dlgService
				.obtenListadoRegistroCdvPaav(0, 0, 0, 0, 0);
		assertNotNull(registroList);
		assertFalse(registroList.isEmpty());

	}

	@Test
	public void deberiaLlenarDetalleCdvPaav() throws Exception {
		when(dlgForm.getId()).thenReturn(1L);
		when(dlgService.obtenerDetalleCdv(1L)).thenReturn(detalleCdv);
		when(detalleCdv.getCveCdv()).thenReturn(1L);
		when(detalleCdv.getDelegacion()).thenReturn("Df");
		when(detalleCdv.getTurno()).thenReturn("matutino");
		when(detalleCdv.getUnidad()).thenReturn("hgzm");
		when(detalleCdv.getVentanilla()).thenReturn("ventanilla1");

		dlgController.obtenerDetalleCdv();

		verify(dlgService).obtenerDetalleCdv(1L);
		verify(dlgForm).setDelegacionModal("Df");
		verify(dlgForm).setUnidadModal("hgzm");
		verify(dlgForm).setVentanillaModal("ventanilla1");
		verify(dlgForm).setTurnoModal("matutino");
	}

	@Test
	public void deberiaGenerarInforme() {
		String imgReporte = "../../images/pdf.png";
		dlgController.generarInforme(e);
		verify(dlgForm).setImgReporte(imgReporte);
	}

	@Test
	public void deberiaCrearCdv() {
		when(dlgForm.getId()).thenReturn(1L);
		when(dlgForm.getRazonModal()).thenReturn("razon");
		when(dlgForm.getFechaLimiteModal()).thenReturn(fecha);
		dlgController.guardarAutorizacionCambios();
		verify(dlgService).guardarAutorizacionCambios(1L, "razon", fecha);
	}

	@Test
	public void deberiaFiltrarComboporTipoRegistro() throws Exception {
		List<EstatusVo> listaEstatus = new ArrayList<EstatusVo>();
		EstatusVo vo = new EstatusVo();
		listaEstatus.add(vo);
		listaEstatus.add(vo);
		when(busquedaService.obtieneListadoEstatusPorTipoRegistro(new Long(0)))
				.thenReturn(listaEstatus);
		dlgController.filtrarComboEstatus();
		verify(busquedaService).obtieneListadoEstatusPorTipoRegistro(
				new Long(0));
		verify(panelForm).setComboEstatus(any(List.class));
	}

}
