/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestInterrelacionadasController.java
 *
 * Creado:  03/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcInterService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.VentanillaAnteriorEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.VentanillaPosteriorEntity;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * 
 * @author Gamaliel
 * 
 */
public class TestInterrelacionadasController extends UnitTest {

	@InjectMocks
	private InterrelacionadasController interrelacionado = new InterrelacionadasController();
	@Mock
	private EdcService edcService;
	@Mock
	private EdcInterService edcInterService;
	@Mock
	private VentanillaAnteriorEntity anteriorEntity;
	@Mock
	private VentanillaPosteriorEntity posteriorEntity;

	private List<VentanillaAnteriorEntity> listaAnterior;

	private List<VentanillaPosteriorEntity> listaPosterior;

	private CdvServicioEntity cdvServicioEntity;

	private List<CdvServicioEntity> listaServicio;

	@Before
	public void preparaListaServicioParaGuardar() {
		cdvServicioEntity = new CdvServicioEntity();
		cdvServicioEntity.setAnterior(new Integer("1"));
		cdvServicioEntity.setPosterior(new Integer("1"));
		listaServicio = new ArrayList<CdvServicioEntity>();
		listaServicio.add(cdvServicioEntity);

	}

	@Before
	public void preparaListaServicioParaLlenarTabla() {
		listaAnterior = new ArrayList<VentanillaAnteriorEntity>();
		listaPosterior = new ArrayList<VentanillaPosteriorEntity>();
		listaAnterior.add(anteriorEntity);
		listaPosterior.add(posteriorEntity);
	}

	@Test
	public void deberiaLlenarTabla() throws Exception {
		Long cve = new Long("1");
		when(edcInterService.llenarComboVentaAnterior(cve)).thenReturn(
		        listaAnterior);
		when(edcInterService.llenarComboVentaPost(cve)).thenReturn(
		        listaPosterior);
		when(anteriorEntity.getCveVentanillaAnterior()).thenReturn(cve);
		when(anteriorEntity.getNombreVentanillaAnterior()).thenReturn("value");
		
		interrelacionado.llenarTabla();
		
		verify(edcInterService).llenarComboVentaAnterior(cve);
		verify(edcInterService).llenarComboVentaPost(cve);
		verify(edcService).recuperarCdvServicios(cve);
	}

	@Test
	public void deberiaGuardarInterrelacionadas() throws Exception {
		interrelacionado.setListaCdvServicios(listaServicio);
		interrelacionado.guardarInterrelacionadas();
		verify(edcInterService).recuperarVentanillaAnterior(new Long("1"));
		verify(edcInterService).recuperarVentanillaPosterior(new Long("1"));
		verify(edcInterService).updateCdvServicio(any(CdvServicioEntity.class));
	}

	@Test
	public void interrelacionadasRetroceder() {
		assertNotNull(interrelacionado.interrelacionadasRetroceder());
		assertEquals("servicio", interrelacionado.interrelacionadasRetroceder());

	}

	@Test
	public void interrelacionadasAvanzar() {
		assertNotNull(interrelacionado.interrelacionadasAvanzar());
		assertEquals("solicitudes", interrelacionado.interrelacionadasAvanzar());

	}

}
