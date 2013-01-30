/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestAtencionController.java
 *
 * Creado:  03/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcAtencionForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcAtencionService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ModuloAtencionEntity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author Gamaliel
 * 
 */

public class TestAtencionController {
	@InjectMocks
	private AtencionController atencionController = new AtencionController();
	@Mock
	private EdcAtencionService edcAtencionService;
	@Mock
	private EdcService edcService;
	@Mock
	private EdcAtencionForm atencionForm;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void debieraExistirAtencionController() throws Exception {
		assertNotNull(atencionController);
	}

	@Test
	public void deberiaGuardarAtencion() throws Exception {
		atencionController.guardarAtencion();
		verify(edcService).recuperarCdv(new Long("1"));
		verify(atencionForm).getAccesible();
		verify(edcAtencionService).guardarModuloAtencion(
				any(ModuloAtencionEntity.class));

	}

}
