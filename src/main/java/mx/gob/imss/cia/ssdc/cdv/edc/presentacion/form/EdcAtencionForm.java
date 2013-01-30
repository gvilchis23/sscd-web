/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcEncabezadoForm.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author propietario
 *
 */

@Component
@Qualifier("edcAtencionForm")
@Scope("session")
public class EdcAtencionForm implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer existeModulo;
	private Integer personalTecnico;
	private Integer visible;
	private Integer accesible;
	private Integer senializado;
	private Integer numeroPersonaAtienden;
	/**
	 * @return the existeModulo
	 */
	public Integer getExisteModulo() {
		return existeModulo;
	}
	/**
	 * @param existeModulo the existeModulo to set
	 */
	public void setExisteModulo(Integer existeModulo) {
		this.existeModulo = existeModulo;
	}
	/**
	 * @return the personalTecnico
	 */
	public Integer getPersonalTecnico() {
		return personalTecnico;
	}
	/**
	 * @param personalTecnico the personalTecnico to set
	 */
	public void setPersonalTecnico(Integer personalTecnico) {
		this.personalTecnico = personalTecnico;
	}
	/**
	 * @return the visible
	 */
	public Integer getVisible() {
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	/**
	 * @return the accesible
	 */
	public Integer getAccesible() {
		return accesible;
	}
	/**
	 * @param accesible the accesible to set
	 */
	public void setAccesible(Integer accesible) {
		this.accesible = accesible;
	}
	/**
	 * @return the senializado
	 */
	public Integer getSenializado() {
		return senializado;
	}
	/**
	 * @param senializado the senializado to set
	 */
	public void setSenializado(Integer senializado) {
		this.senializado = senializado;
	}
	/**
	 * @return the numeroPersonaAtienden
	 */
	public Integer getNumeroPersonaAtienden() {
		return numeroPersonaAtienden;
	}
	/**
	 * @param numeroPersonaAtienden the numeroPersonaAtienden to set
	 */
	public void setNumeroPersonaAtienden(Integer numeroPersonaAtienden) {
		this.numeroPersonaAtienden = numeroPersonaAtienden;
	}
	
	
}
