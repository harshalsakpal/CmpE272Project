<%@page import="edu.sjsu.cmpe272.databaseapi.CarPredictionJDBCDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<title>Home For Website</title>
</head>
<body>
	<form method="post">
		<div class="container">
			<div class="row" id="main-content">
				<div class="span4" id="sidebar">

					<div class="well">

						<fieldset>
							<div class="pull-left">
								<img src="../images/KeyImage.jpg">
							</div>
							<div class="span123">we have an approach that will help you
								to decide what type of car is suitable based on your
								psychological inclination. All Questions are based on current
								the market trend. The answers to these questions are analyzed to
								know your perspective of requirements and according to the
								answers best option is suggested. The main objective of this
								analysis is to make right decision for you.</div>
							<br> <br> <br>
							<legend>Car Prediction For You</legend>
						</fieldset>
					</div>
				</div>
			</div>
			<div class="row" id="main-content">

				<div class="span4" id="sidebar">
					<div class="well">
						<fieldset>
							<br> <input id="emailid" type="text" name="emailid" align="left"
								onkeydown="clearError()" placeholder="email address" /> <span
								id="error" class="errorEmailid"></span> <br> 
								
								<a class="btn btn-info" href="#continue" role="button" data-toggle="modal" onclick="return doContinue()">Continue</a>
						</fieldset>
				</div>
			</div>

		</div>
		</div>
	</form>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery-1.9.1.js"></script>

	<script type="text/javascript">
		function doContinue() {
			var email = $("#emailid").val();
			if (email == "") {
				document.getElementById("error").innerHTML = "Email id is mandatory";
				return false;
			}
			if (!validateEmailid(email)) {
				document.getElementById("error").innerHTML = "Email id is not valid";
				return false;
			}
			document.forms[0].action = '../IntroServlet';
			document.forms[0].submit();
		}

		function validateEmailid(email) {
			var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
			if (pattern.test(email))
				return true;
			else
				return false;
		}

		function clearError() {
			document.getElementById("errorEmailid").innerHTML = "";
		}
	</script>

</body>
</html>