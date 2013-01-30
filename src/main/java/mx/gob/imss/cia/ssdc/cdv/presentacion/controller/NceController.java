/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: NceController.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import mx.gob.imss.cia.ssdc.cdv.presentacion.form.NceForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NceController{
	@Autowired
	private NceForm nceForm;
}
