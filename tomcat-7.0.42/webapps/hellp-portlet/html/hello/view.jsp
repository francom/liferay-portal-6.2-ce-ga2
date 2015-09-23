<%@page import="java.util.List"%>
<%@page import="com.service.model.AcademicYear"%>
<%@page import="com.service.service.persistence.AcademicYearUtil"%>
<%@page import="com.service.service.AcademicYearLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Hello</b> portlet in View mode.

<portlet:defineObjects/>

<% System.out.println("Vao view.jsp"); %>

<portlet:actionURL var="addStudentActionURL" windowState="normal" name="addStudent"></portlet:actionURL>

<form action="<%=addStudentActionURL %>" method="POST" name="studentForm">

<b>First Name</b><br/>
<input type="text" name="<portlet:namespace/>firstName" id ="<porlet:namespace/>firstName"><br/>
<b>Last Name</b><br/>
<input type="text" name="<portlet:namespace/>lastName" id ="<porlet:namespace/>lastName"><br/>
<b>Exam Fee</b><br/>
<input type="text" name="<portlet:namespace/>examFee" id ="<porlet:namespace/>examFee"><br/>
<b>Gender</b><br/>
<input type="radio" name="<portlet:namespace/>sex" value ="male">Male<br/>
<input type="radio" name="<portlet:namespace/>sex" value ="female">Female<br/>
<b>Subjects Obtained</b><br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value ="Maths">Maths<br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value ="Physics">Physics<br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value ="Chemistry">Chemistry<br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value ="Bio Technology">Bio Technology<br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value ="Computer Science">Computer Science<br/>

<%
	List <AcademicYear> listAcademicYear = AcademicYearLocalServiceUtil.getAcademicYears(0, 100);
%>
<b>Academic Year</b><br>
<select name="<portlet:namespace/>academicYear">
<% if (listAcademicYear != null){
	
	for(AcademicYear lst: listAcademicYear){
%>
  <option value="<%=lst.getId()%>"><%=lst.getName() %></option>
<%
	}
}	%>
</select><br>

<b>Address</b><br/>
<textarea rows="4" cols="50" name="<portlet:namespace/>address">
</textarea><br/>
<input type="submit" name="addStudent" id="addStudent" value="Add Student"/>

</form>

