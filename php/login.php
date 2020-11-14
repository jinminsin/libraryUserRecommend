<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");
     
   $id = $_POST['id'];
   $pw = $_POST['pw']; 

$query = "SELECT * FROM user where _id ='$id' and pw='$pw'";
$result = mysqli_query($conn, $query);

if(mysqli_num_rows($result)>0){
$res = array();
while($row = mysqli_fetch_array($result)){  
      array_push($res, array('seedid' =>$row[0], 'id'=>$row[1], 'pw'=>$row[2], 'authority'=>$row[3], 'type'=>$row[4]));  
    }  

    echo json_encode(array('success' => "1", 'result' => $res), JSON_UNESCAPED_UNICODE);  
} else
{
    echo json_encode(array('success' => "-1"), JSON_UNESCAPED_UNICODE);
}
    mysqli_close($conn);
?>