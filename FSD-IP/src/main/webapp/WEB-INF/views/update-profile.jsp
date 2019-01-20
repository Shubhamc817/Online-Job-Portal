<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Update Profile</title>

<style>
.outer_layout{
	background-color: #58D6C1;
    width: 80%;
    height: 680px;
    margin: 0 auto;
}
.form_layout{
	width: 50%;
    margin: 0 auto;
    background-color: white;
   height: auto;
}
.form_body{
	padding:10px;
	}
	
.form_title{
	padding: 15px 0px 15px 0px;
    width: 15%;
    margin: auto;
    color: red;
    font-weight: bold;
}	
.input_label{
	width: 165px;
    float: left;
}
.input_field{
}
.form_content{
    width: 340px;
    margin: auto;
    padding: 5px;
    height: 25px;
}
.submit_button{
	margin: 16px auto;
	width:100px;
}
.input_field input{
	border-radius: 3px;
    border: 1px solid gray;
}
.input_field textarea{
	border-radius: 3px;
    border: 1px solid lightgray;
}

.submit_button input[type=submit]{
	border: 1px solid gray;
    border-radius: 3px;
    color: black;
    padding: 5px 5px;
    background-color: lightgray;
    font-weight:bold;
}
.job_description{
	width: 340px;
    margin: auto;
    padding: 5px;
    height: 70px;
}
.star{
	color: red;
}
.inside_header{
	width: 80%;
    margin: 0 auto;
    height: 40px;}
.header{
	width: 80%;
    margin: 0 auto;
    height: 55px;
    background-color: #EC7063;
}
.header_title{
	padding: 15px 10px 15px 70px;
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
#home{
	color: white;
    float: left;
    padding: 10px;}
#logout{
	color: white;
    float: right;
    padding: 10px;}
</style>
</head>
<body>

<body>
<div class="header"><div class="header-img"><img src="images/download.png" alt="Smiley face" height="42" width="42"></div><div class="header_title">JOB SEARCH PORTAL</div></div>
<div class="outer_layout">
<div class="option_bar"><div id="home"><a href="/FSD-IP/jobseeker/home/">Home</a></div>
<!-- <div id="logout">logout</div> --></div>
	<div class="inside_header"></div>
	<div class="form_layout">
		<div class="form_body">	
			<div class="form_title">Update Profile</div>

<form:form action="/FSD-IP/user/updateSuccess" modelAttribute="jobseeker" method="POST">


<div class="form_content"><div class="input_label">Employee Id <span class="star">*</span></div><div class="input_field">
<form:input path="id" required="required"/></div></div>

<div class="form_content"><div class="input_label">First name <span class="star">*</span></div><div class="input_field">
<form:input path="firstName" /></div></div>

<div class="form_content"><div class="input_label">Last Name<span class="star">*</span></div><div class="input_field">
<form:input path="lastName"/></div></div>

<div class="form_content"><div class="input_label">Skill Set</div><div class="input_field">
<form:textarea path="skillset"/></div></div>

<div class="form_content"><div class="input_label">Date Of birth:<span class="star">*</span></div><div class="input_field">
<form:input path="dob"/></div></div>

<div class="form_content"><div class="input_label">Qualification</div><div class="input_field">
<form:input path="qualification"/></div></div>

<div class="form_content"><div class="input_label">Total experience<span class="star">*</span></div><div class="input_field">
<form:input path="experience"/></div></div>

<div class="form_content"><div class="input_label">Gender</div><div class="input_field">
<form:input path="gender"/></div></div>

<div class="form_content"><div class="input_label">Email <span class="star">*</span></div><div class="input_field">
<form:input path="email" /></div></div>

<div class="form_content"><div class="input_label">Contact </div><div class="input_field">
<form:input path="contact"/></div></div>

<div class="form_content"><div class="input_label">Password </div><div class="input_field">
<form:password path="password" required="required"/></div></div>


<div class="submit_button"><input type="submit" value="Update"></div>

</form:form>


</div>
</div>
</div>
</body>
</html>

	
			