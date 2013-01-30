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

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import mx.gob.imss.cia.ssdc.login.presentacion.form.LoginForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.context.SecurityContext;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class LoginController {
	
	public static final Logger LOG = LoggerFactory
    .getLogger(LoginController.class);
	@Autowired
	private LoginForm loginForm;

	/**
	 * @return the loginForm
	 */
	public LoginForm getLoginForm() {
		return loginForm;
	}

	/**
	 * @param loginForm the loginForm to set
	 */
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	
	
	public String validarLogin(){
	        	try {
					ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		        	String rep = new StringBuilder("/conf/j_spring_security_check?j_username=")
					.append(getLoginForm().getUsuario()).append("&j_password=").append(
							getLoginForm().getContrasena()).append(
							"&_spring_security_remember_me=on").toString();

		        	RequestDispatcher dispatcher = ((ServletRequest) context
							.getRequest()).getRequestDispatcher(rep);
					dispatcher.forward((ServletRequest) context.getRequest(),
					        (ServletResponse) context.getResponse());
					FacesContext.getCurrentInstance().responseComplete();
					HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
					SecurityContext sec=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
					if(sec != null ){
						if(sec.getAuthentication().isAuthenticated()){
							session.getServletContext().setAttribute("usuario", getLoginForm().getUsuario());
						}
						
					}
					
					
				} catch (ServletException e) {
					LOG.error(e.toString());
				} catch (IOException e) {
					LOG.error(e.toString());
				}
		// It's OK to return null here because Faces is just going to exit.
	        return null;
	}
	
	public void validarLogout(ActionEvent e){
		try {
			FacesContext.getCurrentInstance().
			  getExternalContext().getSessionMap();
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest()).getRequestDispatcher("/conf/j_spring_security_logout");
			dispatcher.forward((ServletRequest) context.getRequest(),
			        (ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().getResponseComplete();
		} catch (ServletException e1) {
			LOG.error(e.toString());
		} catch (IOException e1) {
			LOG.error(e.toString());
		}
	
	}
	
}
