<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Search">
		<input type="text" id="auto" onkeyup="FindSuggestions(this)" name="word">
	</form>
	<div id="data">
	</div>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
function FindSuggestions(s) {
	var len = s.value.length;
    if(len>=3){
        $.ajax({
            url : 'GetSuggestions', // Your Servlet mapping or JSP(not suggested)
            data : {"word" : s.value},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
            	var obj = JSON.parse(response);
            	document.getElementById("data").innerHTML= obj[0].word+"with "+ obj[0].hits+" hits" ;
            	
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 
    }
}
</script>
</body>
</html>