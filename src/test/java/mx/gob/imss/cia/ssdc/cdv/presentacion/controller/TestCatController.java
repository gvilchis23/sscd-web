/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestCatController.java
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

public class TestCatController extends UnitTest {
	@Test
	public void debieraExistirEcdController() throws Exception {
		assertNotNull(new TestCatController());	
	}
}
