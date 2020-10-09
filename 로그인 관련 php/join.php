<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");
     
   $id = $_POST['u_id'];
   $pw = $_POST['u_pw']; 

$query = "SELECT * FROM user where _id ='$id' and pw='$pw'";
$result = mysqli_query($conn, $query);
$num=mysqli_num_rows($result);
if ($num > 0) {
echo "-1";
} else {
$query = "INSERT INTO USERS(_id, pw, authority) VALUES('$id', '$pw',0)";
$result = mysqli_query($conn, $query);
echo "1";
}

    mysqli_close($conn);
?>