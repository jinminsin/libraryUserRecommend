<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $pid = (int)$_POST['pid'];
   $subtitle = $_POST['subtitle'];
   $owner = $_POST['owner'];
   $createDate = $_POST['createDate'];
   $password = $_POST['password'];

   $query = "INSERT INTO comment(pid, subtitle, owner, createDate, password) VALUES($pid, $subtitle, $owner, $createDate, $password)";
   $result = mysqli_query($conn, $query);
   if(!$result)   
       echo "1";
   else
       echo "-1";
       
    mysqli_close($conn);  
?>