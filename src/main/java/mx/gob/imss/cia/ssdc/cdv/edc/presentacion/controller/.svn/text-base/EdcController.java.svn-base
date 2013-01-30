/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: EdcController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcEncabezadoForm;
import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcGeneralesService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.edc.vo.CabeceraDatosGeneralesVo;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CatServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CategoriaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvPersonaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.LlaveCompuestaCdvPersona;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonaPropiaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PuestoEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoUnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoVentanillaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TurnoEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.UnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.vo.DelegacionVo;
import mx.gob.imss.cia.ssdc.commons.Constantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class EdcController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EdcForm cdvForm;

	@Autowired
	private EdcEncabezadoForm edcEncabezadoForm;

	@Autowired
	private EdcGeneralesService edcGeneralesService;

	@Autowired
	private BusquedaService busquedaService;

	@Autowired
	private EdcService edcService;

	private List<SelectItem> comboDelegacion = new ArrayList<SelectItem>();

	private List<SelectItem> comboTipoUnidad = new ArrayList<SelectItem>();

	private List<SelectItem> comboUnidad = new ArrayList<SelectItem>();

	private List<SelectItem> comboTipoVentanilla = new ArrayList<SelectItem>();

	private List<SelectItem> comboTurno = new ArrayList<SelectItem>();

	private String datoPersonaInfo;

	private Integer datoPersonaId;

	private String error = "";

	private String menu = "footer";

	@PostConstruct
	public void init() {
		llenarComboDelegacion();
		llenarComboTipoVentanilla();
		llenarComboTurno();
		llenarPersonaInfo();
		encabezado();
		llenarDatosGeneralesCabecera();
	}

	/**
	 * @return the edcService
	 */
	public EdcService getEdcService() {
		return edcService;
	}

	/**
	 * @param edcService
	 *            the edcService to set
	 */
	public void setEdcService(EdcService edcService) {
		this.edcService = edcService;
	}

	/**
	 * @return the cdvForm
	 */
	public EdcForm getCdvForm() {
		return cdvForm;
	}

	/**
	 * @param cdvForm
	 *            the cdvForm to set
	 */
	public void setCdvForm(EdcForm cdvForm) {
		this.cdvForm = cdvForm;
	}

	/**
	 * @return the edcGeneralesService
	 */
	public EdcGeneralesService getEdcGeneralesService() {
		return edcGeneralesService;
	}

	/**
	 * @param edcGeneralesService
	 *            the edcGeneralesService to set
	 */
	public void setEdcGeneralesService(EdcGeneralesService edcGeneralesService) {
		this.edcGeneralesService = edcGeneralesService;
	}

	/**
	 * @return the comboDelegacion
	 */
	public List<SelectItem> getComboDelegacion() {
		return comboDelegacion;
	}

	/**
	 * @param comboDelegacion
	 *            the comboDelegacion to set
	 */
	public void setComboDelegacion(List<SelectItem> comboDelegacion) {
		this.comboDelegacion = comboDelegacion;
	}

	/**
	 * @return the comboTipoUnidad
	 */
	public List<SelectItem> getComboTipoUnidad() {
		return comboTipoUnidad;
	}

	/**
	 * @param comboTipoUnidad
	 *            the comboTipoUnidad to set
	 */
	public void setComboTipoUnidad(List<SelectItem> comboTipoUnidad) {
		this.comboTipoUnidad = comboTipoUnidad;
	}

	/**
	 * @return the comboUnidad
	 */
	public List<SelectItem> getComboUnidad() {
		return comboUnidad;
	}

	/**
	 * @param comboUnidad
	 *            the comboUnidad to set
	 */
	public void setComboUnidad(List<SelectItem> comboUnidad) {
		this.comboUnidad = comboUnidad;
	}

	/**
	 * @return the comboTipoVentanilla
	 */
	public List<SelectItem> getComboTipoVentanilla() {
		return comboTipoVentanilla;
	}

	/**
	 * @param comboTipoVentanilla
	 *            the comboTipoVentanilla to set
	 */
	public void setComboTipoVentanilla(List<SelectItem> comboTipoVentanilla) {
		this.comboTipoVentanilla = comboTipoVentanilla;
	}

	/**
	 * @return the comboTurno
	 */
	public List<SelectItem> getComboTurno() {
		return comboTurno;
	}

	/**
	 * @param comboTurno
	 *            the comboTurno to set
	 */
	public void setComboTurno(List<SelectItem> comboTurno) {
		this.comboTurno = comboTurno;
	}

	/**
	 * @return the datoPersonaInfo
	 */
	public String getDatoPersonaInfo() {
		return datoPersonaInfo;
	}

	/**
	 * @param datoPersonaInfo
	 *            the datoPersonaInfo to set
	 */
	public void setDatoPersonaInfo(String datoPersonaInfo) {
		this.datoPersonaInfo = datoPersonaInfo;
	}

	/**
	 * @return the datoPersonaId
	 */
	public Integer getDatoPersonaId() {
		return datoPersonaId;
	}

	/**
	 * @param datoPersonaId
	 *            the datoPersonaId to set
	 */
	public void setDatoPersonaId(Integer datoPersonaId) {
		this.datoPersonaId = datoPersonaId;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the edcEncabezadoForm
	 */
	public EdcEncabezadoForm getEdcEncabezadoForm() {
		return edcEncabezadoForm;
	}

	/**
	 * @param edcEncabezadoForm
	 *            the edcEncabezadoForm to set
	 */
	public void setEdcEncabezadoForm(EdcEncabezadoForm edcEncabezadoForm) {
		this.edcEncabezadoForm = edcEncabezadoForm;
	}

	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	// METODO PARA LLENAR EL COMBO DELEGACION
	public void llenarComboDelegacion() {
		List<DelegacionVo> lista = busquedaService.obtieneListadoDelegacion();
		List<SelectItem> combo = new ArrayList<SelectItem>();

		for (DelegacionVo delegacion : lista) {
			combo.add(new SelectItem(delegacion.getClave(), delegacion
					.getDelegacion()));
		}

		setComboDelegacion(combo);

	}

	// METODO PARA LLENAR EL COMBO UNIDAD
	public void llenarComboUnidad(ActionEvent e) {
		Long cveDelegacion = getCdvForm().getDatoDelegacion();// vendra lleno de
																// panel de
																// unidad
		List<UnidadEntity> lista = edcGeneralesService
				.llenarComboUnidad(cveDelegacion);
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (UnidadEntity unidad : lista) {
			combo.add(new SelectItem(unidad.getCveUnidad(), unidad
					.getNombreUnidad()));
		}
		setComboUnidad(combo);
	}

	// METODO PARA LLENAR EL COMBO TIPO UNIDAD
	public void llenarComboTipoUnidad(ActionEvent e) {
		TipoUnidadEntity tipoUnidad = edcGeneralesService
				.llenarComboTipoUnidad(Long.valueOf(getCdvForm()
						.getDatoTipoUnidad()));

		List<SelectItem> combo = new ArrayList<SelectItem>();
		combo.add(new SelectItem(tipoUnidad.getCveTipoUnidad(), tipoUnidad
				.getNombreTipoUnidad()));

		setComboTipoUnidad(combo);
	}

	// METODO PARA LLENAR EL COMBO TIPO VENTANILLA
	public void llenarComboTipoVentanilla() {
		List<TipoVentanillaEntity> lista = edcGeneralesService
				.llenarComboTipoVentanilla();
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (TipoVentanillaEntity ventanilla : lista) {
			combo.add(new SelectItem(ventanilla.getCveTipoVentanilla(),
					ventanilla.getNombreTipoVentanilla()));
		}
		setComboTipoVentanilla(combo);
	}

	// METODO PARA LLENAR EL COMBO TURNO
	public void llenarComboTurno() {
		List<TurnoEntity> lista = edcGeneralesService.llenarComboTurno();
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (TurnoEntity turno : lista) {
			combo.add(new SelectItem(turno.getCveTurno(), turno
					.getDescripcionTurno()));
		}
		setComboTurno(combo);
	}

	// METODO PARA LLENAR EL COMBO CATEGORIA
	public void llenarComboCategoria() {
		List<CategoriaEntity> lista = edcGeneralesService
				.llenarComboCategoria();
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (CategoriaEntity categoria : lista) {
			combo.add(new SelectItem(categoria.getCveCategoria(), categoria
					.getNomCategoria()));
		}
		getCdvForm().setComboCategoria(combo);

	}

	// METODO PARA LLENAR EL COMBO PUESTO
	public void llenarComboPuesto() {
		List<PuestoEntity> lista = edcGeneralesService.llenarComboPuesto();
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (PuestoEntity puesto : lista) {
			combo.add(new SelectItem(puesto.getCvePuesto(), puesto
					.getNomPuesto()));
		}
		getCdvForm().setComboPuesto(combo);
	}

	// METODO DEL SUPPORT PARA LLENAR COMBOS EN EL MODAL
	public void llenarCombosModal() {
		llenarComboCategoria();
		llenarComboPuesto();
	}

	// METODO PARA GUARDAR PERSONAL INFO
	// TODO: Corregir esta implementacion
	public void guardarPersonaInfo() {
		PersonaPropiaEntity entidad = new PersonaPropiaEntity();
		entidad.setApellidoPaterno(getCdvForm().getDatoModalApellidoP());
		entidad.setApellidoMaterno(getCdvForm().getDatoModalApellidoM());
		entidad.setCorreoElectronico(getCdvForm().getDatoModalCorreo());
		CatServicioEntity categoria = edcGeneralesService
				.recuperarCategoria(Long.valueOf(getCdvForm()
						.getDatoModalCategoria()));
		entidad.setCatServicio(categoria);
		PuestoEntity puesto = edcGeneralesService.recuperarPuesto(Long
				.valueOf(getCdvForm().getDatoModalPuesto()));
		entidad.setPuesto(puesto);
		entidad.setExtension(getCdvForm().getDatoModalExtension());
		entidad.setLada(getCdvForm().getDatoModalLada());
		entidad.setNombre(getCdvForm().getDatoModalNombre());
		entidad.setStatus(Constantes.ENABLE);
		entidad.setTelefono(getCdvForm().getDatoModalTelefono());
		// Recuperar de panel de unidad
		TipoVentanillaEntity ventanilla = edcService.recuperarVentanilla(1L);
		entidad.setTipoVentanilla(ventanilla);
		// Recuperar de panel de unidad
		UnidadEntity unidad = edcGeneralesService.recuperarUnidad(1L);
		entidad.setUnidad(unidad);
		edcGeneralesService.guardadPersonaInfo(entidad, getDatoPersonaId());

	}

	// METODO PARA LLENAR LA PERSONA FALTA MANDAR EL TIPO DE VENTANILLA
	public void llenarPersonaInfo() {
		PersonaPropiaEntity persona = edcGeneralesService.llenarPersonaInfo();
		if (persona != null) {
			setDatoPersonaId(persona.getCvePersona().intValue());
			setDatoPersonaInfo(persona.getNombre() + " "
					+ persona.getApellidoPaterno() + " "
					+ persona.getApellidoMaterno());
		} else {
			setDatoPersonaId(0);
		}
	}

	public String guardarCdvGeneral() {
		String servicio = null;
		if (getCdvForm().getDatoHoraNormalIni() <= getCdvForm()
				.getDatoHoraNormalFin()
				&& getCdvForm().getDatoHoraRealIni() <= getCdvForm()
						.getDatoHoraRealFin()) {
			if (getCdvForm().getDatoMinNormalIni() <= getCdvForm()
					.getDatoMinNormalFin()
					&& getCdvForm().getDatoMinRealIni() <= getCdvForm()
							.getDatoMinRealFin()) {

				CdvEntity cdv = new CdvEntity();

				TipoVentanillaEntity ventanilla = edcService
						.recuperarVentanilla(Long.valueOf(getCdvForm()
								.getDatoTipoVentanilla()));
				cdv.setTipoVentanilla(ventanilla);

				TurnoEntity turno = edcGeneralesService.recuperarTurno(Long
						.valueOf(getCdvForm().getDatoTurno()));
				cdv.setTurno(turno);

				UnidadEntity unidad = edcGeneralesService.recuperarUnidad(Long
						.valueOf(getCdvForm().getDatoUnidad()));
				cdv.setUnidad(unidad);

				cdv.setFechaCreacion(new Date());
				cdv.setHoraNormalFin(getCdvForm().getDatoHoraNormalFin());
				cdv.setHoraNormalIni(getCdvForm().getDatoHoraNormalIni());
				cdv.setHoraRealFin(getCdvForm().getDatoHoraRealFin());
				cdv.setHoraRealIni(getCdvForm().getDatoHoraRealIni());
				cdv.setMinNormalFin(getCdvForm().getDatoMinNormalFin());
				cdv.setMinNormalIni(getCdvForm().getDatoMinNormalIni());
				cdv.setMinRealFin(getCdvForm().getDatoMinRealFin());
				cdv.setMinRealIni(getCdvForm().getDatoMinRealIni());
				cdv.setNumeroVentanillas(getCdvForm().getDatoNumVentanilla());
				edcGeneralesService.guardadCdvGeneral(cdv);

				PersonaPropiaEntity persona = edcGeneralesService
						.llenarPersonaInfo();

				LlaveCompuestaCdvPersona llave = new LlaveCompuestaCdvPersona();
				llave.setCdv(cdv);
				llave.setPersona(persona);

				CdvPersonaEntity cdvPersona = new CdvPersonaEntity();
				cdvPersona.setLlaveCompuesta(llave);
				cdvPersona.setStatus(Constantes.ENABLE);
				edcGeneralesService.guardarCdvPersona(cdvPersona);
				servicio = "servicio";

			} else {
				setError("El horario final debe ser mayor al inicial");
			}

		} else {
			setError("El horario final debe ser mayor al inicial");
		}

		return servicio;

	}

	public void encabezado() {
		CdvEntity cdv = edcService.recuperarCdv(1L);
		getEdcEncabezadoForm().setTurno(cdv.getTurno().getDescripcionTurno());
		getEdcEncabezadoForm().setUnidad(cdv.getUnidad().getNombreUnidad());
		getEdcEncabezadoForm().setVentanilla(
				cdv.getTipoVentanilla().getNombreTipoVentanilla());
		cdv = null;
	}

	public void llenarDatosGeneralesCabecera() {
		CabeceraDatosGeneralesVo cabecera = edcService
				.obtenerDatosgenerales(1L);
		getEdcEncabezadoForm().setDelegacion(cabecera.getDelegacion());
		getEdcEncabezadoForm().setTurno(cabecera.getTurno());
		getEdcEncabezadoForm().setUnidad(cabecera.getUnidad());
		getEdcEncabezadoForm().setVentanilla(cabecera.getTipoVentanilla());

	}
}
