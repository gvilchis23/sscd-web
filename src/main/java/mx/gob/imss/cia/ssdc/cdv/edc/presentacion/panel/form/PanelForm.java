/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PanelForm.java
 *
 * Creado:  08/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.stereotype.Component;

/**
 * @author Gamaliel
 * 
 */
@Component
public class PanelForm {
	private List<SelectItem> comboTipo = new ArrayList<SelectItem>();
	private List<SelectItem> comboMes = new ArrayList<SelectItem>();
	private List<SelectItem> comboAnio = new ArrayList<SelectItem>();
	private List<SelectItem> comboEstatus = new ArrayList<SelectItem>();
	private List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();
	private List<SelectItem> comboUnidad = new ArrayList<SelectItem>();
	private List<SelectItem> comboTipoVentanilla = new ArrayList<SelectItem>();
	private List<SelectItem> comboTurno = new ArrayList<SelectItem>();
	private List<SelectItem> comboTipoInforme = new ArrayList<SelectItem>();

	/**
	 * @return the comboTipo
	 */
	public List<SelectItem> getComboTipo() {
		return comboTipo;
	}

	/**
	 * @param comboTipo
	 *            the comboTipo to set
	 */
	public void setComboTipo(List<SelectItem> comboTipo) {
		this.comboTipo = comboTipo;
	}

	/**
	 * @return the comboMes
	 */
	public List<SelectItem> getComboMes() {
		return comboMes;
	}

	/**
	 * @param comboMes
	 *            the comboMes to set
	 */
	public void setComboMes(List<SelectItem> comboMes) {
		this.comboMes = comboMes;
	}

	/**
	 * @return the comboAnio
	 */
	public List<SelectItem> getComboAnio() {
		return comboAnio;
	}

	/**
	 * @param comboAnio
	 *            the comboAnio to set
	 */
	public void setComboAnio(List<SelectItem> comboAnio) {
		this.comboAnio = comboAnio;
	}

	/**
	 * @return the comboEstatus
	 */
	public List<SelectItem> getComboEstatus() {
		return comboEstatus;
	}

	/**
	 * @param comboEstatus
	 *            the comboEstatus to set
	 */
	public void setComboEstatus(List<SelectItem> comboEstatus) {
		this.comboEstatus = comboEstatus;
	}

	/**
	 * @return the comboDelegacion
	 */
	public List<SelectItem> getComboDelegacion() {
		return comboDelegacion;
	}

	/**
	 * @param comboDelegacion
	 *            the comboDelegacion to set
	 */
	public void setComboDelegacion(List<SelectItem> comboDelegacion) {
		this.comboDelegacion = comboDelegacion;
	}

	/**
	 * @return the comboUnidad
	 */
	public List<SelectItem> getComboUnidad() {
		return comboUnidad;
	}

	/**
	 * @param comboUnidad
	 *            the comboUnidad to set
	 */
	public void setComboUnidad(List<SelectItem> comboUnidad) {
		this.comboUnidad = comboUnidad;
	}

	/**
	 * @return the comboTipoVentanilla
	 */
	public List<SelectItem> getComboTipoVentanilla() {
		return comboTipoVentanilla;
	}

	/**
	 * @param comboTipoVentanilla
	 *            the comboTipoVentanilla to set
	 */
	public void setComboTipoVentanilla(List<SelectItem> comboTipoVentanilla) {
		this.comboTipoVentanilla = comboTipoVentanilla;
	}

	/**
	 * @return the comboTurno
	 */
	public List<SelectItem> getComboTurno() {
		return comboTurno;
	}

	/**
	 * @param comboTurno
	 *            the comboTurno to set
	 */
	public void setComboTurno(List<SelectItem> comboTurno) {
		this.comboTurno = comboTurno;
	}

	/**
	 * @return the comboTipoInforme
	 */
	public List<SelectItem> getComboTipoInforme() {
		return comboTipoInforme;
	}

	/**
	 * @param comboTipoInforme
	 *            the comboTipoInforme to set
	 */
	public void setComboTipoInforme(List<SelectItem> comboTipoInforme) {
		this.comboTipoInforme = comboTipoInforme;
	}
}
