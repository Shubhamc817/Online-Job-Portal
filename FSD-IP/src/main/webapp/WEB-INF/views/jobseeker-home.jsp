<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">        
        <title></title>
<style>
.container{

	}			
.profile_title{
	margin: 10px 10px;
}
.outer_layout{
	
    width: 80%;
    height: 680px;
    margin: 0 auto;
}			
.header{
	width: 80%;
    margin: 0 auto;
    height: 55px;
    background-color: #33d6ff;
}			
.header_title{
	padding: 5px 10px 15px 70px;
    font-size: 30px;
    font-weight: bold;
}
.header-img{
	float: left;
    margin: 6px 18px;
}		
.option_bar{
	height: 34px;
    background-color: black;
}

.profile_title{
	text-align: center;
    font-size: 21px;
    text-decoration: underline;
    font-weight: bold;
    margin: 22px 13px;}   
    
.detail{font-weight: bold;
    width: 25%;}
    
 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  font-size: 14px;
}

li {
  float: left;
}
li a {
  display: block;
  color: white;
  text-align: center;
  padding: 8px 16px;
  text-decoration: none;
  
}
li a:hover:not(.active) {
  background-color: #111;
}
.active {
	 background-color: 	#b3b3b3;
	 color:black;
}
</style>

<script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
}
</script>
 </head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">  	
<div class="">
	<div class="header">
		<div class="header-img">
			<img src="<c:url value='/images/download.png' />" alt="Smiley face" height="42" width="42">
		</div>
		<div class="header_title">JOB SEARCH PORTAL</div>
	</div>
<div class="outer_layout">
	<div class="option_bar">
	
<c:url var="updateLink" value="/user/updateProfile">
	<c:param name="empId" value="${jobseeker.id}"></c:param>
</c:url>

<c:url var="profileLink" value="/user/applicantProfile">
	<c:param name="empId" value="${jobseeker.id }"></c:param>
</c:url>

<ul>
  <li><a class="active" href="#">Job Seeker Home</a></li>
  <li style="float:right"><a class="" href="/FSD-IP/user/logout">Logout</a></li>
   <li style="float:right"><a class="" href="/FSD-IP/user/searchJobs">Search Jobs</a></li>
    <li style="float:right"><a class="" href=${profileLink} >View Profile</a></li>
  <li style="float:right"><a class="" href=${updateLink} >Update profile</a></li>
</ul>


<div style="float:right"> ${msg}   </div>
<table border="1">
<tr><th>Job ID</th>
<th>Job Name</th>
<th> Project Name</th>
<th> Location</th>
<th> Mandatory Skills</th>
<th> View</th>
<th>Action</th>
</tr>


<c:forEach var="theJob" items="${jobs}" >

<!-- Construct a update link for customer ID -->
<!--<c:url var="updateLink" value="/FormForUpdateJob">
	<c:param name="jobId" value="${theJob.jobId }"></c:param>
</c:url> -->
<c:url var="viewLink" value="/user/jobview">
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
  <!--  <td><a href="${updateLink }">Update</a></td>-->
  </tr>

</c:forEach>
</table>
<div>


	<center>
		<form method="post" action="/FSD-IP/user/doUpload" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Upload Resume</td>
                    <td><input type="file" name="file" size="50" required /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form> 
    </center>
</div>
</body>
</html>