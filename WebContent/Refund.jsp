<%
/*
   This is the sample Checkout Page JSP script. It can be directly used for integration with CCAvenue if your application is developed in JSP. You need to simply change the variables to match your variables as well as insert routines (if any) for handling a successful or unsuccessful transaction.
*/
%>
<%@ page import = "java.io.*,java.util.*,com.ccavenue.security.*" %>
<html>
<head>
	<title>Sub-merchant checkout page</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<%

	 int merchant_id = 60380; 
	 Enumeration enumeration=request.getParameterNames();
	 String ccaRequest="";
	 String workingKey ="18F62D2A438A259C8D85C9DB06C73485";
	 String accessCode = "AVUQ04CC64AF66QUFA";
	 
	 String pname="", pvalue="";
	 while(enumeration.hasMoreElements()) {
	      pname = ""+enumeration.nextElement();
	      pvalue = request.getParameter(pname);
	      ccaRequest = ccaRequest +pvalue + "|";
	 }
	 AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
	 String encRequest = aesUtil.encrypt(ccaRequest);
	 out.println(encRequest);
	%>
	<form id="nonseamless" method="post" name="redirect" action="https://login.ccavenue.com/apis/servlet/DoWebTrans"/> 
		<input type="hidden" id="enc_request" name="enc_request" value="<%= encRequest %>">
		<input type="hidden" name="access_code" id="access_code" value="<%= accessCode %>">
		<input type="hidden" name="command" id="command" value="refundOrder">
		<input type="hidden" name="request_type" id="request_type" value="STRING">
		<input type="hidden" name="version" id="version" value="1.1">
		<script language='javascript'>document.redirect.submit();</script>
	</form>	
 </body> 
</html>