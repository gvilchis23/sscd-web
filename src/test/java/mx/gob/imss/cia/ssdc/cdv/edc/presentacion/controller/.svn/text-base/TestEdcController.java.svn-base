/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestEdcController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcGeneralesService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CatServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CategoriaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonaPropiaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PuestoEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoUnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoVentanillaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TurnoEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.UnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;
import mx.gob.imss.cia.ssdc.cdv.vo.DelegacionVo;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TestEdcController extends UnitTest {

	@InjectMocks
	private EdcController edcController = new EdcController();

	@Mock
	private BusquedaService busquedaService;

	@Mock
	private EdcGeneralesService edcGeneralesService;

	@Mock
	private EdcService edcService;

	@Mock
	private EdcForm edcForm;

	@Test
	public void debieraExistirEcdController() throws Exception {
		assertNotNull(edcController);
	}

	@Test
	public void deberiaLlenarElComboDelegacion() throws Exception {
		List<DelegacionVo> delegacionLista = new ArrayList<DelegacionVo>();
		delegacionLista.add(mock(DelegacionVo.class));
		when(busquedaService.obtieneListadoDelegacion()).thenReturn(
		        delegacionLista);

		edcController.llenarComboDelegacion();

		verify(busquedaService).obtieneListadoDelegacion();
	}

	@Test
	public void deberiaLlenarElComboUnidad() throws Exception {
		List<UnidadEntity> unidadLista = new ArrayList<UnidadEntity>();
		unidadLista.add(mock(UnidadEntity.class));
		Long cve = 1L;

		when(edcForm.getDatoDelegacion()).thenReturn(cve);
		when(edcGeneralesService.llenarComboUnidad(cve))
		        .thenReturn(unidadLista);

		edcController.llenarComboUnidad(mock(ActionEvent.class));

		verify(edcGeneralesService).llenarComboUnidad(cve);
	}

	@Test
	public void deberiaLlenarElComboTipoUnidad() throws Exception {
		TipoUnidadEntity tipoUnidad = mock(TipoUnidadEntity.class);
		Long cve = 1L;

		when(edcForm.getDatoTipoUnidad()).thenReturn(cve.intValue());
		when(edcGeneralesService.llenarComboTipoUnidad(cve)).thenReturn(
		        tipoUnidad);

		edcController.llenarComboTipoUnidad(mock(ActionEvent.class));

		verify(edcGeneralesService).llenarComboTipoUnidad(cve);
	}

	@Test
	public void deberiaLlenarComboTipoVentanilla() throws Exception {
		List<TipoVentanillaEntity> tipoVentanillaLista = new ArrayList<TipoVentanillaEntity>();
		tipoVentanillaLista.add(mock(TipoVentanillaEntity.class));
		when(edcGeneralesService.llenarComboTipoVentanilla()).thenReturn(
		        tipoVentanillaLista);

		edcController.llenarComboTipoVentanilla();

		verify(edcGeneralesService).llenarComboTipoVentanilla();
	}

	@Test
	public void deberiaLlenarElComboTurno() throws Exception {
		List<TurnoEntity> tipoVentanillaLista = new ArrayList<TurnoEntity>();
		tipoVentanillaLista.add(mock(TurnoEntity.class));
		when(edcGeneralesService.llenarComboTurno()).thenReturn(
		        tipoVentanillaLista);

		edcController.llenarComboTurno();

		verify(edcGeneralesService).llenarComboTurno();
	}

	@Test
	public void deberiaLlenarElComboCategoria() throws Exception {
		List<CategoriaEntity> categoriaLista = new ArrayList<CategoriaEntity>();
		categoriaLista.add(mock(CategoriaEntity.class));
		when(edcGeneralesService.llenarComboCategoria()).thenReturn(
		        categoriaLista);

		edcController.llenarComboCategoria();

		verify(edcGeneralesService).llenarComboCategoria();
		verify(edcForm).setComboCategoria(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboPuesto() throws Exception {
		List<PuestoEntity> puestoLista = new ArrayList<PuestoEntity>();
		puestoLista.add(mock(PuestoEntity.class));
		when(edcGeneralesService.llenarComboPuesto()).thenReturn(puestoLista);

		edcController.llenarComboPuesto();

		verify(edcGeneralesService).llenarComboPuesto();
		verify(edcForm).setComboPuesto(any(List.class));
	}

	@Test
	public void deberiaGuardarPersonaInfo() throws Exception {
		CatServicioEntity catServicioEntity = mock(CatServicioEntity.class);
		PuestoEntity puestoEntity = mock(PuestoEntity.class);
		TipoVentanillaEntity tipoVentanilla = mock(TipoVentanillaEntity.class);
		UnidadEntity unidad = mock(UnidadEntity.class);
		Long cve = 1L;

		when(edcForm.getDatoModalApellidoP()).thenReturn("apellidoP");
		when(edcForm.getDatoModalApellidoM()).thenReturn("apellidoM");
		when(edcForm.getDatoModalCorreo()).thenReturn("correo");
		when(edcForm.getDatoModalCategoria()).thenReturn(cve.toString());
		when(edcGeneralesService.recuperarCategoria(cve)).thenReturn(
		        catServicioEntity);
		when(edcForm.getDatoModalPuesto()).thenReturn(cve.toString());
		when(edcGeneralesService.recuperarPuesto(cve)).thenReturn(puestoEntity);
		when(edcForm.getDatoModalExtension()).thenReturn("extension");
		when(edcForm.getDatoModalLada()).thenReturn("lada");
		when(edcForm.getDatoModalNombre()).thenReturn("nombre");
		when(edcForm.getDatoModalTelefono()).thenReturn("telefono");
		when(edcService.recuperarVentanilla(cve)).thenReturn(tipoVentanilla);
		when(edcGeneralesService.recuperarUnidad(cve)).thenReturn(unidad);

		edcController.guardarPersonaInfo();

		verify(edcGeneralesService).guardadPersonaInfo(
		        any(PersonaPropiaEntity.class), anyInt());
	}

	@Test
	public void deberiaGuardarCdvGeneral() throws Exception {
		TipoVentanillaEntity tipoVentanilla = mock(TipoVentanillaEntity.class);
		TurnoEntity turno = mock(TurnoEntity.class);
		UnidadEntity unidad = mock(UnidadEntity.class);
		final int tiempoInicial = 5;
		final int tiempoFinal = 6;
		Long cve = 1L;

		when(edcForm.getDatoTipoVentanilla()).thenReturn(cve.intValue());
		when(edcForm.getDatoTurno()).thenReturn(cve.intValue());
		when(edcForm.getDatoUnidad()).thenReturn(cve.intValue());
		when(edcService.recuperarVentanilla(cve)).thenReturn(tipoVentanilla);
		when(edcGeneralesService.recuperarTurno(cve)).thenReturn(turno);
		when(edcGeneralesService.recuperarUnidad(cve)).thenReturn(unidad);

		when(edcForm.getDatoHoraNormalFin()).thenReturn(tiempoFinal);
		when(edcForm.getDatoHoraNormalIni()).thenReturn(tiempoInicial);
		when(edcForm.getDatoHoraRealFin()).thenReturn(tiempoFinal);
		when(edcForm.getDatoHoraRealIni()).thenReturn(tiempoInicial);
		when(edcForm.getDatoMinNormalFin()).thenReturn(tiempoFinal);
		when(edcForm.getDatoMinNormalIni()).thenReturn(tiempoInicial);
		when(edcForm.getDatoMinRealFin()).thenReturn(tiempoFinal);
		when(edcForm.getDatoMinRealIni()).thenReturn(tiempoInicial);
		when(edcForm.getDatoNumVentanilla()).thenReturn(2);

		edcController.guardarCdvGeneral();

		verify(edcGeneralesService).guardadCdvGeneral(any(CdvEntity.class));
		verify(edcGeneralesService).llenarPersonaInfo();
	}
}
