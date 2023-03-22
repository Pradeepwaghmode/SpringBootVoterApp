<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<h1 style="color: lime; text-align: center;">
	<b>Voting Page</b>
</h1>

<noscript>
	<h1 style="color: red; text-align: center;">
		<b>Please Enable java Script</b>
	</h1>
</noscript>


<script lang="javaScript" src="js/registrationValidator.js"></script>
<style>
.error {
	color: red
}
</style>

<script type="text/javascript">
	function check() {

		
		if (document.getElementById('c1').checked == true) {
			document.getElementById("c2").disabled = true;  
			document.getElementById("c3").disabled = true; 
			document.getElementById("c4").disabled = true;  
		} else if (document.getElementById('c2').checked == true) {

			document.getElementById("c1").disabled = true;  
			document.getElementById("c3").disabled = true; 
			document.getElementById("c4").disabled = true;  
		} else if (document.getElementById('c3').checked == true) {
			
			document.getElementById("c2").disabled = true;  
			document.getElementById("c1").disabled = true; 
			document.getElementById("c4").disabled = true;  
		} else if (document.getElementById('c4').checked == true) {
			
			document.getElementById("c2").disabled = true;  
			document.getElementById("c3").disabled = true; 
			document.getElementById("c1").disabled = true;  
		} else {
			document.write("<h1 style='color: red; text-align: center;'><b>Please give your vote !!</b></h1>");
			document.write("<h1 style='color: red; text-align: center;'><a href='home'><b>home</b></a></h1>");
		}
		
		
	}
</script>


<script type="text/javascript">
	function check1() {

		
		if (document.getElementById('c1').checked == true) {
			document.getElementById("c2").checked = false;  
			document.getElementById("c3").checked = false; 
			document.getElementById("c4").checked = false;  
		} else if (document.getElementById('c2').checked == true) {

			document.getElementById("c1").checked = false;  
			document.getElementById("c3").checked = false; 
			document.getElementById("c4").checked = false;  
		}else  if (document.getElementById('c3').checked == true) {
			
			document.getElementById("c2").checked = false;  
			document.getElementById("c1").checked = false; 
			document.getElementById("c4").checked = false;  
		} else if (document.getElementById('c4').checked == true) {
			
			document.getElementById("c2").checked = false;  
			document.getElementById("c3").checked = false; 
			document.getElementById("c1").checked = false;  
		}
		
		
	}
</script>






<c:form method="Post" action="votting" modelAttribute="can"
	cssClass="error" onsubmit="return check(this)" onclick="return check1(this)">


	<table align="center" border="1" bgcolor="cyan">
		<tr>
			<td>CANDIDATE 1</td>
			<td><input type="radio" name="c1" id="c1" value="1" /> <c:errors
					cssStyle="color:red" path="c1" /><span id="c1err"></span></td>
		</tr>

		<tr>
			<td>CANDIDATE 2</td>
			<td><input type="radio" name="c2" id="c2" value="1" /> <c:errors
					cssStyle="color:red" path="c2" /><span id="c2err"></span></td>
		</tr>

		<tr>
			<td>CANDIDATE 3</td>
			<td><input type="radio" name="c3" id="c3" value="1" /> <c:errors
					cssStyle="color:red" path="c3" /><span id="c3err"></span></td>
		</tr>


		<tr>
			<td>CANDIDATE 4</td>
			<td><input type="radio" name="c4" id="c4" value="1" /> <c:errors
					cssStyle="color:red" path="c4" /><span id="c4err"></span></td>
		</tr>

		<tr align="center">
			<td colspan="2"><input type="submit" value="VoteRegister">
			</td>
		</tr>

	</table>

</c:form>

