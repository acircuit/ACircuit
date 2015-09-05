
       <div class="category-filter-div container no-padding">
  			<div class="col-xs-12 choose-div no-padding-xs">Choose your area of advice</div>
  			<div class="col-xs-12 no-padding">
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bblue" name="bb1"><img class="category-im" src="assets/img/higher_studies.png">
  							<br class="hidden-xs" ><span>Higher studies</span></button>
  							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bpink" name="bb2"><img src="assets/img/higher_studies.png">
  							<br class="hidden-xs"><span>Industry</span></button>
  						<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bgreen" name="bb3"><img src="assets/img/higher_studies.png">
  							<br class="hidden-xs" ><span>Courses</span></button>
  							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs ">Understand the choices are available to you, the do's and don'ts. Talk to somebody with experience.</span>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="row category-filter-row">
  				<div class="category-all-filters container">
  					
  				</div>
  			</div>
  			<script>
  			$('body').on('click', '.big-button', function(e){
  				 var color = $(this).attr('name');
  				 	$('.big-button').css('background-color','white');
  				 	$(this).css('color','white');
  					 if(color=='bb1')
  					 {
  						var databb1="";
  					 	$(this).css('background-color','#00b9ff');
  					 	$('.category-filter-row').slideDown();
  					 	$('.category-filter-row').css('border-top','4px solid #00b9ff')
  					 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
						   databb1=databb1 + '<a class="col-xs-4 Cfilter" id="${sub}" onclick="GetAdvisorAccordingToSubCategory(this)">${sub}</a>';
  					 	   $('.category-all-filters').html(databb1);
  					 	</c:forEach>
  					 }
  					else if(color=='bb2')
  					 {  
  						var databb2="";
  					 	$(this).css('background-color','#f2624d');
  					 	$('.category-filter-row').slideDown();
  					 	$('.category-filter-row').css('border-top','4px solid #f2624d')
  					 	<c:forEach items="${industrySubCategory}" var="sub">
					 	   databb2=databb2 + '<a class="col-xs-4 Cfilter" id="${sub}" onclick="GetAdvisorAccordingToSubCategory(this)">${sub}</a>';
  					 	   $('.category-all-filters').html(databb2);
  					 	</c:forEach>
  					 }
  					else
  					{
  						var databb3="";
  						$(this).css('background-color','#a5cd5b');
  						$('.category-filter-row').slideDown();
  						$('.category-filter-row').css('border-top','4px solid #a5cd5b')
  						<c:forEach items="${optionsSubCategory}" var="sub">
						   databb3=databb3 +'<a class="col-xs-4 Cfilter" id="${sub}" onclick="GetAdvisorAccordingToSubCategory(this)">${sub}</a>';
  					 	   $('.category-all-filters').html(databb3);
  					 	</c:forEach>
  					}
  					
  				});
  			$('body').on('click', '.Cfilter', function(e){
  				$('.collapsed-filter').slideDown();
  				$('.category-filter-div').slideUp();
  				$('.category-filter-row').slideUp();

  			});
  			
  			</script>
