<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Assignment3</title>
</head>
<body>
  <h1 style="font-weight: bold; margin:20px;">Book Database</h1>

  <div class="col-container">
    <div class="col" id="createForm">
        <form action="insertData.php" method="POST">
	    <h4 style="color:white; font-weight:bold">New Book Entry</h4>
            <input type="text" name="creator" placeholder="Creator">
            <input type="text" name="title" placeholder="Title">
            <input type="text" name="type" placeholder="Type">
            <input type="text" name="identifier" placeholder="Identifier">
            <input type="date" name="date" placeholder="Date">
            <input type="text" name="language" placeholder="Language">
            <input type="text" name="description" placeholder="Description">
            <input class="button" type="submit" value="Submit">
        </form>
    </div>

	<div class="col" id="updateForm">
        <form action="updateData.php" method="POST">
	    <h4 style="color:white; font-weight:bold">Update Existing Entry</h4>
            <input type="text" name="id" placeholder="Book ID">
            <input type="text" name="creator" placeholder="Creator">
            <input type="text" name="title" placeholder="Title">
            <input type="text" name="type" placeholder="Type">
            <input type="text" name="identifier" placeholder="ISBN">
            <input type="date" name="date" placeholder="Date">
            <input type="text" name="language" placeholder="Language">
            <input type="text" name="description" placeholder="Description">
            <input class="button" type="submit" value="Update">
        </form>
	</div>
	
	<div class="col" id="deleteForm">
        <form action="deleteData.php" method="POST">
	    <h4 style="color:white; font-weight:bold">Delete Entry </h4>
            <input type="text" name="id" placeholder="Enter Row ID">
            <input class="button" type="submit" value="Delete">
        </form>
	</div>
  </div>

	<form id="undoButton" action="undoAction.php">
		<input class="button" type="submit" value="Undo Last Action">
	</form>

    <table>
        <thead>
	    <tr>
		<th>ID</th>
		<th>Creator</th>
		<th>Title</th>
		<th>Type</th>
		<th>Identifier</th>
		<th>Date</th>
		<th>Language</th>
		<th>Description</th>
        </tr>
	</thead>

	<tbody>
		<?php
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
		//select entire database
		$sql = "SELECT * FROM eBook_MetaData";
		$result = $conn->query($sql);

		if ($result->num_rows > 0) {
		 while($rows = $result->fetch_assoc())
		    { 
		      //display db row values in table
		      echo "
  		      <tr>
  		        <td>".$rows["id"]."</td>
 		        <td>".$rows["creator"]."</td>
  		        <td>".$rows["title"]."</td>
				<td>".$rows["type"]."</td>
				<td>".$rows["identifier"]."</td>
				<td>".$rows["date"]."</td>
				<td>".$rows["language"]."</td>
				<td>".$rows["description"]."</td>
 		     </tr>
		     ";
		   }
		} else {
		    echo "0 results";
		}
		$conn->close();
		?>
	</tbody>
	</table>
</body>
</html>


