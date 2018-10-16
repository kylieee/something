<!DOCTYPE html>
<html>
<head>

<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<style>
body {
    font-family: 'Montserrat';
}

h2 {
	font-size: 0.8em;
}
</style>

<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>

<form method="POST">

	<h1>LOGIN</h1>
	<hr>
	
	<p>
	<label for="username"><b>Username: </b></label>
	<input type="text" name="username" /><br>
	</p>
	
	<p>
	<label for="password"><b>Password: </b></label>
	<input type ="password" name="password" /><br>
	</p>
	
	<p>
	<input type="submit" value="Submit" name="submit" />
	<input type="reset" value="Clear" /><br>
	</p>
	
	<p>
	Click <a href='Register.html'> here </a> to register.
	</p>
	
</form>

<%
String user = request.getParameter("username");
String pw = request.getParameter("password");

if(request.getParameter("submit") != null){
	if(user.equals("") || pw.equals("")){
		out.print("Username/password cannot be empty");
	}
	else{
		request.setAttribute("username", user);
		request.setAttribute("password", pw);
		request.getRequestDispatcher("LoginServlet").forward(request, response);
	}
}

%>

</body>
</html>