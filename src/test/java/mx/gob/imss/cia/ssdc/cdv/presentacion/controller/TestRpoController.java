/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestRpoController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import static org.junit.Assert.assertNotNull;
import mx.gob.imss.cia.ssdc.cdv.test.UnitTest;

import org.junit.Test;

public class TestRpoController extends UnitTest {
	@Test
	public void debieraExistirRpoController() throws Exception {
		assertNotNull(new TestRpoController());
		
	
	}
}
