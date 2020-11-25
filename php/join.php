<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");
     
   $id = $_POST['id'];
   $pw = $_POST['pw']; 

$query = "SELECT * FROM user where _id ='$id'";
$result = mysqli_query($conn, $query);
$num=mysqli_num_rows($result);
if ($num > 0) {
echo "0";
} else {
   $query = "INSERT INTO USER(_id, pw, authority, likebookcode, siblinglikebookcode) VALUES('$id', '$pw', 0, -1, -1)";
   $result = mysqli_query($conn, $query);

   if($result)   
       echo "1";
   else
       echo "-1";
}

    mysqli_close($conn);
?>