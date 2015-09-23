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
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
      AdvisorDTO advisorDetails = (AdvisorDTO) request.getAttribute("advisorDetails");
      List<ActivityDTO> activities = (List<ActivityDTO>) request.getAttribute("activities");        

%>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text">Dashboard</span>
	</div>
   		   <div class="col-xs-12 no-padding">
   		    		<div class="col-xs-12 col-md-2 four-cards no-padding dp-container">
	   		    		<div class="col-xs-12 blueT4">
		   		    		<div class="Adp" style="text-align:center;">
								<img src="${advisorDetails.getImage()}">
							</div>
							<div class="user-name-info" style="text-align:center;">
								<span class="user-name">${advisorDetails.getName()}</span><br>
								<span class="user-email">${advisorDetails.getEmail()}</span><br>
								<span class="user-settings">Edit Profile Settings</span>
							</div>
				   		</div>
				   	</div>
				   	<div class="col-xs-12 col-md-3 four-cards no-padding">
		   		    	<div class="top-bar-div backp">
								<span class="top-bar-text">CURRENT SESSIONS</span>
						</div>
					<div class="card-content col-xs-2 col-sm-12">
							<img src="assets/img/current_session.png">
							<span class="card-text hidden-xs">Hope your session was great! Please review the advisor to help others.  <span class="btext">Review Now</span></span>
						</div>
						<div class="col-xs-10 col-sm-12 card-content-xs">
							<div class="gborder-div col-xs-12">
								<span class="gborder-text-big">Dorris Weaver : Scheduled</span><br>
								<span class="gborder-time">23 September 5:00 pm</span>
							</div>
						</div>
						<div class="col-xs-12 card-footer">
							<a href="advisorsessions"><span class="btext">View All Sessions</span></a>
						</div>
				   	</div>
				   	<div class="col-xs-12 col-md-3 four-cards no-padding">
		   		    	<div class="top-bar-div backg">
								<span class="top-bar-text">PAYMENT</span>
						</div>
				<!-- 		<div class="card-content col-xs-2 col-sm-12">
							<img src="assets/img/payment_wallet.png">
							<span class="card-text hidden-xs">Recharge now for <span class="rtext">Rs 500</span> to get <span class="rtext">10%</span> off on your next session. <span class="btext">View More Offers</span></span>
						</div>
					<div class="col-xs-10 col-sm-12 card-content-xs">
							<div class="col-xs-8 col-sm-6 no-padding">
								<span class="balance-text">Current Balance</span><br>
								<span class="bamount">Rs 1240.00</span><br>
							</div>
							<div class="col-xs-4 col-sm-6 no-padding r-button-div">
								<button type="button" class="btn recharg-button">Recharge</button>
							</div>
						</div>  -->
						<div class="col-xs-12 card-footer">
							<a href="advisorpaymenthistory"><span class="btext">View Payment History</span></a>
						</div>
				   	</div>
				   	<div class="col-xs-12 col-md-3 four-cards no-padding">
		   		    	<div class="top-bar-div backb">
								<span class="top-bar-text">QUESTIONS ASKED</span>
						</div>
						<div class="card-content col-xs-2 col-sm-12">
							<img src="assets/img/questions.png">
							<span class="card-text hidden-xs">Its been 2 weeks since you asked your last question.  <span class="btext">Ask New Question</span></span>
						</div>
						<div class="col-xs-10 col-sm-12 card-content-xs ask-div">
							<span class="ask-text-big"><span class="btext">Doris Weaver</span> answered your question.</span><br>
							<span class="ask-text-small">Posted on 3rd August</span>
						</div>
						<div class="col-xs-12 card-footer">
							<a href="advisorquestions"><span class="btext">View All Questions</span></a>
						</div>
				   	</div>
		   	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			<div class="col-xs-12 body-contenthead-div">
							<span class="body-content-head">Activity Feed for Interests: MBA India, Management Consulting</span><span class="btext change-interest">Change Interests</span>
			</div>
   				<div class="col-xs-12 col-sm-9 ud-left-section">
		   			<div class="col-xs-12 ud-left-section-head-div ">
							<span class="ud-left-section-head">Activity Feed </span>
					</div>
					<c:forEach items="${activities }" var="activity">
					     <c:if test="${activity.getFeedType().equals('question')}">
					     <div class="col-xs-12 no-padding">
						    <div class="each-question-div col-xs-12">
							<span class="new-expert-head">New Question Posted in Q&A Forum</span><br>
				   				<div class="col-xs-12 tag-div no-padding">
									<span class="tag">${activity.getCategory()}</span>
									<span class="tag">${activity.getSubcategory()}</span>
				   				</div>
				   				<div class="col-xs-12 question-div no-padding">
									<span class="question">${activity.getQuestion()}</span>
				   					<br>
				   					<span class="updated-on">Posted on ${activity.getQuestionPostedOn()}</span>
				   				</div> 
				   				<div class="col-xs-11 no-padding" style="margin-top: 10px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
				   				
			   				</div>
						</div>
					     </c:if>
					     <c:if test="${activity.getFeedType().equals('review')}">
					      <div class="col-xs-12 review-div-container no-padding">
							<div class="col-xs-12 userr-card ">
							<span class="new-expert-head">New Review Added</span><br>
									<img src="${activity.getImage()}">
									<span class="btext rfrom">${activity.getUserName()}</span><span class="rto btext"> ${activity.getAdvisorName()}</span>
									<br>
									<span class="review-text">${activity.getReview()}</span>
									
							</div>
							<div class="col-xs-12 ">
							<span class="all-r btext">See all reviews</span>
							</div>
							<div class="col-xs-11" style="margin-top: 10px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
						</div>
					     
					     
					     </c:if>
					     
					
					
					
					</c:forEach>
					
					
					
					
			   			
			   			<div class="col-xs-12 new-expert-div no-padding">
							<div class="col-xs-12 new-expert-card ">
								<span class="new-expert-head">New Expert Added to Category <span class="btext"> MBA India </span></span><br>
									<img src="assets/img/Abhishek.JPG">
									<span class="n-expert-name btext">fddfdfd0 <span class="n-expert-category">| asdasd</span></Span>
									<br>
									<span class="n-expert-designation">sdasd</span>
									
							</div>
							<div class="col-xs-11" style="margin-top: 4px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
						</div>
						<div class="col-xs-12 no-padding">
						<div class="each-question-div col-xs-12">
							<span class="new-expert-head">New Question Posted in Q&A Forum</span><br>
				   				<div class="col-xs-12 tag-div no-padding">
									<span class="tag">Category</span>
									<span class="tag">subCategory</span>
				   				</div>
				   				<div class="col-xs-12 question-div no-padding">
									<span class="question">Common Admission Test (CAT): Nearly 100 days to go for the CAT 2015. Is it OK if I start preparing now and get a  90+ percentile?</span>
				   					<br>
				   					<span class="count-answers">5 Answers</span><span class="updated-on">Last Updated on 3rd August</span>
				   				</div> 
				   				<div class="col-xs-11 no-padding" style="margin-top: 10px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
				   				
			   				</div>
						</div>
						<div class="col-xs-12 new-expert-div no-padding">
							<div class="col-xs-12 new-expert-card ">
								<span class="new-expert-head">New Expert Added to Category <span class="btext"> MBA India </span></span><br>
									<img src="assets/img/Abhishek.JPG">
									<span class="n-expert-name btext">fddfdfd0 <span class="n-expert-category">| asdasd</span></Span>
									<br>
									<span class="n-expert-designation">sdasd</span>
									
							</div>
							<div class="col-xs-11" style="margin-top: 4px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
						</div>
						<div class="col-xs-12 review-div-container no-padding">
							<div class="col-xs-12 userr-card ">
							<span class="new-expert-head">New Review Added</span><br>
									<img src="assets/img/Abhishek.JPG">
									<span class="btext rfrom">sdfds</span><span class="rto btext"> > sdfds</span>
									<br>
									<span class="review-text">I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015). Let me share a personal perspective that I have shared with countless young MBA.</span>
									
							</div>
							<div class="col-xs-12 ">
							<span class="all-r btext">See all reviews</span>
							</div>
							<div class="col-xs-11" style="margin-top: 10px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
						</div>
			   		</div>

	   			<div class="col-xs-12 col-sm-3">
		   			<div  class="related col-xs-12">
	                    <div class="rel-section">
	                        <h2 class="mostviewed">MOST VIEWED QUESTIONS</h2>
	                         
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section">
                        <h2 class="poptags">POPULAR CATEGORIES</h2>
                      
                    </div>
	   			</div>
   			</div>
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
</div>
<div class="modal fade" id="booksession" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								    	<div class="modal-head-bsession">
								    		<span class="modal-head-text">Book A Session</span>
								    	</div>
								    	<div class="modal-main-body row">
								    		<span class="modal-body-text">Session with Charles Dixon</span>
								    		<form class="book-session no-padding" method="post" enctype="multipart/form-data">
								    			<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Select Mode </label>
											       <div class="col-xs-9 form-group">
				                                         <div class="col-xs-6">
				                                         	 <div class="roundedOne">
																<input type="checkbox" value="" id="phone" name="check" />
																<label for="phone"></label>
																<span class="available-type-text">Phone</span>
																
															</div>
														</div>
														<div class="col-xs-6">
				                                         	 <div class="roundedOne">
																<input type="checkbox" value="" id="video" name="check" />
																<label for="video"></label>
																<span class="available-type-text">video</span>
																
															</div>
														</div>
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Session Duration </label>
											       <div class="col-xs-9 form-group">
				                                        <select class="collapsed-filter-button inpt-mw" id="duration">
														  <option value="1">30 minutes</option>
														  <option value="2">Industry</option>
														  <option value="3">Courses</option>
														 
														</select> 
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Approximate Cost</label>
											       <div class="col-xs-9 form-group">
				                                       <span class="session-cost">Rs 500</span><br>
				                                        <span class="session-cost-text">Payment will not be collected until this advisor has accepted your request.</span><br>
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Query Description</label>
											       <div class="col-xs-9 form-group">
				                                       <textarea class="form-control"></textarea>
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											     <label class="col-xs-3 no-padding form-label">Attachments</label>
											       <div class="col-xs-9 form-group">
				                                      <input type="file" class="custom-file-input">
											 		</div>
											 	</div>
											 	<span class="modal-body-text">Propose three time slots for booking a session</span>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 1</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw">
														  <option value="1">4:30pm</option>
														  <option value="2">Industry</option>
														  <option value="3">Courses</option>
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 2</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw">
														  <option value="1">4:30pm</option>
														  <option value="2">Industry</option>
														  <option value="3">Courses</option>
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="form-group each-form-div">
											 	<label class="col-xs-3 no-padding form-label">Slot 3</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw">
														  <option value="1">4:30pm</option>
														  <option value="2">Industry</option>
														  <option value="3">Courses</option>
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>
											 	<div class="col-xs-12 button-div" >
											 	<button type="button" class="btn book-button" >Book</button>
											 	<button type="button" class="btn cancel-button" data-dismiss="modal">Cancel</button>
											 	
											 	</div>
								    		</form>
								    	</div>
								      </div>
								      
								    </div>
								  </div>
								</div>
<div class="modal fade" id="askquestion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Ask Question</span><br>
								      <br>
								      <form class="ask-form"> 
								      	<textarea id="question"  class="form-control ask-question"  placeholder="Type your Question" > </textarea>
								      
									       <br><br>
									       <div class="row">
										       <div class="col-xs-3"><span>Select category :</span></div>
										       <div class="col-xs-9">
											       <div class="col-xs-6">
												       <select class="form-control collapsed-filter-button" id="category-menu-on-modal">
														  <option value="volvo">Volvo</option>
														  <option value="saab">Saab</option>
														  <option value="mercedes">Mercedes</option>
														  <option value="audi">Audi</option>
														</select>
											       </div>
											       <div class="col-xs-6">
												          <select class="form-control collapsed-filter-button" id="subcategory-menu-on-modal">
															  <option value="volvo">Volvo</option>
															  <option value="saab">Saab</option>
															  <option value="mercedes">Mercedes</option>
															  <option value="audi">Audi</option>
														</select>
														
											       </div>
											      <br>
											      <br>
											        <div class="form-group squaredThree" >
														  	<input type="checkbox" id="21" name="Post anonymously" />
															<label for="2l"></label><span>Post anonymously</span>
													</div>

													<button type="button" class="btn red-button ask-question-button" onclick="SubmitQuestion()">Ask question</button>
										       </div>
									       </div>
								        </form>
								      </div>
								      
								    </div>
								  </div>
								</div>
<script>
$(document).ready(function () {
	$.ajax({
        url : 'GetMostViwedAndPopularTagsController', // Your Servlet mapping or JSP(not suggested)
        data : {"category":"${advisorCategory}", "subcategory": "${advisorSubcategory}","advisorId" :"${advisor.getId()} "},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	var obj = JSON.parse(response);
          	$.each(obj, function(key,value) {
          		if(value.type == "question"){
              		MostViewedQuestionsCard(value);
      			}else if (value.type == "category") {
      				Populartags(value);
				}
          	}); 
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
	
});
function MostViewedQuestionsCard(value){
	var html = '<p class="rel_ques"><a class="rel_ques" href="answers?q='+value.id+'">'+value.question+'</a></p>';
	 $('.mostviewed').append(html);
} 
function Populartags(value){
	var html = '<a class="rel-category">'+value.category+'</a>';
	 $('.poptags').append(html);
}
$('.datepicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d'
})
function questioncard(value){
	var html='<div class="each-question-div row" id="">'
			+'<div class="col-xs-12 tag-div">'
			+'<span class="tag">'+value.category+'</span>'
			+'<span class="tag">'+value.subcategory+'</span>'
			+'</div>'
			+'<div class="col-xs-12 question-div">'
			+'<a href="answers?q='+value.id+'"><span class="question">'+value.question+'</span></a>'
			+'<br>'
			+'<span class="count-answers">'+value.count+' answers</span><span class="updated-on">Last Updated on '+value.lastupdated+'</span>'
			+'</div> '
			+'<div class="col-xs-9 answer-div">'
			+'<span class="by-whom">'
			+'<span class="nameA">Raghu Venkat </span> answered'
			+'</span>'
			+'<p class="answer-to-question">'
			+value.answer+'<span class="more">more</span>'

			+'</p>'
			+'</div>'
			+'<div class="col-xs-11">'
			+'<div style="border-bottom: 1px solid lightgray;"></div>'
			+'</div>'

			+'</div>';
			
	        $('.white-body-div').append(html);
}
$('body').on('click', '.Cfilter', function(e){
	$('.body-content').removeClass('border-top');
});
$('body').on('click', '.more', function(e){
	var id = $(this).closest('.answer-to-question').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	 $(this).closest('.each-question-div').find('.answer-to-question').html(data+'<span class="less">less</span>');
});
$('body').on('click', '.less', function(e){
	var id = $(this).closest('.answer-to-question').attr('id');
	var data="I am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA orI am not a fresher. But I do have an MBA (Michigan, Ross, 93-95), and I do work at Mu Sigma (since March 2015 Let me share a personal perspective that I have shared with countless young MBA or ";
	var res = data.substring(0,200);
	$(this).closest('.each-question-div').find('.answer-to-question').html(res+'<span class="more"> more</span>');
});

	function GetResultAccordingToSubCategory(elem){
		$('.black-screen').show();
		var id = elem.id;
		var cat = id.split(",");
		categ= cat[0];
		subcateg = cat[1];
		
	}
	function SubmitQuestion(){
		$('.black-screen').show();
		var question =$("#question").val();
		var category = $("#category-menu-on-modal").val();
		var subcategory = $("#subcategory-menu-on-modal").val();
    	$.ajax({
            url : 'QuestionsController', // Your Servlet mapping or JSP(not suggested)
            data : {"question":question,"category" :category,"subcategory":subcategory},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
				 alert(response);
            	 $('.black-screen').hide();

            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
                
            }
        });
	}
	
	function GetResultAccordingToSubCategory(elem){
		$('.black-screen').show();
		var id = elem.id;
		var cat = id.split(",");
		categ= cat[0];
		subcateg = cat[1];
	    $('.white-body-div').html('');
		$.ajax({
	        url : 'GetSubcategoryQuestions', // Your Servlet mapping or JSP(not suggested)
	        data : {"category":cat[0],"subcategory":cat[1]},
	        type : 'POST',
	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	        success : function(response) {
	          	var obj = JSON.parse(response);
	          	$.each(obj, function(key,value) {
	          		 questioncard(value);
	          	}); 
	          	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
	             					// create an empty div in your page with some id
	          	 $('.black-screen').hide();

	          },
	          error : function(request, textStatus, errorThrown) {
	            alert(errorThrown);
	            
	        }
	    });
	}
	
	function GetResultsUsingSubCategory(){
		$('.black-screen').show();
		   var sel = document.getElementById('category-menu');
		   var category = sel.options[sel.selectedIndex].value;
		   var sel1 = document.getElementById('subcategory-menu');
		   var subcategory = sel1.options[sel1.selectedIndex].value;
		    $('.white-body-div').html('');
			$.ajax({
		        url : 'GetSubcategoryQuestions', // Your Servlet mapping or JSP(not suggested)
		        data : {"category":category,"subcategory":subcategory},
		        type : 'POST',
		        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
		        success : function(response) {
		          	var obj = JSON.parse(response);
		          	$.each(obj, function(key,value) {
		          		 questioncard(value);
		          	}); 
		          	//console.log(obj[0].name+": subcategory : "+ obj[0].subcategory+" :institution:"+ obj[0].institution+":company:" +obj[0].company+":designation:"+obj[0].designation) ;
		             					// create an empty div in your page with some id
		          	 $('.black-screen').hide();

		          },
		          error : function(request, textStatus, errorThrown) {
		            alert(errorThrown);
		            
		        }
		    });
	}

</script>
</body>
</html>