package com.evolve_it.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.evolve_it.pojo.Department;
import com.evolve_it.pojo.Employees;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "empMB")
@SessionScoped

public class EmployeesMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3250635579403319950L;

	private Employees emp;

	private List<Employees> allEmployees;

	private List<Department> allDepartments;

	@PostConstruct
	public void init() {
		emp = new Employees();
		allEmployees = new ArrayList<>();
		allDepartments = new ArrayList<>();
	}

	@ManagedProperty("#{depsMB}")
	private DepartmentMB departmentMB;

	public String addEmp() {
		if (emp.getId() == null) {
			emp.setId(allEmployees.size() + 1);
			allEmployees.add(emp);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Added Successfully", emp.getFirstName() + " " + emp.getLastName() + "  added"));
		}
		emp = new Employees();
		return null;
	}

	public String updateEmp() {
		if (emp.getId() != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Updated Successfully", emp.getFirstName() + " " + emp.getLastName() + "  updated"));
		}
		emp = new Employees();
		return null;
	}

	public void deleteEmp() {
		if (emp.getId() != null) {
			allEmployees.remove(emp);
			emp = new Employees();
		}
	}

	public String cancel() {
		emp = new Employees();
		return null;
	}

	public void checkEmailValidate(AjaxBehaviorEvent event) {
		for (Employees e : allEmployees) {
			if (emp.getEmail().equals(e.getEmail())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Already exist email", "This email already exist"));
				return;
			}
		}

	}

	public DepartmentMB getDepartmentMB() {
		return departmentMB;
	}

	public void setDepartmentMB(DepartmentMB departmentMB) {
		this.departmentMB = departmentMB;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}

	public List<Employees> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(List<Employees> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public List<Department> getAllDepartments() {
		return allDepartments;
	}

	public void setAllDepartments(List<Department> allDepartments) {
		this.allDepartments = allDepartments;
	}

}
