/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PadController.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanCommandButton;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.PadForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.PadService;
import mx.gob.imss.cia.ssdc.cdv.vo.RegistroCdvPaavVo;
import mx.gob.imss.cia.ssdc.panel.controller.PanelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class PadController extends PanelController {

	@Autowired
	private PadForm padForm;

	@Autowired
	private PadService padService;

	@Autowired
	private BackingBeanTable backingTable;

	@Autowired
	private BackingBeanCommandButton backingButton;

	private int page = 1;

	@PostConstruct
	public void init() {
		llenarComboNotificacion();
		getBackingTable().getTableBinding().setValue(cargarTabla());
	}

	public void filtrarComboEstatus() {
		llenarComboEstatusPorTipoRegistro(Long.valueOf(padForm.getTipo()));

	}

	public List<RegistroCdvPaavVo> cargarTabla() {
		return padService.obtenListadoRegistroCdvPaav();
	}

	public void generarInforme(ActionEvent e) {
		getPadForm().setInformeTabla("../../images/pdf.png");
	}

	public void autorizarCambios() {

	}

	// TODO: Realizar la implementacion cuando el padService este completo
	public void llenarComboNotificacion() {
	}

	public void llenarNotificacion() {
		if (getPadForm().getTipoNotificacion().equals("1"))
			getPadForm().setNotificacion("Todas Mock");
		else if (getPadForm().getTipoNotificacion().equals("2"))
			getPadForm().setNotificacion("CambiosAutorizados Mock");
	}

	public void guardarNotificacion(ActionEvent e) {

	}

	/**
	 * @return the padForm
	 */
	public PadForm getPadForm() {
		return padForm;
	}

	/**
	 * @param padForm
	 *            the padForm to set
	 */
	public void setPadForm(PadForm padForm) {
		this.padForm = padForm;
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

	/**
	 * @return the backingButton
	 */
	public BackingBeanCommandButton getBackingButton() {
		return backingButton;
	}

	/**
	 * @param backingButton
	 *            the backingButton to set
	 */
	public void setBackingButton(BackingBeanCommandButton backingButton) {
		this.backingButton = backingButton;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

}
