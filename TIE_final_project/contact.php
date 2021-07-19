<?php
error_reporting(0);
if(isset($_POST)) {
	$Name = $_POST['Name'];
	$email = $_POST['email'];
	$phone = $_POST['phone'];
	$subject = $_POST['subject'];
	$message = $_POST['message'];

	// Database connection
	$conn = new mysqli('localhost','root','','tie_proj');
	if($conn->connect_error){
		echo "$conn->connect_error";
		die("Connection Failed : ". $conn->connect_error);
	} else {
		$stmt = $conn->prepare("INSERT INTO `contact_us` (`Phone`, `Name`, `Email`, `subject`, `message`) VALUES (?, ?, ?, ?, ?)");
		$stmt->bind_param("issss", $phone, $Name, $email, $subject, $message);
		$execval = $stmt->execute();
		echo $execval;
		echo "Your Message was successfully submitted";
		$stmt->close();
		$conn->close();
	}
}
else { echo "No Data";}
?>