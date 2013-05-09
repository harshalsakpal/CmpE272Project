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

<div class="container">
	 
	<header class="row">
	<div class="span12">
		<nav class="navbar">
			<div class="navbar-inner">
				<a href="#" class="brand"> Car Prediction </a>
				
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				
				<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<li><a href="#">Home</a> </li>
					
					<li class="divider-vertical"></li>
					<li><a href="#">Blog</a> </li>
					
					<li class="divider-vertical"></li>
					<li><a href="#">About Us</a> </li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown"> 
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Connect
							<b class="caret"></b>
						</a>
						
						<ul class="dropdown-menu">
							<li><a href="#">twitter</a> </li>
							<li><a href="#">facebook</a> </li>
							<li><a href="#">google+</a> </li>
							<li class="divider"></li>
							<li><a href="#">contact</a> </li>
						</ul>
					
					</li>
					
					<li class="divider-vertical"></li>
					
				</ul>
			</div>
			</div>
		</nav>
	</div>
	
	</header>
	
	
	<div class="row" id="main-content">
	<div class="span4" id="sidebar">
	
	<div class="well">
	<form>
		<fieldset>
			<legend>Login</legend>
			<input type="text" class="input-block-level" placeholder="username">
			<input type="text" class="input-block-level" placeholder="password">
			<label class="checkbox">
				<input type="checkbox">Remember Me
			</label>
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" value="Login">
				<a class="btn btn-info" href="#register" role="button" data-toggle="modal">Register</a>
			</div>
		</fieldset>
	</form>
	
	</div>
	
	<div class="accordion" id="questions">
	
		<div class="accordion-group">
		
			<div class="accordion-heading">
			
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions" href="#who">Who? </a>
				
			</div>
			
			<div id="who" class="accordion-body collapse">
			
				<div class="accordion-inner">
				
					<p>Car Prediction</p>
				
				</div>
			
			</div>
			
		</div>
		
	</div>
	
	</div>
	<div class="span8"></div>
	</div>
	<footer class="row"></footer>
	
	</div> <!-- End of container -->
	
	<div id="register" class="modal hide fade" aria-labelledby="modalLabel" aria-hidden="true">
	
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></button>
			<h3 id="modalLabel">Register</h3>
		</div>
		
		<div class="modal-body">
		<form>
		
		<p class="label label-info">required</p>
		
			<div class="controls controls-row">
				<input type="text" class="span2" placeholder="First Name">
				<input type="text" class="span2" placeholder="Last Name">
				
				<select class="span1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>			
			</div>
			
			<div class="controls control-group info">
				<input type="text" class="span5" placeholder="username" id="inputinfo">
				<input type="text" class="span5" placeholder="email" id="inputinfo">
				<input type="text" class="span5" placeholder="confirm email" id="inputinfo">
			
			</div>
			
			<p class="help-block">I would like to learn:
				<a href="#" id="tip" rel="tooltip" data-animation="true" data-original-title="Cool tip" 
				data-placement="right">Tip</a>
			</p>
			
			<label class="checkbox inline">
				<input type="checkbox">HTML/CSS
			</label>
			
			<label class="checkbox inline">
				<input type="checkbox">Javascript
			</label>
			
			<label class="checkbox inline">
				<input type="checkbox">PHP
			</label>
			
			
		</form>
		
		</div>
		
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancel</button>
			<button class="btn btn-success" >Register</button>
		</div>
		
	</div>


    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-1.9.1.js"></script>
    
    <script type="text/javascript">
    
		$("#tip").tooltip();
    
    </script>
    
</body>
</html>