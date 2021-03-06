<?php
//connect to database
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

//if last click was create, run the if statement
if($_SESSION['lastClick']=='create'){
    //SQL query to order db by ID & limit to 1, this saves the most recent db entry as a variable
    $maxIdSql = "SELECT * FROM eBook_MetaData ORDER BY id DESC LIMIT 1";
    $maxIdResult = $conn->query($maxIdSql); 
    //gets the id of this row
    $rows = $maxIdResult->fetch_assoc();   
    $id=$rows['id'];
    
    //deletes the most recently created row
    $sql = "DELETE FROM eBook_MetaData WHERE id = $id;";
    $result = $conn->query($sql);
    //reset lastClick variable so undo button cant be re-clicked
    $_SESSION['lastClick'] = 'reset';
}

//if last click was update, run else if statement
else if($_SESSION['lastClick']=='update'){
    //retrieve all session variables saved in updateData.php file
    $id = $_SESSION["updId"];
    $creator = $_SESSION["updCreator"];
    $title = $_SESSION["updTitle"];
    $type = $_SESSION["updType"];
    $identifier = $_SESSION["updIdentifier"];
    $date = $_SESSION["updDate"];
    $language = $_SESSION["updLanguage"];
    $description = $_SESSION["updDescription"];
    
    //SQL statement to update the row back to previous values
    $sql = "UPDATE eBook_MetaData SET 
    creator='$creator', title='$title', type='$type', identifier='$identifier', date='$date', language='$language', description='$description' 
    WHERE id ='$id'";

    if (mysqli_query($conn, $sql)) {
        echo "Record updated successfully";
    } else {
        echo "Error updating record: " . mysqli_error($conn);
    }

    $_SESSION['lastClick'] = 'reset';
}

//if last click was delete, run this else if statement
else if($_SESSION['lastClick']=='delete'){
    //retrieve all session variables stored in deleteData.php
    $id = $_SESSION["delId"];
    $creator = $_SESSION["delCreator"];
    $title = $_SESSION["delTitle"];
    $type = $_SESSION["delType"];
    $identifier = $_SESSION["delIdentifier"];
    $date = $_SESSION["delDate"];
    $language = $_SESSION["delLanguage"];
    $description = $_SESSION["delDescription"];
    
    //SQL statement to insert the variables back to their previous location with the same ID
    $sql = "INSERT INTO eBook_MetaData (id, creator, title, type, identifier, date, language, description) 
    VALUES ('$id', '$creator', '$title', '$type', '$identifier', '$date', '$language', '$description')";
    $result = $conn->query($sql);

    $_SESSION['lastClick'] = 'reset';
}

//reroute to homepage
header("Location: home.php");

mysqli_close($conn);
?>
