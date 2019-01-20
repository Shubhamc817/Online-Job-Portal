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
    </head>
<body>  	
<div class="">
	<div class="header">
		<div class="header-img">
			<img src="/images/download.png" alt="Smiley face" height="42" width="42">
		</div>
		<div class="header_title">JOB SEARCH PORTAL</div>
	</div>
<div class="outer_layout">
	<div class="option_bar">
<ul>


  <!-- <li><a class="active" href="/FSD-IP/listJobs">Home</a></li> -->
  <!-- <li style="float:right"><a class="" href="#">logout</a></li> -->
 <!--   <li style="float:right"><a class="" href="#">Search Job</a></li>
  <li style="float:right"><a class="" href="#">Update profile</a></li>-->
</ul>
<c:url var="profileLink" value="profile">
	<c:param name="empId" value="${jobseeker.id }"></c:param>
</c:url>
	</div>
	<div class="inside_header"></div>
	<div class="profile_title">User profile</div>
<table class="table table-striped table-bordered table-condensed">
    <tr><td class="detail">Name</td><td>${jobseeker.firstName} &nbsp ${jobseeker.lastName }</td></tr>
    <tr><td class="detail">Email</td><td>${jobseeker.email}</td></tr>
    <tr><td class="detail">Contact</td><td>${jobseeker.contact }</td></tr>
    <tr><td class="detail">Total Experience</td><td>${jobseeker.experience}</td></tr>
    <tr><td class="detail">Qualification</td><td>${jobseeker.qualification}</td></tr>
    <tr><td class="detail">Skills</td><td>${jobseeker.skillset}</td></tr>
    <tr><td class="detail">Date of Birth</td><td>${jobseeker.dob}</td></tr>
    <tr><td class="detail">Resume link</td><td><a href="${profileLink }">View/Download Resume</a></td></tr>
</table>
<br/>
<% if(session.getAttribute("admin")!=null){
	
	System.out.println("Admin");
	out.println("Hey Admin <a href="+"/FSD-IP/listJobs"+">"+"Go back home"+"</a>");
	
}
else{
	
	System.out.println("User");
	out.println("<a href="+"/FSD-IP/jobseeker/home"+">"+"Go back home"+"</a>");
}
%>
</div>

</div>


        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
