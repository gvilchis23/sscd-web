/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: DlgForm.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.form;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Gamaliel
 * 
 */
@Component
public class DlgForm {
	private String imgReporte = "";
	private Long id;
	private Integer tipo;
	private Integer mes;
	private Integer anio;
	private Integer estatus;
	private Integer unidad;
	private String unidadModal;
	private String delegacionModal;
	private String turnoModal;
	private Date fechaLimiteModal;
	private String razonModal;
	private Integer tipoInforme;
	private Integer unidadInforme;
	private String ventanillaModal;
	/**
	 * @return the imgReporte
	 */
	public String getImgReporte() {
		return imgReporte;
	}
	/**
	 * @param imgReporte the imgReporte to set
	 */
	public void setImgReporte(String imgReporte) {
		this.imgReporte = imgReporte;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the unidad
	 */
	public Integer getUnidad() {
		return unidad;
	}
	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}
	/**
	 * @return the unidadModal
	 */
	public String getUnidadModal() {
		return unidadModal;
	}
	/**
	 * @param unidadModal the unidadModal to set
	 */
	public void setUnidadModal(String unidadModal) {
		this.unidadModal = unidadModal;
	}
	/**
	 * @return the delegacionModal
	 */
	public String getDelegacionModal() {
		return delegacionModal;
	}
	/**
	 * @param delegacionModal the delegacionModal to set
	 */
	public void setDelegacionModal(String delegacionModal) {
		this.delegacionModal = delegacionModal;
	}
	/**
	 * @return the turnoModal
	 */
	public String getTurnoModal() {
		return turnoModal;
	}
	/**
	 * @param turnoModal the turnoModal to set
	 */
	public void setTurnoModal(String turnoModal) {
		this.turnoModal = turnoModal;
	}
	/**
	 * @return the fechaLimiteModal
	 */
	public Date getFechaLimiteModal() {
		return fechaLimiteModal;
	}
	/**
	 * @param fechaLimiteModal the fechaLimiteModal to set
	 */
	public void setFechaLimiteModal(Date fechaLimiteModal) {
		this.fechaLimiteModal = fechaLimiteModal;
	}
	/**
	 * @return the razonModal
	 */
	public String getRazonModal() {
		return razonModal;
	}
	/**
	 * @param razonModal the razonModal to set
	 */
	public void setRazonModal(String razonModal) {
		this.razonModal = razonModal;
	}
	/**
	 * @return the tipoInforme
	 */
	public Integer getTipoInforme() {
		return tipoInforme;
	}
	/**
	 * @param tipoInforme the tipoInforme to set
	 */
	public void setTipoInforme(Integer tipoInforme) {
		this.tipoInforme = tipoInforme;
	}
	/**
	 * @return the unidadInforme
	 */
	public Integer getUnidadInforme() {
		return unidadInforme;
	}
	/**
	 * @param unidadInforme the unidadInforme to set
	 */
	public void setUnidadInforme(Integer unidadInforme) {
		this.unidadInforme = unidadInforme;
	}
	/**
	 * @return the ventanillaModal
	 */
	public String getVentanillaModal() {
		return ventanillaModal;
	}
	/**
	 * @param ventanillaModal the ventanillaModal to set
	 */
	public void setVentanillaModal(String ventanillaModal) {
		this.ventanillaModal = ventanillaModal;
	}
		
}
