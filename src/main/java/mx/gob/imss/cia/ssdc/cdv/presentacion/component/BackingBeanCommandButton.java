/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: BackingBeanCommandButton.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.component;

import javax.faces.component.html.HtmlCommandButton;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Qualifier("backingButton")
public class BackingBeanCommandButton {
	
	private HtmlCommandButton botonBinding;

	/**
	 * @return the botonBinding
	 */
	public HtmlCommandButton getBotonBinding() {
		return botonBinding;
	}

	/**
	 * @param botonBinding the botonBinding to set
	 */
	public void setBotonBinding(HtmlCommandButton botonBinding) {
		this.botonBinding = botonBinding;
	}

	
}
