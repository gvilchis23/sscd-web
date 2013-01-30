/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestServiciosController.java
 *
 * Creado: 07/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CatServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.LlaveCompuestaCdv;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * 
 * @author Equipo de Desarrollo
 * 
 */
public class TestServiciosController extends UnitTest {

	@InjectMocks
	private ServiciosController serviciosController = new ServiciosController();

	@Mock
	private EdcService edcService;

	@Test
	public void deberiaLlenarComboCategoriaServicios() throws Exception {
		List<CatServicioEntity> listaCatServicio = new ArrayList<CatServicioEntity>();
		CatServicioEntity catServicioMock = mock(CatServicioEntity.class);
		listaCatServicio.add(catServicioMock);
		listaCatServicio.add(catServicioMock);

		when(edcService.llenarComboCategoriaServicios(1L)).thenReturn(
		        listaCatServicio);

		serviciosController.llenarComboCategoriaServicios();

		verify(catServicioMock, times(2)).getCveCategoria();
		verify(catServicioMock, times(2)).getNombreCategoria();

	}

	@Test
	public void deberiaLlenarComboServicios() throws Exception {
		Long cveCategoria = 1L;
		List<ServicioEntity> listaServicio = new ArrayList<ServicioEntity>();
		ServicioEntity servicioEntityMock = mock(ServicioEntity.class);
		listaServicio.add(servicioEntityMock);

		List<CdvServicioEntity> listaCatServicio = new ArrayList<CdvServicioEntity>();
		CdvServicioEntity cdvServicioMock = mock(CdvServicioEntity.class);
		listaCatServicio.add(cdvServicioMock);

		when(edcService.llenarComboServicios(cveCategoria)).thenReturn(
		        listaServicio);
		when(edcService.recuperarCdvServicios(cveCategoria)).thenReturn(
		        listaCatServicio);

		LlaveCompuestaCdv id = mock(LlaveCompuestaCdv.class);
		when(cdvServicioMock.getLlaveCompuesta()).thenReturn(id);
		when(cdvServicioMock.getLlaveCompuesta().getServicio()).thenReturn(
		        servicioEntityMock);

//		serviciosController.llenarComboServicios(cveCategoria);

	}
}
