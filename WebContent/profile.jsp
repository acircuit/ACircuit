<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ac.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

  <link rel="shortcut icon" href="https://www.advisorcircuit.com/assets/img/PageTop_Logo.png"> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<!-- Bootstrap core CSS -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="assets/css/pannel.css" rel="stylesheet">
<link href="assets/css/star-rating.css" rel="stylesheet">
<link href="assets/css/nav-mobile.css" rel="stylesheet">
<link href="assets/css/qa.css" rel="stylesheet">
<link href="assets/css/ud.css" rel="stylesheet">
<link href="assets/css/advisor.css" rel="stylesheet">
<link href="assets/css/allsessions.css" rel="stylesheet">
<link href="assets/css/profile.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
String advisorverification =  request.getParameter("advisorverification");
AdvisorDTO advisor = (AdvisorDTO) request.getAttribute("profile"); 
String action = (String) request.getAttribute("action"); 
List<String> higherStudiesSubCategory = (List<String>) request.getAttribute("higherStudiesSubCategory"); 
List<String> industrySubCategory = (List<String>) request.getAttribute("industrySubCategory"); 
List<String> optionsSubCategory = (List<String>) request.getAttribute("optionsSubCategory"); 
pageContext.setAttribute("advisorverification", advisorverification);
pageContext.setAttribute("advisor", advisor);	

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
.add-language{
cursor:pointer;
}
</style>

<title>Give Back & Get Paid - Become an Advisor | Join Advisor Circuit</title>
<body>
 <div id="wrapper">
 <%@include file="/notify.jsp" %>
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text"><a href="advisordashboard">Dashboard </a>> Profile</span>
	</div>
   		  
   			<div class="body-content col-xs-12 no-padding" >
   			     <c:if test="${action != null && advisor.getStatus().equals('EducationInfo')}">
   			      <div class="alert alert-success" role="alert">
   			       You are going great. Please fill out your Education background.   
   			     </div>
   			     </c:if>
   			     <c:if test="${action != null && advisor.getStatus().equals('ProfessionalBackground')}">
   			      <div class="alert alert-success" role="alert">
   			       You are going great. Please fill out your Professional background.   
   			     </div>
   			     </c:if>
   			      <c:if test="${action != null && advisor.getStatus().equals('Skills')}">
   			      <div class="alert alert-success" role="alert">
   			       You are going great. Please fill out your modes of communication and area of advice.   
   			     </div>
   			     </c:if>
   			     <c:if test="${action != null && advisor.getStatus().equals('Complete')}">
   			      <div class="alert alert-success" role="alert">
   			       Great! You have successfully completed the Registration process. Just sit back and We will contact you within 24hours.   
   			     </div>
   			     </c:if>
   			    
   			     <span class="body-head-text" style="font-family: LatoL;font-size: 24px;color: #4a4a4a;" >Advisor Registration</span>
   			     <div class="profile-form-div col-md-12 col-xs-12 no-padding" style="margin-bottom: 21px">
   			     <span style="float: left;font-family: Open SansL;font-size: 20px;margin-right: 3%;color: #9b9b9b;padding-top:21px;padding-left: 30px ">Profile Completion</span>
   			     <div class="progress col-sm-4 col-xs-12" style="margin-top: 27px;padding-left: 0%;padding-right: 0%">
   			        <c:choose>
   			           <c:when test="${advisor.getStatus().equals('GeneralInfo')}">
   			                   <div id="pb" class="progress-bar" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%;">
                                    10%
                                </div>
   			           </c:when>
   			           <c:when test="${advisor.getStatus().equals('EducationInfo')}">
   			                   <div id="pb" class="progress-bar" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%;">
                                    30%
                                </div>
   			           </c:when>
   			           <c:when test="${advisor.getStatus().equals('ProfessionalBackground')}">
   			                   <div id="pb" class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
                                    50%
                                </div>
   			           </c:when>
   			            <c:when test="${advisor.getStatus().equals('Skills')}">
   			                   <div id="pb" class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
                                    70%
                                </div>
   			           </c:when>
   			           <c:when test="${advisor.getStatus().equals('Complete')}">
   			                   <div id="pb" class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                    100%
                                </div>
   			           </c:when>
   			        
   			        </c:choose>
                  
                 </div>
   			     </div>
   			     
   				<div class="col-md-12 col-xs-12 col-sm-12 ud-left-section" >
<!-- 		   			<div class="div-for-notifications col-xs-12 no-padding" style="border-top: 4px solid #37b7b3;">
		   			<div class="profile-owner-info col-xs-12 no-padding">
		   				<div class="col-xs-4 dp-div-profile">
		   					 <img class="profile-dp" src="assets/img/Abhishek.JPG"><br>
		   					 <span class="btext change-do change-profile">Change Profile Picture</span>
		   				
				                                      <input type="file" class="custom-file-input" style="visibility:hidden;" name="dp"  aria-required="true">
											 		
		   				</div>
		   				<div class="col-xs-8 info-div-profile">
		   					<span class="name-profile">Angela Dixon</span><br>
		   					<span class="email-profile">angeladixon@gmail.com</span><br>
		   					<span class="pno-profile">+91 9860313000</span>
		   				</div>
		   			</div>
			   			
		   			</div> -->
		   			<div class="profile-form-div col-sm-3 col-xs-12 no-padding pro " style="margin-right: 0px;">
                               <ul class="nav navbar-nav">
                                   <li class="info" id="gene"><a id="gen" href="#" class="profil-form-head prof-font">General Information</a></li>
                                   <li class="info" id="educ"><a id="edu" href="#" class="profil-form-head prof-font">Background </a></li>
                                   <!-- <li><a id="professional" href="#" class="profil-form-head prof-font">Professional Background</a></li> -->
                                   <li class="info" id="skil"><a id="skill" href="#" class="profil-form-head prof-font">Area of Advice</a></li>
                                </ul>
   					</div>
		   			<div class="profile-form-div col-sm-9 col-xs-12 no-padding" style="border-left: 1px solid #979797;">
		   			    <div id="general" class="space" style="display: none">
		   				<div class="profil-form-head-div">
		   					<span class="profil-form-head">General Info</span>
		   				</div>
		   				<div class="alert alert-success" role="alert" id="validation" style="display: none">
		   				
		   				</div>
		   				
		   				<form class="profile-form" id="geninfo" action="generalinfo" method="post" enctype="multipart/form-data">
<!-- 		   					<span class="profile-form-head">General Details</span>

 -->		   						
 
                            <div class="col-xs-12 col-sm-4">
		   					 <img id="advprev" class="profile-dp" src="${advisor.getImage()}"><br>
		   					 <span class="btext change-do change-profile">Change Profile Picture</span>
		   				     <input id="advimg" type="file" class="custom-file-input" style="visibility:hidden;" name="file"  aria-required="true">
						    </div>
						    <c:choose>
						            <c:when test="${advisor.getStatus().equals('GeneralInfo')}">
						                                                    <div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Full name</label>
												       <div class="col-xs-9">
					                                       <input class="form-control" id="fname" name="name">
												 		</div>
										</div>
			   						</div>
			   						
		   						</div>
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
											      <label class="col-xs-3 no-padding form-label">Age</label>
												       <div class="col-xs-9 ">
					                                       <input class="form-control" id ="age"  name="age">
												 		</div>
											 </div>
			   						</div>
		   						</div>
		   						 
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Gender</label>
												       <div class="col-xs-9 ">
						                                     <div class="col-xs-6 no-padding">
						                                        <input type="radio" id="radio01" value="male" name="gender" />
  																<label for="radio01"><span></span>Male</label>
													 		</div>
													 		<div class="col-xs-6 no-padding">
						                                       <input type="radio" id="radio02" value="female" name="gender" />
															 <label for="radio02"><span></span>Female</label>
													 		</div>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Mobile</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="phone" name="phone">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">City</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="city" name="city">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Industry</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="industry" name="industry" onkeyup="GetIndustrySuggesions(this)">
					                                       <span class="label label-default">Example: Advertising</span>
					                                       <div id="industrysuggestions" class="suggestions">
					                                       </div>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Experience</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="experience"  name="experience">
					                                       <span class="label label-default">Example: 5 years</span>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Linkedin profile</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="profile" name="linkedin">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Introduction</label>
												      <div class="col-xs-9">
					                                       <textarea class="form-control" id="intro" name="intro"></textarea>
					                                       <span class="label label-default visible-md visible-lg">Example: Graduate from SRCC. Been in the consulting <br> field  for 3 years and love it. Enjoy dancing, reading<br> in my spare time.</span>
												 			<span class="label label-default visible-sm ">Example: Graduate from SRCC.<br> Been in the consulting <br>field  for 3 years and love it.<br> Enjoy dancing, reading in <br>my spare time.</span>
												 			<span class="label label-default visible-xs">Example:Graduate from SRCC.<br> Been in the consulting field <br> for 3 years and love it.<br> Enjoy dancing, reading in my<br> spare time.</span>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Languages Known</span>
		   				        </div>
		   				        <div class="languages">
		   							<div class="col-xs-12 no-padding">
			   							<div class="col-xs-12 col-sm-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label">Language</label>
													      <div class="col-xs-9">
						                                       <input class="form-control" id="lang" name="language[]">
						                                       <span class="add-language btext">Add more</span>
													 		</div>
													 		
											</div>
				   						</div>
		   							</div>
		   						</div>
		   						<!-- <div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Industry</span>
		   				        </div> -->
		   						
		   						
		   		
						            
						            </c:when>
						            <c:otherwise>
						        <div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Full name</label>
												       <div class="col-xs-9">
					                                       <input class="form-control" id="fname" name="name" value="${advisor.getName()}">
												 		</div>
										</div>
			   						</div>
			   						
		   						</div>
		   						<input type="hidden" value="true" name="edit">
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
											      <label class="col-xs-3 no-padding form-label">Age</label>
												       <div class="col-xs-9 ">
					                                       <input class="form-control" id="age" name="age" value="${advisor.getAge()}">
												 		</div>
											 </div>
			   						</div>
		   						</div>
		   						 
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Gender</label>
												       <div class="col-xs-9 ">
												            <c:if test="${advisor.getGender().equals('male') }">
												                   <div class="col-xs-6 no-padding">
						                                               <input type="radio" id="radio01" value="male" name="gender" checked="checked" />
  																       <label for="radio01"><span></span>Male</label>
													 		       </div>
													 		       <div class="col-xs-6 no-padding">
						                                                <input type="radio" id="radio02" value="female" name="gender" />
															            <label for="radio02"><span></span>Female</label>
													 		       </div>
												            
												            </c:if>
												             <c:if test="${advisor.getGender().equals('female') }">
												                   <div class="col-xs-6 no-padding">
						                                               <input type="radio" id="radio01" value="male" name="gender"  />
  																       <label for="radio01"><span></span>Male</label>
													 		       </div>
													 		       <div class="col-xs-6 no-padding">
						                                                <input type="radio" id="radio02" value="female" name="gender" checked="checked"/>
															            <label for="radio02"><span></span>Female</label>
													 		       </div>
												            
												            </c:if>
						                                     
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Mobile</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="phone" name="phone" value="${advisor.getPhoneNo()}">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 col-sm-8 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">City</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="city" name="city" value="${advisor.getCity()}">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Industry</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="industry" name="industry" value="${advisor.getIndustry()}" onkeyup="GetIndustrySuggesions(this)">
					                                       <span class="label label-default">Example: Advertising</span>
					                                         <div id="industrysuggestions" class="suggestions">
					                                       </div>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Experience</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="experience" name="experience" value="${advisor.getExperience()}">
					                                       <span class="label label-default">Example: 5 years</span>
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Linkedin profile</label>
												      <div class="col-xs-9">
					                                       <input class="form-control" id="profile" name="linkedin" value="${advisor.getLinkedIn()}">
												 		</div>
										</div>
			   						</div>
		   						</div>
		   						<div class="col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
			   							<div class="form-group each-form-div col-xs-12 no-padding">
												     <label class="col-xs-3 no-padding form-label">Introduction</label>
												      <div class="col-xs-9">
					                                       <textarea class="form-control" id="intro" name="intro" >${advisor.getIntro()}</textarea>
					                                       <span class="label label-default visible-md visible-lg">Example: Graduate from SRCC. Been in the consulting <br> field  for 3 years and love it. Enjoy dancing, reading<br> in my spare time.</span>
												 			<span class="label label-default visible-sm ">Example: Graduate from SRCC.<br> Been in the consulting <br>field  for 3 years and love it.<br> Enjoy dancing, reading in <br>my spare time.</span>
												 			<span class="label label-default visible-xs">Example:Graduate from SRCC.<br> Been in the consulting field <br> for 3 years and love it.<br> Enjoy dancing, reading in my<br> spare time.</span>
												 		
												 		</div>
										</div>
										
			   						</div>
		   						</div>
		   						<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Languages Known</span>
		   				        </div>
		   				        <div class="languages">
		   							<div class="col-xs-12 no-padding">
			   							<div class="col-xs-12 col-sm-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label">Language</label>
													      <div class="col-xs-9">
													           <c:forEach items="${advisor.getLanguage()}" var="lang">
						                                         <input class="form-control" id="lang" name="language[]" value="${lang.getLanguage()}">
													           </c:forEach>
						                                       <span class="add-language btext">Add more</span>
													 		</div>
													 		
											</div>
				   						</div>
		   							</div>
		   						</div>
		   						<!-- <div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Industry</span>
		   				        </div> -->
		   						
		   						

						            
						            
						            </c:otherwise>
						    
						    
						    </c:choose>
						    
						    
 
		   								<div class="col-xs-12 no-padding">
			   						<div class="col-xs-12 col-sm-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                  
						                                      	<button type="submit" class="btn red-button "  style="width: 90px;margin-right: 10px;">Save</button>
<!-- 						                                      	<button type="button" class="btn dark-button" style="width: 90px;">Cancel</button>
 -->														
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						</form>
		   						</div>
		   						<div id="education" class="space" style="display: none" >
		   						<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Education</span>
		   				        </div>
		   				        <c:set var="counter" value="0"></c:set>
		   				        <div class="alert alert-success" role="alert" id="validationeduc" style="display: none">
		   				
		   				             </div>
		   				        <form class="profile-form" id="educinfo" action="educationinfo" method="post">
		   							<div class="education-div-container col-xs-12 no-padding">
		   							<c:choose>
		   							<c:when test="${advisor.getEducation().size() > 0 }">
		   								<input type="hidden" name="edit" value="true">
		   							      <c:forEach items="${advisor.getEducation()}" var="adv">
		   							      		<div class="each-education-div col-xs-12 no-padding">
		   							          
		   							           <div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														    <div class="col-xs-12">
														    <c:if test="${adv.getType().equals('UG') }">
														      <div class="col-xs-4">
							                                       <input type="radio" id="level1" value="UG" name="type${counter}" checked="checked" />
  																	<label for="level1"><span></span>UG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level2" value="PG" name="type${counter}" />
  																<label for="level2"><span></span>PG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level3" value="others" name="type${counter}" />
  																<label for="level3"><span></span>Other</label>
							                                    </div>
							                                  </c:if>  
							                                  <c:if test="${adv.getType().equals('PG') }">
														      <div class="col-xs-4">
							                                       <input type="radio" id="level1" value="UG" name="type${counter}"  />
  																	<label for="level1"><span></span>UG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level2" value="PG" name="type${counter}" checked="checked"/>
  																<label for="level2"><span></span>PG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level3" value="others" name="type${counter}" />
  																<label for="level3"><span></span>Other</label>
							                                    </div>
							                                  </c:if> 
							                                  <c:if test="${adv.getType().equals('others') }">
														      <div class="col-xs-4">
							                                       <input type="radio" id="level1" value="UG" name="type${counter}"  />
  																	<label for="level1"><span></span>UG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level2" value="PG" name="type${counter}" />
  																<label for="level2"><span></span>PG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level3" value="others" name="type${counter}" checked="checked"/>
  																<label for="level3"><span></span>Other</label>
							                                    </div>
							                                  </c:if> 
							                                    </div>
							                                    
							                                    
												</div>
												<div class="col-xs-12 no-padding">
				   							    <div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Course</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="course" name="course[]" value="${adv.getCourse()}" onkeyup="GetCourseSuggesions(this)">
							                                       <div id="coursesuggestions" class="coursesuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						    </div>
		   								       </div>
		   								       
		   								       	<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Institution</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="institution" name="institution[]" value="${adv.getInstitution()}" onkeyup="GetInstitutionSuggesions(this)">
							                                       <div id="inssuggestions" class="inssuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12  no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="duration" name="duration[]" value="${adv.getDuration()}">
							                                       <span class="label label-default">Example: 2002 - 2005</span>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
					   						</div>
		   							      
		   							      
		   							      </div>
		   							      <c:set value="${counter+1}" var="counter"></c:set>
		   							      </c:forEach>
		   							
		   							</c:when>
		   							<c:otherwise>
		   							<div class="each-education-div col-xs-12 no-padding">
		   							
		   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														    <div class="col-xs-12">
														      <div class="col-xs-4">
							                                       <input type="radio" id="level1" value="UG" name="type${counter}" />
  																	<label for="level1"><span></span>UG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level2" value="PG" name="type${counter}" />
  																<label for="level2"><span></span>PG</label>
							                                    </div>
							                                    <div class="col-xs-4">
							                                       <input type="radio" id="level3" value="others" name="type${counter}" />
  																<label for="level3"><span></span>Other</label>
							                                    </div>
							                                    </div>
												</div>
					   						</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Course</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="course" name="course[]" onkeyup="GetCourseSuggesions(this)">
							                                        <div id="coursesuggestions" class="coursesuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Institution</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="institution" name="institution[]" onkeyup="GetInstitutionSuggesions(this)">
							                                       <div id="inssuggestions" class="inssuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="duration" name="duration[]">
							                                       <span class="label label-default">Example: 2002 - 2005</span>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
		   								</div>
		   										   							      <c:set value="${counter+1}" var="counter"></c:set>
		   								
		   								</c:otherwise>
		   								</c:choose>
		   								</div>
		   							<span class="add-education btext">Add more</span>
	   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                  
						                                      	<button type="submit" class="btn red-button "  style="width: 90px;margin-right: 10px;">Save</button>
														
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						</form>

		   						</div>
		   						<div id="profession" style="display: none" >
		   						<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Profession</span>
		   				        </div>
		   				        <div class="alert alert-success" role="alert" id="validationprof" style="display: none">
		   				
		   				             </div>
		   				        <c:set value="0" var="procounter"></c:set>
		   				        <form class="profile-form" id="profinfo" action="professionalbackground" method="post">
		   						<div class="professional-div-container col-xs-12 no-padding">
		   						    <c:choose>
		   						        <c:when test="${advisor.getProfession().size() > 0}">
		   						        <input type="hidden" name="edit" value="true">
		   						           <c:forEach var="prof" items="${advisor.getProfession()}">
		   						        <div class="each-profession-div col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														    <div class="col-xs-12">
														      <div class="col-xs-4">
														        <c:choose>
														          <c:when test="${prof.getIsCurrent()}">
							                                       <input type="checkbox" id="level1" value="true" style="visibility: visible" name="level${procounter}" checked="checked" />
														          
														          </c:when>
														          <c:otherwise>
							                                       <input type="checkbox" id="level1" value="true" style="visibility: visible;" name="level${procounter}" />
														          
														          </c:otherwise>
														        </c:choose>
  																	<label for="level1"><span></span>Present</label>
							                                    </div>
							                                  </div>
												</div>
					   						</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Company</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="company" name="company[]" value="${prof.getCompany() }" onkeyup="GetCompanySuggesions(this)">
							                                       <div id="compsuggestions" class="compsuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Designation</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="designation" name="designation[]" value="${prof.getDesignation() }">
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="profduration" name="duration[]" value="${prof.getDuration()}">
							                                       <span class="label label-default">Example: 2002 - 2005</span>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
		   							</div>
		   						        <c:set value="${procounter+1 }" var="procounter"></c:set>
		   						           
		   						           
		   						           </c:forEach>
		   						        
		   						        </c:when>
		   						        <c:otherwise>
		   						       <div class="each-profession-div col-xs-12 no-padding">
		   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														    <div class="col-xs-12">
														      <div class="col-xs-4">
							                                       <input type="checkbox" style="visibility: visible;" value="true" id="leve1" name="level${procounter}" />
  																	<label for="leve1"><span></span>Present</label>
							                                    </div>
							                                  </div>
												</div>
					   						</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Organisation</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="company" name="company[]" onkeyup="GetCompanySuggesions(this)">
							                                       <div id="compsuggestions" class="compsuggestions">
					                                                </div>
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Designation</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="designation" name="designation[]">
							                                    </div>
												</div>
					   						</div>
		   								</div>
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>
														      <div class="col-xs-9">
							                                       <input class="form-control" id="profduration" name="duration[]">
							                                       <span class="label label-default">Example: 2002 - 2005</span>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
		   							</div>
		   							<c:set value="${procounter+1 }" var="procounter"></c:set>
		   						        </c:otherwise> 
		   						        		   						        
		   						        
		   						    </c:choose>
		   						

		   							<span class="add-profession btext">Add more</span>
		   						</div>
		   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                  
						                                      	<button type="submit" class="btn red-button "  style="width: 90px;margin-right: 10px;">Save</button>
														
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						</form>

		   						</div>
		   						<div id="skills" class="space" style="display: none">
		   						<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Mode of Communication :This sections helps user to understand through which mode you want to offer them advice.</span>
		   				        </div>
		   				        <div class="alert alert-success" role="alert" id="validationskill" style="display: none">
		   				
		   				             </div>
		   				        <form class="profile-form" id="skillinfo" action="skills" method="post">
		   				        <c:choose>
		   				           <c:when test="${profile.getInterests().size() > 0 }">
		   				                     <div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Select Mode </label>
											       <div class="col-xs-9 form-group">
											             <c:choose>
											                 <c:when test="${profile.getPhone()}">
											                       <div class="col-xs-6">
				                                         	           <div class="">
																           <input type="checkbox" style="visibility: visible;" value="phone" id="phone" name="modephone" aria-required="true" checked="checked"/>
																           <label for="phone"><span></span><img src="assets/img/phone.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Phone</label>
																       </div>
														            </div>
											                 </c:when>
											                 <c:otherwise>
											                       <div class="col-xs-6">
				                                         	           <div class="">
																           <input type="checkbox" style="visibility: visible;" value="phone" id="phone" name="modephone" aria-required="true"/>
																           <label for="phone"><span></span><img src="assets/img/phone.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Phone</label>
																       </div>
														            </div>
											                 </c:otherwise>
											             </c:choose>
											             <c:choose>
											                     <c:when test="${profile.getVideo()}">
											                             <div class="col-xs-6">
				                                         	               <div class="">
																               <input type="checkbox" style="visibility: visible;" value="video" id="video" name="modevideo" checked="checked"/>
																               <label for="video"><span></span><img src="assets/img/video.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Video</label>
															                </div>
														               </div>
											                     </c:when>
											                     <c:otherwise>
											                          <div class="col-xs-6">
				                                         	               <div class="">
																               <input type="checkbox" style="visibility: visible;" value="video" id="video" name="modevideo" />
																               <label for="video"><span></span><img src="assets/img/video.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Video</label>
															                </div>
														               </div>
											                     
											                     </c:otherwise>
											             
											             </c:choose>
				                                         
														
											 		</div>
											 	</div>
								<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Area of Advice : This sections helps user to understand where all can you offer them advice.</span>
		   				        </div>
		   				        <c:forEach items="${profile.getInterests()}" var="interest">
		   				              <div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label">Category</label>
														      <div class="col-xs-9">
														          <c:if test="${interest.getCategory().equals('studies')}">
							                                         <p class="form-control"> Higher Studies</p>
							                                      </c:if>
							                                      <c:if test="${interest.getCategory().equals('industry')}">
							                                         <p class="form-control"> Career & Jobs</p>
							                                      </c:if>
							                                      <c:if test="${interest.getCategory().equals('options')}">
							                                         <p class="form-control"> Courses</p>
							                                      </c:if>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
		   								 <div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label">Sub Category</label>
														      <div class="col-xs-9">
							                                      <p class="form-control"> ${interest.getSub().getSubCategory()}</p>
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div>
		   								
		   								<div class="col-xs-12 no-padding">
				   							<div class="col-xs-12 col-sm-6 no-padding">
					   							<div class="form-group each-form-div col-xs-12 no-padding">
														     <label class="col-xs-3 no-padding form-label">Skills</label>
														      <div class="col-xs-9">
							                                       <ul style="border: 1px solid lightgray;">
							                                         <c:forEach items="${interest.getSub().getSkills()}" var="skill">
							                                          <li>${skill }</li>
							                                         </c:forEach>
							                                       </ul>
							                                       
							                                    </div>
												</div>
					   						</div>
					   						
		   								</div> 
		   								<hr>    
		   				        </c:forEach>
		   				        <div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Want to fill the Area of Advice again? </span>
		   				        </div>
		   				        <div class="eg" style="margin-bottom: 70px">
		   					       <span class=" col-xs-12">Example: If you want give advice regarding how to prepare for MBA in india, then choose 'Higher Studies' as category,<br> 'MBA-India' as sub category and then choose the relevant skills</span>
		   				        </div>
		   				        <input type="hidden" name="edit" value="true">	 			   						
		   						<div class="each-interest-div col-xs-12 no-padding">
		   							<div class="col-xs-12 no-padding">
			   							<div class="col-xs-12 col-sm-10 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label" style="max-width:115.8px">Area of Advice</label>
													      <div class="col-xs-12 col-sm-9">
													          <c:set value="0" var="catcounter"></c:set>
						                                      <div class="col-xs-12 col-sm-6 no-padding" style="margin-bottom: 5%">
	   																 <select class="collapsed-filter-button category-menu" id="category-menu${catcounter}" onchange="GetSubCategory(this);" name="category[]">
	   																 <option value="">Choose Category</option>
																	  <option value="higherstudies">Higher studies</option>
																	  <option value="industry">Career & Jobs</option>
																	  <option value="options">Courses</option>
																	 
																	</select>
									   							</div>
									   							<div class="col-xs-12 col-sm-6 no-padding" style="padding-right:0px;margin-bottom: 5%">
	   																 <select class="collapsed-filter-button subcategory-menu" id="subcategory-menu${catcounter}" onchange="GetSkills(this);" name="subcategory[]">
																	  
																	  
																	 
																	</select>
									   							</div>
<!-- 									   							<div class="col-xs-12 tell-info no-padding" style="margin-top:10px;display:none;">Choose skills for category: <span class="category-span-info"></span> and  sub-category <span class="subcategory-span-info"></span></div>
 -->									   							<div class="skills-pool col-xs-12" id="skill-pool${catcounter}" >
									   								
									   			
									   							</div>
									   							<div class="skills-selected col-xs-12" style="visibility:hidden;position:absolute;">
									   							</div>
													 		</div>
											</div>
										</div>	
			   						
		   							</div>
		   						</div>
		   						<div class="col-xs-12 no-padding more-interest-div">
			   						
		   						</div>
		   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                      <span class="add-more-interest btext">+ Add More Area of Advice </span>
													 		</div>
											</div>
			   						</div>
		   						</div>
		   				           </c:when>
		   				           <c:otherwise>
		   				                      <!-- 		   						   <span class="profile-form-head col-xs-12 no-padding" style="margin-top: 50px;"></span>
 -->		   						   <div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Select Mode </label>
											       <div class="col-xs-9 form-group">
				                                         <div class="col-xs-6">
				                                         	 <div class="">
																<input type="checkbox" style="visibility: visible;" value="phone" id="phone" name="modephone" aria-required="true" checked="checked"/>
																<label for="phone"><span></span><img src="assets/img/phone.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Phone</label>
																
															</div>
														</div>
														<div class="col-xs-6">
				                                         	 <div class="">
																<input type="checkbox" style="visibility: visible;" value="video" id="video" name="modevideo" checked="checked"/>
																<label for="video"><span></span><img src="assets/img/video.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Video</label>
																
																
															</div>
														</div>
											 		</div>
											 	</div>
											 	
								<div class="profil-form-head-div" style="margin-bottom: 35px">
		   					       <span class="profil-form-head">Area of Advice:  : This sections helps user to understand where all can you offer them advice.</span>
		   				        </div>
		   				        <div class="eg" style="margin-bottom: 70px">
		   					          <span class="col-xs-12" style="display: block">Example: If you want give advice regarding how to prepare for MBA in india, then choose 'Higher Studies' as category,<br> 'MBA-India' as sub category and then choose the relevant skills</span>
		   					    </div>	 			   						
		   						<div class="each-interest-div col-xs-12 no-padding">
		   							<div class="col-xs-12 no-padding">
			   							<div class="col-xs-12 col-sm-10 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label" style="max-width:115.8px">Area of Advice:</label>
													      <div class="col-xs-12 col-sm-9">
													          <c:set value="0" var="catcounter"></c:set>
						                                      <div class="col-xs-12 col-sm-6 no-padding" style="margin-bottom: 5%">
	   																 <select class="collapsed-filter-button category-menu" id="category-menu${catcounter}" onchange="GetSubCategory(this);" name="category[]">
	   																 <option value="">Choose Category</option>
																	  <option value="higherstudies">Higher studies</option>
																	  <option value="industry">Career & Jobs</option>
																	  <option value="options">Courses</option>
																	 
																	</select>
									   							</div>
									   							<div class="col-xs-12 col-sm-6 no-padding" style="padding-right:0px;margin-bottom: 5%">
	   																 <select class="collapsed-filter-button subcategory-menu" id="subcategory-menu${catcounter}" onchange="GetSkills(this);" name="subcategory[]">
																	  
																	  
																	 
																	</select>
									   							</div>
<!-- 									   							<div class="col-xs-12 tell-info no-padding" style="margin-top:10px;display:none;">Choose skills for category: <span class="category-span-info"></span> and  sub-category <span class="subcategory-span-info"></span></div>
 -->									   							<div class="skills-pool col-xs-12" id="skill-pool${catcounter}" >
									   								
									   			
									   							</div>
									   							<div class="skills-selected col-xs-12" style="visibility:hidden;position:absolute;">
									   							</div>
													 		</div>
											</div>
										</div>	
			   						
		   							</div>
		   						</div>
		   						<div class="col-xs-12 no-padding more-interest-div">
			   						
		   						</div>
		   						<div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                      <span class="add-more-interest btext">+ Add More Area of Advice</span>
													 		</div>
											</div>
			   						</div>
		   						</div>
		   				           
		   				           </c:otherwise>
		   				        </c:choose>
		   				        <div class="col-xs-12 no-padding">
			   						<div class="col-xs-6 no-padding">
				   							<div class="form-group each-form-div col-xs-12 no-padding">
													     <label class="col-xs-3 no-padding form-label"></label>
													      <div class="col-xs-9">
						                                  
						                                      	<button type="submit" class="btn red-button "  style="width: 90px;margin-right: 10px;">Save</button>
														
													 		</div>
											</div>
			   						</div>
		   						</div>
		   						</form>
		   						</div>

		   						
		   						

		   				
		   						
		   			</div>
			
						
			   	</div>
	   			
<%-- 	   			<div class="col-xs-12 col-sm-3">
	   			<div class="col-xs-12 text-center no-padding-xs">
							<button type="button" class="btn red-button " style="width: 100%;margin-bottom: 10px;" data-toggle="modal" data-target="#booksession">Book a session</button>
							<br>
							<button type="button" class="btn dark-button" style="width: 100%;">Ask a question</button>
						</div>
						
						<div class="col-xs-12" style="margin-top:10px;">
		<div class="right-head">SIMILAR PROFILES</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
			<div class="advisor_details col-xs-6 col-sm-12 no-padding" >
			                                    <img class="adv-img" src="assets/img/Abhishek.JPG">
			                                    <p class="adv-name">Doris Weaver</p><br>
			                                    <p class="adv-field">Marketing</p><br>
			                                    <p class="written-on" >23 Answers</p>
			                                 
			</div>
		</div>
		   			<div  class="related col-xs-12">
	                    <div class="rel-section">
	                        <h2>MOST VIEWED QUESTIONS</h2>
	                          <c:forEach items="${mostViewedQuestions}" var="viewed">
	                                 <p class="rel_ques"><a class="rel_ques" href="answers?q=${viewed.getQuestionId()}">${viewed.getQuestion()}</a></p>
	                          </c:forEach>
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section">
                        <h2>POPULAR CATEGORIES</h2>
                        <c:forEach items="${popCats}" var="pop">
                            <a class="rel-category">${pop}</a>
	                    </c:forEach>
                    </div>
	   			</div>
   			</div> --%>
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
</div>


<script>
var lal=2;
var rad=1;
var inter=1;
$(document).ready(function () {
	if("${advisor.getStatus()}" == "EducationInfo"){
		
		$("#educ").addClass("active");
		$("#edu").trigger('click');
	}else if ("${advisor.getStatus()}" == "ProfessionalBackground") {
		$("#educ").addClass("active");
		$("#edu").trigger('click');
	}else if ("${advisor.getStatus()}" == "Skills") {
		$("#skil").addClass("active");
		$("#skill").trigger('click');
	}else{
		$("#gene").addClass("active");
		$("#gen").trigger('click');
	}
	
	/* document.getElementById("general").style.display = 'block'; */
	starinputconversion();
	if("${advisorverification.equals('true') }"){
		document.getElementById("advisorverificationsuccess").style.display = "block";
	}else{
		document.getElementById("advisorverificationsuccess").style.display = "none";
	}
});
function GetIndustrySuggesions(elem){
	var id = elem.id;
	var value = elem.value;
	if($('#'+id).val().length > 0){
	       $.ajax({
	            url : 'GetRegistrationSuggestionsController', // Your Servlet mapping or JSP(not suggested)
	            data : {"industry" : $('#'+id).val()},
	            type : 'POST',
	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	            success : function(response) {
	            	if(response != "nosuggestion"){
	   	   	            document.getElementById("industrysuggestions").innerHTML="";
	   	   	            $('.suggestions').append('<div value='+value+' class="isuggestion">'+value+'</div>'); 
						$('.suggestions').append(response);
	            	    $('.suggestions').show();
	   	            	/* var obj = JSON.parse(response); */
	   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
	   	            	/* $.each(response,function(key,value){
		   	            	var html='	<div class="isuggestion">'+value.word+'</div>';
		   	            	$('.suggestions').append(html);
		   	            	$('.isuggestion').show();
	   	            	});  */
	   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
	   	            	}else{
		   	            	document.getElementById("industrysuggestions").style.display = "none";
	   	            	}
	            	
	            },
	            error : function(request, textStatus, errorThrown) {
	            }
	        }); 
	}else{
		document.getElementById("industrysuggestions").style.display = "none";
	}

}
function GetCourseSuggesions(elem){
	var value = elem.value;
	var length = elem.value.length;
	var id = elem.id;
	if(length > 0){
	       $.ajax({
	            url : 'GetRegistrationSuggestionsController', // Your Servlet mapping or JSP(not suggested)
	            data : {"course" : value},
	            type : 'POST',
	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	            success : function(response) {
	            	if(response != "nosuggestion"){
	   	   	            document.getElementById("coursesuggestions").innerHTML="";
	   	   	           $(elem).next(".coursesuggestions").append('<div value='+value+' class="csuggestion">'+value+'</div>'); 
	   	   	           $(elem).next(".coursesuggestions").append(response);
	   	   	           $(elem).next(".coursesuggestions").show();
	   	            	/* var obj = JSON.parse(response); */
	   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
	   	            	/* $.each(response,function(key,value){
		   	            	var html='	<div class="isuggestion">'+value.word+'</div>';
		   	            	$('.suggestions').append(html);
		   	            	$('.isuggestion').show();
	   	            	});  */
	   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
	   	            	}else{
	   	            		$(elem).next(".coursesuggestions").hide();
	   	            	}
	            	
	            },
	            error : function(request, textStatus, errorThrown) {
	            }
	        }); 
	}else{
		$(elem).next(".coursesuggestions").hide();
	}
}

function GetInstitutionSuggesions(elem){
	var value = elem.value;
	var length = elem.value.length;
	var id = elem.id;
	if(length > 0){
	       $.ajax({
	            url : 'GetRegistrationSuggestionsController', // Your Servlet mapping or JSP(not suggested)
	            data : {"institution" : value},
	            type : 'POST',
	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	            success : function(response) {
	            	if(response != "nosuggestion"){
	   	   	            document.getElementById("inssuggestions").innerHTML="";
	   	   	           $(elem).next(".inssuggestions").append('<div value='+value+' class="insuggestions">'+value+'</div>');
	   	   	           $(elem).next(".inssuggestions").append(response);
	   	   	           $(elem).next(".inssuggestions").show();
	   	            	/* var obj = JSON.parse(response); */
	   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
	   	            	/* $.each(response,function(key,value){
		   	            	var html='	<div class="isuggestion">'+value.word+'</div>';
		   	            	$('.suggestions').append(html);
		   	            	$('.isuggestion').show();
	   	            	});  */
	   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
	   	            	}else{
	   	            		$(elem).next(".inssuggestions").hide();
	   	            	}
	            	
	            },
	            error : function(request, textStatus, errorThrown) {
	            }
	        }); 
	}else{
		$(elem).next(".inssuggestions").hide();
	}
}

function GetCompanySuggesions(elem){
	var value = elem.value;
	var length = elem.value.length;
	var id = elem.id;
	if(length > 0){
	       $.ajax({
	            url : 'GetRegistrationSuggestionsController', // Your Servlet mapping or JSP(not suggested)
	            data : {"company" : value},
	            type : 'POST',
	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	            success : function(response) {
	            	if(response != "nosuggestion"){
	   	   	            document.getElementById("compsuggestions").innerHTML="";
	   	   	     	   $(elem).next(".compsuggestions").append('<div value='+value+' class="comsuggestions">'+value+'</div>');
	   	   	           $(elem).next(".compsuggestions").append(response);
	   	   	           $(elem).next(".compsuggestions").show();
	   	            	/* var obj = JSON.parse(response); */
	   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
	   	            	/* $.each(response,function(key,value){
		   	            	var html='	<div class="isuggestion">'+value.word+'</div>';
		   	            	$('.suggestions').append(html);
		   	            	$('.isuggestion').show();
	   	            	});  */
	   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
	   	            	}else{
	   	            		$(elem).next(".compsuggestions").hide();
	   	            	}
	            	
	            },
	            error : function(request, textStatus, errorThrown) {
	            }
	        }); 
	}else{
		$(elem).next(".compsuggestions").hide();
	}
}
$('body').on('click', '.isuggestion', function(e){
  		var suge= $(this).text();
  		$('#industry').val(suge);
  		$('.suggestions').hide();
   });
$('body').on('click', '.csuggestion', function(e){
		var suge= $(this).text();
		$(this).parent().parent().find("#course").val(suge);
		$('.coursesuggestions').hide();
});
$('body').on('click', '.insuggestions', function(e){
	var suge= $(this).text();
	$(this).parent().parent().find("#institution").val(suge);
	$('.inssuggestions').hide();
});
$('body').on('click', '.comsuggestions', function(e){
	var suge= $(this).text();
	$(this).parent().parent().find("#company").val(suge);
	$('.compsuggestions').hide();
});
$('#pb').css({
    'background-image': 'none',
    'background-color': '#7ed321'
});

 $('#edu').on('click', function() {
	 document.getElementById("general").style.display = 'none';
		document.getElementById("education").style.display = 'block';
		document.getElementById("skills").style.display = 'none';
		document.getElementById("profession").style.display = 'block';
		
	});
 $( ".info").hover(function() {
	 $(".info").removeClass("marker");
	  $(this).addClass("marker");
	  
	});
 $( ".info").mouseout(function() {
	 $(".info").removeClass("marker");
 });
 $( ".info").click(function() {
	 $(".info" ).removeClass("marker");
	 $(".info" ).removeClass("active");
	  $(this).addClass("active");
	});
 
 $('#professional').on('click', function() {
	 document.getElementById("general").style.display = 'none';
		document.getElementById("education").style.display = 'none';
		document.getElementById("skills").style.display = 'none';
		document.getElementById("profession").style.display = 'none';
	});
 
 $('#gen').on('click', function() {
	    document.getElementById("general").style.display = 'block';
		document.getElementById("education").style.display = 'none';
		document.getElementById("skills").style.display = 'none';
		document.getElementById("profession").style.display = 'none';
	});
 $('#skill').on('click', function() {
	    document.getElementById("general").style.display = 'none';
		document.getElementById("education").style.display = 'none';
		document.getElementById("skills").style.display = 'block';
		document.getElementById("profession").style.display = 'none';
		
	});

/*  $('.category-menu').on('change', function() {
		$(this).closest('.each-interest-div').find('.subcategory-menu').html('<option>Sub Category</option>');
		$(this).closest('.each-interest-div').find('.tell-info').find('.subcategory-span-info').text('');
		$(this).closest('.each-interest-div').find('.skills-pool').html('');
		 var values= ( this.value );
		 var suboptions='<option value="123">123</option>';
		 $(this).closest('.each-interest-div').find('.subcategory-menu').append(suboptions);
		 $(this).closest('.each-interest-div').find('.tell-info').find('.category-span-info').text(values);
		
	});  */
function GetSkills(elem){
	
	var value= ( elem.value );
	var id = elem.id;
	id = id.substring(id.length -1, id.length);
	if(value == "MBA India"){
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Management Programs & Schools in India" id="mbaindia1" name="mbaindia'+id+'[]"/><label for="mbaindia1"></label><span>Management Programs & Schools in India</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="My MBA Experience" id="mbaindia2" name="mbaindia'+id+'[]"/><label for="mbaindia2"></label><span>My MBA Experience</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Preparation and profile required to get in" id="mbaindia3" name="mbaindia'+id+'[]"/><label for="mbaindia3"></label><span>Preparation and profile required to get in</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Is MBA right for you ?" id="mbaindia4" name="mbaindia'+id+'[]"/><label for="mbaindia4"></label><span>Is MBA right for you ?</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Excelling in your Management Program" id="mbaindia5" name="mbaindia'+id+'[]"/><label for="mbaindia5"></label><span>Excelling in your Management Program</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Scholarships, Financing Options" id="mbaindia6" name="mbaindia'+id+'[]"/><label for="mbaindia6"></label><span>Scholarships, Financing Options</span></div>'
		          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Options, Job Prospects after Management in India" id="mbaindia7" name="mbaindia'+id+'[]"/><label for="mbaindia7"></label><span>Options, Job Prospects after Management in India</span></div>';
				  $("#skill-pool"+id).html(skill);
/* 		          $(this).closest('.each-interest-div').find('.skills-pool').html(skill);          
 */	}else if (value == "MBA Abroad") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Management Programs & Schools Abroad" id="mbaabroad1" name="mbaabroad'+id+'[]"/><label for="mbaabroad1"></label><span>Management Programs & Schools Abroad</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="What B Schools abroad want & how to build it" id="mbaabroad2" name="mbaabroad'+id+'[]"/><label for="mbaabroad2"></label><span>What B Schools abroad want & how to build it</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Is MBA right for you ?" id="mbaabroad3" name="mbaabroad'+id+'[]"/><label for="mbaabroad3"></label><span>Is MBA right for you ?</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Excelling in your Management Program" id="mbaabroad4" name="mbaabroad'+id+'[]"/><label for="mbaabroad4"></label><span>Excelling in your Management Program</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Building Great Applications & SOPs" id="mbaabroad5" name="mbaabroad'+id+'[]"/><label for="mbaabroad5"></label><span>Building Great Applications & SOPs</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Scholarships, Financing Options" id="mbaabroad6" name="mbaabroad'+id+'[]"/><label for="mbaabroad6"></label><span>Scholarships, Financing Options</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Options, Job Prospects after Management in India" id="mbaabroad7" name="mbaabroad'+id+'[]"/><label for="mbaabroad7"></label><span>Options, Job Prospects after Management in India</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Acing the GMAT" id="mbaabroad8" name="mbaabroad'+id+'[]"/><label for="mbaabroad8"></label><span>Acing the GMAT</span></div>';
		      $("#skill-pool"+id).html(skill);
	}else if (value == "Masters India") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Is Masters right for you?" id="mastersindia1" name="mastersindia[]"/><label for="mastersindia1"></label><span>Is Masters right for you?</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Excelling in your Masters Program" id="mastersindia2" name="mastersindia'+id+'[]"/><label for="mastersindia2"></label><span>Excelling in your Masters Program</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Acing GATE" id="mastersindia3" name="mastersindia'+id+'[]"/><label for="mastersindia3"></label><span>Acing GATE</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Masters Programs & Colleges in India" id="mastersindia4" name="mastersindia'+id+'[]"/><label for="mastersindia4"></label><span>Masters Programs & Colleges in India</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Options, Job Prospects after Masters in India" id="mastersindia5" name="mastersindia'+id+'[]"/><label for="mastersindia5"></label><span>Options, Job Prospects after Masters in India</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Scholarships, Financing Options" id="mastersindia6" name="mastersindia'+id+'[]"/><label for="mastersindia6"></label><span>Scholarships, Financing Options</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Preparation and profile required to get in" id="mastersindia7" name="mastersindia'+id+'[]"/><label for="mastersindia7"></label><span>Preparation and profile required to get in</span></div>';
		      $("#skill-pool"+id).html(skill);
	}else if (value == "Masters Abroad") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Is Masters right for you?" id="mastersabroad1" name="mastersabroad'+id+'[]"/><label for="mastersabroad1"></label><span>Is Masters right for you?</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Masters Programs & Colleges Abroad" id="mastersabroad2" name="mastersabroad'+id+'[]"/><label for="mastersabroad2"></label><span>Masters Programs & Colleges Abroad</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Acing GRE" id="mastersabroad3" name="mastersabroad'+id+'[]"/><label for="mastersabroad3"></label><span>Acing GRE</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Building Great Applications & SOPs" id="mastersabroad4" name="mastersabroad'+id+'[]"/><label for="mastersabroad4"></label><span>Building Great Applications & SOPs</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Options, Job Prospects after Masters Abroad" id="mastersabroad5" name="mastersabroad'+id+'[]"/><label for="mastersabroad5"></label><span>Options, Job Prospects after Masters Abroad</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Excelling in your Masters Program" id="mastersabroad6" name="mastersabroad'+id+'[]"/><label for="mastersabroad6"></label><span>Excelling in your Masters Program</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Scholarships, Financing Options" id="mastersabroad7" name="mastersabroad'+id+'[]"/><label for="mastersabroad7"></label><span>Scholarships, Financing Options</span></div>';
		      $("#skill-pool"+id).html(skill);
	}else if (value == "Engineering") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="What next after your course" id="engineering1" name="engineering'+id+'[]"/><label for="engineering1"></label><span>What next after your course</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Higher Studies or Job?" id="engineering2" name="engineering'+id+'[]"/><label for="engineering2"></label><span>Higher Studies or Job?</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="5 Year Career Plan" id="engineering3" name="engineering'+id+'[]"/><label for="engineering3"></label><span>5 Year Career Plan</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Which Internships to do & why" id="engineering4" name="engineering'+id+'[]"/><label for="engineering4"></label><span>Which Internships to do & why</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Excelling in placement season" id="engineering5" name="engineering'+id+'[]"/><label for="engineering5"></label><span>Excelling in placement season</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Building the right profile in college" id="engineering6" name="engineering'+id+'[]"/><label for="engineering6"></label><span>Building the right profile in college</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="MBA or Masters?" id="engineering7" name="engineering'+id+'[]"/><label for="engineering7"></label><span>MBA or Masters?</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Masters in India or Masters Abroad?" id="engineering8" name="engineering'+id+'[]"/><label for="engineering8"></label><span>Masters in India or Masters Abroad?</span></div>';
		      $("#skill-pool"+id).html(skill); 
	}else if (value =="industry") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Overview of my industry" id="industry1" name="industry'+id+'[]"/><label for="industry1"></label><span>Overview of my industry</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Evaluating if my industry is right for you" id="industry2" name="industry'+id+'[]"/><label for="industry2"></label><span>Evaluating if my industry is right for you</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="How to enter in the industry" id="industry3" name="industry'+id+'[]"/><label for="industry3"></label><span>How to enter in the industry</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Reviewing your resume" id="industry4" name="industry'+id+'[]"/><label for="industry4"></label><span>Reviewing your resume</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Interview preparation" id="industry5" name="industry'+id+'[]"/><label for="industry5"></label><span>Interview preparation</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Growth & Prospects in my Industry" id="industry6" name="industry'+id+'[]"/><label for="industry6"></label><span>Growth & Prospects in my Industry</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Job profile & description" id="industry7" name="industry'+id+'[]"/><label for="industry7"></label><span>Job profile & description</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Work culture & environment" id="industry8" name="industry'+id+'[]"/><label for="industry8"></label><span>Work culture & environment</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Questions about (Area of Expertise)" id="industry9" name="industry'+id+'[]"/><label for="industry9"></label><span>Questions about (Area of Expertise)</span></div>';
		      $("#skill-pool"+id).html(skill);
	}else if (value=="Startups") {
		var	skill= '<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Bootstrapping" id="startup1" name="startup'+id+'[]"/><label for="startup1"></label><span>Bootstrapping</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Raising Funds" id="startup2" name="startup'+id+'[]"/><label for="startup2"></label><span>Raising Funds</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Accelerator Programs" id="startup3" name="startup'+id+'[]"/><label for="startup3"></label><span>Accelerator Programs</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Product development" id="startup4" name="startup'+id+'[]"/><label for="startup4"></label><span>Product development</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Sales and Marketing"  id="startup5" name="startup'+id+'[]"/><label for="startup5"></label><span>Sales and Marketing</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Managing your venture" id="startup6" name="startup'+id+'[]"/><label for="startup6"></label><span>Managing your venture</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Growing & Improving as an Entrepreneur" id="startup7" name="startup'+id+'[]"/><label for="startup7"></label><span>Growing & Improving as an Entrepreneur</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Networking - How, Where and my secrets" id="startup8" name="startup'+id+'[]"/><label for="startup8"></label><span>Networking - How, Where and my secrets</span></div>'
	          +'<div class="form-group squaredThree col-xs-12"><input type="checkbox" value="Evaluating a Co Founder" id="startup9" name="startup'+id+'[]"/><label for="startup9"></label><span>Evaluating a Co Founder</span></div>';
		      $("#skill-pool"+id).html(skill);
	}
	/*  $(this).closest('.each-interest-div').find('.tell-info').find('.subcategory-span-info').text(values);
	 $('.tell-info').show();
	 var skills ='';/* add line for checkbok after ajax or json */
	/* $(this).closest('.each-interest-div').find('.skills-pool').append(skills);  */
	}
var i = "${catcounter}";	
$('body').on('click', '.add-more-interest', function(e){
	
	i = parseInt(i)+1;
	if(i < 3){
		var html='<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 col-sm-10 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-12 col-sm-3 no-padding form-label" style="max-width:115.8px">Area of Advice:</label>'
			+'<div class="col-xs-12 col-sm-9">'
			+'<div class="col-xs-12 col-sm-6 no-padding">'
			+'<select class="collapsed-filter-button" id="category-menu'+i+'" onchange="GetSubCategory(this);" style="margin-bottom: 5%" name="category[]">'
			+'<option value="">Choose Category</option>'
			+'<option value="higherstudies">Higher studies</option>'
			+'<option value="industry">Career & Jobs</option>'
			+'<option value="options">Courses</option>'
							 
			+'</select>'
			+'</div>'
			+'<div class="col-xs-12 col-sm-6 no-padding">'
			+'<select class="collapsed-filter-button subcategory-menu" id="subcategory-menu'+i+'" onchange="GetSkills(this);" name="subcategory[]" style="margin-bottom: 5%">'
							  
							 
			+'</select>'
			+'</div>'
			+'<div class="skills-pool col-xs-12" id="skill-pool'+i+'" >'
			+'</div>'	
			+'</div>'
			+'</div>'
			+'</div>'	
	
			+'</div>';
			$('.more-interest-div').append(html);
	}else{
		document.getElementById("validationskill").style.display = 'block';
		document.getElementById("validationskill").innerHTML = 'You cannot add more than 3 area of advice.';
	}

});

$('body').on('click', '.add-language', function(e){
	$('.add-language').remove();
	var html='<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-6 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label">Language</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" name="language[]">'
			+'<span class="add-language btext">Add more</span>'
			+'</div>'
			 		
			+'</div>'
			+'</div>'
			+'</div>';
			$('.languages').append(html);
});
$('body').on('click', '.remove-education', function(e){
	$(this).closest('.each-education-div').remove();
	
});
$('body').on('click', '.remove-profession', function(e){
	$(this).closest('.each-profession-div').remove();
	
});
$('body').on('click', '.change-profile', function(e){
	$('.custom-file-input').trigger('click');
	
});
$( "#geninfo" ).submit(function( event ) {
	var input_p = $("#phone").val();
	var filter = /^\d{12}$/; 
	var is_phone = filter.test(input_p);
 if($("#fname").val()==''){
		
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your full name.';
		$('body').scrollTop(0);
	}else if ($("#age").val()=='') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your age.';
		$('body').scrollTop(0);
	}else if ($('input[name=gender]:checked').length == 0) {
	event.preventDefault();	
	document.getElementById("validation").style.display = 'block';
	document.getElementById("validation").innerHTML = 'Please select your gender.';
	$('body').scrollTop(0);
	}else if (input_p == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your phone number.';
		$('body').scrollTop(0);
	}else if ($("#city").val() == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your city.';
		$('body').scrollTop(0);
	}else if ($("#lang").val() == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your language preference.';
		$('body').scrollTop(0);
	}else if ($("#industry").val() == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your industry.';
		$('body').scrollTop(0);
	}else if ($("#experience").val() == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your experience.';
		$('body').scrollTop(0);
	}else if ($("#intro").val() == '') {
		event.preventDefault();	
		document.getElementById("validation").style.display = 'block';
		document.getElementById("validation").innerHTML = 'Please enter your introduction to the user.';
		$('body').scrollTop(0);

	}
	  
	});
$( "#educinfo" ).submit(function( event ) {
	if("${advisor.getStatus()}" == "GeneralInfo"){
		event.preventDefault();	
		document.getElementById("validationeduc").style.display = 'block';
		document.getElementById("validationeduc").innerHTML = 'Please fill ${advisor.getStatus()}.';
		$('body').scrollTop(0);
	}else if($('input[name=type0]:checked').length == 0 || $('#course').val() == '' || $('#institution').val() == '' || $('#duration').val() == '' ){
		event.preventDefault();	
		document.getElementById("validationeduc").style.display = 'block';
		document.getElementById("validationeduc").innerHTML = 'Please complete your education';
		$('body').scrollTop(0);

	}
	
});
$( "#profinfo" ).submit(function( event ) {
	if("${advisor.getStatus()}" == "GeneralInfo" || "${advisor.getStatus()}" == "EducationInfo"){
		event.preventDefault();	
		document.getElementById("validationprof").style.display = 'block';
		document.getElementById("validationprof").innerHTML = 'Please fill ${advisor.getStatus()}.';
		$('body').scrollTop(0);
	}else if($('#company').val() == '' || $('#designation').val() == '' || $('#profduration').val() == '' ){
		event.preventDefault();	
		document.getElementById("validationprof").style.display = 'block';
		document.getElementById("validationprof").innerHTML = 'Please complete your professional background';
		$('body').scrollTop(0);

	}else{
		var check = new Array(10);
		var counter = 0;
		for(i=0;i<10;i++){
			check[i] = false;
			 if($('input[name="level'+i+'"]:checked').length > 0){
				 check[i] = true;
				 counter++;
			 }
		}
		if(counter == 0){
			event.preventDefault();	
			document.getElementById("validationprof").style.display = 'block';
			document.getElementById("validationprof").innerHTML = 'Please choose a current profession';
			$('body').scrollTop(0);
		}else if (counter > 1) {
			event.preventDefault();	
			document.getElementById("validationprof").style.display = 'block';
			document.getElementById("validationprof").innerHTML = 'You cannot have more than one current profession';
			$('body').scrollTop(0);
		} 
	}
	
});
$( "#skillinfo" ).submit(function( event ) {
	if("${advisor.getStatus()}" == "GeneralInfo" && "${advisor.getStatus()}" == "EducationInfo" && "${advisor.getStatus()}" == "ProfessionalBackground"){
		event.preventDefault();	
		document.getElementById("validationskill").style.display = 'block';
		document.getElementById("validationskill").innerHTML = 'Please fill ${advisor.getStatus()}.';
		$('body').scrollTop(0);
	}else if(($("#category-menu0").is(":visible") && $("#category-menu0").val()=='') || ($("#category-menu1").is(":visible") && $("#category-menu1").val()=='') || ($("#category-menu2").is(":visible") && $("#category-menu2").val()=='') ){
		event.preventDefault();	
		document.getElementById("validationskill").style.display = 'block';
		document.getElementById("validationskill").innerHTML = 'Please select a category';
		$('body').scrollTop(0);

	}else if (($("#category-menu0").is(":visible") && ($("#subcategory-menu0").val()== null || $("#subcategory-menu0").val()== '')) || ($("#category-menu1").is(":visible") && ($("#subcategory-menu1").val()== null || $("#subcategory-menu1").val()== '')) || ($("#category-menu2").is(":visible") && ($("#subcategory-menu2").val()== null || $("#subcategory-menu2").val()== ''))) {
		event.preventDefault();	
		document.getElementById("validationskill").style.display = 'block';
		document.getElementById("validationskill").innerHTML = 'Please select a subcategory';
		$('body').scrollTop(0);

	}
	if ($("#category-menu0").is(":visible")) {
		var value = $("#subcategory-menu0").val();
		if(value == "MBA India" && !$(":checkbox[name='mbaindia0[]']", skillinfo).is(":checked")){
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

	 	}else if (value == "MBA Abroad" && !$(":checkbox[name='mbaabroad0[]']", skillinfo).is(":checked")) {
	 		event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters India" && !$(":checkbox[name='mastersindia0[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters Abroad" && !$(":checkbox[name='mastersabroad0[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Engineering" && !$(":checkbox[name='engineering0[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value =="industry" && !$(":checkbox[name='industry0[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value=="Startups" && !$(":checkbox[name='startup0[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}
	} 
	if ($("#category-menu1").is(":visible")) {
		var value = $("#subcategory-menu1").val();
		if(value == "MBA India" && !$(":checkbox[name='mbaindia1[]']", skillinfo).is(":checked")){
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

	 	}else if (value == "MBA Abroad" && !$(":checkbox[name='mbaabroad1[]']", skillinfo).is(":checked")) {
	 		event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters India" && !$(":checkbox[name='mastersindia1[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters Abroad" && !$(":checkbox[name='mastersabroad1[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Engineering" && !$(":checkbox[name='engineering1[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value =="industry" && !$(":checkbox[name='industry1[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value=="Startups" && !$(":checkbox[name='startup1[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}
	} 
	if ($("#category-menu2").is(":visible")) {
		var value = $("#subcategory-menu2").val();
		if(value == "MBA India" && !$(":checkbox[name='mbaindia2[]']", skillinfo).is(":checked")){
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

	 	}else if (value == "MBA Abroad" && !$(":checkbox[name='mbaabroad2[]']", skillinfo).is(":checked")) {
	 		event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters India" && !$(":checkbox[name='mastersindia2[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Masters Abroad" && !$(":checkbox[name='mastersabroad2[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value == "Engineering" && !$(":checkbox[name='engineering2[]]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value =="industry" && !$(":checkbox[name='industry2[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}else if (value=="Startups" && !$(":checkbox[name='startup2[]']", skillinfo).is(":checked")) {
			event.preventDefault();	
			document.getElementById("validationskill").style.display = 'block';
			document.getElementById("validationskill").innerHTML = 'Please choose a skill';
			$('body').scrollTop(0);

		}
	} 
	
});

var count = "${counter}";
$('body').on('click', '.add-education', function(e){
	$('.add-education').remove();
	inter++;
	var html='<div class="each-education-div col-xs-12 no-padding">'
			+'<span class="remove-education btext">X</span>'
			+'<div class="col-xs-12 col-sm-6 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
				    
			+'<div class="col-xs-12">'
			+'<div class="col-xs-4">'
			+'<input type="radio" id="level1'+inter+'"value="UG" name="type'+count+'" />'
			+'<label for="level1'+inter+++'"><span></span>UG</label>'
			+'</div>'
			+'<div class="col-xs-4">'
			+'<input type="radio" id="level2'+inter+'" value="PG" name="type'+count+'"/>'
			+'<label for="level2'+inter+++'"><span></span>PG</label>'
			+'</div>'
			+'<div class="col-xs-4">'
			+'<input type="radio" id="level3'+inter+'" value="others" name="type'+count+'"/>'
			+'<label for="level3'+inter+++'"><span></span>Other</label>'
			+'</div>'                			 
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Course</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" id="course" name="course[]" onkeyup="GetCourseSuggesions(this)">'
			+'<div id="coursesuggestions" class="coursesuggestions"></div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Institution</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" id="institution" name="institution[]" onkeyup="GetInstitutionSuggesions(this)">'
			+'<div id="inssuggestions" class="inssuggestions"></div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" name="duration[]">'
            +'<span class="label label-default">Example: 2002 - 2005</span>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<span class="add-education btext">Add more</span>';
			$('.education-div-container').append(html);
			count++;
});


var procount = "${procounter}";
$('body').on('click', '.add-profession', function(e){
	$('.add-profession').remove();
	inter++;
/* 	rad = "${procounter}";
 */	var html='<div class="each-profession-div col-xs-12 no-padding">'
			+'<span class="remove-profession btext">X</span>'
			+'<div class="col-xs-12 col-sm-6 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
				    
			+'<div class="col-xs-12">'
			+'<div class="col-xs-4">'
			+'<input type="checkbox" value="true" style="visibility: visible;" id="level1'+inter+'" name="level'+procount+'" />'
			+'<label for="leve1'+inter+++'"><span></span>Present</label>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Company</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" id="company" name="company[]" onkeyup="GetCompanySuggesions(this)"> '
			+'<div id="compsuggestions" class="compsuggestions"></div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Designation</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" name="designation[]">'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="col-xs-12 no-padding">'
			+'<div class="form-group each-form-div col-xs-12 no-padding">'
			+'<label class="col-xs-3 no-padding form-label" style="max-width: 113px;">Duration</label>'
			+'<div class="col-xs-9">'
			+'<input class="form-control" name="duration[]">'
			+'<span class="label label-default">Example: 2002 - 2005</span>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'<span class="add-profession btext">Add more</span>';
			$('.professional-div-container').append(html);
			procount++;
});
function GetSubCategory(elem){
	 var values= ( elem.value ); // or $(this).val()
	 var id = elem.id;
	 id = id.substring(id.length -1, id.length);
		if(values=='higherstudies')
		 {
				var option1="<option value=''>Choose SubCategory</option>";
		 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
		   option1=option1 + '<option value="${sub}">${sub}</option>';
		   console.log(option1);
		   $('#subcategory-menu'+id).html(option1); 
		 	</c:forEach>
		 }
		else if(values=='industry')
		 {  
			var option2="<option value=''>Choose SubCategory</option>";
		   option2=option2 + '<option value="industry">Industry & Job</option>'
		                   +'<option value="Startups">Startup</option>';
		                   /* +'<option value="civil">Civil Services</option>'; */
/* 		                   $(this).closest('.subcategory-menu').find('.subcategory-menu').html(option2);
 */		                   $('#subcategory-menu'+id).html(option2); 
		   /* $('#subcategory-menu').html(option2); */
		  }
		else
		{
			var option3="<option value=''>Choose SubCategory</option>";
			<c:forEach items="${optionsSubCategory}" var="sub">
		   option3=option3 + '<option value="${sub}">${sub}</option>';
/* 		   $(this).closest('.subcategory-menu').find('.subcategory-menu').html(option3);
 */		   $('#subcategory-menu'+id).html(option3); 
		   /* $('#subcategory-menu').html(option3); */
		  	</c:forEach>

		}
}
/* $('#category-menu').on('change', function() {
	debugger;
		 var values= ( this.value ); // or $(this).val()
		if(values=='higherstudies')
		 {
				var option1="<option value=''>Choose SubCategory</option>";
		 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
		   option1=option1 + '<option value="${sub}">${sub}</option>';
		   console.log(option1);
		   $(this).closest('.subcategory-menu').find('.subcategory-menu').html(option1);
		 	</c:forEach>
		 }
		else if(values=='industry')
		 {  
			var option2="<option value=''>Choose SubCategory</option>";
		   option2=option2 + '<option value="industry">Industry & Job</option>'
		                   +'<option value="startup">Startup</option>'
		                   +'<option value="civil">Civil Services</option>';
		                   $(this).closest('.subcategory-menu').find('.subcategory-menu').html(option2); */
		   /* $('#subcategory-menu').html(option2); */
		/*  }
		else
		{
			var option3="<option value=''>Choose SubCategory</option>";
			<c:forEach items="${optionsSubCategory}" var="sub">
		   option3=option3 + '<option value="${sub}">${sub}</option>';
		   $(this).closest('.subcategory-menu').find('.subcategory-menu').html(option3); */
		   /* $('#subcategory-menu').html(option3); */
		 /* 	</c:forEach>

		}
		}); */
		function readURL(input) {
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();

		        reader.onload = function (e) {
		            $('#advprev').attr('src', e.target.result);
		        }

		        reader.readAsDataURL(input.files[0]);
		    }
		}

		$("#advimg").change(function(){
		    readURL(this);
		});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>