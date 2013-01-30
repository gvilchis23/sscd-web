/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcForm.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Qualifier("cdvForm")
@Scope("session")
public class EdcForm implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long datoDelegacion;
	private Integer datoTipoUnidad;
	private Integer datoUnidad;
	private Integer datoTipoVentanilla;
	private Integer datoTurno;
	private Integer datoNumVentanilla;
	private Integer datoHoraNormalIni;
	private Integer datoMinNormalIni;
	private Integer datoHoraNormalFin;
	private Integer datoMinNormalFin;
	private Integer datoHoraRealIni;
	private Integer datoMinRealIni;
	private Integer datoHoraRealFin;
	private Integer datoMinRealFin;
	private String datoModalCategoria;
	private String datoModalPuesto;
	
	
	@Pattern(regexp = "[a-z, A-Z, á, é, í, ó, ú, Á, É, Í, Ó, Ú]+", message = "Campo alfabético")
	 private String datoModalApellidoP;	
	
	@Pattern(regexp = "[a-z, A-Z, á, é, í, ó, ú Á-Ú]+", message = "Campo alfabético")
	private String datoModalApellidoM;
	
	@Pattern(regexp = "[a-z, A-Z, á, é, í, ó, ú]+", message = "Campo alfabético")
	private String datoModalNombre;
	
	@Pattern(regexp = "[0-9]+", message = "campo numérico")
	@Length(min = 2, max = 3, message = "No está dentro del rango permitido")
	private String datoModalLada;
	
	@Pattern(regexp = "[0-9]+", message = "campo numérico")
	@Length(min = 8, max = 8, message = "No está dentro del rango permitido")
	private String datoModalTelefono;
	
	@Pattern(regexp = "[0-9]+", message = "campo numérico")
	@Length(min = 2, max = 4, message = "No está dentro del rango permitido")
	private String datoModalExtension;
	
	@Email(message="Email no válido")
	@Length(max = 20, message = "No está dentro del rango permitido")
	private String datoModalCorreo;
	private List<SelectItem>comboNumVentanilla;
	private List<SelectItem>comboHoraNormalIni;
	private List<SelectItem>comboMinNormalIni;
	private List<SelectItem>comboCategoria=new ArrayList<SelectItem>();
	private List<SelectItem>comboPuesto=new ArrayList<SelectItem>();
	
	
	
	/**
	 * @return the datoDelegacion
	 */
	public Long getDatoDelegacion() {
		return datoDelegacion;
	}

	/**
	 * @param datoDelegacion the datoDelegacion to set
	 */
	public void setDatoDelegacion(Long datoDelegacion) {
		this.datoDelegacion = datoDelegacion;
	}

	/**
	 * @return the datoTipoUnidad
	 */
	public Integer getDatoTipoUnidad() {
		return datoTipoUnidad;
	}

	/**
	 * @param datoTipoUnidad the datoTipoUnidad to set
	 */
	public void setDatoTipoUnidad(Integer datoTipoUnidad) {
		this.datoTipoUnidad = datoTipoUnidad;
	}

	/**
	 * @return the datoUnidad
	 */
	public Integer getDatoUnidad() {
		return datoUnidad;
	}

	/**
	 * @param datoUnidad the datoUnidad to set
	 */
	public void setDatoUnidad(Integer datoUnidad) {
		this.datoUnidad = datoUnidad;
	}

	/**
	 * @return the datoTipoVentanilla
	 */
	public Integer getDatoTipoVentanilla() {
		return datoTipoVentanilla;
	}

	/**
	 * @param datoTipoVentanilla the datoTipoVentanilla to set
	 */
	public void setDatoTipoVentanilla(Integer datoTipoVentanilla) {
		this.datoTipoVentanilla = datoTipoVentanilla;
	}

	/**
	 * @return the datoTurno
	 */
	public Integer getDatoTurno() {
		return datoTurno;
	}

	/**
	 * @param datoTurno the datoTurno to set
	 */
	public void setDatoTurno(Integer datoTurno) {
		this.datoTurno = datoTurno;
	}

	/**
	 * @return the comboNumVentanillas
	 */
	public List<SelectItem> getComboNumVentanilla() {
		List<SelectItem>combo=new ArrayList<SelectItem>();
		combo.add(new SelectItem(1,"1"));
		combo.add(new SelectItem(2,"2"));
		combo.add(new SelectItem(3,"3"));
		combo.add(new SelectItem(4,"4"));
		combo.add(new SelectItem(5,"5"));
		combo.add(new SelectItem(6,"6"));
		combo.add(new SelectItem(7,"7"));
		combo.add(new SelectItem(8,"8"));
		combo.add(new SelectItem(9,"9"));
		combo.add(new SelectItem(10,"10"));
		return combo;
	}

	/**
	 * @param comboNumVentanillas the comboNumVentanillas to set
	 */
	public void setComboNumVentanilla(List<SelectItem> comboNumVentanilla) {
		this.comboNumVentanilla = comboNumVentanilla;
	}

	/**
	 * @return the datoNumVentanilla
	 */
	public Integer getDatoNumVentanilla() {
		return datoNumVentanilla;
	}

	/**
	 * @param datoNumVentanilla the datoNumVentanilla to set
	 */
	public void setDatoNumVentanilla(Integer datoNumVentanilla) {
		this.datoNumVentanilla = datoNumVentanilla;
	}

	/**
	 * @return the comboCategoria
	 */
	public List<SelectItem> getComboCategoria() {
		return comboCategoria;
	}

	/**
	 * @param comboCategoria the comboCategoria to set
	 */
	public void setComboCategoria(List<SelectItem> comboCategoria) {
		this.comboCategoria = comboCategoria;
	}

	/**
	 * @return the datoModalCategoria
	 */
	public String getDatoModalCategoria() {
		return datoModalCategoria;
	}

	/**
	 * @param datoModalCategoria the datoModalCategoria to set
	 */
	public void setDatoModalCategoria(String datoModalCategoria) {
		this.datoModalCategoria = datoModalCategoria;
	}

	/**
	 * @return the datoModalPuesto
	 */
	public String getDatoModalPuesto() {
		return datoModalPuesto;
	}

	/**
	 * @param datoModalPuesto the datoModalPuesto to set
	 */
	public void setDatoModalPuesto(String datoModalPuesto) {
		this.datoModalPuesto = datoModalPuesto;
	}

	/**
	 * @return the comboPuesto
	 */
	public List<SelectItem> getComboPuesto() {
		return comboPuesto;
	}

	/**
	 * @param comboPuesto the comboPuesto to set
	 */
	public void setComboPuesto(List<SelectItem> comboPuesto) {
		this.comboPuesto = comboPuesto;
	}

	/**
	 * @return the datoModalApellidoP
	 */
	public String getDatoModalApellidoP() {
		return datoModalApellidoP;
	}

	/**
	 * @param datoModalApellidoP the datoModalApellidoP to set
	 */
	public void setDatoModalApellidoP(String datoModalApellidoP) {
		this.datoModalApellidoP = datoModalApellidoP;
	}

	/**
	 * @return the datoModalApellidoM
	 */
	public String getDatoModalApellidoM() {
		return datoModalApellidoM;
	}

	/**
	 * @param datoModalApellidoM the datoModalApellidoM to set
	 */
	public void setDatoModalApellidoM(String datoModalApellidoM) {
		this.datoModalApellidoM = datoModalApellidoM;
	}

	/**
	 * @return the datoModalNombre
	 */
	public String getDatoModalNombre() {
		return datoModalNombre;
	}

	/**
	 * @param datoModalNombre the datoModalNombre to set
	 */
	public void setDatoModalNombre(String datoModalNombre) {
		this.datoModalNombre = datoModalNombre;
	}

	/**
	 * @return the datoModalLada
	 */
	public String getDatoModalLada() {
		return datoModalLada;
	}

	/**
	 * @param datoModalLada the datoModalLada to set
	 */
	public void setDatoModalLada(String datoModalLada) {
		this.datoModalLada = datoModalLada;
	}

	/**
	 * @return the datoModalTelefono
	 */
	public String getDatoModalTelefono() {
		return datoModalTelefono;
	}

	/**
	 * @param datoModalTelefono the datoModalTelefono to set
	 */
	public void setDatoModalTelefono(String datoModalTelefono) {
		this.datoModalTelefono = datoModalTelefono;
	}

	/**
	 * @return the datoModalExtension
	 */
	public String getDatoModalExtension() {
		return datoModalExtension;
	}

	/**
	 * @param datoModalExtension the datoModalExtension to set
	 */
	public void setDatoModalExtension(String datoModalExtension) {
		this.datoModalExtension = datoModalExtension;
	}

	/**
	 * @return the datoModalCorreo
	 */
	public String getDatoModalCorreo() {
		return datoModalCorreo;
	}

	/**
	 * @param datoModalCorreo the datoModalCorreo to set
	 */
	public void setDatoModalCorreo(String datoModalCorreo) {
		this.datoModalCorreo = datoModalCorreo;
	}

	

	/**
	 * @return the comboHoraNormalIni
	 */
	public List<SelectItem> getComboHoraNormalIni() {
		List<SelectItem>combo=new ArrayList<SelectItem>();
		for(int x=1;x<=24;x++){
			if(x<10){
				combo.add(new SelectItem(x,"0"+String.valueOf(x)));
			}else{
				combo.add(new SelectItem(x,String.valueOf(x)));
			}
		}
		return combo;
	}

	/**
	 * @param comboHoraNormalIni the comboHoraNormalIni to set
	 */
	public void setComboHoraNormalIni(List<SelectItem> comboHoraNormalIni) {
		this.comboHoraNormalIni = comboHoraNormalIni;
	}

	
	/**
	 * @return the comboMinNormalIni
	 */
	public List<SelectItem> getComboMinNormalIni() {
		List<SelectItem>combo=new ArrayList<SelectItem>();
		for(int x=0;x<=59;x++){
			if(x<10){
				combo.add(new SelectItem(x,"0"+String.valueOf(x)));
			}else{
				combo.add(new SelectItem(x,String.valueOf(x)));
			}
			
		}
		return combo;
	}

	/**
	 * @param comboMinNormalIni the comboMinNormalIni to set
	 */
	public void setComboMinNormalIni(List<SelectItem> comboMinNormalIni) {
		this.comboMinNormalIni = comboMinNormalIni;
	}

	/**
	 * @return the datoHoraNormalIni
	 */
	public Integer getDatoHoraNormalIni() {
		return datoHoraNormalIni;
	}

	/**
	 * @param datoHoraNormalIni the datoHoraNormalIni to set
	 */
	public void setDatoHoraNormalIni(Integer datoHoraNormalIni) {
		this.datoHoraNormalIni = datoHoraNormalIni;
	}

	/**
	 * @return the datoMinNormalIni
	 */
	public Integer getDatoMinNormalIni() {
		return datoMinNormalIni;
	}

	/**
	 * @param datoMinNormalIni the datoMinNormalIni to set
	 */
	public void setDatoMinNormalIni(Integer datoMinNormalIni) {
		this.datoMinNormalIni = datoMinNormalIni;
	}

	/**
	 * @return the datoHoraNormalFin
	 */
	public Integer getDatoHoraNormalFin() {
		return datoHoraNormalFin;
	}

	/**
	 * @param datoHoraNormalFin the datoHoraNormalFin to set
	 */
	public void setDatoHoraNormalFin(Integer datoHoraNormalFin) {
		this.datoHoraNormalFin = datoHoraNormalFin;
	}

	/**
	 * @return the datoMinNormalFin
	 */
	public Integer getDatoMinNormalFin() {
		return datoMinNormalFin;
	}

	/**
	 * @param datoMinNormalFin the datoMinNormalFin to set
	 */
	public void setDatoMinNormalFin(Integer datoMinNormalFin) {
		this.datoMinNormalFin = datoMinNormalFin;
	}

	/**
	 * @return the datoHoraRealIni
	 */
	public Integer getDatoHoraRealIni() {
		return datoHoraRealIni;
	}

	/**
	 * @param datoHoraRealIni the datoHoraRealIni to set
	 */
	public void setDatoHoraRealIni(Integer datoHoraRealIni) {
		this.datoHoraRealIni = datoHoraRealIni;
	}

	/**
	 * @return the datoMinRealIni
	 */
	public Integer getDatoMinRealIni() {
		return datoMinRealIni;
	}

	/**
	 * @param datoMinRealIni the datoMinRealIni to set
	 */
	public void setDatoMinRealIni(Integer datoMinRealIni) {
		this.datoMinRealIni = datoMinRealIni;
	}

	/**
	 * @return the datoHoraRealFin
	 */
	public Integer getDatoHoraRealFin() {
		return datoHoraRealFin;
	}

	/**
	 * @param datoHoraRealFin the datoHoraRealFin to set
	 */
	public void setDatoHoraRealFin(Integer datoHoraRealFin) {
		this.datoHoraRealFin = datoHoraRealFin;
	}

	/**
	 * @return the datoMinRealFin
	 */
	public Integer getDatoMinRealFin() {
		return datoMinRealFin;
	}

	/**
	 * @param datoMinRealFin the datoMinRealFin to set
	 */
	public void setDatoMinRealFin(Integer datoMinRealFin) {
		this.datoMinRealFin = datoMinRealFin;
	}

	

}
