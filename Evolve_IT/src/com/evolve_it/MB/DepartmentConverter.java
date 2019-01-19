package com.evolve_it.MB;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.evolve_it.pojo.Department;

@FacesConverter("departConv")
public class DepartmentConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		for ( Department department :  Department.allDeps)
		{
			if(arg2.equals(department.getDepName()))
				return department;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		Department department;
		if (arg2 instanceof Department){
			department = (Department) arg2;
			department.getDepName();
		}
		
		return null;
	}
	

}
