/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: SolicitudesController.java
 *
 * Creado:  18/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcSolicitudesForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcGeneralesService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcSolicitudesService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CausaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class SolicitudesController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EdcSolicitudesForm edcSolicitudesForm;
	@Autowired
	private EdcSolicitudesService edcSolicitudesService;
	@Autowired
	private EdcService edcService;
	@Autowired
	private EdcGeneralesService edcGeneralesService;
	private List<Integer>  listaCausas;
	private List<CausaEntity>  listaCausasEn;

	
	private String menu="header";
	
	@PostConstruct
	public void init(){
		setMenu("footer");
		
	}

	/**
	 * @return the edcSolicitudesForm
	 */
	public EdcSolicitudesForm getEdcSolicitudesForm() {
		return edcSolicitudesForm;
	}

	/**
	 * @param edcSolicitudesForm the edcSolicitudesForm to set
	 */
	public void setEdcSolicitudesForm(EdcSolicitudesForm edcSolicitudesForm) {
		this.edcSolicitudesForm = edcSolicitudesForm;
	}
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * @return the listaRequisitos
	 */
	public List<Integer> getListaCausas() {
		return listaCausas;
	}

	/**
	 * @param listaRequisitos the listaRequisitos to set
	 */
	public void setListaCausas(List<Integer> listaCausas) {
		this.listaCausas = listaCausas;
	}
	
	/**
	 * @return the listaCausasEn
	 */
	public List<CausaEntity> getListaCausasEn() {
		return listaCausasEn;
	}

	/**
	 * @param listaCausasEn the listaCausasEn to set
	 */
	public void setListaCausasEn(List<CausaEntity> listaCausasEn) {
		this.listaCausasEn = listaCausasEn;
	}

	public String solicitudesRetroceder(){
		String retroceder=null;
		retroceder="interrelacionadas";
			return retroceder;
	}
	public String solicitudesAvanzar(){
		String avanzar=null;
		avanzar="modAtencion";
			return avanzar;
		
	}
	
	//Falta recuperar por tipo de ventanilla que estara en session
	public void llenarPickListCausas(ActionEvent e){
		List<CausaEntity> lista=edcSolicitudesService.recuperarCausaPorStatus();
		ArrayList<SelectItem> combo = new ArrayList<SelectItem>();
		for(CausaEntity causa:lista){
			combo.add(new SelectItem
					(causa.getCveCausa().intValue(), causa.getNombreCausa()));
		}
		getEdcSolicitudesForm().setPickRequisitos(combo);
	}
	
	
	public void aceptarCausas(ActionEvent e){
		List <CausaEntity> causa= new ArrayList<CausaEntity>();
		if(getListaCausas().size()>0){
			for(Integer cadena:getListaCausas()){
				CausaEntity causaE=edcSolicitudesService.
				recuperarCausaPorId(cadena);
				causa.add(causaE);
			}
			setListaCausasEn(causa);
		}else{
			setListaCausasEn(causa);
		}
	}
	
	public String guardarCausas(){
		String regreso="";
		try{
			//quitar y poner el objeto de session de PUD
			CdvEntity cdv = edcService.recuperarCdv(1L);
			cdv.setNumSolicitudAtendidas(getEdcSolicitudesForm().getDatoPromSolAtendidas());
			cdv.setNumSolicitudRecogidas(getEdcSolicitudesForm().getDatoPromSolRecibidas());
			cdv.setCausa(getListaCausasEn());
			edcGeneralesService.guardadCdvGeneral(cdv);
			regreso="sucess";
		}catch(Exception e){
			log.info("Error en guardar cdv en solicitudes controller");
			regreso="error";
		}
	    return regreso;	
	}
}
