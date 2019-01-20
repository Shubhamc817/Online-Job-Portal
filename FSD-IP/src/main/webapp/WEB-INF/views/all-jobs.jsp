<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>
Admin Home</title>
</head>

<script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
}
</script>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">

<div style="float:right"> <a href="/FSD-IP/admin/logout">Logout</a></div>

<input type="submit" value="Add Jobs"
onclick="window.location.href='/FSD-IP/FormForAddJob';return false"
/>
<table border="1">
<tr><th>Job ID</th>
<th>Job Name</th>
<th> Project Name</th>
<th> Location</th>
<th> Mandatory Skills</th>
<th> View</th>
<th>Action</th>
<th>Applicants</th>
</tr>


<c:forEach var="theJob" items="${jobs}" >

<!-- Construct a update link for customer ID -->
<c:url var="updateLink" value="/FormForUpdateJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
<c:url var="viewLink" value="/showJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
<c:url var="ViewApplicants" value="/applicants">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
<c:url var="deleteJob" value="/deleteJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
  <tr>
  <td>${theJob.jobId }</td>
  <td>${theJob.jobName }</td>
  <td>${theJob.projectName }</td>
  <td>${theJob.location }</td>
  <td>${theJob.mandSkills }</td>
  <!-- display Update  -->
  <td><a href="${viewLink }">View Job</a></td>
  <td><a href="${updateLink }">Update</a></td>
   <td><a href="${ViewApplicants }">View Applicants</a></td>
   <td><a href="${deleteJob }">Delete Job</a></td>
  </tr>

</c:forEach>
</table>

</body>
</html>