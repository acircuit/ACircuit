<%@page import="ac.dto.AnswerDTO"%>
<%@page import="ac.dto.UserDetailsDTO"%>
<%@page import="ac.dto.ReviewsDTO"%>
<%@page import="ac.dto.AdvisorDTO"%>
<%@page import="ac.dto.QuestionsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<link href="assets/css/pannel.css" rel="stylesheet">
<link href="assets/css/ud.css" rel="stylesheet">
<link href="assets/css/star-rating.css" rel="stylesheet">
<link href="assets/css/nav-mobile.css" rel="stylesheet">
<link href="assets/css/qa.css" rel="stylesheet">
<link href="assets/css/advisor.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<%
                   AdvisorDTO advisor = (AdvisorDTO) request.getAttribute("advisor");
                   String currentDesignation = (String) request.getAttribute("currentDesignation");
                   String currentCompany = (String) request.getAttribute("currentCompany");
                   List<UserDetailsDTO> userDetails = (List<UserDetailsDTO>) request.getAttribute("userDetails");
                   Integer consultations = (Integer) request.getAttribute("consultations");
                   List<ReviewsDTO> advisorReviews = (List<ReviewsDTO>)request.getAttribute("advisorReviews");
                   List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("answers");
                   List<QuestionsDTO> questions = (List<QuestionsDTO>)request.getAttribute("questions");
                   Boolean isPhone = (Boolean) request.getAttribute("isPhone");
                   Double rateCount = (Double) request.getAttribute("rateCount");
                   Integer reviewCount = (Integer) request.getAttribute("reviewCount");
                   Integer answerCount = (Integer) request.getAttribute("answerCount");
                   String advisorId = request.getParameter("a");
           	       Boolean isUserVerified =false;
           	       if(session.getAttribute("isVerified") != null){
           	    	isUserVerified = (Boolean) session.getAttribute("isVerified");
           	       }

       			   int userId = 0;
       			   if(request.getSession().getAttribute("userId") != null){
       				userId = (Integer)request.getSession().getAttribute("userId");
       			   }
       			   Boolean isUserLoggedIn = false;
       			   if(userId != 0){
       				isUserLoggedIn = true;
       			   }
       			   pageContext.setAttribute("advisorId", advisorId);
%>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
 <%@include file="/notify.jsp" %>
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
		   	<!-- <div class="advisor-page-heading" >
			   	<span class="adpage-big-texth">Expert Advisors :</span>
			   	<span class="adpage-small-texth">Higher Studies in MBA India</span>
		   	</div> -->
   		 <div class="col-xs-12  expert-card-div" style="margin-top:10px;">
			<div class="expert-card">
				<div class="col-xs-12 no-padding">
					<div class="col-xs-12 col-sm-3 blueT  no-padding">
						<div class="Adp" style="text-align:center;">
							<img src="${advisor.getImage()}">
						</div>
					
					</div>
					<c:set value="" var="category"></c:set>
					<c:set value="" var="subcategory"></c:set>
					<div class="col-xs-12 col-sm-9 padding-l-xs">
						<div class="Apinfo">
							<span class="Aname">${advisor.getName()} <br class="visible-xs">
							<c:forEach items="${advisor.getCategories()}" var="category">
							    <c:forEach items="${advisor.getSubCategories()}" var="subcategory">
							         <c:if test="${category.getCatId() == subcategory.getCategoryId()}">
							         <c:set value="${category.getCategory()}" var="advisorCategory"></c:set>
					                 <c:set value="${subcategory.getSubCategory()}" var="advisorSubcategory"></c:set>
							              <span class="designation"><span class="hidden-xs">|</span>	${category.getCategory()}, ${subcategory.getSubCategory()}</span>
							         </c:if>     
							    </c:forEach>
							</c:forEach>
							
							</span><br>
							<span class="Afeild">${currentDesignation} in ${currentCompany}</span>
							<span class="stars-xs visible-xs"><span class="rating-no">4.5</span>
							<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="4" disabled></span>
							<div class="dquotes">
								<span class="bqstart">“</span>
							</div>
							<div class="ad-speaks">
								<span>${advisor.getIntro()}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 no-padding">
					<div class="b-strip">
						<div class="col-xs-12 col-sm-8 no-padding-xs text-center-xs" style="visibility:hidden;">
							<span class="stars-xs hidden-xs"><span class="rating-no">4.5</span>
							<input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="${rateCount}" disabled></span>
							<span class="ad-stats"><span class="no-blue">${reviewCount }</span><span class="no-type">Reviews</span></span>
							<span class="ad-stats"><span class="no-blue">${answerCount }</span><span class="no-type">Answers</span></span>
							<span class="ad-stats"><span class="no-blue">${consultations }</span><span class="no-type">Sessions</span></span>
						
						</div>
						<div class="col-xs-12 col-sm-4 text-right text-center-xs no-padding-xs">
							<button type="button" class="btn red-button book-a-session-button" onclick="CheckLoggedIn()" >Book a session</button>
							<button type="button" class="btn dark-button ask-a-question-button" onclick="CheckLoggedInForQuestions()">Ask a question</button>
						</div>
					
					
					</div>
				</div>
			</div>
			</div>   
	<div class="body-content">
		<div class="col-xs-12 col-sm-3 advisor-left-pannel">
			<div class="verified-green-div">
				<span> <img src="assets/img/verified.png" style="width: 32px;margin-right: 6px;margin-left: 5px;margin-top: -10px;"> Verified Expert </span> <img src="assets/img/info.png" style="width: 17px;margin-right: 6px;margin-left: 5px;margin-top: 4px;float:right;">
			</div>
			<div class="can-help-container">
				<div class="can-help-div">
				<span class="can-help-head">I can help you with</span>
				<c:forEach items="${advisor.getSubCategories()}" var="subcategory">
				    <div class="each-topic-div">
								<span class="topic-head">${subcategory.getSubCategory()}</span>
								<ul class="topic-list">
								    <c:forEach items="${advisor.getSkills()}" var="skills">
								        <c:if test="${subcategory.getId() == skills.getSubId()}">
											<li>${skills.getSkill() }</li>
										</c:if>
							    </c:forEach>
								</ul>
								
					</div>
						
				</c:forEach>
			</div>
			</div>
			<div class="available-div col-xs-12">
				<span class="available-head">Available on</span>
				<c:if test="${advisor.getPhone() }">
					<div class="col-xs-6 no-padding">
					<img src="assets/img/phone.png" style="width: 20px;margin-right: 6px;margin-left: 5px;margin-top: -10px;"> <span class="available-type-text">Phone</span>
					</div>
				</c:if>
				<c:if test="${advisor.getVideo() }">
					<div class="col-xs-6 no-padding">
					<img src="assets/img/vicon.svg" style="width: 31px;margin-right: 6px;margin-left: 5px;margin-top: -10px;"> </i><span class="available-type-text" style="margin-left: 43px;">Video Chat</span>
					</div>
				</c:if>
			</div>
			<div class="session-info col-xs-12">
				<div class="session-div">
					<span class="session-head-type" >Book A Session</span><br>
					<span class="session-head-text">Rs ${advisor.getPhonePrice()}/min</span>
					<button type="button" class="btn red-button book-a-session-button" onclick="CheckLoggedIn()" style="width: 99px;">Book now</button>
				</div>
				<div class="session-div">
					<span class="session-head-type">Ask A Question</span><br>
					<span class="session-head-text">Absolutely free</span>
					<button type="button" class="btn dark-button ask-a-question-button" onclick="CheckLoggedInForQuestions()" style="width: 99px;">Ask now</button>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-6 advisor-center-pannel">
			<span class="bio-heading">Work Experience</span>
			<div class="border-b">
				<div class="bio-div">
				    <c:forEach items="${advisor.getProfession()}" var="profession">
					<div class="bio-element">
						<span class="bio-title">${profession.getDesignation()}</span>
						<span class="bio-subtitle">${profession.getCompany()}</span><span class="seperator">|</span><span class="bio-subtitle3">${profession.getDuration()}</span>
						
					</div>
					</c:forEach>
				</div>	
				<span class="view-linkedin"> <i class="fa fa-linkedin"></i> <a href="${advisor.getLinkedIn()}" target="blank">View Linkedin Profile</a></span>
			</div>
			<span class="bio-heading">Education</span>
			<div class="border-b">
				<div class="bio-div">
				    <c:forEach items="${advisor.getEducation()}" var="education">
				       <div class="bio-element">
						   <span class="bio-title">${education.getCourse()}</span>
						   <span class="bio-subtitle">${education.getInstitution()}</span><span class="seperator">|</span><span class="bio-subtitle"> New Delhi</span>
						   <span class="bio-subtitle3">${education.getDuration()}</span>
					   </div>
				    </c:forEach>
				</div>	
				
			</div>
			<span class="bio-heading">Other Information</span>
			<div class="border-b">
				<span class="a-info-each"><span class="additional-info-type">Current City: </span><span class="additional-info-text"> ${advisor.getCity()}</span></span>
				<span class="a-info-each"><span class="additional-info-type">Language: </span>
				<c:forEach items="${advisor.getLanguage()}" var="language">
				<span class="additional-info-text"> ${language.getLanguage()},</span>
				</c:forEach>
				</span>
				<span class="a-info-each"><span class="additional-info-type">Industry:</span><span class="additional-info-text"> ${advisor.getIndustry()}</span></span>
			</div>
			<div class="ar-tab-div ">
				   	<ul class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="active"><a href="#answers" aria-controls="answers" role="tab" data-toggle="tab">ANSWERS (${answerCount})</a></li>
				    <li role="presentation"><a href="#reviews" aria-controls="reviews" role="tab" data-toggle="tab">REVIEWS (${reviewCount})</a></li>
				   
				  </ul>
				
				  <!-- Tab panes -->
				  <div class="tab-content">
				    <div role="tabpanel" class="tab-pane fade in active" id="answers">
					     <div class="answers">
					         <c:forEach items="${questions}" var="question">
					           
					                         <div class="each-question-div row" id="1">
					   				           <div class="col-xs-12 question-div">
										          <span class="question">${question.getQuestion()}</span>
					   					          <br>
					   					          <span class="updated-on">Posted on ${question.getPostedOnDate()}</span>
					   				           </div>
					   				            <c:forEach items="${answers}" var="answer">
					                               <c:if test="${question.getQuestionId() == answer.getQuestionId()}"> 
					   				                   <div class="col-xs-12 answer-div">
										
										                  <p class="answer-to-question">
										                   ${answer.getAnswer()}
										                  </p>
										                  
					   				                  </div>
					   				               </c:if>
					                           </c:forEach>
					   				          <div class="col-xs-12">
					   					      <div style="border-bottom: 1px solid lightgray;"></div>
					   				          </div>
				   				          </div>
					                
					         </c:forEach>
					     </div>
				    </div>
				    <div role="tabpanel" class="tab-pane fade" id="reviews">
				    	<div class="reviews-container">
				    	<c:forEach items="${advisorReviews}" var="reviews">
				    	  <c:forEach items="${userDetails}" var="user">
				    	    <c:if test="${reviews.getUserId() == user.getUserId() && reviews.getReview() != null}">
				    	             <div class="review-each-div" id="r1">
					    		     <span class="by-whom">
									<span class="nameA">${user.getFullName()} </span> wrote on ${reviews.getPostedOn()}
									</span><span class="review-stars-on-advisor"><input name="rating" class="rating" data-min="0" data-max="5" data-step="0.5" data-stars=5 data-glyphicon="false" value="${reviews.getRating() }" disabled></span>
									<p class="review-text-profile">
									${reviews.getReview()}
									</p>
					    	        </div>
				    	     </c:if>
				    	    </c:forEach>
				    	</c:forEach>
					    	
					    
				    	</div>
				    </div>
				  </div>
				   		
				</div>
			
		</div>
		<div class="col-xs-12 col-sm-3 advisor-right-pannel similar">
		<div class="right-head ">SIMILAR PROFILES</div>

		</div>
	</div>
	</div>
</div>
<div class="modal fade" id="booksession" tabindex="-1" role="dialog" aria-labelledby="booksession">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								    	<div class="modal-head-bsession">
								    		<span class="modal-head-text">Book A Session</span>
								    	</div>
								    	<div class="modal-main-body row">
								    		<span class="modal-body-text">Session with Charles Dixon${isPhone}</span>
								    		<form class="book-session no-padding" method="post" enctype="multipart/form-data" action="bookasession" id="book-session-form">
								    		    
								    			<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Select Mode </label>
											       <div class="col-xs-9 form-group">
				                                         <div class="col-xs-6">
				                                         	 <div class="">
																<input type="radio" value="phone" id="phone" name="mode" aria-required="true" required/>
																<label for="phone"><span></span><img src="assets/img/phone.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Phone</label>
																
															</div>
														</div>
														<div class="col-xs-6">
				                                         	 <div class="">
																<input type="radio" value="video" id="video" name="mode"/>
																<label for="video"><span></span><img src="assets/img/video.png" style="width: 20px;margin-right: 6px;margin-left: 5px;"> Video</label>
																
																
															</div>
														</div>
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Session Duration </label>
											       <div class="col-xs-9 form-group">
				                                        <select class="collapsed-filter-button" id="duration" name="duration" title="Please select time duration" required="" aria-required="true" onchange="GetAdvisorPrice()">
														</select> 
											 		</div>
											 	</div>
											 	<input type="hidden" name="aId" value="${advisor.getId()}">
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Approximate Cost</label>
											       <div class="col-xs-9 form-group">
											           <input type="hidden" id="approxprice" name="approxprice" value="500">
				                                       <span class="session-cost" id="price"></span><br>
				                                        <span class="session-cost-text">Payment will not be collected until this advisor has accepted your request.</span><br>
											 		</div>
											 	</div>
											 	<c:if test="${!isPhone}">
											 	  <input type="hidden" name="uid" value="${userId}">
								    			  <div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Phone Number</label>
											       <div class="col-xs-9 form-group">
				                                       <input class="form-control" name="phone" required>
											 		</div>
											 	</div>
											 	</c:if>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Query Description</label>
											       <div class="col-xs-9 form-group">
				                                       <textarea class="form-control" name="query" required></textarea>
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Attachments</label>
											       <div class="col-xs-9 form-group">
				                                      <input type="file" class="custom-file-input required" name="resume" accept="application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/msword" aria-required="true">
											 		</div>
											 	</div>
											 	<span class="modal-body-text">Propose three time slots for booking a session</span>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 1</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker" name="slot1date" required>
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" name="slot1time" title="Please select slot 1" required="" aria-required="true">
														  
														  
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 2</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker" name="slot2date" required>
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" name="slot2time" title="Please  select slot 2" required="" aria-required="true">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 3</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker" name="slot3date" required>
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" name="slot3time" title="Please  select slot 3" required="" aria-required="true">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="col-xs-12 button-div" >
											 	<button type="submit" class="btn book-button" id="book-booksession" >Book</button>
											 	<button type="button" class="btn cancel-button" data-dismiss="modal" id="cancel-booksession">Cancel</button>
											 	
											 	</div>
								    		</form>
								    	</div>
								      </div>
								      
								    </div>
								  </div>
								</div>
				   	  <%@include file="/askqmodal.jsp" %>
				   	 <%@include file="/footer.jsp" %>
								
<script>

$(document).ready(function () {
	if(<%=isAdv%>){
   		$(".ask-a-question-button").hide();
   		$(".book-a-session-button").hide();
   	} 
	$('.datepicker').datepicker({
	    format: 'mm/dd/yyyy',
	    startDate: '-3d'
	});
	var i=0;
	for(i=0;i<25;i++){
		html='<option value="'+i+':00">'+i+':00 Hours</option>'
			+'<option value="'+i+':30">'+i+':30 Hours</option>';
		$('.inpt-mw').append(html);
	}
	var j=0;
	var htmld="";
	for(j=15;j<91;){
		htmld='<option value="'+j+'">'+j+' Minutes</option>';
		$('#duration').append(htmld);
		j=j+15;
	}
	$("#book-session-form").validate();
	starinputconversion();
	
	$.ajax({
        url : 'getsimilarprofiles', // Your Servlet mapping or JSP(not suggested)
        data : {"category":"${advisorCategory}", "subcategory": "${advisorSubcategory}","advisorId" :"${advisor.getId()} "},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
          	$.each(obj, function(key,value) {
          		similarprofile(value,"${advisorCategory}","${advisorSubcategory}");
          	}); 
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
	
	
});


function similarprofile(value,category,subcategory){
	var html = '<div class="advisor_details col-xs-6 col-sm-12 no-padding" >'
	           +'<img class="adv-img" src="'+value.image+'"></img>' 
		       +'<p class="adv-name">'+value.name+'</p><br>'
		       +'<p class="adv-field">'+category+','+subcategory+'</p><br>'  
               +'</div>';		
               $('.similar').append(html);
 }


$('body').on('click', '#book-booksession', function(e){
	var validator=$("#book-session-form").validate();
	validator.resetForm();
});
$('body').on('click', '.more', function(e){
	var id = $(this).closest('.each-question-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	 $(this).closest('.each-question-div').find('.answer-to-question').html(data+'<span class="less">less</span>');
});
$('body').on('click', '.less', function(e){
	var id = $(this).closest('.each-question-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	var res = data.substring(0,200);
	$(this).closest('.each-question-div').find('.answer-to-question').html(res+'<span class="more"> more</span>');
});
	
$('body').on('click', '.moreR', function(e){
	var id = $(this).closest('.review-each-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	 $(this).closest('.review-each-div').find('.review-text').html(data+'<span class="lessR">less</span>');
});
$('body').on('click', '.lessR', function(e){
	var id = $(this).closest('.review-each-div').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	var res = data.substring(0,200);
	$(this).closest('.review-each-div').find('.review-text').html(res+'<span class="moreR"> more</span>');
});
function GetAdvisorPrice(){
	var duration = $("#duration").val();
	$.ajax({
        url : 'GetAdvisorPriceController', // Your Servlet mapping or JSP(not suggested)
        data : {"advisorId":"${advisorId}", "duration": duration,"isPhone" :$("#phone").val(),"isVideo":$("#video").val()},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	document.getElementById('price').innerHTML = "Rs. " +response;
			 $("#approxprice").val(response);
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}	
	
function CheckLoggedIn(){
	if(<%=isUserLoggedIn && isUserVerified%>){
		$('#booksession').modal('show');
	}else if (<%=!isUserLoggedIn%>) {
		$('#loginmodal').modal('show');
	}
	else if (<%=!isUserVerified%>) {
		document.getElementById("verifytobook").style.display = "block";
	}else{
   		$('#loginmodal').modal('show');
	}

}	
function CheckLoggedInForQuestions(){
	if(<%=session.getAttribute("userId") !=null %>){
		$('#askquestion').modal('show');
	}else{
		$('#loginmodal').modal('show');
	}
}
$('#category-menu-on-modal').on('change', function() {
	 var values= ( this.value ); // or $(this).val()
	if(values=='higherstudies')
	 {
			var option1="";
	 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
	   option1=option1 + '<option value="${sub}">${sub}</option>';
	   console.log(option1);
	   $('#subcategory-menu-on-modal').html(option1);
	 	</c:forEach>
	 	
	 }
	else if(values=='industry')
	 {  
		var option2="";
		<c:forEach items="${industrySubCategory}" var="sub">
	   option2=option2 + '<option value="${sub}">${sub}</option>';
	 
	   $('#subcategory-menu-on-modal').html(option2);
	 	</c:forEach>
	 }
	else
	{
		var option3="";
		<c:forEach items="${optionsSubCategory}" var="sub">
	   option3=option3 + '<option value="${sub}">${sub}</option>';
	 
	   $('#subcategory-menu-on-modal').html(option3);
	 	</c:forEach>

	}
	});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
	</script>
</body>
</html>