<?php
    header("Content-Type: text/html;charset=UTF-8");
    $conn = mysqli_connect("127.0.0.1","root","root","library");
    mysqli_set_charset($conn,"utf8");

   $seedid = (int)$_POST['seedid'];
   $likebookcode = $_POST['likebookcode'];
   $siblinglikebookcode = $_POST['siblinglikebookcode'];


   $query = "update user set likebookcode = '$likebookcode', siblinglikebookcode = '$siblinglikebookcode' where seedid = $seedid";
   $result = mysqli_query($conn, $query);
   if($result)   
       echo "1";
   else
       echo "-1";
       
    mysqli_close($conn);  
?>