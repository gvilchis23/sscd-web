/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: LoginController.java
 *
 * Creado:  13/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */
package mx.gob.imss.cia.ssdc.login.presentacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import mx.gob.imss.cia.ssdc.cdv.commons.CompilacionCondicional;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.MenuEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PerfilPersonalEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonalEntity;
import mx.gob.imss.cia.ssdc.cdv.integracion.entity.PersonalRelPerfilEntity;
import mx.gob.imss.cia.ssdc.cdv.servicios.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author propietario
 * 
 */

@Controller
@Scope("session")
public class MenuController {

	public static final Logger LOG = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private MenuService menuService;
	private List<MenuEntity> listMenu = new ArrayList<MenuEntity>();
	private String campo;

	@PostConstruct
	public void init() {

		if (CompilacionCondicional.HABILITAR_MENU_SERVICE) {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			String usuario = (String) session.getServletContext().getAttribute(
					"usuario");
			PersonalEntity personal = menuService
					.recuperarUsuarioByUsuario(usuario);
			PersonalRelPerfilEntity perRel = menuService
					.recuperarPersonalByCvePersonal(personal.getCvePersonal());
			PerfilPersonalEntity perfil = menuService
					.recuperarPerfilByCvePerfil(perRel.getLlaveCompuesta()
							.getPerfil().getCvePerfilPersonal());
			setListMenu(menuService.filtrarMenuPorRol(perfil.getTipoUsuario()
					.getCveTipoUsuario()));
		}

	}

	/**
	 * @return the campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * @param campo
	 *            the campo to set
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}

	/**
	 * @return the listMenu
	 */
	public List<MenuEntity> getListMenu() {
		return listMenu;
	}

	/**
	 * @param listMenu
	 *            the listMenu to set
	 */
	public void setListMenu(List<MenuEntity> listMenu) {
		this.listMenu = listMenu;
	}

}
