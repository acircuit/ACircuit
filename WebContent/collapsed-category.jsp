<div class="collapsed-filter hidden-xs" style="padding-top: 11px;">
   						<div class="col-xs-3 Choosec-div" >
   							<span class="Choosec">Choose your category</span>
   						</div>
   						<div class="col-xs-9">
   							<div class="col-xs-4">
   					
   							<select class="collapsed-filter-button" id="category-menu">
								  <option value="1">Higher studies</option>
								  <option value="2">Industry</option>
								  <option value="3">Courses</option>
								 
								</select>
   							</div>
   						<div class="col-xs-4">
   							
   							<select class="collapsed-filter-button" id="subcategory-menu">
								 
							</select>
   						</div>
   						<div class="col-xs-4">
   						<button type="button" class="btn green-button collapsed-search-button" style="width:100%">Search</button>
   						</div>
   						</div>
   					</div>
   					<script>
   					$('#category-menu').on('change', function() {
   		  			 var values= ( this.value ); // or $(this).val()
	   		  		if(values=='1')
						 {
	   		  				var option1="";
						 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
						   option1=option1 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option1);
						 	</c:forEach>
						 }
						else if(values=='2')
						 {  
							var option2="";
							<c:forEach items="${industrySubCategory}" var="sub">
						   option2=option2 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option2);
						 	</c:forEach>
						 }
						else
						{
							var option3="";
							<c:forEach items="${optionsSubCategory}" var="sub">
						   option3=option3 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option3);
						 	</c:forEach>
	
						}
   		  			});
   					</script>