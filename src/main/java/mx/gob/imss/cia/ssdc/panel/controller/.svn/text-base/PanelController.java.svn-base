/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: catalogosController.java
 *
 * Creado:  07/11/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.panel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.panel.form.PanelForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.vo.AnyoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.DelegacionVo;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.MesVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoInformeVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoRegistroVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoVentanillaVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TurnoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.UnidadVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Gamaliel
 * 
 */

@Controller
@Scope("request")
public class PanelController {
	@Autowired
	private BusquedaService busquedaService;
	@Autowired
	private PanelForm panelForm;

	@PostConstruct
	public void llenarCombos() {
		llenarComboAnio();
		llenarComboDelegacion();
		llenarComboEstatus();
		llenarComboMes();
		llenarComboTipo();
		llenarComboTipoInforme();
		llenarComboTipoVentanilla();
		llenarComboTurno();
		llenarComboUnidad();
	}

	public final void llenarComboTipo() {
		List<SelectItem> comboTipo = new ArrayList<SelectItem>();
		List<TipoRegistroVo> tipoVO = busquedaService.obtieneListadoTipo();
		for (TipoRegistroVo vo : tipoVO) {
			comboTipo.add(new SelectItem(vo.getClave(), vo.getTipo()));
		}
		getPanelForm().setComboTipo(comboTipo);

	}

	public final void llenarComboMes() {
		List<SelectItem> comboMes = new ArrayList<SelectItem>();
		List<MesVo> mesVO = busquedaService.obtieneListadoMes();
		for (MesVo vo : mesVO) {
			comboMes.add(new SelectItem(vo.getClave(), vo.getMes()));
		}
		getPanelForm().setComboMes(comboMes);
	}

	public final void llenarComboAnio() {
		List<SelectItem> comboAnio = new ArrayList<SelectItem>();
		List<AnyoVo> anioVO = busquedaService.obtieneListadoAnyo();
		for (AnyoVo vo : anioVO) {
			comboAnio.add(new SelectItem(vo.getClave(), vo.getAnyo()));
		}
		getPanelForm().setComboAnio(comboAnio);
	}

	public final void llenarComboDelegacion() {
		List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();
		List<DelegacionVo> delegacionVO = busquedaService
				.obtieneListadoDelegacion();
		for (DelegacionVo vo : delegacionVO) {
			comboDelegacion.add(new SelectItem(vo.getClave(), vo
					.getDelegacion()));
		}
		getPanelForm().setComboDelegacion(comboDelegacion);
	}

	public final void llenarComboUnidad() {
		List<SelectItem> comboUnidad = new ArrayList<SelectItem>();
		List<UnidadVo> unidadVO = busquedaService.obtieneListadoUnidad();
		for (UnidadVo vo : unidadVO) {
			comboUnidad.add(new SelectItem(vo.getClave(), vo.getUnidad()));
		}
		getPanelForm().setComboUnidad(comboUnidad);
	}

	public final void llenarComboTipoVentanilla() {
		List<SelectItem> comboTipoVentanilla = new ArrayList<SelectItem>();
		List<TipoVentanillaVo> tipoVentanillaVO = busquedaService
				.obtieneListadoTipoVentanilla();
		for (TipoVentanillaVo vo : tipoVentanillaVO) {
			comboTipoVentanilla.add(new SelectItem(vo.getClave(), vo
					.getTipoVentanilla()));
		}
		getPanelForm().setComboTipoVentanilla(comboTipoVentanilla);
	}

	public final void llenarComboTurno() {
		List<SelectItem> comboTurno = new ArrayList<SelectItem>();
		List<TurnoVo> turnoVO = busquedaService.obtieneListadoTurno();
		for (TurnoVo vo : turnoVO) {
			comboTurno.add(new SelectItem(vo.getClave(), vo.getTurno()));
		}
		getPanelForm().setComboTurno(comboTurno);
	}

	public final void llenarComboTipoInforme() {
		List<SelectItem> comboTipoInforme = new ArrayList<SelectItem>();
		List<TipoInformeVo> tipoInformeVO = busquedaService
				.obtieneListadoTipoInforme();
		for (TipoInformeVo vo : tipoInformeVO) {
			comboTipoInforme.add(new SelectItem(vo.getClave(), vo
					.getTipoInforme()));
		}
		getPanelForm().setComboTipoInforme(comboTipoInforme);

	}

	public final void llenarComboEstatus() {
		List<SelectItem> comboEstatus = new ArrayList<SelectItem>();
		List<EstatusVo> estatusVO = busquedaService.obtieneListadoEstatus();
		for (EstatusVo vo : estatusVO) {
			comboEstatus.add(new SelectItem(vo.getClave(), vo.getEstatus()));
		}
		getPanelForm().setComboEstatus(comboEstatus);
	}

	public void llenarComboEstatusPorTipoRegistro(long tipoRegistro) {
		List<SelectItem> comboEstatus = new ArrayList<SelectItem>();
		List<EstatusVo> estatusVO = busquedaService
				.obtieneListadoEstatusPorTipoRegistro(tipoRegistro);
		for (EstatusVo vo : estatusVO) {
			comboEstatus.add(new SelectItem(vo.getClave(), vo.getEstatus()));
		}
		getPanelForm().setComboEstatus(comboEstatus);

	}

	/**
	 * @return the panelForm
	 */
	public PanelForm getPanelForm() {
		return panelForm;
	}

	/**
	 * @param panelForm
	 *            the panelForm to set
	 */
	public void setPanelForm(PanelForm panelForm) {
		this.panelForm = panelForm;
	}

}
