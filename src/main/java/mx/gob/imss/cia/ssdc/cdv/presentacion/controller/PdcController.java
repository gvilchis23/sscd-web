/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PdcController.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.PdcForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.BusquedaService;
import mx.gob.imss.cia.ssdc.cdv.servicios.SsdcException;
import mx.gob.imss.cia.ssdc.cdv.servicios.PdcService;
import mx.gob.imss.cia.ssdc.cdv.vo.AnyoVo;
import mx.gob.imss.cia.ssdc.cdv.vo.EstatusVo;
import mx.gob.imss.cia.ssdc.cdv.vo.MesVo;
import mx.gob.imss.cia.ssdc.cdv.vo.TipoRegistroVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Leandro O.
 */
@Controller
@Scope("request")
public class PdcController {

	/**
	 * Variable form para Pdc.
	 */
	@Autowired
	private PdcForm pdcForm;

	/**
	 * Variable para almacenar datos para los datatables.
	 */
	@Autowired
	private BackingBeanTable backingTable;

	/**
	 * Variable para almacenar datos para el datable de dias festivos.
	 */
	@Autowired
	private BackingBeanTable backingTableDias;

	/**
     *
     */
	private List<PdcForm> listaDiasInhabiles;

	/**
	 * Variable que inyecta el servicio de PDC.
	 */
	@Autowired
	private PdcService pdcService;

	/**
	 * Variable que inyecta el servicio de busqueda.
	 */
	@Autowired
	private BusquedaService busquedaService;

	/**
	 * Metodo que inicia el controlador.
	 * 
	 * @throws SsdcException
	 *             exception del imss
	 */
	@PostConstruct
	public final void init() throws SsdcException {
		llenarListaAdmProcCarga();
		llenarCombosdeFiltro();
	}

	/**
	 * Metodo que carga los combos Tipo,Mes,Año,Estatus para el filtrado de la
	 * búsqueda de registros.
	 */
	public final void llenarCombosdeFiltro() {
		llenarComboTipo();
		llenarComboMes();
		llenarComboAnio();
		llenarComboAnioNuevoPC();
		llenarComboEstatus();
	}

	/**
	 * Metodo que llena el combo de tipo de carga.
	 */
	public final void llenarComboTipo() {
		List<SelectItem> comboTipo = new ArrayList<SelectItem>();
		List<TipoRegistroVo> tipoList = busquedaService.obtieneListadoTipo();

		for (TipoRegistroVo tipo : tipoList) {
			comboTipo.add(new SelectItem(tipo.getClave(), tipo.getTipo()));
		}

		getPdcForm().setComboTipo(comboTipo);
	}

	/**
	 * Metodo que llena el combo de meses.
	 */
	public final void llenarComboMes() {
		List<SelectItem> comboMes = new ArrayList<SelectItem>();
		List<MesVo> mesList = busquedaService.obtieneListadoMes();

		for (MesVo mes : mesList) {
			comboMes.add(new SelectItem(mes.getClave(), mes.getMes()));
		}

		getPdcForm().setComboMes(comboMes);
	}

	/**
	 * Metodo que llena el combo de anios.
	 */
	public final void llenarComboAnio() {
		List<SelectItem> comboAnio = new ArrayList<SelectItem>();
		List<AnyoVo> anyoList = busquedaService.obtieneListadoAnyo();

		for (AnyoVo anyo : anyoList) {
			comboAnio.add(new SelectItem(anyo.getClave(), anyo.getAnyo()));
		}

		getPdcForm().setComboAnio(comboAnio);
	}

	/**
	 * Metodo que llena el combo de anios para Nuevo Proceso de Carga.
	 */
	public final void llenarComboAnioNuevoPC() {
		List<SelectItem> comboAnio = new ArrayList<SelectItem>();
		List<AnyoVo> anyoList = busquedaService.obtieneListadoAnyo();

		for (AnyoVo anyo : anyoList) {
			comboAnio.add(new SelectItem(anyo.getClave(), anyo.getAnyo()));
		}

		getPdcForm().setComboAnioNuevoPC(comboAnio);
	}

	/**
	 * Metodo que llena el combo de estatus.
	 */
	public final void llenarComboEstatus() {
		List<SelectItem> comboEstatus = new ArrayList<SelectItem>();
		List<EstatusVo> estatusList = busquedaService.obtieneListadoEstatus();

		for (EstatusVo estatus : estatusList) {
			comboEstatus.add(new SelectItem(estatus.getClave(), estatus
					.getEstatus()));
		}

		getPdcForm().setComboEstatus(comboEstatus);

	}

	/**
	 * Metodo para generar la descripcion del proceso de carga en base a la
	 * fecha de inicio del periodo ingresado y del tipo de carga seleccionado.
	 * (tipo de carga + "_" + mes de fecha inicio + "_" + año de fecha de
	 * inicio)
	 */
	private void generarDescripcion() {

		Date fecIni = getPdcForm().getFechaIni();
		String tipoCarga = getPdcForm().getTipoNuevo();
		String descrip = tipoCarga + "_" + fecIni.getMonth() + "_"
				+ fecIni.getYear();
		getPdcForm().setDescripcion(descrip);
	}

	/**
	 * Metodo que obtiene y arma una lista de procesos de carga. Retorna una
	 * lista.
	 */
	public final void llenarListaAdmProcCarga() {

		List<PdcForm> listaPdcForm = new ArrayList<PdcForm>();
		int tipo;

		if (getPdcForm().getTipoC() != null) {
			tipo = Integer.parseInt(getPdcForm().getTipoC());
		} else {
			tipo = 0;
		}
		int mes;
		if (getPdcForm().getMes() != null) {
			mes = Integer.parseInt(getPdcForm().getMes());
		} else {
			mes = 0;
		}
		int anio;
		if (getPdcForm().getAnio() != null) {
			anio = Integer.parseInt(getPdcForm().getAnio());
		} else {
			anio = 0;
		}
		int estatus;
		if (getPdcForm().getEstatus() != null) {
			estatus = Integer.parseInt(getPdcForm().getEstatus());
		} else {
			estatus = 0;
		}
//		List<Map<String, String>> listaProcesos = (List<Map<String, String>>) pdcService
//				.getRegistroList(tipo, anio, mes, estatus);
//
//		for (Map<String, String> map : listaProcesos) {
//			pdcForm = new PdcForm();
//			getPdcForm().setId(new Long(map.get(PdcService.ID)));
//			getPdcForm().setNombre((String) map.get(PdcService.NOMBRE));
//			getPdcForm().setTipo(map.get(PdcService.TIPO));
//			getPdcForm().setFecha(map.get(PdcService.FECHA));
//			listaPdcForm.add(getPdcForm());
//		}
//		getBackingTable().getTableBinding().setValue(listaPdcForm);
	}

	/**
	 * Carga los CDVs existentes de un anio seleccionado.
	 */
	public final void cargarListaCDV() {

		int anio;
		if (getPdcForm().getAnioNuevo() != null) {
			anio = Integer.parseInt(getPdcForm().getAnioNuevo());
		} else {
			anio = 0;
		}
		// System.out.println("Anio : " + anio);
		//TODO el codigo comentado hay que borrarlo - broken window
/*		if (anio > 0) {
			// getPdcForm().setListaCdvs(pdcService.getCDVsPorEvaluar(anio));
		}*/
	}

	/**
	 * Obtiene una lista de dias festivos.
	 */
	public final void obtenerListaDiasFestivos() {

		int anio;
		if (getPdcForm().getAnio() != null) {
			anio = Integer.parseInt(getPdcForm().getAnio());
		} else {
			anio = 0;
		}

		List<PdcForm> listaPdcForm = new ArrayList<PdcForm>();
		List<Map<String, String>> listaDiasFestivos = (List<Map<String, String>>) pdcService
				.getDiasInhabiles(anio);

		for (Map<String, String> map : listaDiasFestivos) {
			pdcForm = new PdcForm();
			getPdcForm().setIdFechaInhabil(
					new Long(map.get(PdcService.IDFECHAINHAB)));
			getPdcForm().setDescripFechaInhabilListado(
					(String) map.get(PdcService.NOMBRE));
			getPdcForm().setFechaInhabilListado(map.get(PdcService.FECHA));
			listaPdcForm.add(getPdcForm());
		}
		setListaDiasInhabiles(listaPdcForm);
		// getBackingTableDias().getTableBinding().setValue(listaPdcForm);
	}

	/**
	 * Obtiene una lista de dias festivos de un periodo.
	 */
	public final void obtenerListaDiasFestivosPeriodo() {
		Date fecIni = null;
		if (getPdcForm().getFechaIni() != null) {
			fecIni = getPdcForm().getFechaIni();
			generarDescripcion();
		}
		Date fecFinal = null;
		if (getPdcForm().getFechaFinal() != null) {
			fecFinal = getPdcForm().getFechaFinal();
		}
		List<PdcForm> listaPdcForm = new ArrayList<PdcForm>();
		if (fecFinal != null && fecIni != null) {
			List<Map<String, String>> listaDiasFestivos = (List<Map<String, String>>) pdcService
					.getDiasInhabiles(fecIni, fecFinal);
			for (Map<String, String> map : listaDiasFestivos) {
				pdcForm = new PdcForm();
				getPdcForm().setIdFechaInhabil(
						new Long(map.get(PdcService.IDFECHAINHAB)));
				getPdcForm().setDescripFechaInhabilListado(
						(String) map.get(PdcService.NOMBRE));
				getPdcForm().setFechaInhabilListado(map.get(PdcService.FECHA));
				listaPdcForm.add(getPdcForm());
			}
		}
		getPdcForm().setNumDiasInhab(Integer.toString(listaPdcForm.size()));
		setListaDiasInhabiles(listaPdcForm);
	}

	/**
     *
     */
	public final void buscarProcesosCargas() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); String
		 * paramValue =
		 * (String)context.getExternalContext().getRequestParameterMap
		 * ().get("tipoCombo");
		 */
	}

	/**
	 * Metodo para mostrar la pantalla de nuevo proceso de carga.
	 */
	public final void mostrarNuevoProceso() {
		List<SelectItem> comboTipo = new ArrayList<SelectItem>();
		List<TipoRegistroVo> tipoList = busquedaService.obtieneListadoTipo();

		for (TipoRegistroVo tipo : tipoList) {
			comboTipo.add(new SelectItem(tipo.getClave(), tipo.getTipo()));
		}

		getPdcForm().setComboTipo(comboTipo);
	}

	/**
	 * Metodo para mostrar la pantalla de configuracion anual.
	 */
	public final void mostrarConfigAnual() {
		obtenerListaDiasFestivos();
	}

	/**
	 * Metodo para mostrar la pantalla de la seleccion de Cdv's.
	 */
	public final void mostrarSeleccionCDVs() {
		llenarComboAnioNuevoPC();
		cargarListaCDV();
	}

	/**
	 * Devuelve la forma de datos del PDC.
	 * 
	 * @return pdcForm
	 */
	public final PdcForm getPdcForm() {
		return pdcForm;
	}

	/**
	 * Guarda la forma de datos del PDC.
	 * 
	 * @param pdcFormP
	 *            forma
	 */
	public final void setPdcForm(final PdcForm pdcFormP) {
		this.pdcForm = pdcFormP;
	}

	/**
	 * Bean para devolver lista de datos para el binding de un DataTable.
	 * 
	 * @return backingTable
	 */
	public final BackingBeanTable getBackingTable() {
		return backingTable;
	}

	/**
	 * Guarda el Bean de lista de datos para el binding de un DataTable.
	 * 
	 * @param backingTableAux
	 *            tabla
	 */
	public final void setBackingTable(final BackingBeanTable backingTableAux) {
		this.backingTable = backingTableAux;
	}

	/**
	 * 
	 * @return backingTableDias
	 */
	public final BackingBeanTable getBackingTableDias() {
		return backingTableDias;
	}

	/**
	 * 
	 * @param backingTableDiasAux
	 *            tabla de dias
	 */
	public final void setBackingTableDias(
			final BackingBeanTable backingTableDiasAux) {
		this.backingTableDias = backingTableDiasAux;
	}

	/**
	 * Devuelve la lista de dias inhabiles.
	 * 
	 * @return retunr una lista
	 */
	public final List<PdcForm> getListaDiasInhabiles() {
		return listaDiasInhabiles;
	}

	/**
	 * Guarda la lista de dias inhabiles.
	 * 
	 * @param listaDiasInhabilesAux
	 *            recibe una lista
	 */
	public final void setListaDiasInhabiles(
			final List<PdcForm> listaDiasInhabilesAux) {
		this.listaDiasInhabiles = listaDiasInhabilesAux;
	}

}
