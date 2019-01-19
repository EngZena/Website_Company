package com.evolve_it.pojo;

import java.util.List;

public class Department {

	private Integer depId;
	
	private String depName;
	
	private String depDesc;
	
	private List<Employees> allEmps;
	
	//This List for Converter 
	public static List<Department> allDeps;

	
	
	@Override
	public String toString() {
		return depName;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepDesc() {
		return depDesc;
	}

	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}

	public List<Employees> getAllEmps() {
		return allEmps;
	}

	public void setAllEmps(List<Employees> allEmps) {
		this.allEmps = allEmps;
	}

	public static List<Department> getAllDeps() {
		return allDeps;
	}

	public static void setAllDeps(List<Department> allDeps) {
		Department.allDeps = allDeps;
	}
	
	
	
}
