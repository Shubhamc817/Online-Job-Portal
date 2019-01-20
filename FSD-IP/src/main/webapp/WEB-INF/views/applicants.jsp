<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>
Customer List</title>
</head>
<body>


<input type="submit" value="Back to home"
onclick="window.location.href='listJobs';return false"
/>
<table border="1">
<tr><th>Emp ID</th>
<th>Emp Name</th>
<th> Skill Set</th>
<th> Location</th>
<th> Contact</th>
<th> Email</th>
<th> View</th>
</tr>


<c:forEach var="applicant" items="${applicants}" >

<c:url var="applicantLink" value="user/applicantProfile">
	<c:param name="empId" value="${applicant.id }"></c:param>
</c:url>
<c:url var="profileLink" value="user/profile">
	<c:param name="empId" value="${applicant.id }"></c:param>
</c:url>
<!-- Construct a update link for customer ID -->
<!--<c:url var="updateLink" value="/FormForUpdateJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
<c:url var="viewLink" value="/showJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>
<c:url var="View Applicants" value="/applicants">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url>-->

  <tr>
  <td>${applicant.id }</td>
  <td>${applicant.firstName }</td>
  <td>${applicant.skillset }</td>
  <td>${applicant.experience }</td>
  <td>${applicant.contact }</td>
   <td>${applicant.email }</td>
  <!-- display Update  -->
  <td><a href="${applicantLink }">View Profile</a></td>
  <td><a href="${profileLink }">View/Download Resume</a></td>
  
  </tr>

</c:forEach>
</table>

</body>
</html>