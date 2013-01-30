/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcServiciosForm.java
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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cdvServiciosForm")
@Scope("session")
public class EdcServiciosForm implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long datoCategoriaServicio;
	private Integer datoServicio;
	private Integer datoResultadoServicio;
	private List<String>  listaRequisitos;
	private ArrayList<SelectItem>pickRequisitos=new ArrayList<SelectItem>();
	private ArrayList<SelectItem>pickDifusion=new ArrayList<SelectItem>();
	private ArrayList<SelectItem>comboHoraNormalIni;
	private ArrayList<SelectItem>comboMinNormalIni;
	private Integer datoHoraEspera;
	private Integer datoMinEspera;
	private Integer datoSegEspera;
	private Integer datoHoraPromedio;
	private Integer datoMinPromedio;
	private Integer datoSegPromedio;
	private Integer datoHoraAtencion;
	private Integer datoMinAtencion;
	private Integer datoSegAtencion;
	private Integer atendidos;
	
	
	
	public EdcServiciosForm(){
		
	}

	/**
	 * @return the datoCategoriaServicio
	 */
	public Long getDatoCategoriaServicio() {
		return datoCategoriaServicio;
	}

	/**
	 * @param datoCategoriaServicio the datoCategoriaServicio to set
	 */
	public void setDatoCategoriaServicio(Long datoCategoriaServicio) {
		this.datoCategoriaServicio = datoCategoriaServicio;
	}

	

	/**
	 * @return the datoServicio
	 */
	public Integer getDatoServicio() {
		return datoServicio;
	}

	/**
	 * @param datoServicio the datoServicio to set
	 */
	public void setDatoServicio(Integer datoServicio) {
		this.datoServicio = datoServicio;
	}

	/**
	 * @return the datoResultadoServicio
	 */
	public Integer getDatoResultadoServicio() {
		return datoResultadoServicio;
	}

	/**
	 * @param datoResultadoServicio the datoResultadoServicio to set
	 */
	public void setDatoResultadoServicio(Integer datoResultadoServicio) {
		this.datoResultadoServicio = datoResultadoServicio;
	}

	/**
	 * @return the listaRequisitos
	 */
	public List<String>  getListaRequisitos() {
		return listaRequisitos;
	}

	/**
	 * @param listaRequisitos the listaRequisitos to set
	 */
	public void setListaRequisitos(List<String>  listaRequisitos) {
		this.listaRequisitos = listaRequisitos;
	}

	/**
	 * @return the pickRequisitos
	 */
	public ArrayList<SelectItem> getPickRequisitos() {
		return pickRequisitos;
	}

	/**
	 * @param pickRequisitos the pickRequisitos to set
	 */
	public void setPickRequisitos(ArrayList<SelectItem> pickRequisitos) {
		this.pickRequisitos = pickRequisitos;
	}

	/**
	 * @return the pickDifusion
	 */
	public ArrayList<SelectItem> getPickDifusion() {
		return pickDifusion;
	}

	/**
	 * @param pickDifusion the pickDifusion to set
	 */
	public void setPickDifusion(ArrayList<SelectItem> pickDifusion) {
		this.pickDifusion = pickDifusion;
	}
	
	/**
	 * @return the comboHoraNormalIni
	 */
	public ArrayList<SelectItem> getComboHoraNormalIni() {
		ArrayList<SelectItem>combo=new ArrayList<SelectItem>();
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
	public void setComboHoraNormalIni(ArrayList<SelectItem> comboHoraNormalIni) {
		this.comboHoraNormalIni = comboHoraNormalIni;
	}

	
	/**
	 * @return the comboMinNormalIni
	 */
	public ArrayList<SelectItem> getComboMinNormalIni() {
		ArrayList<SelectItem>combo=new ArrayList<SelectItem>();
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
	public void setComboMinNormalIni(ArrayList<SelectItem> comboMinNormalIni) {
		this.comboMinNormalIni = comboMinNormalIni;
	}

	/**
	 * @return the datoHoraEspera
	 */
	public Integer getDatoHoraEspera() {
		return datoHoraEspera;
	}

	/**
	 * @param datoHoraEspera the datoHoraEspera to set
	 */
	public void setDatoHoraEspera(Integer datoHoraEspera) {
		this.datoHoraEspera = datoHoraEspera;
	}

	/**
	 * @return the datoMinEspera
	 */
	public Integer getDatoMinEspera() {
		return datoMinEspera;
	}

	/**
	 * @param datoMinEspera the datoMinEspera to set
	 */
	public void setDatoMinEspera(Integer datoMinEspera) {
		this.datoMinEspera = datoMinEspera;
	}

	/**
	 * @return the datoHoraPromedio
	 */
	public Integer getDatoHoraPromedio() {
		return datoHoraPromedio;
	}

	/**
	 * @param datoHoraPromedio the datoHoraPromedio to set
	 */
	public void setDatoHoraPromedio(Integer datoHoraPromedio) {
		this.datoHoraPromedio = datoHoraPromedio;
	}

	/**
	 * @return the datoMinPromedio
	 */
	public Integer getDatoMinPromedio() {
		return datoMinPromedio;
	}

	/**
	 * @param datoMinPromedio the datoMinPromedio to set
	 */
	public void setDatoMinPromedio(Integer datoMinPromedio) {
		this.datoMinPromedio = datoMinPromedio;
	}

	/**
	 * @return the datoHoraAtencion
	 */
	public Integer getDatoHoraAtencion() {
		return datoHoraAtencion;
	}

	/**
	 * @param datoHoraAtencion the datoHoraAtencion to set
	 */
	public void setDatoHoraAtencion(Integer datoHoraAtencion) {
		this.datoHoraAtencion = datoHoraAtencion;
	}

	/**
	 * @return the datoMinAtencion
	 */
	public Integer getDatoMinAtencion() {
		return datoMinAtencion;
	}

	/**
	 * @param datoMinAtencion the datoMinAtencion to set
	 */
	public void setDatoMinAtencion(Integer datoMinAtencion) {
		this.datoMinAtencion = datoMinAtencion;
	}

	/**
	 * @return the atendidos
	 */
	public Integer getAtendidos() {
		return atendidos;
	}

	/**
	 * @param atendidos the atendidos to set
	 */
	public void setAtendidos(Integer atendidos) {
		this.atendidos = atendidos;
	}

	/**
	 * @return the datoSegEspera
	 */
	public Integer getDatoSegEspera() {
		return datoSegEspera;
	}

	/**
	 * @param datoSegEspera the datoSegEspera to set
	 */
	public void setDatoSegEspera(Integer datoSegEspera) {
		this.datoSegEspera = datoSegEspera;
	}

	/**
	 * @return the datoSegPromedio
	 */
	public Integer getDatoSegPromedio() {
		return datoSegPromedio;
	}

	/**
	 * @param datoSegPromedio the datoSegPromedio to set
	 */
	public void setDatoSegPromedio(Integer datoSegPromedio) {
		this.datoSegPromedio = datoSegPromedio;
	}

	/**
	 * @return the datoSegAtencion
	 */
	public Integer getDatoSegAtencion() {
		return datoSegAtencion;
	}

	/**
	 * @param datoSegAtencion the datoSegAtencion to set
	 */
	public void setDatoSegAtencion(Integer datoSegAtencion) {
		this.datoSegAtencion = datoSegAtencion;
	}
	
	
	
	
	
	
	

	
}
