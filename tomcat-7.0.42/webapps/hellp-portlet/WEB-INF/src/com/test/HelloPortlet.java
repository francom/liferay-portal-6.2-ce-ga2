package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.service.model.Student;
import com.service.model.impl.StudentImpl;
import com.service.service.StudentLocalServiceUtil;


/**
 * Portlet implementation class HelloPortlet
 */
public class HelloPortlet extends MVCPortlet {
 
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) 
	
		throws IOException, PortletException{
		
		try{
			System.out.println("load method com.test.HelloPorlet.addStudent ");
			
			long id = CounterLocalServiceUtil.increment(this.getClass().getName());
			
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			
			double examFee = ParamUtil.getDouble(actionRequest, "examFee", 00.00);
			
			String sex = ParamUtil.getString(actionRequest, "sex");
			
			int academicYear = ParamUtil.getInteger(actionRequest, "academicYear");
			
			//int subjects = ParamUtil.getInteger(actionRequest, "subjects");
			
			//int academicYear = ParamUtil.getInteger(actionRequest, "academicYear");
			
			String address = ParamUtil.getString(actionRequest, "address");
			
			System.out.println("firstName: " + firstName);
			System.out.println("lastName: " + lastName);
			System.out.println("examFee: " + examFee);
			System.out.println("sex: " + sex);
			System.out.println("address: " + address);
			System.out.println("academicYear: " + academicYear);
			
			
			//tao doi tuong student persistence
			Student student = new StudentImpl();
			
			//fill du lieu vao doi tuong student persistence
			student.setId(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setExamFee(examFee);
			student.setAddress(address);
			student.setGender(sex);
			student.setAcademicYearId(academicYear);
			
			//add student persistence object vao bang Student
			student = StudentLocalServiceUtil.addStudent(student);
			
			//actionResponse.setRenderParameter("mvcPath","html/hello/view.jsp");
		}catch(Exception e){
			SessionErrors.add(actionRequest.getPortletSession(),"student-form-error");
			e.printStackTrace();
		}
	}
	

}


