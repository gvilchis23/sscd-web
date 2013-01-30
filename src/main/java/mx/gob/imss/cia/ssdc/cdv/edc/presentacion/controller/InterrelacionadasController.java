/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: InterrelacionadasController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcInterForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcInterService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.VentanillaAnteriorEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.VentanillaPosteriorEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class InterrelacionadasController {

	@Autowired
	private EdcService edcService;
	@Autowired
	private EdcInterService edcInterService;
	@Autowired
	private EdcInterForm edcInterForm;

	private List<SelectItem> comboAnterior = new ArrayList<SelectItem>();
	private List<SelectItem> comboPosterior = new ArrayList<SelectItem>();
	private List<CdvServicioEntity> listaCdvServicios = new ArrayList<CdvServicioEntity>();
	private String menu = "header";

	@PostConstruct
	public void init() {
		setMenu("footer");
		llenarTabla();
	}

	/**
	 * @return the cdvService
	 */
	public EdcService getEdcService() {
		return edcService;
	}

	/**
	 * @param cdvService
	 *            the cdvService to set
	 */
	public void setEdcService(EdcService edcService) {
		this.edcService = edcService;
	}

	/**
	 * @return the cdvInterForm
	 */
	public EdcInterForm getEdcInterForm() {
		return edcInterForm;
	}

	/**
	 * @param cdvInterForm
	 *            the cdvInterForm to set
	 */
	public void setEdcInterForm(EdcInterForm edcInterForm) {
		this.edcInterForm = edcInterForm;
	}

	/**
	 * @return the comboAnterior
	 */
	public List<SelectItem> getComboAnterior() {
		return comboAnterior;
	}

	/**
	 * @param comboAnterior
	 *            the comboAnterior to set
	 */
	public void setComboAnterior(List<SelectItem> comboAnterior) {
		this.comboAnterior = comboAnterior;
	}

	/**
	 * @return the comboPosterior
	 */
	public List<SelectItem> getComboPosterior() {
		return comboPosterior;
	}

	/**
	 * @param comboPosterior
	 *            the comboPosterior to set
	 */
	public void setComboPosterior(List<SelectItem> comboPosterior) {
		this.comboPosterior = comboPosterior;
	}

	/**
	 * @return the listaTabla
	 */
	public List<CdvServicioEntity> getListaCdvServicios() {
		return listaCdvServicios;
	}

	/**
	 * @return the edcInterService
	 */
	public EdcInterService getEdcInterService() {
		return edcInterService;
	}

	/**
	 * @param edcInterService
	 *            the edcInterService to set
	 */
	public void setEdcInterService(EdcInterService edcInterService) {
		this.edcInterService = edcInterService;
	}

	/**
	 * @param listaTabla
	 *            the listaTabla to set
	 */
	public void setListaCdvServicios(List<CdvServicioEntity> listaCdvServicios) {
		this.listaCdvServicios = listaCdvServicios;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void llenarTabla() {
		List<VentanillaAnteriorEntity> lista = edcInterService
		        .llenarComboVentaAnterior(1L);// cveVentanilla PU
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (VentanillaAnteriorEntity anterior : lista) {
			combo.add(new SelectItem(anterior.getCveVentanillaAnterior(),
			        anterior.getNombreVentanillaAnterior()));
		}
		setComboAnterior(combo);

		List<VentanillaPosteriorEntity> listaPost = edcInterService
		        .llenarComboVentaPost(1L);// cveVentanilla
		
		combo = new ArrayList<SelectItem>();
		for (VentanillaPosteriorEntity posterior : listaPost) {
			combo.add(new SelectItem(posterior.getCveVentanillaPosterior(),
			        posterior.getNombreVentanillaPosterior()));
		}
		setComboPosterior(combo);
		List<CdvServicioEntity> listaServicio = edcService
		        .recuperarCdvServicios(1L);
		setListaCdvServicios(listaServicio);

	}

	public void guardarInterrelacionadas() {
		for (CdvServicioEntity entidad : getListaCdvServicios()) {
			VentanillaAnteriorEntity anterior = edcInterService
			        .recuperarVentanillaAnterior(Long.valueOf(entidad
			                .getAnterior()));
			entidad.setVentanillaAnterior(anterior);
			VentanillaPosteriorEntity posterior = edcInterService
			        .recuperarVentanillaPosterior(Long.valueOf(entidad
			                .getPosterior()));
			entidad.setVentanillaPosterior(posterior);
			edcInterService.updateCdvServicio(entidad);
		}
	}

	public String interrelacionadasRetroceder() {
		String retroceder = null;
		retroceder = "servicio";
		return retroceder;

	}

	public String interrelacionadasAvanzar() {
		String avanzar = null;
		avanzar = "solicitudes";
		return avanzar;

	}

}
