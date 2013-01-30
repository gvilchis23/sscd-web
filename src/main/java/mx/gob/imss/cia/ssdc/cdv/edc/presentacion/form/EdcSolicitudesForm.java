/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcSolicitudesForm.java
 *
 * Creado:  18/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("edcSolicitudesForm")
@Scope("session")
public class EdcSolicitudesForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<SelectItem>pickCausas=new ArrayList<SelectItem>();
	private Integer datoPromSolRecibidas;
	private Integer datoPromSolAtendidas;
	
	public EdcSolicitudesForm(){
		
	}
		
	public ArrayList<SelectItem> getPickCausas() {
		return pickCausas;
	}
	public void setPickRequisitos(ArrayList<SelectItem> pickCausas) {
		this.pickCausas = pickCausas;
	}
	public Integer getDatoPromSolRecibidas() {
		return datoPromSolRecibidas;
	}
	public void setDatoPromSolRecibidas(Integer datoPromSolRecibidas) {
		this.datoPromSolRecibidas = datoPromSolRecibidas;
	}
	public Integer getDatoPromSolAtendidas() {
		return datoPromSolAtendidas;
	}
	public void setDatoPromSolAtendidas(Integer datoPromSolAtendidas) {
		this.datoPromSolAtendidas = datoPromSolAtendidas;
	}
	
	

}
