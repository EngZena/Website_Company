package com.evolve_it.MB;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.evolve_it.pojo.Employees;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {

	private Employees emp;

	@PostConstruct
	private void init() {
		emp = new Employees();

	}

	public String Login() {
		if (emp != null) {
			if (emp.getAdmin() == 0) {
				return "adminView.xhtml?faces-redirect=true";
			} else if (emp.getAdmin() == 1) {
				return "employeesView.xhtml?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "No such Email", "No such Email"));
				return null;
			}
		}
		return null;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}

}
