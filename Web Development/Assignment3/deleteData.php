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
//activates session variables
session_start();

//get id of row to be deleted from home.php form
$id = $_POST["id"];

//select statement to get data of pre-deleted row
$deletedRow = "SELECT * FROM eBook_MetaData WHERE id = $id;";
$deleteResult = $conn->query($deletedRow);

//change lastClick variable to delete
$_SESSION['lastClick'] = 'delete';

//get value of each element prior to deleting, this is used for the undo function
if ($result->num_rows > 0) {
  while($rows = $deleteResult->fetch_assoc()){ 
    $_SESSION["delId"] = $rows["id"];
    $_SESSION["delCreator"] = $rows["creator"];
    $_SESSION["delTitle"] = $rows["title"];
    $_SESSION["delType"] = $rows["type"];
    $_SESSION["delIdentifier"] = $rows["identifier"];
    $_SESSION["delDate"] = $rows["date"];
    $_SESSION["delLanguage"] = $rows["language"];
    $_SESSION["delDescription"] = $rows["description"];
  }
} else {
    header("Location: home.php");
}

$_SESSION['deletedRow'] = $deletedRow;

//delete row using ID
$sql = "DELETE FROM eBook_MetaData WHERE id = $id;";
$result = $conn->query($sql);

//redirect to homepage
header("Location: home.php");

mysqli_close($conn);
?>
