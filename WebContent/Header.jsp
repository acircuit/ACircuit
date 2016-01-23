<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%
Boolean isLoggedIn=false;
Boolean isAdv = false;
String username="";
int  userd =0;
int advisord = 0;
if( session.getAttribute("admin") != null &&  (Boolean)session.getAttribute("admin")){
	isLoggedIn=true;
	
	username = "Admin";
}
else if(session.getAttribute("userId") !=null ){
		isLoggedIn=true;
		username=(String)session.getAttribute("username");
		userd = (Integer)session.getAttribute("userId");
}
else if( session.getAttribute("advisorId") !=null){
		isLoggedIn=true;
		isAdv =true;
		username=(String)session.getAttribute("username");
		advisord = (Integer)session.getAttribute("advisorId");
}
String type = request.getParameter("type");
	pageContext.setAttribute("type", type);
%>

<c:choose>
				<c:when test="<%=isLoggedIn %>">
                       <%@include file="/header-inner.jsp" %>
				</c:when>
				<c:otherwise>
					     <div class="div-container-navbar">
			   	<nav class="navbar navbar-default">
					  <div class="container-fluid">
					    <div class="navbar-header">
					    <fmt:bundle basename="ac.resources.Path" prefix="path.">
					        <a class="navbar-brand hidden-xs" href="<fmt:message key="home_secured"/>"><img src="assets/img/horizontal_logo.png" class="" style="max-width:187px;"></a>
					    </fmt:bundle>
					         
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					     <ul class="nav navbar-nav">

					       <!--  <li><a href="advisors?category=all">Experts <span class="sr-only">(current)</span></a></li>
					        <li><a href="questions">Q&A</a></li> -->
					        <li><a href="becomeanadvisor">Be an Advisor</a></li>
					         <li><a href="howitworks">How it Works</a></li>
					          <li><a href="#" onclick="ShowLogin()">Sign In</a></li>
					           <li><a  href="#" style="background-image: none !important"><span data-toggle="modal" data-target="#signupmodal" style="background-color: #f2624d;padding: 7px 10px 10px 10px;border-radius: 3px;color: #fff">Sign up </span></a></li>
					          
					          <!-- 	<li><form class="search-form" action="Search"><input  class="form-control search-box" type="text" placeholder="Search" onkeyup="FindSuggestions(this)" name="word" autocomplete="off">
					          	<div id="headersuggestions" class="dropdown sugg">
					          			
					          	</div></form></li> -->
					      </ul>
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
			   	</div>
			   	<!-- Sidebar -->
					        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
					            <ul class="nav sidebar-nav">
					                
					                <!-- <li>
					                    <a href="advisors?category=all">Experts</a>
					                </li>
					                <li>
					                    <a href="questions">Q&A</a>
					                </li> -->
				                <fmt:bundle basename="ac.resources.Path" prefix="path.">
					                 <li>
					                    <a href="<fmt:message key="home_secured"/>">Home</a>
					                </li>
					                </fmt:bundle>
					                <li>
					                    <a href="becomeanadvisor">Be an Advisor</a>
					                </li>
					                <li>
					                    <a href="howitworks">How it Works</a>
					                </li>
					                <li>
					                    <a onclick="ShowLogin()">Sign In</a>
					                </li>
					           <li><a  href="#" ><span data-toggle="modal" data-target="#signupmodal" style="background-color: #f2624d;padding: 7px 10px 10px 10px;border-radius: 3px;color: #fff">Sign up </span></a></li>
					               
					            </ul>
					        </nav>
					        <!-- /#sidebar-wrapper -->
					       
					         <button type="button" class="hamburger is-closed visible-xs" data-toggle="offcanvas">
					                <span class="hamb-top"></span>
					    			<span class="hamb-middle"></span>
									<span class="hamb-bottom"></span>
					            </button>
					   
					        <img src="assets/img/horizontal_logo.png" class="visible-xs" style=" position: absolute;top: 13px;right: 3%;max-width:214px;">
					   
					        <!--   <form class="search-form"  style="position: absolute;top: -8px;right: 11%;"><input  class="form-control search-box visible-xs" type="text"  placeholder="Search">
					        <div id="headersuggestions" class="dropdown sugg">
					          			
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
				</c:otherwise>
</c:choose>
         	
   	
   	<script type="text/javascript">
    function ShowLogin(){
    	$("#loginmodal").modal("show");
    		document.getElementById("logintocontinueadvisors").style.display = "none";
    		document.getElementById("logintocontinuequestions").style.display = "none";
    }
   	
   	function FindSuggestions(s) {
   		var len = s.value.length;
   	    if(len>=3){
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
   	            	
   	            },
   	            error : function(request, textStatus, errorThrown) {
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
   	<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-58914838-1', 'auto');
  ga('send', 'pageview');

</script>
<!--Start of Zopim Live Chat Script-->
<script type="text/javascript">
window.$zopim||(function(d,s){var z=$zopim=function(c){z._.push(c)},$=z.s=
d.createElement(s),e=d.getElementsByTagName(s)[0];z.set=function(o){z.set.
_.push(o)};z._=[];z.set._=[];$.async=!0;$.setAttribute("charset","utf-8");
$.src="//v2.zopim.com/?3O1oN7WcsBdgCN1h4zUZeEgf0nCudKAr";z.t=+new Date;$.
type="text/javascript";e.parentNode.insertBefore($,e)})(document,"script");
</script>
<!--End of Zopim Live Chat Script-->
