<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Jobs</title>

<script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
	
	myFun();
}
</script>

<script type="text/javascript">

function findBySkill() {
	
	var x= document.getElementById("findBySkill");
	
	document.getElementById("myForm").style.display ="block";
		x.style.display = "block";
	
	document.getElementById("findByLoc").style.display="none";
	document.getElementById("findByExp").style.display="none"; 
}

function findByLoc() {
	
	var x= document.getElementById("findByLoc");
	
	document.getElementById("myForm").style.display ="block";
		x.style.display = "block";
	
	document.getElementById("findBySkill").style.display="none";
	document.getElementById("findByExp").style.display="none"; 
}

function findByExp() {
	
	var x= document.getElementById("findByExp");
	
	document.getElementById("myForm").style.display ="block";
		x.style.display = "block";
	
	document.getElementById("findBySkill").style.display="none";
	document.getElementById("findByLoc").style.display="none";
}

function myFun() {
	
	document.getElementById("myForm").style.display ="none";	
	document.getElementById("findByExp").style.display ="none";	
	document.getElementById("findBySkill").style.display="none";
	document.getElementById("findByLoc").style.display="none";
}
</script> 

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
<header>
<div class="nav">
<ul>
<li><a href="/FSD-IP/jobseeker/home">Go back home</a></li>
<!--  <li><a href="/rest/modifyProfile">Modify Profile</a></li>
<li><a href="/rest/deleteProfile">Delete Profile</a></li> 
<li><a href="/rest/uploadProfile">Upload Profile</a></li>
<li><a href="/rest/searchJob">Search Job</a></li>
<li><a href="/rest/logOut">Log Out</a></li>-->
</ul>
</div>
</header>
<!--  style="color:#f2f2f2;padding:20px;"-->
<div><h1>Search Job</h1>



<form>
<input type="radio" name="firstName" value="findBySkill" onclick="findBySkill()"></input> Search By Skills<br><br>
<input type="radio" name="firstName" value="findByLoc" onclick="findByLoc()"></input> Search By Location<br><br>
<input type="radio" name="firstName" value="findByExp" onclick="findByExp()"> Search By Experience</input><br><br>
</form>

<div class="form" id="myForm">
<div id="findBySkill" display="none">
<form action="/FSD-IP/user/showJobBySkill" method="post">
<input type="text" name="showJobBySkill" placeholder="Enter Skill" required/><br>
<input type="submit" value="find" style="background-color:#11C656"/>
</form>
</div>

<div id="findByLoc" display="none">
<form action="/FSD-IP/user/showJobByLoc" method="post">
<input type="text" name="showJobByLoc" placeholder="Enter Location" required/><br>
<input type="submit" value="find" style="background-color:#11C656"/>
</form>
</div>

<div id="findByExp" display="none">
<form action="/FSD-IP/user/showJobByExp" method="post">
<input type="text" name="showJobByExp" placeholder="Enter Exp" required/><br>
<input type="submit" value="find" style="background-color:#11C656"/>
</form>
</div>
</div>



<c:if test="${!empty list}">
<table border="1">
<tr>
<th>JobID</th>
<th>Job Name</th>
<th>Project Name</th>
<th>Skills Required</th>
<th>optionalSkills</th>
<th>Location</th>
<th>Employee Band</th>
<th>Experience</th>
<th> View Job </th>
</tr>

<c:forEach var="job" items="${list}">
<c:url var="viewLink" value="/user/jobview">
	<c:param name="jobId" value="${job.jobId }"></c:param>
</c:url>
<tr>
	<td><c:out value="${job.jobId}"></c:out></td>
	<td><c:out value="${job.jobName}"></c:out></td>
	<td><c:out value="${job.projectName}"></c:out></td>
	<td><c:out value="${job.mandSkills}"></c:out></td>
	<td><c:out value="${job.optionalSkills}"></c:out></td>
	<td><c:out value="${job.location}"></c:out></td>  
	<td><c:out value="${job.empBand}"></c:out></td>
	<td><c:out value="${job.empExp}"></c:out></td>
	 <td><a href="${viewLink }">View Job</a></td>
</tr>
</c:forEach>
</table>
</c:if>

<center><h3 style="color:green">${msg}!</h3><br><center>


</body>
</html>