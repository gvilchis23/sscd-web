/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: BackingBeanTable.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.component;

import org.richfaces.component.html.HtmlDataTable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Guillermo Vilchis Gonzalez
 *
 */
@Component
@Scope("request")
@Qualifier("backingTable")
public class BackingBeanTable {
	
	private HtmlDataTable tableBinding ;
	
	
	public BackingBeanTable() {
	      tableBinding = new HtmlDataTable() ;
	   }


	/**
	 * @return the tableBinding
	 */
	public HtmlDataTable getTableBinding() {
		return tableBinding;
	}

	/**
	 * @param tableBinding the tableBinding to set
	 */
	public void setTableBinding(HtmlDataTable tableBinding) {
		this.tableBinding = tableBinding;
	}

	
}
