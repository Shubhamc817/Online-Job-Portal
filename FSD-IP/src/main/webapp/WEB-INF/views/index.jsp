<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">        
        <title>Home</title>
<style>
.header{
	height: 40px;
	background-color: #05416D;
	}
.outer_body{
    width: 80%;
    height: 680px;
    margin: 0 auto;}
.phone_icon{
	color: white;
    padding: 9px 2px 3px 10px;}	
.number{}
.email{
	color:white;
	font-size:13px;}
.sub-header{
	height: 47px;
   }
.header_img{
		margin-left:20px;
		margin-bottom: 6px;
		float: left;
		}
 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  font-size: 14px;
}

li {
  float: left;
}
li a {
  display: block;
  color: black;
  text-align: center;
  padding: 8px 16px;
  text-decoration: none;
  
}
li a:hover:not(.active) {
 
}

li a:hover {
  background-color: white;
}

.active {
	color: #05416D;
}
.option_bar{
    margin-top: 8px;
}
.site_tilte{
	height: 275px;
	background: url(/FSD-IP/images/bg_image.jpeg)  repeat 20px 14px;;
	}
.title{
	font-size: 35px;
    font-weight: bold;
    margin: 13px;
    padding-top: 92px;
    color: white;
    text-align: center;}
.discription{
	
	color: white;
    font-size: 15px;
    text-align: center;}
  
  .left_div{
	width: 50%;
	float:left;}
.right_div{
	float:right;
	width: 50%;}
    
.user_login{margin: 58px 28px 0px 31px;
    padding: 20px;}
.admin_login{ padding: 20px;
	margin: 58px 28px 0px 31px;}
.user_button{ margin: 8px 5px 1px 150px;}
.admin_button{ margin: 8px 5px 1px 150px;}
.register{
	float: right;
    color: white;
    font-size: 13px;
    padding: 11px;
   }
</style>
    </head>
<body>
	<div class="outer_body">
	<div class="header">
          <span class="glyphicon glyphicon-earphone phone_icon"> Call-us 0123456789</span>
          <i class='far fa-envelope' style='font-size:18px;color:white;padding-left:10px;padding-right:10px;'></i> <span class="email">shubham.choudhary1@wipro.com</span><span class="register"></span>
    </div>
    <!--  <spring:url value="/resources/images" var="images" />-->
	<div class="sub-header"><img class="header_img" src="/images/job_finder.png" alt="Smiley face" height="60" width="100">
		<div class="option_bar">
			<!--  <ul>
				<li style="float:right"><a class="" href="#">logout</a></li>
				<li style="float:right"><a class="" href="#">Search</a></li>
				<li style="float:right"><a class="" href="#">Update profile</a></li>
				<li style="float:right"><a class="" href="#">Contact us</a></li>
				<li style="float:right"><a class="active" href="#">Home</a></li>
			</ul>-->
		</div>
	</div>
	<div class="site_tilte">
		<div class="title">Join the best job finder</div>
		<div class="discription">Search your dream jobs here.....</div>
	</div>
	<div class="left_div">
			<div class="user_login">Choose a job you love, and you will never have to work a day in your life.
			So, why to wait, Just sign up, login and starts applying your dream jobs.
		 </div>
		
<form action="/FSD-IP/jobseeker/jobSeekerLogin" method="post">
<div class="user_button"><input type="Submit" class="btn btn-primary" value="JobSeeker login"/>
</div></form>
</div>
	<div class="right_div"> 
		<div class="admin_login">
			Our Admin are here to help you out finding your dream job. Are you an Admin? Login here <br/><br>
		</div>
		<form action="/FSD-IP/admin/login" method="post">
	 <div class="admin_button"><input  type="Submit" class="btn btn-primary" value="Admin Login"/>
	<!--  <div class="admin_button"><button type="button" class="btn btn-primary">Admin login</button>-->
		</div>
	</form>
		
   </div>
	
	
</div>
		<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.6.3/css/all.css' integrity='sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/' crossorigin='anonymous'>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>

