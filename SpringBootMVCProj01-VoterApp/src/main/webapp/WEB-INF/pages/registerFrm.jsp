<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="c"%>

<h1 style="color: lime;text-align: center;"><b>New Registration Form</b></h1>

<c:form method="Post"  modelAttribute="emp">
<table align="center"  border="1" bgcolor="cyan" >
<tr> 
<td>User Name </td>
<td><c:input path="username"/></td>
</tr>
<tr>
<td>PassWord</td>
<td><c:input path="password"/></td>
</tr>

<tr>
<td>User email</td>
<td><c:input path="email"/></td>
</tr>

<tr>
<td>Mobile No</td>
<td><c:input path="phno"/></td>
</tr>

<tr>
<td>Role</td>
<td>
<c:select path="role">
<c:option label="Admin" value="Admin"/>
<c:option label="Voter" value="Voter"/>
<c:option label="Visiter" value="Visiter"/>
</c:select>
</td>
</tr>

<tr  align="center">
<td colspan="2" ><input type="submit" value="Save"> </td>
</tr>

</table>

</c:form>

