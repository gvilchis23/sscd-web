/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: RpoForm.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.form;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.stereotype.Component;

@Component
public class RpoForm {
	private String tipoReporte;
	private String delegacion;
	private String unidad;
	private String mes;
	private String anio;
	private String seleccionarTabla;
	private String levantamientoTabla;
	private String fechaTabla;
	private String estatusTabla;
	private String informeTabla;
	private String ocultarComboDel;
	private String ocultarComboUni;
	private String colspan;
	private List<SelectItem> comboTipoReporte = new ArrayList<SelectItem>();
	private List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();
	private List<SelectItem> comboUnidad = new ArrayList<SelectItem>();
	private List<SelectItem> comboMes = new ArrayList<SelectItem>();
	private List<SelectItem> comboAnio = new ArrayList<SelectItem>();

	/**
	 * @return the tipoReporte
	 */
	public String getTipoReporte() {
		return tipoReporte;
	}

	/**
	 * @param tipoReporte
	 *            the tipoReporte to set
	 */
	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	/**
	 * @return the delegacion
	 */
	public String getDelegacion() {
		return delegacion;
	}

	/**
	 * @param delegacion
	 *            the delegacion to set
	 */
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad
	 *            the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * @param mes
	 *            the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the seleccionarTabla
	 */
	public String getSeleccionarTabla() {
		return seleccionarTabla;
	}

	/**
	 * @param seleccionarTabla
	 *            the seleccionarTabla to set
	 */
	public void setSeleccionarTabla(String seleccionarTabla) {
		this.seleccionarTabla = seleccionarTabla;
	}

	/**
	 * @return the levantamientoTabla
	 */
	public String getLevantamientoTabla() {
		return levantamientoTabla;
	}

	/**
	 * @param levantamientoTabla
	 *            the levantamientoTabla to set
	 */
	public void setLevantamientoTabla(String levantamientoTabla) {
		this.levantamientoTabla = levantamientoTabla;
	}

	/**
	 * @return the fechaTabla
	 */
	public String getFechaTabla() {
		return fechaTabla;
	}

	/**
	 * @param fechaTabla
	 *            the fechaTabla to set
	 */
	public void setFechaTabla(String fechaTabla) {
		this.fechaTabla = fechaTabla;
	}

	/**
	 * @return the estatusTabla
	 */
	public String getEstatusTabla() {
		return estatusTabla;
	}

	/**
	 * @param estatusTabla
	 *            the estatusTabla to set
	 */
	public void setEstatusTabla(String estatusTabla) {
		this.estatusTabla = estatusTabla;
	}

	/**
	 * @return the informeTabla
	 */
	public String getInformeTabla() {
		return informeTabla;
	}

	/**
	 * @param informeTabla
	 *            the informeTabla to set
	 */
	public void setInformeTabla(String informeTabla) {
		this.informeTabla = informeTabla;
	}

	/**
	 * @return the ocultarComboDel
	 */
	public String getOcultarComboDel() {
		return ocultarComboDel;
	}

	/**
	 * @param ocultarComboDel
	 *            the ocultarComboDel to set
	 */
	public void setOcultarComboDel(String ocultarComboDel) {
		this.ocultarComboDel = ocultarComboDel;
	}

	/**
	 * @return the ocultarComboUni
	 */
	public String getOcultarComboUni() {
		return ocultarComboUni;
	}

	/**
	 * @param ocultarComboUni
	 *            the ocultarComboUni to set
	 */
	public void setOcultarComboUni(String ocultarComboUni) {
		this.ocultarComboUni = ocultarComboUni;
	}

	/**
	 * @return the comboTipoReporte
	 */
	public List<SelectItem> getComboTipoReporte() {
		return comboTipoReporte;
	}

	/**
	 * @return the colspan
	 */
	public String getColspan() {
		return colspan;
	}

	/**
	 * @param colspan
	 *            the colspan to set
	 */
	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	/**
	 * @param comboTipoReporte
	 *            the comboTipoReporte to set
	 */
	public void setComboTipoReporte(List<SelectItem> comboTipoReporte) {
		this.comboTipoReporte = comboTipoReporte;
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

}
