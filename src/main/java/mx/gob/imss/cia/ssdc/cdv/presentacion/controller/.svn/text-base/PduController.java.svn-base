/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PduController.java
 *
 * Creado: 12/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.PduForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.PduService;
import mx.gob.imss.cia.ssdc.cdv.servicios.SsdcException;
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
@Scope("request")
public class PduController extends PanelController {

	@Autowired
	private PduForm pduForm;
	@Autowired
	private BackingBeanTable backingTable;
	@Autowired
	private PduService pduService;
	private Calendar fechaActual;

	@PostConstruct
	public void init() throws SsdcException {
		fechaActual = Calendar.getInstance();
		getPduForm().setTipo(0);
		getPduForm().setMes(fechaActual.get(Calendar.MONTH) + 1);
		getPduForm().setAnio(fechaActual.get(Calendar.YEAR));
		getPduForm().setEstatus(0);
		getBackingTable().getTableBinding().setValue(llenarTablaCdvPaav());
	}

	public void filtrarComboEstatus() {
		llenarComboEstatusPorTipoRegistro(pduForm.getTipo());

	}

	public List<PduForm> llenarTablaCdvPaav() {
		List<PduForm> listaPduForm = new ArrayList<PduForm>();

		List<RegistroCdvPaavVo> listaCdvPaav = pduService
				.obtenListadoRegistroCdvPaav(getPduForm().getTipo(),
						getPduForm().getMes(), getPduForm().getAnio(),
						getPduForm().getEstatus());

		for (RegistroCdvPaavVo vo : listaCdvPaav) {
			pduForm.setId(Long.valueOf(vo.getId()));
			pduForm.setEstatusTabla(vo.getEstatus());
			pduForm.setNombre(vo.getNombre());
			pduForm.setTipoTabla(vo.getTipo());
			pduForm.setFecha(vo.getFecha());
			pduForm.setImgReporte(vo.getReporte());
			listaPduForm.add(pduForm);
		}

		return listaPduForm;
	}

	public void crearCdv() {
		pduService.crearCdv(getPduForm().getDelegacionModal(), getPduForm()
				.getUnidadModal(), getPduForm().getTipoVentanillaModal(),
				getPduForm().getTurnoModal());
	}

	public void generarInforme(ActionEvent e) {
		String imgReporte = "../../images/pdf.png";
		getPduForm().setImgReporte(imgReporte);
	}

	void enviarCdv() {
		pduService.enviarCdv(getPduForm().getId());
	}

	void eliminarCdv() {
		pduService.eliminarCdv(getPduForm().getId());
	}

	/**
	 * @return the pduForm
	 */
	public PduForm getPduForm() {
		return pduForm;
	}

	/**
	 * @param pduForm
	 *            the pduForm to set
	 */
	public void setPduForm(PduForm pduForm) {
		this.pduForm = pduForm;
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
