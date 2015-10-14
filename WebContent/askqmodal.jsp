<script src="//cdn.ckeditor.com/4.5.4/basic/ckeditor.js"></script>

<div class="modal fade" id="askquestion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Ask Question</span><br>
								      <br>
								      <form class="ask-form" id="ask-form-modal" method="post" enctype="multipart/form-data">
									      <div class="form-group each-form-div"> 
									      	<textarea  class="form-control ask-question"  placeholder="Type your Question" id="question" required maxlength="2000"></textarea>
									      </div>
									      <br><br>
									       <div class="row">
										       <div class="col-xs-12 col-sm-3"><span style="margin-top: 7px;display: block;">Select Area of Advice :</span></div>
										       <div class="col-xs-12 col-sm-9">
											       <div class="col-xs-6">
												     <div class="form-group"> 
												       <select class="form-control collapsed-filter-button" id="category-menu-on-modal" required aria-required="true">
														  <option value="studies">Higher studies</option>
														  <option value="industry">Career & Jobs</option>
														  <option value="options">Courses</option>
														</select>
														 </div>
											       </div>
											       <div class="col-xs-6">
											       	<div class="form-group"> 
												         <select class="form-control collapsed-filter-button" id="subcategory-menu-on-modal" required aria-required="true">
															<option value="">Select Something</option> 
														</select>
														 </div>
											       </div>
											      <br>
											      <br>
											        <div class="col-xs-12" style="margin-top: 21px;">
											        <button type="submit" class="btn red-button ask-question-button" style="float:right">Ask question</button>
											        	<div class="form-group squaredThree" style="float:right;margin-right: 11px;margin-top: -9px;">
														  	<input type="checkbox" id="postanonymously" name="Post anonymously" />
															<label for="postanonymously" style="margin-top: 1px;"></label><span>Post anonymously</span>
													</div>
													
														
											        </div>
										       		
										       </div>
									       </div>
								        </form>
								      </div>
								      
								    </div>
								  </div>
								</div>
									<div class="modal fade" id="userverificationmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								     <p>Please verify your account thrugh the verification link sent to you via email.<a onclick="ResendLink()">Resend Mail</a> </p>
								      </div>
								      
								    </div>
								  </div>
								</div> 
<script>
CKEDITOR.replace( 'question' );
$(document).ready(function () {
	CKEDITOR.config.removePlugins = 'about';
	$("#ask-form-modal").validate();
	
	var option1="";
 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
   option1=option1 + '<option value="${sub}">${sub}</option>';
   console.log(option1);
   $('#subcategory-menu-on-modal').html(option1);
 	</c:forEach>
 	
	
	$('body').on('submit', '#ask-form-modal', function(e){
		e.preventDefault();
		var ques=$('#question').val();
		var cat=$('#category-menu-on-modal').val();
		var subcat=$('#subcategory-menu-on-modal').val();
		console.log(ques.length);
		if(ques.length>0)
		{}
		else
			return false;
		$('.black-screen').show();
		var question =$("#question").val();
		var category = $("#category-menu-on-modal").val();
		var subcategory = $("#subcategory-menu-on-modal").val();
		var url = window.location.href;
		if(url.indexOf("advisors", 0) > -1 || url.indexOf("advisorprofile", 0) > -1) {
			var id  = "${advisor.getId()}";
			$.ajax({
		        url : 'QuestionToAdvisorController', // Your Servlet mapping or JSP(not suggested)
		        data : {"question":question,"category" :category,"subcategory":subcategory,"aid":id},
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
			
		}else{
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
	                alert("Sorry your question could no be posted. Please try again.");
	                
	            }
	        });
		}

	});
});
</script>