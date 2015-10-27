<%@page import="ac.dto.*"%>
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
<link href="assets/css/pannel.css" rel="stylesheet">
<link href="assets/css/star-rating.css" rel="stylesheet">
<link href="assets/css/nav-mobile.css" rel="stylesheet">
<link href="assets/css/qa.css" rel="stylesheet">
<link href="assets/css/answer.css" rel="stylesheet">


<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
    
<%
                String ids = (String) request.getAttribute("ids");
                List<String> industries = (List<String>)request.getAttribute("industries");
                List<String> institutions = (List<String>)request.getAttribute("institutions");
                List<String> languages = (List<String>)request.getAttribute("languages");
                QuestionsDTO question = (QuestionsDTO)request.getAttribute("question");
                List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("answers");
                String last_Updated = (String) request.getAttribute("last_Updated");
                List<AdvisorDTO> advisors = (List<AdvisorDTO>)request.getAttribute("advisors");
                Integer count = (Integer) request.getAttribute("count");
                List<QuestionsDTO> mostViewedQuestions = (List<QuestionsDTO>)request.getAttribute("mostViewedQuestions");
                List<String> popCats = (List<String>)request.getAttribute("popCats");
                Boolean isUserVerified =false;
        	       if(session.getAttribute("isVerified") != null){
        	    	isUserVerified = (Boolean) session.getAttribute("isVerified");
        	       }
				pageContext.setAttribute("ids", ids);
	

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
   		 
   		  
   			<div class="row no-padding-xs stopnow body-content">
   			<div class="col-xs-12 cc">
   			  <%@include file="/collapsed-category.jsp" %>
   			</div>
   			 
   				<div class="col-xs-12 col-sm-9 qa-left-section">
		   			<div class="head-for-body">
			   			<span class="big-title-body">Question & Answers :</span>
			   			<!-- <span class="search-item">Higher Studies in MBA India</span> -->
			   			<button type="button" class="btn red-button ask-question-button" onclick="OpenAskAQuestion()">Ask question</button>
			   		</div>
		   			<div class="white-body-div">
			   				<div class="each-question-div row" id="1">
				   				<div class="col-xs-12 tag-div">
									<c:if test="${question.getCategory().equals('studies')}">
										<span class="tag">Higher Studies</span>
			   						</c:if>
				   					<c:if test="${question.getCategory().equals('industry')}">
										<span class="tag">Career & Jobs</span>
				   					</c:if>
				   					<c:if test="${question.getCategory().equals('options')}">
										<span class="tag">Course</span>
				   					</c:if>
									<span class="tag">${question.getSubcategory()}</span>
				   				</div>
				   				<div class="col-xs-12 question-div">
									<span class="question">${question.getQuestion()}</span>
				   					<br>
				   					<span class="count-answers">${count } answers</span><span class="updated-on">Last Updated on ${last_Updated }</span>
				   				</div> 
				   				<div class="col-xs-11" style="margin-top: 4px;">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
				   				
			   				</div>
			   				<c:forEach items="${answers}" var="answer">
			   					<c:forEach items="${advisors}" var="advisor">
			   			
			   						<c:if test="${answer.getAdvisor_id() == advisor.getId()}">
						   				<div class="each-answer-div row">
						   				<div class="col-xs-12 col-sm-12  answer-div">
												<div class="advisor_ans col-xs-12 no-padding">
						                            <div class="advisor">
						                               <div class="advisor_details col-xs-12 no-padding" >
						                               <a href="advisorprofile?a=${advisor.getId()}">
						                                
						                                    <img class="adv-img" src="${advisor.getImage()}">
						                                    <p class="adv-name">${advisor.getName()}</p>
						                                    <p class="adv-field">${advisor.getIndustry()}</p>
						                                    <p class="written-on" >${answer.getDate()}</p>
						                                </a>
						                                    
						                                    <span  class="red-action-a"><a href="advisorprofile?a=${advisor.getId()}" > <img src="assets/img/answer_ask.svg"> Ask Question</a>
						                                    <a href="advisorprofile?a=${advisor.getId()}"> <img src="assets/img/answer_book.svg"> Book Session</a>
						                                    </span>
						                                </div>
						                             </div>
						                            <div class="adv_ans col-xs-12 col-sm-11 no-padding">
						                                <p>${answer.getAnswer()}:</p>
						                                <span class="upvote" id="${answer.getId()}:${advisor.getId()}" onclick="UpdateUpvote(this)">Upvote | ${answer.getUpvote()}</span>
						                            </div>
						                        </div>
			                        			
							   				</div>
							   				<div class="col-xs-11">
							   					<div style="border-bottom: 1px solid lightgray;"></div>
							   				</div>
						   				</div>
					   				</c:if>
				   				</c:forEach>
			   				</c:forEach>
			   				
				   			
			   				</div>
			   				
			   				
			   				
			   		</div>
	   			
	   			<div class="col-xs-12 col-sm-3">
		   			<div  class="related col-xs-12">
	                    <div class="rel-section mostviewed">
	                        <h2>MOST VIEWED QUESTIONS</h2>
	                          
	
	                    </div>
					</div>
					<div class="related col-xs-12">
                    <div class="rel-section poptags">
                        <h2>POPULAR CATEGORIES</h2>
                        
                    </div>
	   			</div>
   			</div>
   			<!-- <div class="load-more-div col-xs-12" style="margin-top:30px;">
   				<div class="col-xs-9" id="loadmore" style="text-align:center;text-align: center;margin-bottom: 15px;">
	   						<button type="button" class="btn load-more" style="width: 200px;">
	  											Load more</button>
	
	   					</div>
   			</div> -->
   		</div>	
   	 </div>
   	    	  <%@include file="/askqmodal.jsp" %>
   	 	 <%@include file="/footer.jsp" %>
</div>
<script>
$(document).ready(function () {
	if("${type.equals('signup') }"){
		document.getElementById("verifyaccount").style.display = "block";
	}else{
		document.getElementById("verifyaccount").style.display = "none";
	}
   	if(<%=isAdv%>){
   		$(".ask-a-question-button").hide();
   		$(".book-a-session-button").hide();
   	} 
	$.ajax({
        url : 'GetMostViwedAndPopularTagsController', // Your Servlet mapping or JSP(not suggested)
        data : {},
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
function OpenAskAQuestion(){
	
	if(<%=isUserVerified%>){
		$('#askquestion').modal('show');
		$("#userverificationmodal").modal("hide");
	}else{
		$("#userverificationmodal").modal("show");
	}
}
function MostViewedQuestionsCard(value){
	var html = '<p class="rel_ques"><a class="rel_ques" href="answers?q='+value.id+'">'+value.question+'</a></p>';
	 $('.mostviewed').append(html);
} 
function Populartags(value){
	var html = '<a class="rel-category">';
	  if(value.category == "studies"){
		  html+='Higher Studies</a>';
	  }else if (value.category == "industry") {
		  html+='Career & Jobs</a>';
	}else if (value.category == "options") {
		html+='Course</a>';
	}
	 $('.poptags').append(html);
}
function UpdateUpvote(elem){
	var id = elem.id;
	var data = id.split(':');
	$('.black-screen').show();
	$.ajax({
        url : 'UpdateAnswerUpvote', // Your Servlet mapping or JSP(not suggested)
        data : {"answerId":data[0],"aid":data[1]},
        type : 'POST',
        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
        success : function(response) {
        	if(response != "false"){
        		document.getElementById(''+id).innerHTML ="Upvoted |"+response;
        	}
        	 $('.black-screen').hide();

        },
        error : function(request, textStatus, errorThrown) {
            alert(errorThrown);
            
        }
    });
}
$('body').on('click', '.Cfilter', function(e){
	$('.body-content').removeClass('border-top');
});
$('body').on('click', '.collapsed-search-button', function(e){
	 var optionSelected = $("#category-menu option:selected").attr('value');
	 var optionSelectedsub = $("#subcategory-menu option:selected").attr('value');
	 window.location.href = 'questions?category='+optionSelected+'&subcategory='+optionSelectedsub+'';
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
</script>
</body>
</html>