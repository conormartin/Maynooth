<?php
//connect to db
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

//save all form values from home.php as variables
$id = $_POST["id"];
$creator =  $_POST["creator"];
$title =  $_POST["title"];
$type =  $_POST["type"];
$identifier =  $_POST["identifier"];
$date =  $_POST["date"];
$language =  $_POST["language"];
$description =  $_POST["description"];

//save row before updating using a select statement, this is necessary for the undo function to work
$updatedRow = "SELECT * FROM eBook_MetaData WHERE id = $id;";
$result = $conn->query($updatedRow);

//change lastClick variable to update
$_SESSION['lastClick'] = 'update';

//store all pre-updated values as session variables
if ($result->num_rows > 0) {
  while($rows = $result->fetch_assoc()){ 
    $_SESSION["updId"] = $rows["id"];
    $_SESSION["updCreator"] = $rows["creator"];
    $_SESSION["updTitle"] = $rows["title"];
    $_SESSION["updType"] = $rows["type"];
    $_SESSION["updIdentifier"] = $rows["identifier"];
    $_SESSION["updDate"] = $rows["date"];
    $_SESSION["updLanguage"] = $rows["language"];
    $_SESSION["updDescription"] = $rows["description"];
  }
}
else {
    header("Location: home.php");
}

//run update statement to change values of selected row
$sql = "UPDATE eBook_MetaData SET 
creator='$creator', title='$title', type='$type', identifier='$identifier', date='$date', language='$language', description='$description' 
WHERE id ='$id'";

if (mysqli_query($conn, $sql)) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}

//redirect to homepage
header("Location: home.php");

mysqli_close($conn);
?>
