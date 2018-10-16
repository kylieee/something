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

	<title>New Student Form</title>
</head>
<body>

<form action="AddStudServlet" method="get">

    <h1>Add Student</h1>
    <hr>
	
	<p>
    <label for="name"><b>Name: </b></label>
    <input type="text" placeholder="Enter Name" name="name" required><br>
	</p>

	<p>
    <label for="contact"><b>Contact: </b></label>
    <input type="number" placeholder="Enter Contact" name="contact" required><br>
	</p>
				
	<p>
	<label for="gender"><b>Gender: </b></label>
	<input type="radio" name="gender" value="male"> Male
	<input type="radio" name="gender" value="female"> Female
	</p>
	
    <div>
      <button type="submit" class="signupbtn">Add</button>
      <button type="button" class="cancelbtn">Clear</button>
    </div>

</form>


</body>
</html>
