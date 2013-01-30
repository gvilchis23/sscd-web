/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: IndController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.presentacion.form.IndForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.SsdcException;
import mx.gob.imss.cia.ssdc.cdv.servicios.IndService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class IndController {
	@Autowired
	private IndForm indForm;
	@Autowired
	private IndService indService;

	private String aux = "1";
	private String block1 = "1";
	private String block2 = "2";

	@PostConstruct
	public void init() throws SsdcException {
		llenarPickList();
		llenaComboCobertura();
		llenaComboDelegacion();
	}

	public void llenarPickList() {
		List<Map<String, String>> mapProblematicas = indService
				.obtenerProblematicas();
		List<SelectItem> problematicas = llenarListItems(mapProblematicas);

		getIndForm().setCategorias(problematicas);
	}

	public void generarImagenReporte() {
		String url = indService.generarReporte(getAux(), getBlock1(),
				getBlock2());
		getIndForm().setUrlImagen(url);

	}

	public void llenaComboCobertura() {
		List<Map<String, String>> mapProblematicas = indService
				.obtenerCobertura();
		List<SelectItem> comboCobertura = llenarListItems(mapProblematicas);

		getIndForm().setListaCobertura(comboCobertura);
	}

	public void llenaComboDelegacion() {

		List<Map<String, String>> mapProblematicas = indService
				.obtenerDelegacion();
		List<SelectItem> comboDelegacion = llenarListItems(mapProblematicas);
		getIndForm().setListaDelegaciones(comboDelegacion);
	}

	public List<SelectItem> llenarListItems(List<Map<String, String>> listaMap) {
		List<SelectItem> listGenerica = new ArrayList<SelectItem>();
		if (listaMap.size() > 0 || listaMap != null) {
			for (Map<String, String> map : listaMap) {
				listGenerica.add(new SelectItem(map.get(IndService.LLAVE_MAP),
						map.get(IndService.VALOR_MAP)));
			}
		}

		return listGenerica;
	}

	/**
	 * @return the indForm
	 */
	public IndForm getIndForm() {
		return indForm;
	}

	/**
	 * @param indForm
	 *            the indForm to set
	 */
	public void setIndForm(IndForm indForm) {
		this.indForm = indForm;
	}

	/**
	 * @return the aux
	 */
	public String getAux() {
		return aux;
	}

	/**
	 * @param aux
	 *            the aux to set
	 */
	public void setAux(String aux) {
		this.aux = aux;
	}

	/**
	 * @return the block1
	 */
	public String getBlock1() {
		return block1;
	}

	/**
	 * @param block1
	 *            the block1 to set
	 */
	public void setBlock1(String block1) {
		this.block1 = block1;
	}

	/**
	 * @return the block2
	 */
	public String getBlock2() {
		return block2;
	}

	/**
	 * @param block2
	 *            the block2 to set
	 */
	public void setBlock2(String block2) {
		this.block2 = block2;
	}

}
