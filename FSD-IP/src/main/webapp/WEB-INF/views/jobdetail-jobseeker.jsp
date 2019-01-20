<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
	<title>webpagesA2</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="Css2 .css">
	<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<style>
.heading{
	background-color: sky blue; /* For browsers that do not support gradients */
    background-image: linear-gradient(to right, rgba(255,0,0,1), rgba(255,0,0,0));
	height: 200px;
	width: 100%;
}
.job_post_tilte{
	font-weight: bold;
    color: white;
    font-size: 24px;
    padding: 39px 25px 16px 24px;

}
#job_description{
	color: white;
    line-height: 1.5;
    padding: 0px 6px 6px 21px;
    width: 20%;
}
.outer_body{
	background-color: lightgray;
	    padding-top: 57px;
}

.body_content{
	
	height: 90%;
    background-color: white;
    width: 97%;
    margin: 0 auto;
    
}
.inner_job_title{
	    background-color: #9E9E9E;
	    height: 110px;    
}

.start_date{
	font-size: 16px;
    float: left;
    padding: 1px 21px 6px 13px;
	
}

.end_date{
	font-size: 16px;
    float: left;
}
#job_id{
	padding: 26px 15px 13px 15px;
    color: white;
    font-size: 17px;
}	

#job_code{
	font-weight: bold;
    color: white;	
}
.billing_date{
	float: left;
    padding-left: 17px;
}

.detailed_job_description{
	width: 95%;
    height: 300px;
    margin: 0 auto;
        padding: 45px 13px;
         font-family: arial;
	
}

#job_discription_title{
	width: 157px;
    border-bottom: 6px solid gray;
    padding-bottom: 7px;
}
#description{
	font-weight: bold;  
    padding-left: 5px;
}
.job_discription_details{
	    border-bottom: 1px solid gray;
}
.favourites{
}

.job_para{
	padding-top: 30px;
}


#job_skills{
}

#skills_list{
	padding-top: 10px;
    line-height: 2;
    padding-buttom: 10px; 
}
.full_page{
	
	width: 100%;
    margin: 0 auto;
	}
</style>
<body>
	<div class="full_page">
<div class="heading">
	<div class="job_post_tilte">${job.jobName }</div>
	<address id="job_description">${job.location},
	${job.empBand} 
	</address>
</div>
<div class="outer_body">
	<div class="body_content">
		<div class="inner_job_title">
			<div id="job_id">Indent No. <span id="job_code">${job.jobId}</span></div>
			<div class="start_date">Job Start Date: 12 Oct 2018</div>
			<div class="end_date">Job End Date: 31 Oct 2018</div>
	
		</div>
		<div class="detailed_job_description">
			<div class="job_description_details">
				<div id="job_description_title"> Account Name <span id="description">${job.projectName}</span>
				</div>
				<div id="job_description_title"> Open Position <span id="description">${job.openPosition}</span>
				</div>
				<div id="job_description_title"> Min Experience Required <span id="description">${job.empExp}</span>
				</div>
			</div>
		<div class="job_para">
		<div id="job_skills">
		key skills for the  job are:
		</div>
		<div id="skills_list">
		${job.mandSkills}<br>
		
		</div>
		<div id="job_skills">
		Good to have skills for the  job are:
		</div>
		<div id="skills_list">
		${job.optionalSkills}<br>
		
		</div>
		${job.jobDescription} 
		
		</div>
		
		</div>
	</div>
</div>


</div>
 
<div>
<a href="/FSD-IP/jobseeker/home">Back to Job's List</a>
</div>
<center><a href="apply"><input type="submit" value="Apply"></button></a></center>

<center><h2 style="color:red">${msg}</h2><br></center>

</body>

</html>