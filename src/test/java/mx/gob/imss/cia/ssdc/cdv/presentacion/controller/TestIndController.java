/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: TestIndController.java
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.gob.imss.cia.ssdc.cdv.presentacion.form.IndForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.IndService;
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
public class TestIndController extends UnitTest {
	@InjectMocks
	private IndController indController = new IndController();

	@Mock
	private IndForm indForm;
	@Mock
	private IndService indService;
	@Mock
	private Map<String, String> map;

	private List<Map<String, String>> list;

	private String cadena = "../../images/pdf.png";

	private final String AUX = "1";
	private final String BLOCK1 = "1";
	private final String BLOCK2 = "2";

	@Before
	public void preparaLista() {
		list = new ArrayList<Map<String, String>>();
		list.add(map);
		list.add(map);
	}

	@Test
	public void debieraExistirIndController() throws Exception {
		assertNotNull(new IndController());
	}

	@Test
	public void deberiaInicializarDatosDePantalla() throws Exception {
		indController.init();

		verify(indService).obtenerCobertura();
		verify(indService).obtenerDelegacion();

	}

	@Test
	public void deberiaLlenarElComboCobertura() throws Exception {
		when(indService.obtenerCobertura()).thenReturn(list);
		indController.llenaComboCobertura();
		verify(indService).obtenerCobertura();
		verify(indForm).setListaCobertura(any(List.class));
	}

	@Test
	public void deberiaLlenarElComboDelegacion() throws Exception {
		when(indService.obtenerDelegacion()).thenReturn(list);
		indController.llenaComboDelegacion();
		verify(indService).obtenerDelegacion();
		verify(indForm).setListaDelegaciones(any(List.class));
	}

	@Test
	public void deberiaLlenarProblematicasDelPickList() throws Exception {
		when(indService.obtenerProblematicas()).thenReturn(list);
		indController.llenarPickList();
		verify(indService).obtenerProblematicas();
		verify(indForm).setCategorias(any(List.class));
	}

	@Test
	public void deberiaGenerarImagenDelReporte() throws Exception {
		when(indService.generarReporte(AUX, BLOCK1, BLOCK2)).thenReturn(cadena);
		indController.generarImagenReporte();
		verify(indService).generarReporte(AUX, BLOCK1, BLOCK2);
		verify(indForm).setUrlImagen(cadena);
	}
}
