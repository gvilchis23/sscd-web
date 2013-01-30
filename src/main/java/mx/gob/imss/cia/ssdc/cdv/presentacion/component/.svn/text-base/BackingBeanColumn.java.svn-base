/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: BackingBeanColumn.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.component;

import org.richfaces.component.html.HtmlColumn;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Qualifier("backingColumn")
public class BackingBeanColumn {
	private HtmlColumn columnBinding;
	private HtmlColumn presupColumnBinding;

	/**
	 * @return the columnBinding
	 */
	public HtmlColumn getColumnBinding() {
		return columnBinding;
	}

	/**
	 * @param columnBindingthe
	 *            columnBinding to set
	 */
	public void setColumnBinding(HtmlColumn columnBinding) {
		this.columnBinding = columnBinding;
	}

	public HtmlColumn getPresupColumnBinding() {
		return presupColumnBinding;
	}

	public void setPresupColumnBinding(HtmlColumn delegacionColumnBinding) {
		this.presupColumnBinding = delegacionColumnBinding;
	}

}
