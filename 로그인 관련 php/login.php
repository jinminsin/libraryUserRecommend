<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");
     
   $id = $_POST[u_id];
   $pw = $_POST[u_pw]; 

$result = mysql_query("SELECT * FROM user where _id ='$id' and pw='$pw'");
$num=mysql_num_rows($result);
if ($num > 0) {
echo "1";
} else {
echo "-1";
}


    mysqli_close($conn);
?>