package com.evolve_it.MB;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.evolve_it.pojo.Department;

@ManagedBean(name = "depMB")
@SessionScoped
public class DepartmentMB {

	private Department depar;

	private List<Department> allDepart;

	@PostConstruct
	public void init() {
		depar = new Department();
		allDepart = new ArrayList<>();
		// This List for converter
		Department.allDeps = new ArrayList<>();
	}

	public String addDepartment() {
		if (depar.getDepId() == null) {
			depar.setDepId(allDepart.size() + 1);
			allDepart.add(depar);
			Department.allDeps.add(depar);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Added Successfully", depar.getDepName() + "  added"));

		}
		depar = new Department();
		return null;
	}

	public void updateDep() {
		if (depar.getDepId() != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", depar.getDepName() + "  updated"));
		}
	}

	public void deleteDep() {
		if (depar.getDepId() != null) {
			allDepart.remove(depar);
			Department.allDeps.remove(depar);
			depar = new Department();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Deleted Successfully", depar.getDepName() + "  deleted"));
		}
	}

	public String cancel() {
		depar = new Department();
		return null;
	}

	public Department getDepar() {
		return depar;
	}

	public void setDepar(Department depar) {
		this.depar = depar;
	}

	public List<Department> getAllDepart() {
		return allDepart;
	}

	public void setAllDepart(List<Department> allDepart) {
		this.allDepart = allDepart;
	}

}
