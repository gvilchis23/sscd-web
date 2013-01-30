/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PduForm.java
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
public class PduForm {
	private Long id;
	private String nombre;
	private Date fecha;
	private String estatusTabla;
	private String imgReporte = "";
	private Integer estatus;
	private Integer tipo;
	private Integer mes;
	private Integer anio;
	private String tipoTabla;
	private String delegacion;
	private String unidad;
	private String tipoVentanilla;
	private String turno;
	private String tipoInforme;
	private Long delegacionModal;
	private long unidadModal;
	private Long tipoVentanillaModal;
	private Long turnoModal;
	private Long tipoModal;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
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
	 * @return the imgReporte
	 */
	public String getImgReporte() {
		return imgReporte;
	}

	/**
	 * @param imgReporte
	 *            the imgReporte to set
	 */
	public void setImgReporte(String imgReporte) {
		this.imgReporte = imgReporte;
	}

	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tipoTabla
	 */
	public String getTipoTabla() {
		return tipoTabla;
	}

	/**
	 * @param tipoTabla
	 *            the tipoTabla to set
	 */
	public void setTipoTabla(String tipoTabla) {
		this.tipoTabla = tipoTabla;
	}

	/**
	 * @return the tipoModal
	 */
	public Long getTipoModal() {
		return tipoModal;
	}

	/**
	 * @param tipoModal
	 *            the tipoModal to set
	 */
	public void setTipoModal(Long tipoModal) {
		this.tipoModal = tipoModal;
	}

	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}

	/**
	 * @param mes
	 *            the mes to set
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
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
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
	 * @return the tipoVentanilla
	 */
	public String getTipoVentanilla() {
		return tipoVentanilla;
	}

	/**
	 * @param tipoVentanilla
	 *            the tipoVentanilla to set
	 */
	public void setTipoVentanilla(String tipoVentanilla) {
		this.tipoVentanilla = tipoVentanilla;
	}

	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * @param turno
	 *            the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

	/**
	 * @return the tipoInforme
	 */
	public String getTipoInforme() {
		return tipoInforme;
	}

	/**
	 * @param tipoInforme
	 *            the tipoInforme to set
	 */
	public void setTipoInforme(String tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	/**
	 * @return the delegacionModal
	 */
	public Long getDelegacionModal() {
		return delegacionModal;
	}

	/**
	 * @param delegacionModal
	 *            the delegacionModal to set
	 */
	public void setDelegacionModal(Long delegacionModal) {
		this.delegacionModal = delegacionModal;
	}

	/**
	 * @return the unidadModal
	 */
	public long getUnidadModal() {
		return unidadModal;
	}

	/**
	 * @param unidadModal
	 *            the unidadModal to set
	 */
	public void setUnidadModal(long unidadModal) {
		this.unidadModal = unidadModal;
	}

	/**
	 * @return the tipoVentanillaModal
	 */
	public Long getTipoVentanillaModal() {
		return tipoVentanillaModal;
	}

	/**
	 * @param tipoVentanillaModal
	 *            the tipoVentanillaModal to set
	 */
	public void setTipoVentanillaModal(Long tipoVentanillaModal) {
		this.tipoVentanillaModal = tipoVentanillaModal;
	}

	/**
	 * @return the turnoModal
	 */
	public Long getTurnoModal() {
		return turnoModal;
	}

	/**
	 * @param turnoModal
	 *            the turnoModal to set
	 */
	public void setTurnoModal(Long turnoModal) {
		this.turnoModal = turnoModal;
	}

}
