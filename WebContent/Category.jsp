<%
String pageurl = request.getRequestURL().toString();
pageContext.setAttribute("pageurl", pageurl);

%>
       <div class="category-filter-div container no-padding">
  			<div class="col-xs-12 choose-div no-padding-xs">Choose Area of advice</div>
  			<div class="col-xs-12 no-padding">
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bblue" name="bb1" onclick="ga('send', 'event', 'HigherStudiesCategory', 'click', '${pageurl}');"><img class="category-im svg" src="assets/img/home_higher_studies.svg">
  							<br class="hidden-xs"><span>Higher studies</span></button>
  							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Solve all your doubts regarding higher studies and how to prepare for it.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bpink" name="bb2" onclick="ga('send', 'event', 'Career&JobsCategory', 'click', '${pageurl}');"><img class="svg" src="assets/img/home_industry.svg">
  							<br class="hidden-xs"><span>Career & Jobs</span></button>
  						<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs">Explore and understand different career, job options and how to make it in the industry.</span>
  					</div>
  				</div>
  				<div class="col-xs-12 col-sm-4 no-padding-xs">
  					<div class="big-button-div no-padding-xs">
  						<button class="big-button bgreen" name="bb3" onclick="ga('send', 'event', 'CourseCategory', 'click', '${pageurl}');"><img class="svg" src="assets/img/home_courses.svg">
  							<br class="hidden-xs"><span>Course</span></button>
 							<br class="hidden-xs"><br class="hidden-xs">
  						<span class="hidden-xs ">Have all your questions which come to mind while studying in college answered.</span>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="row category-filter-row ">
  		        <span class="glyphicon glyphicon-remove"   aria-hidden="true" style="float: right;" onclick="CloseCategory()"></span>
  				<div class="category-all-filters container">
  				
  					
  				</div>
  			</div>
  			<script>
  			jQuery('img.svg').each(function(){
  	            var $img = jQuery(this);
  	            var imgID = $img.attr('id');
  	            var imgClass = $img.attr('class');
  	            var imgURL = $img.attr('src');


  	            jQuery.get(imgURL, function(data) {
  	                // Get the SVG tag, ignore the rest
  	                var $svg = jQuery(data).find('svg');

  	                // Add replaced image's ID to the new SVG
  	                if(typeof imgID !== 'undefined') {
  	                    $svg = $svg.attr('id', imgID);
  	                }
  	                // Add replaced image's classes to the new SVG
  	                if(typeof imgClass !== 'undefined') {
  	                    $svg = $svg.attr('class', imgClass+' replaced-svg');
  	                }

  	                // Remove any invalid XML tags as per http://validator.w3.org
  	                $svg = $svg.removeAttr('xmlns:a');

  	                // Replace image with new SVG
  	                $img.replaceWith($svg);

  	            }, 'xml');

  	        });
			
  			$('body').on('click', '.big-button', function(e){
  				 var color = $(this).attr('name');
  				var location = window.location;
  				 	$('.big-button').css('background-color','white');
  				 	$('.big-button').removeClass('whitepath');
  				 	$('.big-button').css('color','#4a4a4a');
  				 	$(this).css('color','white');
  				 	$(this).addClass('whitepath');
  					 if(color=='bb1')
  					 {
  						var databb1="";
  						var option1="";
  					 	$(this).css('background-color','#00b9ff');
  					 	$('.category-filter-row').slideDown();
  					 	$('.category-filter-row').css('border-top','4px solid #00b9ff')
  					 	$('#category-menu > option[value="higherstudies"]').prop('selected',true);
  					 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
                        databb1=databb1 + '<a class="col-xs-4 Cfilter" id="higherstudies,${sub}" onclick="ga(\'send\',\'event\',\'HigherStudiesSubCategory\',\'click\',\''+location+':${sub}\');GetResultAccordingToSubCategory(this)">${sub}</a>';
                        option1=option1 + '<option value="${sub}">${sub}</option>';
                        $('#subcategory-menu').html(option1);
                        $('.category-all-filters').html(databb1);
                     </c:forEach>
  					 
  					 }
  					else if(color=='bb2')
  					 {  
  						var databb2="";
  						var option2="";
  					 	$(this).css('background-color','#f2624d');
  					 	$('.category-filter-row').slideDown();
  					 	$('.category-filter-row').css('border-top','4px solid #f2624d')
  					 	$('#category-menu > option[value="industry"]').prop('selected',true);
  					 	<c:forEach items="${industrySubCategory}" var="sub">
					 	   databb2=databb2 + '<a class="col-xs-4 Cfilter" id="industry,${sub}" onclick="ga(\'send\',\'event\',\'Career&JobsSubCategory\',\'click\',\''+location+':${sub}\');GetResultAccordingToSubCategory(this)">${sub}</a>';
					 	  option2=option2 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option2);
					 	   $('.category-all-filters').html(databb2);
  					 	</c:forEach>
  					 }
  					else
  					{
  						var databb3="";
  						var option3="";
  						$(this).css('background-color','#a5cd5b');
  						$('.category-filter-row').slideDown();
  						$('.category-filter-row').css('border-top','4px solid #a5cd5b')
  						$('#category-menu > option[value="options"]').prop('selected',true);
  						<c:forEach items="${optionsSubCategory}" var="sub">
						   databb3=databb3 +'<a class="col-xs-4 Cfilter" id="options,${sub}" onclick="ga(\'send\',\'event\',\'CourseSubCategory\',\'click\',\''+location+':${sub}\');GetResultAccordingToSubCategory(this)">${sub}</a>';
						   option3=option3 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option3);
						   $('.category-all-filters').html(databb3);
  					 	</c:forEach>

  					}
  					
  				});
  			$('body').on('click', '.Cfilter', function(e){
  				$('.collapsed-filter').slideDown();
  				$('.category-filter-div').slideUp();
  				$('.category-filter-row').slideUp();
				var selected =$(this).html();
				$('#subcategory-menu > option[value="'+selected+'"]').prop('selected',true);
  			});
  			function CollapsedCategory(val, categ){
				 	$('.big-button').css('background-color','white');
				 	$('.big-button').removeClass('whitepath');
				 	$('.big-button').css('color','#4a4a4a');
				 	$(this).css('color','white');
				 	$(this).addClass('whitepath');
					 if(categ=='higherstudies')
					 {
						var databb1="";
						var option1="";
					 	$(this).css('background-color','#00b9ff');
					 	$('.category-filter-row').slideDown();
					 	$('.category-filter-row').css('border-top','4px solid #00b9ff')
					 	$('#category-menu > option[value="higherstudies"]').prop('selected',true);
					 	<c:forEach items="${higherStudiesSubCategory}" var="sub">
						   databb1=databb1 + '<a class="col-xs-4 Cfilter" id="higherstudies,${sub}" onclick="GetResultAccordingToSubCategory(this)">${sub}</a>';
						   option1=option1 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option1);
						   $('.category-all-filters').html(databb1);
					 	</c:forEach>
					 
					 }
					else if(categ=='industry')
					 {  
						var databb2="";
						var option2="";
					 	$(this).css('background-color','#f2624d');
					 	$('.category-filter-row').slideDown();
					 	$('.category-filter-row').css('border-top','4px solid #f2624d')
					 	$('#category-menu > option[value="industry"]').prop('selected',true);
					 	<c:forEach items="${industrySubCategory}" var="sub">
					 	   databb2=databb2 + '<a class="col-xs-4 Cfilter" id="industry,${sub}" onclick="GetResultAccordingToSubCategory(this)">${sub}</a>';
					 	  option2=option2 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option2);
					 	   $('.category-all-filters').html(databb2);
					 	</c:forEach>
					 }
					else
					{
						var databb3="";
						var option3="";
						$(this).css('background-color','#a5cd5b');
						$('.category-filter-row').slideDown();
						$('.category-filter-row').css('border-top','4px solid #a5cd5b')
						$('#category-menu > option[value="options"]').prop('selected',true);
						<c:forEach items="${optionsSubCategory}" var="sub">
						   databb3=databb3 +'<a class="col-xs-4 Cfilter" id="options,${sub}" onclick="GetResultAccordingToSubCategory(this)">${sub}</a>';
						   option3=option3 + '<option value="${sub}">${sub}</option>';
						   $('#subcategory-menu').html(option3);
						   $('.category-all-filters').html(databb3);
					 	</c:forEach>

					}
  				$('.collapsed-filter').slideDown();
  				$('.category-filter-div').slideUp();
  				$('.category-filter-row').slideUp();
				var selected =val;
				$('#subcategory-menu > option[value="'+selected+'"]').prop('selected',true);
  			}
  			
  			function CloseCategory(){
  				$('.category-filter-row').slideUp();
  			}
  			</script>
