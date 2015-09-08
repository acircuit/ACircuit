
     <div class="div-container-navbar">
			   	<nav class="navbar navbar-default">
					  <div class="container-fluid">
					    <div class="navbar-header">
					     <a class="navbar-brand hidden-xs" href="https://www.advisorcircuit.com" ><img src="https://www.advisorcircuit.com/assets/img/logo-black.png" class="logo"></a>
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">
					        <li class="active"><a href="#">Experts <span class="sr-only">(current)</span></a></li>
					        <li><a href="#">Q&A</a></li>
					        <li><a href="#">Be an Advisor</a></li>
					         <li><a href="#">How it Works</a></li>
					          <li><a href="#">Login In</a></li>
					          	<li><form class="search-form"><input  class="form-control search-box" type="text" placeholder="Search"></form></li>
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
					                    <a href="#">Login In</a>
					                </li>
					               
					            </ul>
					        </nav>
					        <!-- /#sidebar-wrapper -->
					       
					         <button type="button" class="hamburger is-closed visible-xs" data-toggle="offcanvas">
					                <span class="hamb-top"></span>
					    			<span class="hamb-middle"></span>
									<span class="hamb-bottom"></span>
					            </button>
					       
					         <form class="search-form" style="position: absolute;top: -8px;right: 11%;"><input  class="form-control search-box visible-xs" type="text" placeholder="Search"></form>
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
