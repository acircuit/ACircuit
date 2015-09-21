<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <div class="div-container-navbar">
			   	<nav class="navbar navbar-default">
					  <div class="container-fluid">
					    <div class="navbar-header">
					    <fmt:bundle basename="ac.resources.Path" prefix="path.">
					         <a class="navbar-brand hidden-xs" href=<fmt:message key="home"/>><img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo"></a>
					    </fmt:bundle>
					         
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">

					        <li><a href="advisors?category=all">Experts <span class="sr-only">(current)</span></a></li>
					        <li><a href="questions">Q&A</a></li>
					        <li><a href="#">Be an Advisor</a></li>
					         <li><a href="#">How it Works</a></li>
					          <li><a href="logout">Logout</a></li>
					          	<li><form class="search-form" action="Search"><input  class="form-control search-box" type="text" placeholder="Search" onkeyup="FindSuggestions(this)" name="word" autocomplete="off">
					          	<div id="headersuggestions" class="dropdown sugg">
					          			
					          	</div></form></li>
					          	<ul class="nav navbar-nav navbar-right ">
						          	 <li class="dropdown">
							          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="assets/img/phone.png"><span class="badge">2</span></a>
							          <ul class="dropdown-menu notify-div-dropdown" style="min-width: 273px;padding: 0px;border: 0px;">
										  <a href="#" class="list-group-item">Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in Dapibus ac facilisis in nhjnjjkjnk <span class="badge">9:30pm</span></a>
										  <a href="#" class="list-group-item">Morbi leo risus <span class="badge">9:30pm</span></a>
										  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
										  <a href="#" class="list-group-item">Vestibulum at eros</a>
							          </ul>
							        </li>
							          <li><a href="#"><img src="assets/img/Abhishek.JPG" style="width: 32px;height: 32px;border-radius: 50%;"></a></li>
						        </ul>
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			   	<!-- Sidebar -->
					        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
					            <ul class="nav sidebar-nav">
					                
					                <li>
					                    <a href="#">Experts</a>
					                </li>
					                <li>
					                    <a href="#">Q&A</a>
					                </li>
					                <li>
					                    <a href="#">Be an Advisor</a>
					                </li>
					                <li>
					                    <a href="#">How it Works</a>
					                </li>
					                <li>
					                    <a data-toggle="modal" data-target="#loginmodal">Login In</a>
					                </li>
					               
					            </ul>
					        </nav>
					        <!-- /#sidebar-wrapper -->
					       
					         <button type="button" class="hamburger is-closed visible-xs" data-toggle="offcanvas">
					                <span class="hamb-top"></span>
					    			<span class="hamb-middle"></span>
									<span class="hamb-bottom"></span>
					            </button>
					       
					         <form class="search-form"  style="position: absolute;top: -8px;right: 11%;"><input  class="form-control search-box visible-xs" type="text"  placeholder="Search">
					        <!--  <div id="headersuggestions" class="dropdown sugg">
					          			
					          	</div> --></form>


			          	
   	<script>
   	$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      hamburger_cross();      
    });

    function hamburger_cross() {

      if (isClosed == true) {          
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      } else {   
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }
  }
  
  $('[data-toggle="offcanvas"]').click(function () {
        $('#wrapper').toggleClass('toggled');
  });  

   		
	});
   	</script>
   	<script type="text/javascript">
   	function FindSuggestions(s) {
   		var len = s.value.length;
   	    if(len>=3){
   	   	 $('.black-screen').show();
   	        $.ajax({
   	            url : 'GetSuggestions', // Your Servlet mapping or JSP(not suggested)
   	            data : {"word" : s.value},
   	            type : 'POST',
   	            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
   	            success : function(response) {
   	            	if(response != "nosuggestion"){
   	   	            document.getElementById("headersuggestions").innerHTML="";
   	            	var obj = JSON.parse(response);
   	            	//document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
   	            	$.each(obj, function(key,value) {
	   	            	var html='	<div class="hsuggestion">'+value.word+'</div>';
	   	            	$('.sugg').append(html);
	   	            	$('.hsuggestion').show();
   	            	}); 
   	            	/* alert(obj[0].word+"with "+ obj[0].hits+" hits"); */
   	            	}else{
   	   	   	            document.getElementById("headersuggestions").innerHTML="";
	   	            	$('.hsuggestion').hide();
   	            	}
   	           	    $('.black-screen').hide();
   	            	
   	            },
   	            error : function(request, textStatus, errorThrown) {
   	                alert(errorThrown);
   	            }
   	        }); 
   	    }
   	}
   	$('body').on('focus', '.search-box', function(e){
   		$('.hsuggestion').show();
   		$('#bs-example-navbar-collapse-1 ul li:not(:last)').hide();
   		$('#bs-example-navbar-collapse-1 ul').addClass('inc-searchulli');
   		$('#bs-example-navbar-collapse-1 ul li:last').addClass('inc-searchulli');
   		$('.search-form').addClass('inc-searchbox');
    }).on('blur',".search-box", function() {
    	$('#bs-example-navbar-collapse-1 ul li').show();
    	/* $('.hsuggestion').hide(); */
    	$('#bs-example-navbar-collapse-1 ul').removeClass('inc-searchulli');
   		$('#bs-example-navbar-collapse-1 ul li:last').removeClass('inc-searchulli');
    	$('.search-form').removeClass('inc-searchbox');
    });
   	
   	$('body').on('click', '.hsuggestion', function(e){
   		var suge= $(this).html();
   		$('.search-box').val(suge);
   		$('.hsuggestion').hide();
    });
   	
   	</script>
