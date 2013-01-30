/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: ServiciosController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.edc.presentacion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.edc.presentacion.form.EdcServiciosForm;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcService;
import mx.gob.imss.cia.ssdc.cdv.edc.servicios.EdcServiciosService;
import mx.gob.imss.cia.ssdc.cdv.edc.vo.CdvVO;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CatServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CdvServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.LlaveCompuestaCdv;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.LlaveCompuestaMediosCdv;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.LlaveCompuestaRequisitosCdv;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.MediosCdvEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.MediosDifusionEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.RequisitosCdvEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.RequisitosEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ResultadoServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.ServicioEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.TipoVentanillaEntity;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope("session")
public class ServiciosController {

	@Autowired
	private EdcServiciosService edcServiciosService;

	@Autowired
	private EdcService edcService;

	@Autowired
	private EdcServiciosForm cdvServiciosForm;

	@Autowired
	private BackingBeanTable backingTable;

	private boolean datoDisable;

	private List<SelectItem> comboCategoriaServicios = new ArrayList<SelectItem>();

	private List<SelectItem> comboServicios = new ArrayList<SelectItem>();

	private List<SelectItem> comboResultadoServicios;

	private List<Integer> listaRequisitos;

	private List<Integer> listaDifusion;

	private List<CdvVO> listaVo = new ArrayList<CdvVO>();

	private List<CdvVO> listaMediosVo = new ArrayList<CdvVO>();

	private List<CdvServicioEntity> listaCdv = new ArrayList<CdvServicioEntity>();

	private String menu = "header";

	@PostConstruct
	public void init() {
		llenarCombos();
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * @return the edcServiciosService
	 */
	public EdcServiciosService getEdcServiciosService() {
		return edcServiciosService;
	}

	/**
	 * @param edcServiciosService
	 *            the edcServiciosService to set
	 */
	public void setEdcServiciosService(EdcServiciosService edcServiciosService) {
		this.edcServiciosService = edcServiciosService;
	}

	/**
	 * @return the comboCategoriaServicios
	 */
	public List<SelectItem> getComboCategoriaServicios() {
		return comboCategoriaServicios;
	}

	/**
	 * @param comboCategoriaServicios
	 *            the comboCategoriaServicios to set
	 */
	public void setComboCategoriaServicios(
	        List<SelectItem> comboCategoriaServicios) {
		this.comboCategoriaServicios = comboCategoriaServicios;
	}

	/**
	 * @return the cdvServiciosForm
	 */
	public EdcServiciosForm getCdvServiciosForm() {
		return cdvServiciosForm;
	}

	/**
	 * @param cdvServiciosForm
	 *            the cdvServiciosForm to set
	 */
	public void setCdvServiciosForm(EdcServiciosForm cdvServiciosForm) {
		this.cdvServiciosForm = cdvServiciosForm;
	}

	/**
	 * @return the comboServicios
	 */
	public List<SelectItem> getComboServicios() {
		return comboServicios;
	}

	/**
	 * @param comboServicios
	 *            the comboServicios to set
	 */
	public void setComboServicios(List<SelectItem> comboServicios) {
		this.comboServicios = comboServicios;
	}

	/**
	 * @return the datoDisable
	 */
	public boolean isDatoDisable() {
		return datoDisable;
	}

	/**
	 * @param datoDisable
	 *            the datoDisable to set
	 */
	public void setDatoDisable(boolean datoDisable) {
		this.datoDisable = datoDisable;
	}

	/**
	 * @return the comboResultadoServicios
	 */
	public List<SelectItem> getComboResultadoServicios() {
		return comboResultadoServicios;
	}

	/**
	 * @param comboResultadoServicios
	 *            the comboResultadoServicios to set
	 */
	public void setComboResultadoServicios(
	        List<SelectItem> comboResultadoServicios) {
		this.comboResultadoServicios = comboResultadoServicios;
	}

	/**
	 * @return the listaVo
	 */
	public List<CdvVO> getListaVo() {
		return listaVo;
	}

	/**
	 * @param listaVo
	 *            the listaVo to set
	 */
	public void setListaVo(List<CdvVO> listaVo) {
		this.listaVo = listaVo;
	}

	/**
	 * @return the listaRequisitos
	 */
	public List<Integer> getListaRequisitos() {
		return listaRequisitos;
	}

	/**
	 * @param listaRequisitos
	 *            the listaRequisitos to set
	 */
	public void setListaRequisitos(List<Integer> listaRequisitos) {
		this.listaRequisitos = listaRequisitos;
	}

	/**
	 * @return the listaDifusion
	 */
	public List<Integer> getListaDifusion() {
		return listaDifusion;
	}

	/**
	 * @param listaDifusion
	 *            the listaDifusion to set
	 */
	public void setListaDifusion(List<Integer> listaDifusion) {
		this.listaDifusion = listaDifusion;
	}

	/**
	 * @return the listaMediosVo
	 */
	public List<CdvVO> getListaMediosVo() {
		return listaMediosVo;
	}

	/**
	 * @param listaMediosVo
	 *            the listaMediosVo to set
	 */
	public void setListaMediosVo(List<CdvVO> listaMediosVo) {
		this.listaMediosVo = listaMediosVo;
	}

	/**
	 * @return the listaCdv
	 */
	public List<CdvServicioEntity> getListaCdv() {
		return listaCdv;
	}

	/**
	 * @param listaCdv
	 *            the listaCdv to set
	 */
	public void setListaCdv(List<CdvServicioEntity> listaCdv) {
		this.listaCdv = listaCdv;
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

	// METODO PARA LLENAR EL COMBO DE SERVICIOS
	public void llenarComboCategoriaServicios() {
		List<CatServicioEntity> lista = edcService
		        .llenarComboCategoriaServicios(1L);// cveVentanilla viene de
												   // panel de unidad;
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (CatServicioEntity cat : lista) {
			combo.add(new SelectItem(cat.getCveCategoria(), cat
			        .getNombreCategoria()));
		}
		setComboCategoriaServicios(combo);
	}

	// METODO PARA LLENAR EL COMBO DE SERVICIOS
	public void llenarComboServicios(Long cveCategoria) {
		List<ServicioEntity> lista = new CopyOnWriteArrayList<ServicioEntity>(
		        edcService.llenarComboServicios(cveCategoria)); // remover de
		                                                        // aqui
		List<CdvServicioEntity> listaRemove = edcService
		        .recuperarCdvServicios(1L);// datos a remover

		List<SelectItem> listaSelect = new ArrayList<SelectItem>();

		for (CdvServicioEntity entity : listaRemove) {
			for (ServicioEntity item : lista) {
				if (item.getCveServicio().compareTo(
				        entity.getLlaveCompuesta().getServicio()
				                .getCveServicio()) == 0) {
					lista.remove(item);
				}
			}
		}

		for (ServicioEntity item : lista) {
			listaSelect.add(new SelectItem(item.getCveServicio(), item
			        .getNombreServicio()));
		}

		setComboServicios(listaSelect);
	}

	// METODO PARA LLENAR EL COMBO DE SERVICIOS
	public void llenarComboResultadoServicios(Integer cveTipoVentanilla) {
		List<ResultadoServicioEntity> lista = (ArrayList<ResultadoServicioEntity>) edcService
		        .llenarComboResultadoServicios(1L);// cveVentanilla
		List<SelectItem> combo = new ArrayList<SelectItem>();
		for (ResultadoServicioEntity resultado : lista) {
			combo.add(new SelectItem(resultado.getCveResultado(), resultado
			        .getNombreResultado()));
		}
		setComboResultadoServicios(combo);

	}

	// METODO PARA LA FUNCIONALIDAD DE COMBO CATEGORIA SE MUESTRE O NO
	public void llenarCombos() {
		TipoVentanillaEntity ventanilla = edcService.recuperarVentanilla(1L);// cveTipoVentanilla
		if (ventanilla.getTieneCategoria() == 0) {
			setDatoDisable(true);
			llenarComboServicios(1L);// la cveCategoria de sin categoria
			llenarComboResultadoServicios(1);// tipoVentanilla
		} else {
			llenarComboCategoriaServicios();
			llenarComboResultadoServicios(1);// tipoVentanilla

		}

	}

	// METODO PARA LA FUNCIONALIDAD DE COMBOS
	public void eventoComboServicio(ActionEvent e) {
		if (getCdvServiciosForm().getDatoCategoriaServicio() != null) {
			llenarComboServicios(getCdvServiciosForm()
			        .getDatoCategoriaServicio());
		}

	}

	// METODO PARA LLENAR EL PICKLIST
	public void llenarPickList(ActionEvent e) {
		if (getCdvServiciosForm().getPickRequisitos().size() == 0) {
			List<RequisitosEntity> lista = (ArrayList<RequisitosEntity>) edcServiciosService
			        .llenarPickListRequisito(1);// tipoCatRequisitos tal vez
			ArrayList<SelectItem> combo = new ArrayList<SelectItem>();
			for (RequisitosEntity requisito : lista) {
				combo.add(new SelectItem(requisito.getCveRequisitos()
				        .intValue(), requisito.getNombreRequisitos()));
			}
			getCdvServiciosForm().setPickRequisitos(combo);
		}

	}

	// METODO PARA LLENAR LA TABLA
	public void llenarTablaRequisitos(ActionEvent e) {
		List<CdvVO> lista = new ArrayList<CdvVO>();
		if (getListaRequisitos().size() > 0) {
			for (Integer cadena : getListaRequisitos()) {
				RequisitosEntity requisitos = edcServiciosService
				        .recuperarRequisitos(Long.valueOf(cadena));
				CdvVO vo = new CdvVO();
				vo.setCveForanea(requisitos.getCveRequisitos());
				vo.setRequisito(requisitos.getNombreRequisitos());
				lista.add(vo);
			}
			setListaVo(lista);
		} else {
			setListaVo(lista);
		}
	}

	public void aceptar() {
		if (getListaVo() != null) {
			List<CdvVO> lista = new ArrayList<CdvVO>();
			List<Integer> listaCve = new ArrayList<Integer>();
			for (CdvVO vo : getListaVo()) {
				if (vo.getRadio() != null) {
					if (!vo.getRadio().equals("")) {
						lista.add(vo);
						listaCve.add(vo.getCveForanea().intValue());
					}
				}

			}
			setListaVo(lista);
			setListaRequisitos(listaCve);
		}
	}

	// METODO PARA LLENAR EL PICKLIST
	public void llenarPickListDifusion(ActionEvent e) {

		List<MediosDifusionEntity> lista = (ArrayList<MediosDifusionEntity>) edcServiciosService
		        .llenarPickListDifusion(1);// tipoCatRequisitos tal vez
		ArrayList<SelectItem> combo = new ArrayList<SelectItem>();
		for (MediosDifusionEntity medios : lista) {
			combo.add(new SelectItem(medios.getCveDifusion().intValue(), medios
			        .getNombreDifusion()));
		}
		getCdvServiciosForm().setPickDifusion(combo);

	}

	// METODO PARA ACEPTAR MEDIOS DIFUSION
	public void aceptarMedios(ActionEvent e) {
		List<CdvVO> lista = new ArrayList<CdvVO>();
		if (getListaDifusion().size() > 0) {
			for (Integer cadena : getListaDifusion()) {
				MediosDifusionEntity requisitos = edcServiciosService
				        .recuperarMedios(Long.valueOf(cadena));
				CdvVO vo = new CdvVO();
				vo.setCveForanea(requisitos.getCveDifusion());
				vo.setRequisito(requisitos.getNombreDifusion());
				lista.add(vo);
			}
			setListaMediosVo(lista);
		} else {
			setListaMediosVo(lista);
		}

	}

	public void limpiar() {
		setListaVo(new ArrayList<CdvVO>());
		setListaRequisitos(new ArrayList<Integer>());

	}

	public void limpiarDifusion() {
		setListaMediosVo(new ArrayList<CdvVO>());

	}

	public void guardarCdvServicios() {
		if (listaVo.size() != 0 && listaMediosVo.size() != 0) {
			CdvServicioEntity entityCdv = new CdvServicioEntity();
			entityCdv.setAtendidos(getCdvServiciosForm().getAtendidos());
			CdvEntity entidadCdv = edcService.recuperarCdv(1L);
			ServicioEntity entidadServicio = edcServiciosService
			        .recuperarServicio(Long.valueOf(getCdvServiciosForm()
			                .getDatoServicio()));
			LlaveCompuestaCdv llave = new LlaveCompuestaCdv();
			llave.setCdv(entidadCdv);
			llave.setServicio(entidadServicio);
			entityCdv.setLlaveCompuesta(llave);

			ResultadoServicioEntity entidadResultado = edcServiciosService
			        .recuperarResultadoServicio(Long
			                .valueOf(getCdvServiciosForm()
			                        .getDatoResultadoServicio()));
			entityCdv.setResultado(entidadResultado);

			// VentanillaAnteriorEntity anterior=new VentanillaAnteriorEntity();
			entityCdv.setVentanillaAnterior(null);
			entityCdv.setVentanillaPosterior(null);
			entityCdv.setDatoHoraAtencion(getCdvServiciosForm()
			        .getDatoHoraAtencion());
			entityCdv.setDatoHoraEspera(getCdvServiciosForm()
			        .getDatoHoraEspera());
			entityCdv.setDatoHoraPromedio(getCdvServiciosForm()
			        .getDatoHoraPromedio());
			// min
			entityCdv.setDatoMinAtencion(getCdvServiciosForm()
			        .getDatoMinAtencion());
			entityCdv
			        .setDatoMinEspera(getCdvServiciosForm().getDatoMinEspera());
			entityCdv.setDatoMinPromedio(getCdvServiciosForm()
			        .getDatoMinPromedio());
			// segun
			entityCdv.setDatoSegundosAtencion(getCdvServiciosForm()
			        .getDatoSegAtencion());
			entityCdv.setDatoSegundosEspera(getCdvServiciosForm()
			        .getDatoSegEspera());
			entityCdv.setDatoSegundosPromedio(getCdvServiciosForm()
			        .getDatoSegPromedio());
			edcServiciosService.guardadCdvServicio(entityCdv);
			for (CdvVO vo : listaVo) {
				RequisitosCdvEntity entidad = new RequisitosCdvEntity();
				LlaveCompuestaRequisitosCdv llaveR = new LlaveCompuestaRequisitosCdv();
				llaveR.setCdv(llave.getCdv());
				llaveR.setServicio(llave.getServicio());

				RequisitosEntity entidadRequisitos = edcServiciosService
				        .recuperarRequisitos(vo.getCveForanea());
				llaveR.setRequisito(entidadRequisitos);
				entidad.setLlaveCompuesta(llaveR);
				entidad.setDescripcion(vo.getRadio());
				edcServiciosService.guardadRequisitosCdv(entidad);
			}
			for (CdvVO vo : listaMediosVo) {
				MediosCdvEntity entidad = new MediosCdvEntity();
				MediosDifusionEntity medios = edcServiciosService
				        .recuperarMedios(vo.getCveForanea());
				LlaveCompuestaMediosCdv llaveM = new LlaveCompuestaMediosCdv();
				llaveM.setCdv(llave.getCdv());
				llaveM.setServicio(llave.getServicio());
				llaveM.setMediosDifusion(medios);
				entidad.setLlaveCompuesta(llaveM);
				edcServiciosService.guardadMediosCdv(entidad);
			}
			// limpia pantalla despues de guardar
			getCdvServiciosForm().setAtendidos(null);
			getCdvServiciosForm().setDatoServicio(null);
			getCdvServiciosForm().setDatoCategoriaServicio(null);
			getCdvServiciosForm().setDatoResultadoServicio(null);
			getCdvServiciosForm().setDatoHoraAtencion(null);
			getCdvServiciosForm().setDatoHoraEspera(null);
			getCdvServiciosForm().setDatoHoraPromedio(null);
			getCdvServiciosForm().setDatoMinAtencion(null);
			getCdvServiciosForm().setDatoMinEspera(null);
			getCdvServiciosForm().setDatoMinPromedio(null);
			getCdvServiciosForm().setDatoSegAtencion(null);
			getCdvServiciosForm().setDatoSegEspera(null);
			getCdvServiciosForm().setDatoSegPromedio(null);
			setListaVo(new ArrayList<CdvVO>());
			setListaMediosVo(new ArrayList<CdvVO>());
			llenarCombos();
			setComboServicios(new ArrayList<SelectItem>());
			setListaRequisitos(new ArrayList<Integer>());
			setListaDifusion(new ArrayList<Integer>());
			llenarTablaCdvServicio();
		}
	}

	// METODO PARA LLENAR LA TABLA de CDV
	public void llenarTablaCdvServicio() {
		List<CdvServicioEntity> lista = (ArrayList<CdvServicioEntity>) edcService
		        .recuperarCdvServicios(1L);// cveCdv de panel de unidad
		for (CdvServicioEntity entity : lista) {
			ServicioEntity servicio = edcServiciosService
			        .recuperarServicio(entity.getLlaveCompuesta().getServicio()
			                .getCveServicio());
			entity.setNombreServicio(servicio.getNombreServicio());
		}
		setListaCdv(lista);
	}

	// METODO PARA ELIMINAR DE LA TABLA CDV
	public void eliminarCdvServicio(ActionEvent e) {
		for (CdvServicioEntity entity : getListaCdv()) {
			if (entity.getSeleccion().equals("1")) {
				edcServiciosService.eliminarCdvServicio(entity);
			}

		}
		llenarTablaCdvServicio();
	}

	public void editarServicios() {
		CdvServicioEntity entity = (CdvServicioEntity) getBackingTable()
		        .getTableBinding().getRowData();
		List<SelectItem> listaSelect = new ArrayList<SelectItem>();
		listaSelect.add(new SelectItem(entity.getLlaveCompuesta().getServicio()
		        .getCveServicio().intValue(), entity.getLlaveCompuesta()
		        .getServicio().getNombreServicio()));
		setComboServicios(listaSelect);
		listaSelect = new ArrayList<SelectItem>();
		listaSelect.add(new SelectItem(entity.getLlaveCompuesta().getServicio()
		        .getCategoria().getCveCategoria().intValue(), entity
		        .getLlaveCompuesta().getServicio().getCategoria()
		        .getNombreCategoria()));
		setComboCategoriaServicios(listaSelect);
		getCdvServiciosForm().setDatoResultadoServicio(
		        entity.getResultado().getCveResultado().intValue());
		LlaveCompuestaRequisitosCdv llaveR = new LlaveCompuestaRequisitosCdv();
		llaveR.setCdv(entity.getLlaveCompuesta().getCdv());
		llaveR.setServicio(entity.getLlaveCompuesta().getServicio());
		List<RequisitosCdvEntity> listaRequisitos = edcServiciosService
		        .recuperarCdvRequisito(llaveR);
		List<CdvVO> listaVo = new ArrayList<CdvVO>();
		List<Integer> listaInteger = new ArrayList<Integer>();
		for (RequisitosCdvEntity requi : listaRequisitos) {
			CdvVO vo = new CdvVO();
			vo.setCveForanea(requi.getLlaveCompuesta().getRequisito()
			        .getCveRequisitos());
			vo.setRadio(requi.getDescripcion());
			vo.setRequisito(requi.getLlaveCompuesta().getRequisito()
			        .getNombreRequisitos());
			listaVo.add(vo);
			listaInteger.add(requi.getLlaveCompuesta().getRequisito()
			        .getCveRequisitos().intValue());

		}
		setListaVo(listaVo);
		setListaRequisitos(listaInteger);

		listaVo = new ArrayList<CdvVO>();
		listaInteger = new ArrayList<Integer>();
		LlaveCompuestaMediosCdv llaveM = new LlaveCompuestaMediosCdv();
		llaveM.setCdv(entity.getLlaveCompuesta().getCdv());
		llaveM.setServicio(entity.getLlaveCompuesta().getServicio());
		List<MediosCdvEntity> listaMedios = edcServiciosService
		        .recuperarCdvMedios(llaveM);
		for (MediosCdvEntity requi : listaMedios) {
			CdvVO vo = new CdvVO();
			vo.setCveForanea(requi.getLlaveCompuesta().getMediosDifusion()
			        .getCveDifusion());
			vo.setRequisito(requi.getLlaveCompuesta().getMediosDifusion()
			        .getNombreDifusion());
			listaVo.add(vo);
			listaInteger.add(requi.getLlaveCompuesta().getMediosDifusion()
			        .getCveDifusion().intValue());

		}
		setListaMediosVo(listaVo);
		setListaDifusion(listaInteger);

	}

	public String serviciosRetroceder() {
		String retroceder = null;
		retroceder = "edc";
		return retroceder;

	}

	public String serviciosAvanzar() {
		String avanzar = null;
		avanzar = "interrelacionadas";
		return avanzar;

	}

}
