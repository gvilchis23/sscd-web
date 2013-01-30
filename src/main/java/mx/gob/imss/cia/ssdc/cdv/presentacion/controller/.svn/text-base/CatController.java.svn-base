/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: CatController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CatServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.DelegacionEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.EntidadFederativaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.MediosDifusionEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ResultadoServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoUnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.UnidadEntity;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanColumn;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanCommandButton;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.CatForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.CatalogoService;
import mx.gob.imss.cia.ssdc.cdv.vo.CatalogoVo;
import mx.gob.imss.cia.ssdc.commons.Constantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Guillermo Vilchis Gonzalez
 * 
 */
@Controller
@Scope("session")
public class CatController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CatController.class);

	@Autowired
	private CatForm catForm;

	@Autowired
	private BackingBeanCommandButton backingButton;

	@Autowired
	private BackingBeanTable backingTable;

	@Autowired
	private BackingBeanColumn backingColumn;

	@Autowired
	private CatalogoService catalogoService;

	private List<CatForm> lista;

	@PostConstruct
	public void init() {
		mensajeOriginalEncabezado();
	}

	/**
	 * @return the CatForm
	 */
	public CatForm getCatForm() {
		return catForm;
	}

	/**
	 * @param CatForm
	 *            the CatForm to set
	 */
	public void setCatForm(CatForm CatForm) {
		this.catForm = CatForm;
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
	 * @return the catalogoService
	 */
	public CatalogoService getCatalogoService() {
		return catalogoService;
	}

	/**
	 * @param catalogoService
	 *            the catalogoService to set
	 */
	public void setCatalogoService(CatalogoService catalogoService) {
		this.catalogoService = catalogoService;
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
	 * @return the lista
	 */
	public List<CatForm> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(List<CatForm> lista) {
		this.lista = lista;
	}

	/**
	 * @return the backingColumn
	 */
	public BackingBeanColumn getBackingColumn() {
		return backingColumn;
	}

	/**
	 * @param backingColumn
	 *            the backingColumn to set
	 */
	public void setBackingColumn(BackingBeanColumn backingColumn) {
		this.backingColumn = backingColumn;
	}

	// METODO PARA SABER QUE MODAL MOSTRAR
	public void mostrarVentanaEmergente(ActionEvent e) {
		mensajeOriginalEncabezado();
		if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_CATALOGO_SERVICIO)) {
			getBackingColumn().getColumnBinding().setVisible(false);
			getBackingColumn().getPresupColumnBinding().setVisible(false);
			getCatForm().setTipoSeleccion(Constantes.LABEL_CATALOGO_SERVICIO);
			getBackingTable().getTableBinding().setValue(
					llenarTablaCatServicios());
			getCatForm().setModalEdit(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");
			getBackingButton().getBotonBinding().setOnclick(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_RESULTADO_SERVICIO)) {
			getBackingColumn().getColumnBinding().setVisible(false);
			getBackingColumn().getPresupColumnBinding().setVisible(false);
			getBackingTable().getTableBinding().setValue(
					llenarTablaResulServicios());
			getCatForm().setTipoSeleccion(Constantes.LABEL_RESULTADO_SERVICIO);
			getCatForm().setModalEdit(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");
			getBackingButton().getBotonBinding().setOnclick(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_SERVICIO)) {
			getBackingTable().getTableBinding()
					.setValue(llenarTablaServicios());
			getBackingColumn().getColumnBinding().setVisible(true);
			getBackingColumn().getPresupColumnBinding().setVisible(false);

			getCatForm().setComboServicios(llenarComboServicios());

			getCatForm().setModalEdit(
					"Richfaces.showModalPanel('nuevoServicio');");
			getBackingButton().getBotonBinding().setOnclick(
					"Richfaces.showModalPanel('nuevoServicio');");

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_MEDIOS_DIFUSION)) {
			getBackingColumn().getColumnBinding().setVisible(false);
			getBackingColumn().getPresupColumnBinding().setVisible(false);
			getBackingTable().getTableBinding().setValue(
					llenarTablaMediosDifusion());
			getCatForm().setTipoSeleccion(Constantes.LABEL_MEDIOS_DIFUSION);
			getCatForm().setModalEdit(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");
			getBackingButton().getBotonBinding().setOnclick(
					"Richfaces.showModalPanel('nuevoCatalogoServicio');");

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_UNIDADES)) {
			cambiarMensajeEncabezado();
			getBackingTable().getTableBinding().setValue(llenarTablaUnidades());
			getBackingColumn().getColumnBinding().setVisible(true);
			getBackingColumn().getPresupColumnBinding().setVisible(true);

			getCatForm().setComboEntidadFed(llenarComboEntidadFederativa());
			getCatForm().setComboDelegacion(llenarComboDelegacion());
			getCatForm().setComboTipoUnidad(llenarComboTipoUnidad());

			getCatForm().setModalEdit(
					"Richfaces.showModalPanel('nuevaUnidad');");
			getBackingButton().getBotonBinding().setOnclick(
					"Richfaces.showModalPanel('nuevaUnidad');");
		}
	}

	private void mensajeOriginalEncabezado() {
		getCatForm().setIndexVisible(false);
		getCatForm().setPrimeraColumna("Servicio");
		getCatForm().setSegundaColumna("Registro");
		getCatForm().setTerceraColumna("Tipo de ventanilla");
	}

	private void cambiarMensajeEncabezado() {
		getCatForm().setIndexVisible(true);
		getCatForm().setPrimeraColumna("Unidad Nombre");
		getCatForm().setSegundaColumna("Tipo Unidad");
		getCatForm().setTerceraColumna("Delegacion");
	}

	// METODO GENERAL DE TODOS LOS SERVICIOS IGUALES
	public void guardar() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");

		if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_CATALOGO_SERVICIO)) {
			guardarCategoriaServicio(tipoVentanilla);
		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_RESULTADO_SERVICIO)) {
			guardarResultadoServicio(tipoVentanilla);
		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_MEDIOS_DIFUSION)) {
			guardarMediosDifusion(tipoVentanilla);
		}

	}

	/**
	 * @TODO Corregir todos los guardar ya que cambio el mapeo de columnas a
	 *       objetos
	 * 
	 */

	// METODO PARA GUARDAR EN CDC_CAT_SERVICIO
	public void guardarCategoriaServicio(String tipoVentanilla) {
		CatServicioEntity servicioEntity = new CatServicioEntity();
		servicioEntity.setCveCategoria(getCatForm().getId());
		servicioEntity.getVentanilla().setCveTipoVentanilla(
				Long.valueOf(tipoVentanilla));
		servicioEntity.setNombreCategoria(getCatForm().getValor());
		servicioEntity.setStatus(Constantes.ENABLE);
		catalogoService.guardarCategoriaServicio(servicioEntity);
	}

	// METODO PARA GUARDAR EN CDC_SERVICIO
	public void guardarResultadoServicio(String tipoVentanilla) {
		ResultadoServicioEntity servicioEntity = new ResultadoServicioEntity();
		servicioEntity.setCveResultado(getCatForm().getId());
		servicioEntity.getTipoVentanilla().setCveTipoVentanilla(
				Long.valueOf(tipoVentanilla));
		servicioEntity.setNombreResultado(getCatForm().getValor());
		servicioEntity.setStatus(Constantes.ENABLE);
		catalogoService.guardarResultadoServicio(servicioEntity);

	}

	// METODO PARA GUARDAR EN CDC_SERVICIO
	public void guardarCdcServicio(ActionEvent e) {
		ServicioEntity servicioEntity = new ServicioEntity();
		servicioEntity.setCveServicio(getCatForm().getId());
		servicioEntity.getCategoria().setCveCategoria(
				Long.valueOf(getCatForm().getCatCatalogo()));
		servicioEntity.setNombreServicio(getCatForm().getValor());
		servicioEntity.setStatus(Constantes.ENABLE);
		catalogoService.guardarServicio(servicioEntity);
	}

	// METODO PARA GUARDAR EN SST_UNIDAD
	public void guardarSstUnidades() {
		UnidadEntity unidadEntity = new UnidadEntity();
		unidadEntity.setCveUnidad(getCatForm().getId());

		Long entidadFederativa = getCatForm().getEntidadFederativa();
		Long delegacion = getCatForm().getDelegacion();
		Long tipoUnidad = getCatForm().getTipoUnidad();

		unidadEntity.setNombreUnidad(getCatForm().getNombreUnidad());
		unidadEntity.setDomCalle(getCatForm().getDomCalle());
		unidadEntity.setDomNumero(Integer.valueOf(getCatForm().getDomNumero()));
		unidadEntity.setDomColonia(getCatForm().getDomColonia());
		unidadEntity.setDomMunicipio(getCatForm().getDomMunicipio());
		unidadEntity.setNumTelefono(getCatForm().getNumTelefono());
		unidadEntity.setRefClavePresup(getCatForm().getRefClavePresup());
		unidadEntity.setStatus(Constantes.ENABLE);
		catalogoService.guardarUnidades(unidadEntity, entidadFederativa,
				delegacion, tipoUnidad);
		
		getBackingTable().getTableBinding().setValue(llenarTablaUnidades());
	}
	
	// METODO PARA GUARDAR EN CDC_MEDIOS_DIFUSION
	public void guardarMediosDifusion(String tipoVentanilla) {
		MediosDifusionEntity servicioEntity = new MediosDifusionEntity();
		servicioEntity.setCveDifusion(getCatForm().getId());
		servicioEntity.getTipoVentanilla().setCveTipoVentanilla(
				Long.valueOf(tipoVentanilla));
		servicioEntity.setNombreDifusion(getCatForm().getValor());
		servicioEntity.setStatus(Constantes.ENABLE);
		catalogoService.guardarMediosDifusion(servicioEntity);

	}

	// METODO PARA LLENAR EL COMBO DE SERVICIOS
	public ArrayList<SelectItem> llenarComboServicios() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");
		ArrayList<SelectItem> lista = (ArrayList<SelectItem>) catalogoService
				.llenarComboServicios(Integer.valueOf(tipoVentanilla));
		return lista;
	}

	// METODO PARA LLENAR EL COMBO DE LAS ENTIDADES FEDERATIVAS
	public List<SelectItem> llenarComboEntidadFederativa() {
		List<EntidadFederativaEntity> entidades = catalogoService
				.llenarComboEntidadFed();

		List<SelectItem> items = new ArrayList<SelectItem>();
		for (EntidadFederativaEntity entidadFed : entidades) {
			items.add(new SelectItem(entidadFed.getCveEntidadFed(), entidadFed
					.getNomEntidadFed()));
		}

		return items;
	}

	// METODO PARA LLENAR EL COMBO DE LAS DELEGACIONES
	public List<SelectItem> llenarComboDelegacion() {
		List<DelegacionEntity> delegaciones = catalogoService
				.llenarComboDelegacion();

		List<SelectItem> items = new ArrayList<SelectItem>();
		for (DelegacionEntity delegacion : delegaciones) {
			items.add(new SelectItem(delegacion.getCveDelegacion(), delegacion
					.getNombreDelegacion()));
		}
		return items;
	}

	// METODO PARA LLENAR EL COMBO DE LOS TIPOS DE UNIDAD
	public List<SelectItem> llenarComboTipoUnidad() {
		List<TipoUnidadEntity> tipoUnidades = catalogoService
				.llenarComboTipoUnidad();

		List<SelectItem> items = new ArrayList<SelectItem>();
		for (TipoUnidadEntity tipoUnidad : tipoUnidades) {
			items.add(new SelectItem(tipoUnidad.getCveTipoUnidad(), tipoUnidad
					.getNombreTipoUnidad()));
		}
		return items;
	}

	// METODO PARA LLENAR LA TABLA DE CAT_SERVICIOS
	public List<CatForm> llenarTablaCatServicios() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");
		ArrayList<CatalogoVo> lista = (ArrayList<CatalogoVo>) catalogoService
				.llenarTablaCatServicios(Integer.valueOf(tipoVentanilla));
		ArrayList<CatForm> listaForm = new ArrayList<CatForm>();
		for (CatalogoVo vo : lista) {
			CatForm catalogo = new CatForm();
			catalogo.setId(vo.getId());
			catalogo.setIdForaneo(vo.getIdForaneo());
			catalogo.setNombreCatColumna(vo.getNombreCatalogo());
			catalogo.setVentanillaColumna(vo.getTipoVentanilla());
			listaForm.add(catalogo);
		}
		setLista(listaForm);
		return listaForm;
	}

	// METODO PARA LLENAR LA TABLA DE SERVICIOS
	public List<CatForm> llenarTablaServicios() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");
		ArrayList<CatalogoVo> lista = (ArrayList<CatalogoVo>) catalogoService
				.llenarTablaServicios(Integer.valueOf(tipoVentanilla));
		ArrayList<CatForm> listaForm = new ArrayList<CatForm>();
		for (CatalogoVo vo : lista) {
			CatForm catalogo = new CatForm();
			catalogo.setId(vo.getId());
			catalogo.setIdForaneo(vo.getIdForaneo());
			catalogo.setNombreSerColumna(vo.getNombreServicio());
			catalogo.setVentanillaColumna(vo.getTipoVentanilla());
			catalogo.setNombreCatColumna(vo.getNombreCatalogo());
			listaForm.add(catalogo);
		}
		setLista(listaForm);

		return listaForm;
	}

	// METODO PARA LLENAR EL COMBO DE LA TABLA DE UNIDADES
	private List<CatForm> llenarTablaUnidades() {

		List<UnidadEntity> tablaUnidades = catalogoService
				.llenarTablaUnidades();

		List<CatForm> listaUnidades = new ArrayList<CatForm>();
		for (UnidadEntity unidadEntity : tablaUnidades) {
			CatForm catalogo = new CatForm();
			catalogo.setId(unidadEntity.getCveUnidad());
			catalogo.setNombreCatColumna(unidadEntity.getTipoUnidad()
					.getNombreTipoUnidad());
			catalogo.setVentanillaColumna(unidadEntity.getDelegacion()
					.getNombreDelegacion());
			catalogo.setNombreSerColumna(unidadEntity.getNombreUnidad());
			catalogo.setPresupuestariaColumna(unidadEntity.getRefClavePresup());

			listaUnidades.add(catalogo);
		}

		setLista(listaUnidades);
		return listaUnidades;
	}

	// METODO PARA LLENAR LA TABLA DE CAT_RESUL_SERVICIOS
	public List<CatForm> llenarTablaResulServicios() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");
		ArrayList<CatalogoVo> lista = (ArrayList<CatalogoVo>) catalogoService
				.llenarTablaResulServicios(Integer.valueOf(tipoVentanilla));
		ArrayList<CatForm> listaForm = new ArrayList<CatForm>();
		for (CatalogoVo vo : lista) {
			CatForm catalogo = new CatForm();
			catalogo.setId(vo.getId());
			catalogo.setIdForaneo(vo.getIdForaneo());
			catalogo.setNombreCatColumna(vo.getNombreCatalogo());
			catalogo.setVentanillaColumna(vo.getTipoVentanilla());
			listaForm.add(catalogo);
		}
		setLista(listaForm);
		return listaForm;
	}

	// METODO PARA LLENAR LA TABLA DE CAT_RESUL_SERVICIOS
	public List<CatForm> llenarTablaMediosDifusion() {
		String tipoVentanilla = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("tipoVentanilla");
		ArrayList<CatalogoVo> lista = (ArrayList<CatalogoVo>) catalogoService
				.llenarTablaMediosDifusion(Integer.valueOf(tipoVentanilla));
		ArrayList<CatForm> listaForm = new ArrayList<CatForm>();
		for (CatalogoVo vo : lista) {
			CatForm catalogo = new CatForm();
			catalogo.setId(vo.getId());
			catalogo.setIdForaneo(vo.getIdForaneo());
			catalogo.setNombreCatColumna(vo.getNombreCatalogo());
			catalogo.setVentanillaColumna(vo.getTipoVentanilla());
			listaForm.add(catalogo);
		}
		setLista(listaForm);
		return listaForm;
	}

	// METODO PARA ELIMINADO LOGICO
	public void eliminarDato() {
		CatForm form = (CatForm) getBackingTable().getTableBinding()
				.getRowData();
		if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_CATALOGO_SERVICIO)) {
			CatServicioEntity catEn = new CatServicioEntity();
			catEn.setCveCategoria(form.getId());
			catEn.getVentanilla().setCveTipoVentanilla(form.getIdForaneo());
			catEn.setNombreCategoria(form.getNombreCatColumna());
			catEn.setStatus(0);
			catalogoService.guardarCategoriaServicio(catEn);

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_RESULTADO_SERVICIO)) {
			ResultadoServicioEntity resulEn = new ResultadoServicioEntity();
			resulEn.setCveResultado(form.getId());
			resulEn.getTipoVentanilla().setCveTipoVentanilla(
					form.getIdForaneo());
			resulEn.setNombreResultado(form.getNombreCatColumna());
			resulEn.setStatus(0);
			catalogoService.guardarResultadoServicio(resulEn);

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_SERVICIO)) {
			ServicioEntity serv = new ServicioEntity();
			serv.setCveServicio(form.getId());
			serv.getCategoria().setCveCategoria(form.getIdForaneo());
			serv.setNombreServicio(form.getNombreSerColumna());
			serv.setStatus(0);
			catalogoService.guardarServicio(serv);

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_MEDIOS_DIFUSION)) {
			MediosDifusionEntity serv = new MediosDifusionEntity();
			serv.setCveDifusion(form.getId());
			serv.getTipoVentanilla().setCveTipoVentanilla(form.getIdForaneo());
			serv.setNombreDifusion(form.getNombreCatColumna());
			serv.setStatus(0);
			catalogoService.guardarMediosDifusion(serv);

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_UNIDADES)) {
			UnidadEntity unidad = catalogoService.filtrarUnidadesPorId(form
					.getId());
			unidad.setStatus(Constantes.DISABLE);
			catalogoService.actualizarUnidades(unidad);
			getBackingTable().getTableBinding().setValue(llenarTablaUnidades());
		}

	}

	// METODO PARA EDITAR SABER QUE MODAL MOSTRAR
	public void mostrarEditarEmergente() {
		CatForm form = (CatForm) getBackingTable().getTableBinding()
				.getRowData();
		if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_CATALOGO_SERVICIO)) {
			getCatForm().setTipoSeleccion(Constantes.LABEL_CATALOGO_SERVICIO);
			getCatForm().setValor(form.getNombreCatColumna());
			getCatForm().setId(form.getId());

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_RESULTADO_SERVICIO)) {
			getCatForm().setTipoSeleccion(Constantes.LABEL_RESULTADO_SERVICIO);
			getCatForm().setValor(form.getNombreCatColumna());
			getCatForm().setId(form.getId());

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_SERVICIO)) {
			getCatForm().setId(form.getId());
			getCatForm().setCatCatalogo(form.getIdForaneo().intValue());
			getCatForm().setValor(form.getNombreSerColumna());

		} else if (getCatForm().getCatalogo().equals(
				Constantes.COMBO_MEDIOS_DIFUSION)) {
			getCatForm().setTipoSeleccion(Constantes.LABEL_MEDIOS_DIFUSION);
			getCatForm().setId(form.getId());
			getCatForm().setValor(form.getNombreCatColumna());

		} else if (getCatForm().getCatalogo().equals(Constantes.COMBO_UNIDADES)) {
			UnidadEntity unidad = catalogoService.filtrarUnidadesPorId(form
					.getId());

			getCatForm().setId(unidad.getCveUnidad());
			getCatForm().setDelegacion(
					unidad.getDelegacion().getCveDelegacion());
			getCatForm().setTipoUnidad(
					unidad.getTipoUnidad().getCveTipoUnidad());
			getCatForm().setEntidadFederativa(
					unidad.getEntidadFederativa().getCveEntidadFed());
			getCatForm().setNombreUnidad(
					unidad.getTipoUnidad().getNombreTipoUnidad());
			getCatForm().setDomCalle(unidad.getDomCalle());
			getCatForm().setDomNumero(unidad.getDomNumero());
			getCatForm().setDomColonia(unidad.getDomColonia());
			getCatForm().setRefClavePresup(unidad.getRefClavePresup());
			getCatForm().setNumTelefono(unidad.getNumTelefono());
			getCatForm().setDomMunicipio(unidad.getDomMunicipio());
		}
	}
	
	public void tumama() {
		LOG.info("Ejecut�ndose peeeerra!!!");
	}

	// METODO PARA LIMPIAR EL FORM
	public void limpiar() {
		getCatForm().setValor("");
		getCatForm().setId(0L);
		getCatForm().setCatCatalogo(0);

		getCatForm().setNombreUnidad("");
		getCatForm().setDomCalle("");
		getCatForm().setDomColonia("");
		getCatForm().setDomMunicipio("");
		getCatForm().setDomNumero(null);
		getCatForm().setNumTelefono("");
		getCatForm().setRefClavePresup("");
	}

}