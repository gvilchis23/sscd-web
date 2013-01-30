/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: InterrelacionadasController.java
 *
 * Creado:  14/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author AbySavvy
 *
 */

@Controller
@Scope("session")
public class PerfilesController {
	
	public BackingBeanTable getBackingTable() {
		return backingTable;
	}

	public void setBackingTable(BackingBeanTable backingTable) {
		this.backingTable = backingTable;
	}

	@Autowired
	private BackingBeanTable backingTable;
	

}
