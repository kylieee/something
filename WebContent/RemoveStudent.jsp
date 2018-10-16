<!DOCTYPE html>
<html>
<head>

<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<style>
body {
    font-family: 'Montserrat';
}
</style>

<meta charset="ISO-8859-1">

	<title>Student</title>
</head>
<body>

<form action="RemoveStudServlet" method="get">

    <h1>Remove Student</h1>
    <hr>
	
	<p>
    <label for="studentID"><b>ID: </b></label>
    <input type="number" placeholder="Enter ID" name="studentID" required><br>
	</p>
	
    <div>
      <button type="submit" class="signupbtn">Remove</button>
      <button type="button" class="cancelbtn">Clear</button>
    </div>

</form>

</body>
</html>
