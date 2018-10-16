<!DOCTYPE html>
<html>
<head>
<style>

* {
    box-sizing: border-box;
}

<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>

body {
    font-family: 'Montserrat';
}

header {
    background-color: #666;
    padding: 20px;
    text-align: center;
    font-size: 30px;
    color: white;
}

nav {
    float: left;
    width: 30%;
    height: 1000px;
    background: #ccc;
    padding: 20px;
}

ul {
    list-style-type: none;
    padding: 0;
}

article {
    float: left;
    width: 70%;
    background-color: #f1f1f1;
    height: 1000px;
}

iframe {
	height: 1000px;
	width: 100%;
	border: none;
}

</style>
</head>

<body>

<header>
<h1>Student Management System</h1>
<%="<h1 align='center'>Welcome, " + session.getAttribute("name") + "</h1>" %>
</header>

<nav>
	<ul>
		<li><a href="AddStudent.jsp" target="home" >Add Student</a></li>
		<li><a href="RemoveStudent.jsp" target="home" >Remove Student</a></li>
		<li><a href="UpdateStudent.jsp" target="home" >Update Student</a></li>    
		<li><a href="ListStudentServlet" target="home" >List Students</a></li>
		<li><a href="LogoutServlet" target="_top" >Logout</a></li>
	</ul>
</nav>

	<article>
		<iframe name='home'></iframe>
	</article>
		
</body>
</html>