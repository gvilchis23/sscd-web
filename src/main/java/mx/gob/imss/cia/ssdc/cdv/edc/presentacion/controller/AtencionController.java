/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcAtencionForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcAtencionService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ModuloAtencionEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author propietario
 *
 */

@Controller
@Scope("session")
public class AtencionController {
	
	@Autowired
	private EdcService edcService;
	@Autowired
	private EdcAtencionService edcAtencionService;
	@Autowired
	private EdcAtencionForm edcAtencionForm;
	/**
	 * @return the edcAtencionForm
	 */
	public EdcAtencionForm getEdcAtencionForm() {
		return edcAtencionForm;
	}

	/**
	 * @param edcAtencionForm the edcAtencionForm to set
	 */
	public void setEdcAtencionForm(EdcAtencionForm edcAtencionForm) {
		this.edcAtencionForm = edcAtencionForm;
	}

	private Logger log = LoggerFactory.getLogger(getClass());
	
	public void guardarAtencion(){
		
		ModuloAtencionEntity modulo = new ModuloAtencionEntity();
		modulo.setCdv(edcService.recuperarCdv(1L));//cambiar por el de PUD
		modulo.setAccesible(getEdcAtencionForm().getAccesible());
		modulo.setCveModuloAtencion(null);
		modulo.setExisteModulo(getEdcAtencionForm().getExisteModulo());
		modulo.setPersonalTecnico(getEdcAtencionForm().getPersonalTecnico());
		modulo.setPersonasAtendiendo(getEdcAtencionForm().
				getNumeroPersonaAtienden());
		modulo.setSenializado(getEdcAtencionForm().getSenializado());
		modulo.setVisible(getEdcAtencionForm().getVisible());
		edcAtencionService.guardarModuloAtencion(modulo);
	}

}
