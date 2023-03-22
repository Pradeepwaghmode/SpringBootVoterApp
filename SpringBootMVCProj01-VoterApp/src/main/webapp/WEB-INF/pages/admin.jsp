<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color: lime;text-align: center;"><b>Voting Page</b></h1>
<h1 style="color: red;text-align: right ;"> <a href="logout">Logout</a> </h1>
<c:if test="${!empty currentUser}">
<table align="center"  border="1" bgcolor="cyan"  >

<tr> 
<td><b>CANDIDATES NAME</b></td>
<td><b>TOTALE SCORE</b></td>
</tr>

<tr> 
<td>CANDIDATE 1 </td>
<td>${currentUser.c1}</td>
</tr>

<tr>
<td>CANDIDATE 2</td>
<td>${currentUser.c2}</td>
</tr>

<tr>
<td>CANDIDATE 3</td>
<td >${currentUser.c3}</td>
</tr>


<tr>
<td>CANDIDATE 4</td>
<td>${currentUser.c4}</td>
</tr>

<tr  align="center">
<td colspan="2" ><a href="home">Home</a> </td>
</tr>

</table>

</c:if>
<br>

<c:if test="${!empty report}">
<table align="center"  border="1" bgcolor="cyan" >
			<tr>
			<th>Voter Name</td>
			<th>Vote Given</td>
			</tr> 

        <c:forEach var="repo" items="${report}">
            <tr>
			<td>${repo.usname}</td>
			<td>${repo.cname}</td>
			</tr>    
        </c:forEach>
    
</table>
</c:if>
