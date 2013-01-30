/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: CatForm.java
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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Guillermo Vilchis Gonzalez
 * 
 */
@Component
@Qualifier("catForm")
public class CatForm {

	private Long id;
	private String modalEdit;
	private Long idForaneo;
	private Integer catCatalogo;
	private String tipoSeleccion;
	private String tipoVentanilla;
	private String modalPanel;

	private List<SelectItem> comboCatalogo = new ArrayList<SelectItem>();
	private String catalogo;

	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String valor;

	private List<SelectItem> comboServicios = new ArrayList<SelectItem>();

	// For change header label
	private String primeraColumna;
	private String segundaColumna;
	private String terceraColumna;
	private Boolean indexVisible;

	// In order to show table
	private String nombreSerColumna;
	private String nombreCatColumna;
	private String ventanillaColumna;
	private String presupuestariaColumna;

	// For Unidades view
	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String nombreUnidad;

	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String domCalle;

	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String domColonia;

	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String domMunicipio;

	private Integer domNumero;

	@Pattern(regexp = "[0-9]+", message = "Solo numeros")
	@Length(min = 8, max = 8, message = "No esta dentro del rango permitido")
	private String numTelefono;

	@Length(max = 75, message = "Ha rebasado el maximo de caracteres permitidos para el campo.")
	private String refClavePresup;

	private Long entidadFederativa;
	private Long delegacion;
	private Long tipoUnidad;

	private List<SelectItem> comboEntidadFed = new ArrayList<SelectItem>();
	private List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();
	private List<SelectItem> comboTipoUnidad = new ArrayList<SelectItem>();

	public CatForm() {
		id = 0L;
	}

	/**
	 * @return the catalogo
	 */
	public String getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo
	 *            the catalogo to set
	 */
	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * @return the modalPanel
	 */
	public String getModalPanel() {
		return modalPanel;
	}

	/**
	 * @param modalPanel
	 *            the modalPanel to set
	 */
	public void setModalPanel(String modalPanel) {
		this.modalPanel = modalPanel;
	}

	/**
	 * @return the comboCatalogo
	 */
	public List<SelectItem> getComboCatalogo() {
		comboCatalogo = new ArrayList<SelectItem>();
		comboCatalogo.add(new SelectItem(0, ""));
		comboCatalogo.add(new SelectItem(1, "Categoria Servicios"));
		comboCatalogo.add(new SelectItem(2, "Servicios"));
		comboCatalogo.add(new SelectItem(3, "Resultados de Servicios"));
		comboCatalogo.add(new SelectItem(4, "Medios de Difusion"));
		comboCatalogo.add(new SelectItem(5, "Unidades"));
		return comboCatalogo;
	}

	/**
	 * @param comboCatalogo
	 *            the comboCatalogo to set
	 */
	public void setComboCatalogo(List<SelectItem> comboCatalogo) {
		this.comboCatalogo = comboCatalogo;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipoSeleccion
	 */
	public String getTipoSeleccion() {
		return tipoSeleccion;
	}

	/**
	 * @param tipoSeleccion
	 *            the tipoSeleccion to set
	 */
	public void setTipoSeleccion(String tipoSeleccion) {
		this.tipoSeleccion = tipoSeleccion;
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
	 * @return the nombreSercolumna
	 */
	public String getNombreSerColumna() {
		return nombreSerColumna;
	}

	/**
	 * @param nombreSercolumna
	 *            the nombreSercolumna to set
	 */
	public void setNombreSerColumna(String nombreSerColumna) {
		this.nombreSerColumna = nombreSerColumna;
	}

	/**
	 * @return the nombreCatColumna
	 */
	public String getNombreCatColumna() {
		return nombreCatColumna;
	}

	/**
	 * @param nombreCatColumna
	 *            the nombreCatColumna to set
	 */
	public void setNombreCatColumna(String nombreCatColumna) {
		this.nombreCatColumna = nombreCatColumna;
	}

	/**
	 * @return the ventanillaColumna
	 */
	public String getVentanillaColumna() {
		return ventanillaColumna;
	}

	/**
	 * @param ventanillaColumna
	 *            the ventanillaColumna to set
	 */
	public void setVentanillaColumna(String ventanillaColumna) {
		this.ventanillaColumna = ventanillaColumna;
	}

	public String getPresupuestariaColumna() {
		return presupuestariaColumna;
	}

	public void setPresupuestariaColumna(String presupuestaria) {
		this.presupuestariaColumna = presupuestaria;
	}

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
	 * @return the idForaneo
	 */
	public Long getIdForaneo() {
		return idForaneo;
	}

	/**
	 * @param idForaneo
	 *            the idForaneo to set
	 */
	public void setIdForaneo(Long idForaneo) {
		this.idForaneo = idForaneo;
	}

	/**
	 * @return the modalEdit
	 */
	public String getModalEdit() {
		return modalEdit;
	}

	/**
	 * @param modalEdit
	 *            the modalEdit to set
	 */
	public void setModalEdit(String modalEdit) {
		this.modalEdit = modalEdit;
	}

	/**
	 * @return the catCatalogo
	 */
	public Integer getCatCatalogo() {
		return catCatalogo;
	}

	/**
	 * @param catCatalogo
	 *            the catCatalogo to set
	 */
	public void setCatCatalogo(Integer catCatalogo) {
		this.catCatalogo = catCatalogo;
	}

	/**
	 * @return the comboServicios
	 */
	public List<SelectItem> getComboServicios() {
		return comboServicios;
	}

	/**
	 * @param comboServicios
	 *            the comboServicios to set
	 */
	public void setComboServicios(List<SelectItem> comboServicios) {
		this.comboServicios = comboServicios;
	}

	public List<SelectItem> getComboEntidadFed() {
		return comboEntidadFed;
	}

	public void setComboEntidadFed(List<SelectItem> comboEntidadFed) {
		this.comboEntidadFed = comboEntidadFed;
	}

	public List<SelectItem> getComboDelegacion() {
		return comboDelegacion;
	}

	public void setComboDelegacion(List<SelectItem> comboDelegacion) {
		this.comboDelegacion = comboDelegacion;
	}

	public List<SelectItem> getComboTipoUnidad() {
		return comboTipoUnidad;
	}

	public void setComboTipoUnidad(List<SelectItem> comboTipoUnidad) {
		this.comboTipoUnidad = comboTipoUnidad;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getDomCalle() {
		return domCalle;
	}

	public void setDomCalle(String domCalle) {
		this.domCalle = domCalle;
	}

	public String getDomColonia() {
		return domColonia;
	}

	public void setDomColonia(String domColonia) {
		this.domColonia = domColonia;
	}

	public String getDomMunicipio() {
		return domMunicipio;
	}

	public void setDomMunicipio(String domMunicipio) {
		this.domMunicipio = domMunicipio;
	}

	public Integer getDomNumero() {
		return domNumero;
	}

	public void setDomNumero(Integer domNumero) {
		this.domNumero = domNumero;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getRefClavePresup() {
		return refClavePresup;
	}

	public void setRefClavePresup(String refClavePresup) {
		this.refClavePresup = refClavePresup;
	}

	public Long getEntidadFederativa() {
		return entidadFederativa;
	}

	public Long getDelegacion() {
		return delegacion;
	}

	public Long getTipoUnidad() {
		return tipoUnidad;
	}

	public void setEntidadFederativa(Long entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	public void setDelegacion(Long delegacion) {
		this.delegacion = delegacion;
	}

	public void setTipoUnidad(Long tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public String getPrimeraColumna() {
		return primeraColumna;
	}

	public void setPrimeraColumna(String primeraColumna) {
		this.primeraColumna = primeraColumna;
	}

	public String getSegundaColumna() {
		return segundaColumna;
	}

	public void setSegundaColumna(String segundaColumna) {
		this.segundaColumna = segundaColumna;
	}

	public String getTerceraColumna() {
		return terceraColumna;
	}

	public void setTerceraColumna(String terceraColumna) {
		this.terceraColumna = terceraColumna;
	}

	public boolean getIndexVisible() {
		return indexVisible;
	}

	public void setIndexVisible(boolean indexVisible) {
		this.indexVisible = indexVisible;
	}
}