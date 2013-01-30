/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestPadController.java
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form.PanelForm;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.PadForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.servicios.PadService;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;
import mx.gob.imss.cia.ssdc.cdv.vo.AnyoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.DelegacionVo;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.MesVo;
import mx.gob.imss.cia.ssdc.cdv.vo.RegistroCdvPaavVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoRegistroVo;
import mx.gob.imss.cia.ssdc.cdv.vo.UnidadVo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.richfaces.component.html.HtmlDataTable;

public class TestPadController extends UnitTest {

	@InjectMocks
	private PadController padController = new PadController();

	@Mock
	private BusquedaService busquedaService;

	@Mock
	private PadForm padForm;

	@Mock
	private PanelForm panelForm;

	@Mock
	private PadService padService;

	@Mock
	private RegistroCdvPaavVo registroVO;

	@Mock
	private HtmlDataTable htmlDataTable;

	@Mock
	private BackingBeanTable backingTable;

	private List<RegistroCdvPaavVo> lista;

	@Before
	public void perparaLista() {
		lista = new ArrayList<RegistroCdvPaavVo>();
		lista.add(registroVO);
		lista.add(registroVO);
	}

	@Test
	public void debieraExistirPadController() throws Exception {
		assertNotNull(padController);
	}

	@Test
	public void deberiaLlenarElComboTipo() throws Exception {
		List<TipoRegistroVo> registroLista = new ArrayList<TipoRegistroVo>();
		registroLista.add(mock(TipoRegistroVo.class));

		when(busquedaService.obtieneListadoTipo()).thenReturn(registroLista);

		padController.llenarComboTipo();

		verify(busquedaService).obtieneListadoTipo();
		verify(panelForm).setComboTipo(any(List.class));
	}

	@Test
	public void deberiaLlenarComboMes() throws Exception {
		List<MesVo> mesLista = new ArrayList<MesVo>();
		mesLista.add(mock(MesVo.class));
		when(busquedaService.obtieneListadoMes()).thenReturn(mesLista);

		padController.llenarComboMes();

		verify(busquedaService).obtieneListadoMes();
		verify(panelForm).setComboMes(any(List.class));

	}

	@Test
	public void deberiaLlenarElComboStatus() throws Exception {
		List<EstatusVo> statusLista = new ArrayList<EstatusVo>();
		statusLista.add(mock(EstatusVo.class));

		when(busquedaService.obtieneListadoEstatus()).thenReturn(statusLista);

		padController.llenarComboEstatus();

		verify(busquedaService).obtieneListadoEstatus();
		verify(panelForm).setComboEstatus(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboAnio() throws Exception {
		List<AnyoVo> statusLista = new ArrayList<AnyoVo>();
		statusLista.add(mock(AnyoVo.class));

		when(busquedaService.obtieneListadoAnyo()).thenReturn(statusLista);

		padController.llenarComboAnio();

		verify(busquedaService).obtieneListadoAnyo();
		verify(panelForm).setComboAnio(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboDelegacion() throws Exception {
		List<DelegacionVo> delegacionLista = new ArrayList<DelegacionVo>();
		delegacionLista.add(mock(DelegacionVo.class));
		when(busquedaService.obtieneListadoDelegacion()).thenReturn(
		        delegacionLista);

		padController.llenarComboDelegacion();

		verify(busquedaService).obtieneListadoDelegacion();
		verify(panelForm).setComboDelegacion(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboUnidad() throws Exception {
		List<UnidadVo> unidadLista = new ArrayList<UnidadVo>();
		unidadLista.add(mock(UnidadVo.class));
		when(busquedaService.obtieneListadoUnidad()).thenReturn(unidadLista);

		padController.llenarComboUnidad();

		verify(busquedaService).obtieneListadoUnidad();
		verify(panelForm).setComboUnidad(any(List.class));
	}

	@Test
	public void deberiaLlenarTabla() throws Exception {
		padController.cargarTabla();
		verify(padService).obtenListadoRegistroCdvPaav();
	}

	@Test
	public void deberiaInicializarLosComponentes() throws Exception {
		when(backingTable.getTableBinding()).thenReturn(htmlDataTable);

		padController.init();

		verify(padService).obtenListadoRegistroCdvPaav();
		// verify(padService).getNotificacionList();
	}
}
