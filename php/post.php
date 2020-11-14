<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $cid = (int)$_POST['cid'];

$query = "SELECT * FROM post where cid = $cid";
$result = mysqli_query($conn, $query);
$res = array();

while($row = mysqli_fetch_array($result)){  
      array_push($res, array('id' =>$row[0], 'title'=>$row[1], 'subtitle'=>$row[2], 'owner'=>$row[3], 'createDate'=>$row[4], 'password'=>$row[5]));  
    }  
          
    echo json_encode(array("result" => $res), JSON_UNESCAPED_UNICODE);       
       
    mysqli_close($conn);  
?>