package com.evolve_it.MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean (name = "adminMB")
@SessionScoped
public class AdminMB {
	
	public String goToEmp()
	{
		return "addNewEmp.xhtml?faces-redirect=true";
	}
	
	public String goToDep()
	{
		return "addNewDep.xhtml?faces-redirect=true";
	}

}
