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
                List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("questions");
                String[] higherStudiesSubCategory = (String[])request.getAttribute("higherStudiesSubCategory");
                List<String> industrySubCategory = (List<String>)request.getAttribute("industrySubCategory");
                List<String> optionsSubCategory = (List<String>)request.getAttribute("optionsSubCategory");
                List<QuestionsDTO> mostViewedQuestions = (List<QuestionsDTO>)request.getAttribute("mostViewedQuestions");
                List<String> popCats = (List<String>)request.getAttribute("popCats");

        		pageContext.setAttribute("ids", ids);
	

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
			   			<span class="answers-count">32 Answers</span>
			   			<button type="button" class="btn red-button ask-question-button" data-toggle="modal" data-target="#askquestion">Ask question</button>
			   		</div>
		   			<div class="white-body-div">

		   				<c:forEach items="${questions}" var="question">
 							 <div class="each-question-div row" id="${question.getQuestionId()}">
				   				<div class="col-xs-12 tag-div">
									<span class="tag">${question.getCategory()}</span>
									<span class="tag">${question.getSubcategory()}</span>
				   				</div>
				   				<div class="col-xs-12 question-div">
									<a href="answers?q=${question.getQuestionId()}"><span class="question">${question.getQuestion()}</span></a>
				   					<br>
				   					<span class="count-answers">${question.getCount()} answers</span><span class="updated-on">Last Updated on ${question.getLastUpdated()}</span>
				   				</div> 
				   				<div class="col-xs-9 answer-div">
									<span class="by-whom">
									<span class="nameA">Raghu Venkat </span> answered
									</span>
									<p class="answer-to-question">
									<c:forEach items="${answers }" var="answer">
										<c:if test="${answer.getQuestionId() == question.getQuestionId()}">
											${answer.getAnswer()} <span class="more">more</span>
										</c:if>
									</c:forEach>
									</p>
				   				</div>
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>

			   				</div>		
		   				</c:forEach>	
				   				<div class="col-xs-11">
				   					<div style="border-bottom: 1px solid lightgray;"></div>
				   				</div>
			   				</div>
			   				
			   				
			   		</div>
	   			</div>
	   			<div class="col-xs-3 hidden-xs">
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
$('body').on('click', '.Cfilter', function(e){
	$('.body-content').removeClass('border-top');
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
<script type="text/javascript">
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

</script>
</body>
</html>