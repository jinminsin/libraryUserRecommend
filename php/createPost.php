<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $cid = (int)$_POST['cid'];
   $title = $_POST['title'];
   $subtitle = $_POST['subtitle'];
   $owner = $_POST['owner'];
   $createDate = $_POST['createDate'];
   $password = $_POST['password'];

   $query = "INSERT INTO post(cid, title, subtitle, owner, createDate, password) VALUES($cid, $title, $subtitle, $owner, $createDate, $password)";
   $result = mysqli_query($conn, $query);
   if(!$result)   
       echo "1";
   else
       echo "-1";
       
    mysqli_close($conn);  
?>