/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: AduController.java
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
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import mx.gob.imss.cia.ssdc.cdv.integracion.entity.CategoriaEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.Entidad;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PerfilPersonalEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonalEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonalRelPerfilEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PuestoEntity;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanCommandButton;
import mx.gob.imss.cia.ssdc.cdv.presentacion.component.BackingBeanTable;
import mx.gob.imss.cia.ssdc.cdv.presentacion.form.AduForm;
import mx.gob.imss.cia.ssdc.cdv.servicios.AdministracionUsuariosService;
import mx.gob.imss.cia.ssdc.cdv.servicios.SsdcException;
import mx.gob.imss.cia.ssdc.cdv.servicios.TipoUsuarioService;
import mx.gob.imss.cia.ssdc.commons.Constantes;
import mx.gob.imss.cia.ssdc.commons.SsdcCommon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class AduController {

	@Autowired
	private AduForm aduForm;

	@Autowired
	private BackingBeanCommandButton backingButton;

	@Autowired
	private BackingBeanTable backingTable;

	@Autowired
	private AdministracionUsuariosService administracionUsuariosService;

	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	private List<SelectItem> comboDelegacion;
	private List<SelectItem> comboUnidad = new ArrayList<SelectItem>();
	private List<SelectItem> comboTipoUsuario;
	private List<SelectItem> comboCategorias;
	private List<SelectItem> comboPuestos;

	private List<AduForm> lista;
	private String oculComboDel = "none";
	private String oculComboUni = "none";
	private String oculGrupPerfil = "display";
	private String oculradPerfil = "display";
	private String oculchePerfil = "display";
	private String oculcheDel = "none";
	private String aux = "1";
	private String blok1 = "1";
	private String blok2 = "0";
	private String var1 = "false";
	private String var2 = "true";

	private int page = 1;

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

	/*
	 * METODO PARA QUE SE EJECUTE ANTES DE CARGAR LA INTERFAZ public
	 * AdministracionUserController(){ llenarComboTipoUsuario(); }
	 */
	// Carga inicial de combo
	@PostConstruct
	public void init() throws SsdcException {
		getAduForm().setComboTipoUsuario(llenarComboTipoUsuario());
		getBackingTable().getTableBinding().setValue(llenarTablaUsuarios());
		getAduForm().setComboCategorias(llenarComboCategorias());
		getAduForm().setComboPuestos(llenarComboPuestos());
	}

	// GETTER AND SETTER DE FORM
	public AduForm getAduForm() {
		return aduForm;

	}

	public void setAduForm(AduForm aduForm) {
		this.aduForm = aduForm;

	}

	// GETTER AND SETTER DE COMBO TIPO USUARIO
	public List<SelectItem> getComboTipoUsuario() {
		return comboTipoUsuario;
	}

	public void setComboTipoUsuario(List<SelectItem> comboTipoUsuario) {
		this.comboTipoUsuario = comboTipoUsuario;
	}

	// GETTER AND SETTER DE LISTA
	public void setLista(List<AduForm> lista) {
		this.lista = lista;
	}

	public List<AduForm> getLista() {
		return lista;
	}

	/**
	 * @return the comboCategorias
	 */
	public List<SelectItem> getComboCategorias() {
		return comboCategorias;
	}

	/**
	 * @param comboCategorias
	 *            the comboCategorias to set
	 */
	public void setComboCategorias(List<SelectItem> comboCategorias) {
		this.comboCategorias = comboCategorias;
	}

	/**
	 * @return the comboPuestos
	 */
	public List<SelectItem> getComboPuestos() {
		return comboPuestos;
	}

	/**
	 * @param comboPuestos
	 *            the comboPuestos to set
	 */
	public void setComboPuestos(List<SelectItem> comboPuestos) {
		this.comboPuestos = comboPuestos;
	}

	// GETTER AND SETTER DE TABLA DE TIPO DE USUARIO
	public void setBackingTable(BackingBeanTable backingTable) {
		this.backingTable = backingTable;
	}

	public BackingBeanTable getBackingTable() {
		return backingTable;
	}

	// GETTER AND SETTER DE BOTON
	public BackingBeanCommandButton getBackingButton() {
		return backingButton;
	}

	public void setBackingButton(BackingBeanCommandButton backingButton) {
		this.backingButton = backingButton;
	}

	/**
	 * @return the oculComboDel
	 */
	public String getOculComboDel() {
		return oculComboDel;
	}

	/**
	 * @param oculComboDel
	 *            the oculComboDel to set
	 */
	public void setOculComboDel(String oculComboDel) {
		this.oculComboDel = oculComboDel;
	}

	/**
	 * @return the oculComboUni
	 */
	public String getOculComboUni() {
		return oculComboUni;
	}

	/**
	 * @param oculComboUni
	 *            the oculComboUni to set
	 */
	public void setOculComboUni(String oculComboUni) {
		this.oculComboUni = oculComboUni;
	}

	/**
	 * @return the oculGrupPerfil
	 */
	public String getOculGrupPerfil() {
		return oculGrupPerfil;
	}

	/**
	 * @param oculGrupPerfil
	 *            the oculGrupPerfil to set
	 */
	public void setOculGrupPerfil(String oculGrupPerfil) {
		this.oculGrupPerfil = oculGrupPerfil;
	}

	/**
	 * @return the oculradPerfil
	 */
	public String getOculradPerfil() {
		return oculradPerfil;
	}

	/**
	 * @param oculradPerfil
	 *            the oculradPerfil to set
	 */
	public void setOculradPerfil(String oculradPerfil) {
		this.oculradPerfil = oculradPerfil;
	}

	/**
	 * @return the oculchePerfil
	 */
	public String getOculchePerfil() {
		return oculchePerfil;
	}

	/**
	 * @param oculchePerfil
	 *            the oculchePerfil to set
	 */
	public void setOculchePerfil(String oculchePerfil) {
		this.oculchePerfil = oculchePerfil;
	}

	/**
	 * @return the oculcheDel
	 */
	public String getOculcheDel() {
		return oculcheDel;
	}

	/**
	 * @param oculcheDel
	 *            the oculcheDel to set
	 */
	public void setOculcheDel(String oculcheDel) {
		this.oculcheDel = oculcheDel;
	}

	/**
	 * @return the aux
	 */
	public String getAux() {
		return aux;
	}

	/**
	 * @param aux
	 *            the aux to set
	 */
	public void setAux(String aux) {
		this.aux = aux;
	}

	/**
	 * @return the blok1
	 */
	public String getBlok1() {
		return blok1;
	}

	/**
	 * @param blok1
	 *            the blok1 to set
	 */
	public void setBlok1(String blok1) {
		this.blok1 = blok1;
	}

	/**
	 * @return the blok2
	 */
	public String getBlok2() {
		return blok2;
	}

	/**
	 * @param blok2
	 *            the blok2 to set
	 */
	public void setBlok2(String blok2) {
		this.blok2 = blok2;
	}

	/**
	 * @return the var1
	 */
	public String getVar1() {
		return var1;
	}

	/**
	 * @param var1
	 *            the var1 to set
	 */
	public void setVar1(String var1) {
		this.var1 = var1;
	}

	/**
	 * @return the var2
	 */
	public String getVar2() {
		return var2;
	}

	/**
	 * @param var2
	 *            the var2 to set
	 */
	public void setVar2(String var2) {
		this.var2 = var2;
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

	private List<SelectItem> llenarCombo(List<? extends Entidad> lista) {
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (int i = 0; i < lista.size(); i++) {
			items.add(new SelectItem(SsdcCommon.obtenerValores(lista.get(i),
			        Long.class), SsdcCommon.obtenerValores(lista.get(i),
			        String.class)));
		}

		return items;
	}

	// METODO PARA LLENAR EL COMBO TIPO USUARIO
	public List<SelectItem> llenarComboTipoUsuario() {
		List<SelectItem> lista = llenarCombo(tipoUsuarioService.obtenerTodos());

		setComboTipoUsuario(lista);

		return lista;
	}

	// Metodo para llenar combo de categorias en Nuevo Usuario
	public List<SelectItem> llenarComboCategorias() {
		List<CategoriaEntity> CategoriaUsuarios = administracionUsuariosService
		        .obtenerTodasLasCategorias();
		List<SelectItem> lista = new ArrayList<SelectItem>();

		for (CategoriaEntity cat : CategoriaUsuarios) {
			lista.add(new SelectItem(cat.getCveCategoria(), cat
			        .getNomCategoria()));
		}

		setComboCategorias(lista);
		return lista;
	}

	// Metodo para llenar combo de categorias en Nuevo Usuario
	public List<SelectItem> llenarComboPuestos() {
		List<PuestoEntity> PuestoUsuarios = administracionUsuariosService
		        .obtenerTodosLosPuestos();
		List<SelectItem> lista = new ArrayList<SelectItem>();

		for (PuestoEntity puesto : PuestoUsuarios) {
			lista.add(new SelectItem(puesto.getCvePuesto(), puesto
			        .getNomPuesto()));
		}

		setComboPuestos(lista);
		return lista;
	}

	// METODO PARA LLENAR TABLA DE TIPOS DE USUARIOS
	private List<AduForm> llenarTablaUsuarios() throws SsdcException {
		List<PersonalRelPerfilEntity> usuarios = administracionUsuariosService
		        .filtraPorStatus(Constantes.ENABLE);

		return crearFormConLista(usuarios);
	}

	private String nombreCompleto(PersonalEntity personal) {
		StringBuilder nombreCompleto = new StringBuilder();

		nombreCompleto.append(personal.getNombrePersonal());
		nombreCompleto.append(" ");
		nombreCompleto.append(personal.getApellidoPaterno());
		nombreCompleto.append(" ");
		nombreCompleto.append(personal.getApellidoMaterno());

		return nombreCompleto.toString();
	}

	public void filtrarTipoUsuario() throws NumberFormatException,
	        SsdcException {
		List<PersonalRelPerfilEntity> tipoUsuarioLista = 
				administracionUsuariosService.
				filtraPersonalPorTipo(new Long(getAduForm().getTipoUsuario()));

		getBackingTable().getTableBinding().setValue(
		        crearFormConLista(tipoUsuarioLista));
	}

	private List<AduForm> crearFormConLista(
	        List<PersonalRelPerfilEntity> tipoUsuarioLista) {
		List<AduForm> usuariosForm = new ArrayList<AduForm>();

		for (PersonalRelPerfilEntity usuario : tipoUsuarioLista) {
			AduForm ti = new AduForm();
			PersonalEntity personal = usuario.getLlaveCompuesta().getPersonal();
			PerfilPersonalEntity perfil = usuario.getLlaveCompuesta()
			        .getPerfil();

			ti.setClavePersonal(personal.getCvePersonal());
			ti.setClavePerfil(perfil.getCvePerfilPersonal());
			ti.setUsernameColumna(personal.getNombreUsuario());
			ti.setNombreColumna(nombreCompleto(personal));
			ti.setPerfilColumna(perfil.getNomPerfil());

			usuariosForm.add(ti);
		}

		setLista(usuariosForm);
		return usuariosForm;

	}

	public void eliminarDato() throws SsdcException {
		AduForm form = (AduForm) getBackingTable().getTableBinding()
		        .getRowData();
		PersonalRelPerfilEntity relacion = administracionUsuariosService
		        .recuperaRelacionPerfilPersona(form.getClavePersonal(),
		                form.getClavePerfil());
		relacion.setStatus(Constantes.DISABLE);
		administracionUsuariosService.actualizaRelacionPerfilPersona(relacion);

		getBackingTable().getTableBinding().setValue(llenarTablaUsuarios());
	}

	public String editarUsuario() throws SsdcException {
		String retornar = null;
		retornar = "nuevoUsuario";

		AduForm form = (AduForm) getBackingTable().getTableBinding()
		        .getRowData();
		PersonalRelPerfilEntity relacion = administracionUsuariosService
		        .recuperaRelacionPerfilPersona(form.getClavePersonal(),
		                form.getClavePerfil());
		Long cveTipoUsuario = relacion.getLlaveCompuesta().getPerfil()
		        .getTipoUsuario().getCveTipoUsuario();
		if (cveTipoUsuario == 1) {
			// aduForm.getTipoUsuario();
			String tipoUsuario = relacion.getLlaveCompuesta().getPerfil()
			        .getTipoUsuario().getTipoUsuario();
			String perfil = relacion.getLlaveCompuesta().getPerfil()
			        .getNomPerfil();
			String apellidoP = relacion.getLlaveCompuesta().getPersonal()
			        .getApellidoPaterno();
			String apellidoM = relacion.getLlaveCompuesta().getPersonal()
			        .getApellidoMaterno();
			String nom = relacion.getLlaveCompuesta().getPersonal()
			        .getNombrePersonal();
			String puesto = relacion.getLlaveCompuesta().getPersonal()
			        .getPuesto().getNomPuesto();
			String categoria = relacion.getLlaveCompuesta().getPersonal()
			        .getCategoria().getNomCategoria();
			// TODO Arreglar
			// int lada= relacion.getLlaveCompuesta()
			// .getPersonal().getLada();
			// int telefono= relacion.getLlaveCompuesta()
			// .getPersonal().getTelefono();
			// int extension= relacion.getLlaveCompuesta()
			// .getPersonal().getExtension();
			// String correo= relacion.getLlaveCompuesta().getPersonal()
			// .getCorreoElectronico();

			aduForm.setTipoUsuario(tipoUsuario);
			// aduForm.s
			aduForm.setApPaterno(apellidoP);
			aduForm.setApMaterno(apellidoM);
			aduForm.setNombre(nom);
			aduForm.setPuesto(puesto);
			aduForm.setCategoria(categoria);
			// aduForm.setLada(lada);
			// aduForm.setTelefono(telefono);
			// aduForm.setExtension(extension);
			// aduForm.setCorreoE(correo);
		}

		return retornar;
	}

	public void mostrar(ActionEvent e) throws SsdcException {
		if (getAduForm().getTipoUsuario().equals(Constantes.COMBO_TIPO_USUARIO)) {
			getAduForm().setTipoSeleccion(Constantes.LABEL_TIPO_USUARIO);
			getBackingTable().getTableBinding().setValue(llenarTablaUsuarios());
			// getAdministracionUserForm().setModalEdit("Richfaces.showModalPanel('User');");
			getBackingButton().getBotonBinding().setOnclick(
			        "Richfaces.showModalPanel('User');");

		}

	}

	public void ocultar() {

		if (getAduForm().getTipoUsuario().equals("1")) {
			setOculComboDel("none");
			setOculComboUni("none");
			setOculGrupPerfil("display");
			setOculradPerfil("display");
			setOculchePerfil("display");
			setOculcheDel("none");

		} else if (getAduForm().getTipoUsuario().equals("2")) {
			setOculComboDel("display");
			setOculComboUni("none");
			setOculGrupPerfil("none");
			setOculradPerfil("none");
			setOculchePerfil("none");
			setOculcheDel("display");

		} else if (getAduForm().getTipoUsuario().equals("3")) {
			setOculComboDel("display");
			setOculComboUni("display");
			setOculGrupPerfil("none");
			setOculradPerfil("none");
			setOculchePerfil("none");
			setOculcheDel("none");

		}

	}

	public void controlBloqueo() {
		if (getAux().equals(getBlok1())) {

			setVar1("true");
			setVar2("false");

		} else if (getAux() != getBlok2()) {
			setVar1("false");
			setVar2("true");

		}
	}

	public String nuevoUsuarioNavigation() {
		String nuevo = null;

		nuevo = "nuevoUsuario";

		return nuevo;

	}

	public String retornaPanelAdministrador() {
		String retorna = null;
		retorna = "usuarios";
		return retorna;

	}

}