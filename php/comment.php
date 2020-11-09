<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $pid = (int)$_POST['pid'];

$query = "SELECT * FROM comment where pid = $pid";
$result = mysqli_query($conn, $query);
$res = array();

while($row = mysqli_fetch_array($result)){  
      array_push($res, array('id' =>$row[0], 'subtitle'=>$row[1], 'owner'=>$row[2], 'createDate'=>$row[3], 'password'=>$row[4]));  
    }  
       
   echo json_encode($res, JSON_UNESCAPED_UNICODE); 
       
    mysqli_close($conn);  
?>