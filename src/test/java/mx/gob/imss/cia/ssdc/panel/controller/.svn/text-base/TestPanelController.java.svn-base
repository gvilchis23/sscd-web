/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestPanelController.java
 *
 * Creado:  08/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.panel.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form.PanelForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;
import mx.gob.imss.cia.ssdc.cdv.vo.AnyoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.DelegacionVo;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.MesVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoInformeVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoRegistroVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoVentanillaVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TurnoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.UnidadVo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author Gamaliel
 * 
 */
public class TestPanelController extends UnitTest {
	@InjectMocks
	private PanelController panelController = new PanelController();
	@Mock
	private PanelForm panelForm;
	@Mock
	private BusquedaService busquedaService;
	@Mock
	private TipoRegistroVo tipoRegistro;
	@Mock
	private MesVo mesVo;
	@Mock
	private AnyoVo anioVo;
	@Mock
	private EstatusVo estatusVo;
	@Mock
	private DelegacionVo delegacionVo;
	@Mock
	private TipoVentanillaVo tipoVentanillaVo;
	@Mock
	private UnidadVo unidadVo;
	@Mock
	private TurnoVo turnoVo;
	@Mock
	private TipoInformeVo tipoInformeVo;
	private List<TipoRegistroVo> listTipo;
	private List<MesVo> listaMes;
	private List<AnyoVo> listaAnio;
	private List<EstatusVo> listaEstatus;
	private List<DelegacionVo> listaDelegacion;
	private List<TipoVentanillaVo> listaTipoVentanilla;
	private List<UnidadVo> listaUnidades;
	private List<TurnoVo> listaTurnos;
	private List<TipoInformeVo> listaTipoInforme;
	private List<SelectItem> listaItem;

	@Before
	public void preparaListasCombos() {
		// Creando los objetos del Vo
		tipoRegistro = new TipoRegistroVo();
		mesVo = new MesVo();
		anioVo = new AnyoVo();
		estatusVo = new EstatusVo();
		delegacionVo = new DelegacionVo();
		tipoVentanillaVo = new TipoVentanillaVo();
		unidadVo = new UnidadVo();
		turnoVo = new TurnoVo();
		tipoInformeVo = new TipoInformeVo();
		// Creando los objetos de las listas de los combos
		listTipo = new ArrayList<TipoRegistroVo>();
		listaMes = new ArrayList<MesVo>();
		listaAnio = new ArrayList<AnyoVo>();
		listaEstatus = new ArrayList<EstatusVo>();
		listaDelegacion = new ArrayList<DelegacionVo>();
		listaTipoVentanilla = new ArrayList<TipoVentanillaVo>();
		listaUnidades = new ArrayList<UnidadVo>();
		listaTurnos = new ArrayList<TurnoVo>();
		listaTipoInforme = new ArrayList<TipoInformeVo>();
		// Agregando los vo a las listas
		listTipo.add(tipoRegistro);
		listTipo.add(tipoRegistro);
		listaMes.add(mesVo);
		listaMes.add(mesVo);
		listaAnio.add(anioVo);
		listaAnio.add(anioVo);
		listaEstatus.add(estatusVo);
		listaEstatus.add(estatusVo);
		listaDelegacion.add(delegacionVo);
		listaDelegacion.add(delegacionVo);
		listaTipoVentanilla.add(tipoVentanillaVo);
		listaTipoVentanilla.add(tipoVentanillaVo);
		listaUnidades.add(unidadVo);
		listaUnidades.add(unidadVo);
		listaTurnos.add(turnoVo);
		listaTurnos.add(turnoVo);
		listaTipoInforme.add(tipoInformeVo);
		listaTipoInforme.add(tipoInformeVo);
	}

	@Test
	public void debieraExistirPanelController() throws Exception {
		assertNotNull(panelController);
	}

	@Test
	public void deberiaLlenarElComboTipo() throws Exception {
		when(busquedaService.obtieneListadoTipo()).thenReturn(listTipo);
		panelController.llenarComboTipo();
		verify(busquedaService).obtieneListadoTipo();
		verify(panelForm).setComboTipo(any(List.class));

	}

	@Test
	public void deberiaLlenarComboMes() throws Exception {
		when(busquedaService.obtieneListadoMes()).thenReturn(listaMes);
		panelController.llenarComboMes();
		verify(busquedaService).obtieneListadoMes();
		verify(panelForm).setComboMes(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboStatus() throws Exception {
		when(busquedaService.obtieneListadoEstatus()).thenReturn(listaEstatus);
		panelController.llenarComboEstatus();
		verify(busquedaService).obtieneListadoEstatus();
		verify(panelForm).setComboEstatus(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboAnio() throws Exception {
		when(busquedaService.obtieneListadoAnyo()).thenReturn(listaAnio);
		panelController.llenarComboAnio();
		verify(busquedaService).obtieneListadoAnyo();
		verify(panelForm).setComboAnio(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboDelegacion() throws Exception {
		when(busquedaService.obtieneListadoDelegacion()).thenReturn(
				listaDelegacion);
		panelController.llenarComboDelegacion();
		verify(busquedaService).obtieneListadoDelegacion();
		verify(panelForm).setComboDelegacion(any(List.class));

	}

	@Test
	public void deberiaLlenarElComboUnidad() throws Exception {
		when(busquedaService.obtieneListadoUnidad()).thenReturn(listaUnidades);
		panelController.llenarComboUnidad();
		verify(busquedaService).obtieneListadoUnidad();
		verify(panelForm).setComboUnidad(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboTipoVentanilla() throws Exception {
		when(busquedaService.obtieneListadoTipoVentanilla()).thenReturn(
				listaTipoVentanilla);
		panelController.llenarComboTipoVentanilla();
		verify(busquedaService).obtieneListadoTipoVentanilla();
		verify(panelForm).setComboTipoVentanilla(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboTurno() throws Exception {
		when(busquedaService.obtieneListadoTurno()).thenReturn(listaTurnos);
		panelController.llenarComboTurno();
		verify(busquedaService).obtieneListadoTurno();
		verify(panelForm).setComboTurno(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboTipoInforme() throws Exception {
		when(busquedaService.obtieneListadoTipoInforme()).thenReturn(
				listaTipoInforme);
		panelController.llenarComboTipoInforme();
		verify(busquedaService).obtieneListadoTipoInforme();
		verify(panelForm).setComboTipoInforme(any(List.class));
	}

	@Test
	public void deberiaFiltrarComboEstatus() {
		when(busquedaService.obtieneListadoEstatusPorTipoRegistro(new Long(0)))
				.thenReturn(listaEstatus);
		panelController.llenarComboEstatusPorTipoRegistro(new Long(0));
		verify(busquedaService).obtieneListadoEstatusPorTipoRegistro(
				new Long(0));
		verify(panelForm).setComboEstatus(any(List.class));
	}
}
