<?php
// Database connection setup (replace with your credentials)
$servername = "localhost";
$username = "your_username";
$password = "your_password";
$dbname = "student_marks_db";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Set default values for pagination and search
$page = isset($_GET['page']) ? (int)$_GET['page'] : 1;
$limit = isset($_GET['limit']) ? (int)$_GET['limit'] : 50; // Use a limit like 50 for performance
$offset = ($page - 1) * $limit;
$search = isset($_GET['search']) ? '%' . $_GET['search'] . '%' : '%';

// SQL query with joins for detailed marks
$sql = "
    SELECT
        s.first_name,
        s.last_name,
        c.course_title,
        sc.score_value
    FROM
        students s
    JOIN
        enrollments e ON s.id = e.student_id
    JOIN
        courses c ON e.course_id = c.id
    JOIN
        scores sc ON e.id = sc.enrollment_id
    WHERE
        s.first_name LIKE ? OR s.last_name LIKE ?
    ORDER BY s.last_name
    LIMIT ? OFFSET ?
";

// Prepare and execute the query
$stmt = $conn->prepare($sql);
$stmt->bind_param("ssii", $search, $search, $limit, $offset);
$stmt->execute();
$result = $stmt->get_result();

$marks_data = [];
while ($row = $result->fetch_assoc()) {
    $marks_data[] = $row;
}

// Get the total number of students for pagination
$count_sql = "SELECT COUNT(DISTINCT s.id) FROM students s WHERE s.first_name LIKE ? OR s.last_name LIKE ?";
$count_stmt = $conn->prepare($count_sql);
$count_stmt->bind_param("ss", $search, $search);
$count_stmt->execute();
$count_result = $count_stmt->get_result();
$total_students = $count_result->fetch_row()[0];

// Return data as JSON
header('Content-Type: application/json');
echo json_encode([
    'data' => $marks_data,
    'total_students' => $total_students,
    'current_page' => $page,
    'per_page' => $limit
]);

$conn->close();
?>
