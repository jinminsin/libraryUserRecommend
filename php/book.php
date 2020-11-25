<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $bookcode = $_POST['bookcode'];

$query = "select * from book where bookcode like '$bookcode%' and not ISBNcode = '' order by rand() limit 5";
$result = mysqli_query($conn, $query);
$res = array();

while($row = mysqli_fetch_array($result)){  
      array_push($res, array('name' =>$row[1], 'publisher'=>$row[2], 'author'=>$row[3]));  
    }  
          
    echo json_encode(array("result" => $res), JSON_UNESCAPED_UNICODE);       
       
    mysqli_close($conn);  
?>