<div class="modal fade" id="askquestion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								      <span class="ask-question-modal-head">Ask Question</span><br>
								      <br>
								      <form class="ask-form" id="ask-form-modal" method="post" enctype="multipart/form-data">
									      <div class="form-group each-form-div"> 
									      	<textarea  class="form-control ask-question"  placeholder="Type your Question" id="question" required></textarea>
									      </div>
									      <br><br>
									       <div class="row">
										       <div class="col-xs-3"><span style="margin-top: 7px;display: block;">Select category :</span></div>
										       <div class="col-xs-9">
											       <div class="col-xs-6">
												     <div class="form-group"> 
												       <select class="form-control collapsed-filter-button" id="category-menu-on-modal" required aria-required="true">
														  <option value="higherstudies">Higher studies</option>
														  <option value="industry">Industry</option>
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
<script>
$(document).ready(function () {
	$("#ask-form-modal").validate();
	
	var option1="";
 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
   option1=option1 + '<option value="${sub}">${sub}</option>';
   console.log(option1);
   $('#subcategory-menu-on-modal').html(option1);
 	</c:forEach>
 	
	
	$('body').on('submit', '#ask-form-modal', function(e){
		e.preventDefault();
		var ques=$('#question').text();
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
	});
});
</script>