/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: RpoController.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.RpoForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class RpoController {
	@Autowired
	private RpoForm rpoForm;
	@Autowired
	private BackingBeanTable backingTable;

	@PostConstruct
	public void init() {
		llenarComboAnio();
		llenarComboDelegacion();
		llenarComboMes();
		llenarComboTipoReporte();
		llenarComboUnidad();
		getBackingTable().getTableBinding().setValue(cargarTabla());
	}

	public void llenarComboTipoReporte() {
		List<SelectItem> comboTipoReporte = new ArrayList<SelectItem>();
		comboTipoReporte.add(new SelectItem(1, "Informe Ejecutivo"));
		comboTipoReporte.add(new SelectItem(2, "Informe Delegacional"));
		comboTipoReporte.add(new SelectItem(3, "Informe UMAES"));
		getRpoForm().setColspan("10");
		getRpoForm().setComboTipoReporte(comboTipoReporte);
	}

	public void ocultarCombos() {
		if (getRpoForm().getTipoReporte().equals("2")) {
			getRpoForm().setOcultarComboUni("none");
			getRpoForm().setColspan("8");
		} else if (getRpoForm().getTipoReporte().equals("3")) {
			getRpoForm().setOcultarComboDel("none");
			getRpoForm().setOcultarComboUni("none");
			getRpoForm().setColspan("6");
		} else if (getRpoForm().getTipoReporte().equals("1")) {
			getRpoForm().setOcultarComboDel("display");
			getRpoForm().setOcultarComboUni("display");
			getRpoForm().setColspan("10");
		}

	}

	public void llenarComboDelegacion() {
		List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();
		comboDelegacion.add(new SelectItem(0, "Todas"));
		comboDelegacion.add(new SelectItem(1, "Df Norte"));
		comboDelegacion.add(new SelectItem(2, "Df Sur"));
		getRpoForm().setComboDelegacion(comboDelegacion);
	}

	public void llenarComboUnidad() {
		List<SelectItem> comboUnidad = new ArrayList<SelectItem>();
		comboUnidad.add(new SelectItem(0, "Todas"));
		comboUnidad.add(new SelectItem(1, "UMAE-DF NORTE"));
		comboUnidad.add(new SelectItem(2, "UMAE-DF SUR"));
		getRpoForm().setComboUnidad(comboUnidad);
	}

	public void llenarComboMes() {
		List<SelectItem> comboMes = new ArrayList<SelectItem>();
		comboMes.add(new SelectItem(0, "Todos"));
		comboMes.add(new SelectItem(1, "Enero"));
		comboMes.add(new SelectItem(2, "Febrero"));
		comboMes.add(new SelectItem(3, "Marzo"));
		comboMes.add(new SelectItem(4, "Abril"));
		comboMes.add(new SelectItem(5, "Mayo"));
		comboMes.add(new SelectItem(6, "Junio"));
		comboMes.add(new SelectItem(7, "Julio"));
		comboMes.add(new SelectItem(8, "Agosto"));
		comboMes.add(new SelectItem(9, "Septiembre"));
		comboMes.add(new SelectItem(10, "Octubre"));
		comboMes.add(new SelectItem(11, "Noviembre"));
		comboMes.add(new SelectItem(12, "Diciembre"));
		getRpoForm().setComboMes(comboMes);
	}

	public void llenarComboAnio() {
		List<SelectItem> comboAnio = new ArrayList<SelectItem>();
		comboAnio.add(new SelectItem(0, "Todos"));
		comboAnio.add(new SelectItem(2011, "2011"));
		comboAnio.add(new SelectItem(2012, "2012"));
		getRpoForm().setComboAnio(comboAnio);
	}

	public List<RpoForm> cargarTabla() {
		List<RpoForm> tabla = new ArrayList<RpoForm>();
		getRpoForm().setLevantamientoTabla("PRO_CDV_SEP_2011");
		getRpoForm().setFechaTabla("24/10/2011");
		getRpoForm().setEstatusTabla("Completo");
		getRpoForm().setInformeTabla("");
		tabla.add(getRpoForm());
		return tabla;
	}

	public void generarInfome(ActionEvent e) {
		getRpoForm().setInformeTabla("../../images/pdf.png");
	}

	/**
	 * @return the rpoForm
	 */
	public RpoForm getRpoForm() {
		return rpoForm;
	}

	/**
	 * @param rpoForm
	 *            the rpoForm to set
	 */
	public void setRpoForm(RpoForm rpoForm) {
		this.rpoForm = rpoForm;
	}

	/**
	 * @return the backingTable
	 */
	public BackingBeanTable getBackingTable() {
		return backingTable;
	}

	/**
	 * @param backingTable
	 *            the backingTable to set
	 */
	public void setBackingTable(BackingBeanTable backingTable) {
		this.backingTable = backingTable;
	}

}
