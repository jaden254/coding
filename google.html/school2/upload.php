<?php
// 1. Database connection setup
$servername = "localhost";
$username = "your_username";
$password = "your_password";
$dbname = "student_marks_db";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// 2. Process file upload
if (isset($_POST["submit"])) {
    $file_path = $_FILES['csv_file']['tmp_name'];
    
    // Check if the file is a CSV
    if ($_FILES['csv_file']['type'] != 'text/csv') {
        die("Invalid file type. Please upload a CSV file.");
    }
    
    if (($handle = fopen($file_path, "r")) !== FALSE) {
        $header = fgetcsv($handle); // Read and skip the header row
        
        while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {
            // Assuming your CSV columns match the database tables:
            // students.csv: first_name,last_name
            // scores.csv: enrollment_id,score_value,exam_date

            // Example for inserting student data
            $first_name = $conn->real_escape_string($data[0]);
            $last_name = $conn->real_escape_string($data[1]);
            
            // This is a simplified example; a real-world script would need to handle
            // the logic for linking data across your `students`, `courses`, `enrollments`, and `scores` tables.
            $sql = "INSERT INTO students (first_name, last_name) VALUES ('$first_name', '$last_name')";
            
            if ($conn->query($sql) === TRUE) {
                echo "Record created successfully.<br>";
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
        fclose($handle);
    }
}
$conn->close();
?>
