<?php
//link php file to database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Assignment3";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
//activate session variables
session_start();

//get each element from the form
$creator =  $_POST["creator"];
$title =  $_POST["title"];
$type =  $_POST["type"];
$identifier =  $_POST["identifier"];
$date =  $_POST["date"];
$language =  $_POST["language"];
$description =  $_POST["description"];

//SQL insert statement to enter form variables into the db
$sql = "INSERT INTO eBook_MetaData (creator, title, type, identifier, date, language, description) VALUES ('$creator', '$title', '$type', '$identifier', '$date', '$language', '$description')";

//carry out SQL query & save result in a variable
$result = $conn->query($sql);

//saves the button click to a session variable
$_SESSION['lastClick'] = 'create';

//redirect back to the main page
header("Location: home.php");

mysqli_close($conn);
?>
