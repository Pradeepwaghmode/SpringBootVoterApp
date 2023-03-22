<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="f"%>

<h1 style="color: lime;text-align: center;"><b>Login Page</b></h1>

<c:form method="Post"  modelAttribute="emp1">
<table align="center"  border="1" bgcolor="cyan" >
<tr> 
<td>User Name </td>
<td><c:input path="username"/></td>
</tr>
<tr>
<td>PassWord</td>
<td><c:input path="password" type="password"/></td>
</tr>



<tr  align="center">
<td colspan="2" ><input type="submit" value="Login"> &nbsp &nbsp <a href="register">Register </a></td>
</tr>

</table>

</c:form>

<f:if test="${!empty msg}">
	<h1 style="color: green;text-align: center;">${msg}</h1>
</f:if>
