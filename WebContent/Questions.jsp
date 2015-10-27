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
<meta name="description" content="Get any and every career query answered by our expert advisors for FREE. Learn from questions posted on the platform by your peers. ">
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


<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
                String ids = (String) request.getAttribute("ids");
                List<String> industries = (List<String>)request.getAttribute("industries");
                List<String> institutions = (List<String>)request.getAttribute("institutions");
                List<String> languages = (List<String>)request.getAttribute("languages");
                List<QuestionsDTO> questions = (List<QuestionsDTO>)request.getAttribute("questions");
                List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("answers");
                List<AdvisorDTO> advisors = (List<AdvisorDTO>)request.getAttribute("advisors");
                List<QuestionsDTO> mostViewedQuestions = (List<QuestionsDTO>)request.getAttribute("mostViewedQuestions");
                List<String> popCats = (List<String>)request.getAttribute("popCats");
                Boolean isUserVerified =false;
        	       if(session.getAttribute("isVerified") != null){
        	    	isUserVerified = (Boolean) session.getAttribute("isVerified");
        	       }
        		pageContext.setAttribute("ids", ids);
	

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<style>
@media (min-width: 320px) and (max-width: 767px) {
.dark-button {
    margin-left: 0px;
}
.dark-button, .red-button {
    margin-top: 8px;
}
.ask-question-button {
    margin-top: 0px;
    
}
}
</style>

<title>Get answers to career queries I Advisor Circuit</title>
<body>
 <div id="wrapper">
  <%@include file="/notify.jsp" %>
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
   		    <%@include file="/Category.jsp" %>
   		  
   			<div class="row no-padding-xs stopnow border-top body-content">
   			<div class="col-xs-12 cc" >
   			 <%@include file="/collapsed-category.jsp" %>
   			</div>
   			 
   				<div class="col-xs-12 col-sm-9 qa-left-section">
		   			<div class="head-for-body">
			   			<span class="big-title-body">Question & Answers :</span>
			   			<br>
			   			<span class="answers-count">${answers.size()} Answers</span>
			   			<button type="button" class="btn red-button ask-question-button ask-a-question-button" onclick="OpenAskAQuestion()">Ask question</button>
			   		</div>
		   			<div class="white-body-div">

		   				<c:forEach items="${questions}" var="question">
 							 <div class="each-question-div row" id="${question.getQuestionId()}">
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
									<a href="answers?q=${question.getQuestionId()}"><span class="question">${question.getQuestion()}</span></a>
				   					<br>
				   					<span class="count-answers">${question.getCount()} answers</span><span class="updated-on">Last Updated on ${question.getLastUpdated()}</span>
				   				</div> 
								<c:forEach items="${answers }" var="answer">
								<c:forEach items="${advisors }" var="advisor">
								<c:if test="${answer.getQuestionId() == question.getQuestionId()}">
										<c:if test="${ answer.getAdvisor_id() == advisor.getId()}">
								
						   				<div class="col-xs-9 answer-div" >
											
											<span class="by-whom">
												<span class="nameA">${advisor.getName()} </span> answered
											</span>
											<p  class="answer-to-question">
													${answer.getAnswer()} 
											</p>
						   				</div>
									</c:if>
				   				</c:if>
				   				
				   			</c:forEach>
				   				
							</c:forEach>
				   				
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>

			   				</div>		
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
                    <div class="rel-section poptags ">
                        <h2>POPULAR CATEGORIES</h2>
                        
                    </div>
	   			</div>
   			</div>
   	<!-- 		<div class="load-more-div col-xs-12" style="margin-top:30px;">
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

function OpenAskAQuestion(){
	if(<%=isUserVerified%>){
		$('#askquestion').modal('show');
		$("#userverificationmodal").modal("hide");
	}else{
		$("#userverificationmodal").modal("show");
	}	
}
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
			+'</div> ';
			

		return html;
}
function answercard(value){
	var html = '<div class="col-xs-9 answer-div">'
	+'<span class="by-whom">'
	+'<span class="nameA">'+value.name+' </span> answered'
	+'</span>'
	+'<p class="answer-to-question">'
	+ value.answer
	+'</p>'
	+'</div>';
	return html;
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
	    $('.white-body-div').html('');
		$.ajax({
	        url : 'GetSubcategoryQuestions', // Your Servlet mapping or JSP(not suggested)
	        data : {"category":cat[0],"subcategory":cat[1]},
	        type : 'POST',
	        dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	        success : function(response) {

	        	var qcard="";
          		var acard="";
	          	var obj = JSON.parse(response);
	          	$.each(obj, function(key,value) {
	          		if(typeof value.answer != "undefined"){
	          			acard =acard+ answercard(value);
	          		}else{
	          			qcard = qcard+ questioncard(value);
	          			var card = qcard + acard;
	          			card = card  +'</p>'
	        			+'</div>'
	        			+'<div class="col-xs-11">'
	        			+'<div style="border-bottom: 1px solid lightgray;"></div>'
	        			+'</div>'

	        			+'</div>';
	        	        $('.white-body-div').append(card);
	        	        qcard="";
	        	        acard="";
	          		}
	          		 
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

		        	var qcard="";
	          		var acard="";
		          	var obj = JSON.parse(response);
		          	$.each(obj, function(key,value) {
		          		if(typeof value.answer != "undefined"){
		          			acard =acard+ answercard(value);
		          		}else{
		          			qcard = qcard+ questioncard(value);
		          			var card = qcard + acard;
		          			card = card  +'</p>'
		        			+'</div>'
		        			+'<div class="col-xs-11">'
		        			+'<div style="border-bottom: 1px solid lightgray;"></div>'
		        			+'</div>'

		        			+'</div>';
		        	        $('.white-body-div').append(card);
		        	        qcard="";
		        	        acard="";
		          		}
		          		 
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
</script>
</body>
</html>