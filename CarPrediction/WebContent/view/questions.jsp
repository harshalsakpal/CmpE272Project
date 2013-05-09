<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="edu.sjsu.cmpe272.beans.AnswerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.sjsu.cmpe272.beans.QuestionsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/CarPred/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link rel="stylesheet" href="/CarPred/css/style.css" type="text/css">
<title>Questions</title>
</head>
<body>
	<div class="container">
		<div class="row" id="main-content">

			<div class="well">
				<form method="post">
				<input type="hidden" name="selectedAnswers" id="selectedAnswers" value="" />
					<fieldset>
						<legend>Questions</legend>
							<%List<QuestionsBean> questionList = (ArrayList<QuestionsBean>)session.getAttribute("questionList");
							Map<Integer, List<AnswerBean>> mapOfQandA = (HashMap<Integer, List<AnswerBean>>) request.getAttribute("mapOfQandA");
							for(int key:mapOfQandA.keySet())
							{
								//System.out.println("The question id is ==> " +key );%>
								<div id="question" class="question">
								<%=key%> <%=questionList.get(key-1).getQuestionDescription() %>
								</div>
								<%for(AnswerBean answers:mapOfQandA.get(key) )
								{%>
								<div id="answer" class="answer">
								<br><input type="radio" id="answer" name="<%=answers.getQuestionId()%>" value="<%=answers.getAnswerId()%>"></input>&nbsp;&nbsp;<%=answers.getAnswerDescrition() %>							
								
								</div>
								<%}%>
								
							<br>
						<%}%>
						<span id="error" class="error"></span>
							<div class="pull-right">
								<a class="btn btn-info" href="#continue" role="button" data-toggle="modal" onclick="doContinue()">See the Result</a>
							</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="/CarPred/js/bootstrap.min.js"></script>
	<script src="/CarPred/js/jquery-1.9.1.js"></script>
	
	<script type="text/javascript">
	function doContinue(){
		document.getElementById("error").innerHTML = "";
		var j=0;
		var selected = new Array();
	    for (var i = 0; i < document.forms[0].answer.length; i++) {
	        var button = document.forms[0].answer[i];
	        if (button.checked) {
	        	selected[j] = document.forms[0].answer[i].value;
	        	j++;
	        }
	    }
		if(selected.length<5){
			document.getElementById("error").innerHTML = "Answer All the Questions Before Proceeding";
			return false;
		}
		document.forms[0].selectedAnswers.value = selected;
		//$("#selectedAnswers").val(JSON.stringify(selected));
		//document.getElementById('selectedAnswers').value = selected;
		document.forms[0].action = '/CarPred/QuestionAnswerServlet';
		document.forms[0].submit();
	}
	</script>
</body>
</html>