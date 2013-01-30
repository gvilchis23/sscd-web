/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: DlgController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanCommandButton;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.DlgForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.DlgService;
import mx.gob.imss.cia.ssdc.cdv.servicios.SsdcException;
import mx.gob.imss.cia.ssdc.cdv.vo.CdvDatoGeneralVo;
import mx.gob.imss.cia.ssdc.cdv.vo.RegistroCdvPaavVo;
import mx.gob.imss.cia.ssdc.panel.controller.PanelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Gamaliel
 * 
 */
@Controller
@Scope("session")
public class DlgController extends PanelController {

	/**
	 * Variable de la forma de delegacion.
	 */
	@Autowired
	private DlgForm dlgForm;

	/**
     *
     */
	@Autowired
	private BackingBeanCommandButton backingButton;

	/**
     *
     */
	@Autowired
	private BackingBeanTable backingTable;

	// private CdvDatoGeneralVo detalleCdv;

	/**
     * 
     */
	@Autowired
	private DlgService dlgService;
	private Date fecha;
	private List<RegistroCdvPaavVo> listaDlgForm;
	private Long claveTabla;

	/**
	 * 
	 * @throws SsdcException
	 */
	@PostConstruct
	public void init() throws SsdcException {
		fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		getDlgForm().setTipo(0);
		getDlgForm().setMes(cal.MONTH);
		getDlgForm().setAnio(cal.YEAR);
		getDlgForm().setEstatus(0);
		getDlgForm().setUnidad(0);
		getBackingTable().getTableBinding().setValue(llenarTablaCdvPaav());
	}

	/**
	 * Obtiene la informacion elemental de la CDV con la que se este trabajando
	 * 
	 * @param cveCdv
	 * @return
	 */
	public void obtenerDetalleCdv() {

		CdvDatoGeneralVo detalleCdv = dlgService.obtenerDetalleCdv(getDlgForm()
				.getId());

		getDlgForm().setDelegacionModal(detalleCdv.getDelegacion());
		getDlgForm().setUnidadModal(detalleCdv.getUnidad());
		getDlgForm().setVentanillaModal(detalleCdv.getVentanilla());
		getDlgForm().setTurnoModal(detalleCdv.getTurno());
	}

	/**
	 * Permite buscar todos los estatus por tipo (CDV,PAAV)
	 */
	public void filtrarComboEstatus() {
		llenarComboEstatusPorTipoRegistro(dlgForm.getTipo());

	}

	/**
	 * Permite buscar todas las registros sea por tipo (CDV,PAAV), por mes o no,
	 * por anio o no y por estatus o no. Si los parametros vienen con valor cero
	 * significa que no filtrara la búsqueda por este y obtendrá todos los
	 * registros. Solo se podrá obtener CDV’s en estado PENDIENTE y LISTO.
	 * 
	 */
	public List<RegistroCdvPaavVo> llenarTablaCdvPaav() {
		listaDlgForm = dlgService.obtenListadoRegistroCdvPaav(getDlgForm()
				.getTipo(), getDlgForm().getMes(), getDlgForm().getAnio(),
				getDlgForm().getEstatus(), getDlgForm().getUnidad());
		return listaDlgForm;
	}

	/**
	 * Guarda en BD la razon y la fecha limite para autorizar cambios. Esta
	 * tabla aún no se encuentra en la BD se realizo la petición para que se
	 * reaalice esta modificación.
	 * 
	 */
	public void guardarAutorizacionCambios() {
		dlgService.guardarAutorizacionCambios(getDlgForm().getId(),
				getDlgForm().getRazonModal(), getDlgForm()
						.getFechaLimiteModal());

	}

	public void generarInforme(ActionEvent e) {
		String imgReporte = "../../images/pdf.png";
		getDlgForm().setImgReporte(imgReporte);
	}

	/**
	 * @return the dlgForm
	 */
	public DlgForm getDlgForm() {
		return dlgForm;
	}

	/**
	 * @param dlgForm
	 *            the dlgForm to set
	 */
	public void setDlgForm(DlgForm dlgForm) {
		this.dlgForm = dlgForm;
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
	 * @return the claveTabla
	 */
	public Long getClaveTabla() {
		return claveTabla;
	}

	/**
	 * @param claveTabla
	 *            the claveTabla to set
	 */
	public void setClaveTabla(Long claveTabla) {
		this.claveTabla = claveTabla;
	}

}
