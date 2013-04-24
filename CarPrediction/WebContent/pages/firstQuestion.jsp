<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="../css/bootstrap-responsive.css" type="text/css">
<link rel="javascript" href="../js/jquery-1.9.1.js" type="text/javascript">

<title>First Question</title>
</head>
<body>
 <div class="form-wrapper center">
        <div class="well-white bottom20px">
            <div class="padding20px form">
                <form action="registration.php" method="post" accept-charset="utf-8" class="kissmetrics-signup">
                <div class="cf small-inputs">
                    <div class="left">
                        <label>First Name</label>
                        <input type="text" name="fname" value="Your Firstname here!">                    
                      </div>

                    <div class="right">
                        <label>Last Name</label>
                        <input type="text" name="lname" value="Your Lastname here!">                    
                      </div>
                </div>

                <label>Desired Username</label><input type="text" name="name" value="Your Username here!"><label>Email address</label><input type="text" name="email" value="your email here!" class="ajax-email "><label>Password</label><input type="password" name="password" value=""><div class="urlkey-wrapper"><label>Phone Number</label><input type="text" name="phone" value="Enter your Phone Number " class="ajax-url-key "></div><label>Gender</label><input type="radio" name="sex" value="male"> male <input type = "radio" name= "sex" value = "female"> Female<div class="cf"><br>
                    <div class="left">
                        <span class="free-trial">Learn..Innovate!</span>
                    </div>
                    <div class="right">
                        <input type="submit" class="btn btn-success btn-large" value="Get started">
                    </div>
                </div>
                </form>                <span class="by-clicking">By clicking "Get Started" you agree to <a href="#">Terms of Use</a> and <a href="#">Privacy Policy</a>.</span>
            </div>
        </div>
    </div><table>
	<tr>
		<td>Username<input type="text" name="userName">
		</td>
	</tr>
</table>
</body>
</html>