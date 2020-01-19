<?php
   require_once 'koneksi.php';
   header('Content-Type: application/json');
   if($_SERVER['REQUEST_METHOD'] == 'POST') {
      $username = isset($_POST['username'])?$_POST['username']:"";
      $password = isset($_POST['password'])?$_POST['password']:"";
      
      $query = $con->query("SELECT *
      FROM tbl_user
      WHERE username = '$username' AND password = '$password'");
      $array = array();
      if($query->num_rows > 0) {
         while ($row = mysqli_fetch_assoc($query)) {
         $array[] = $row;
          } 
            echo json_encode(array('kode' => 1, 'pesan' => 'Login user berhasil', 'result' => $array));
      } else {
         echo json_encode(array("kode" => 0, "pesan" => "username tidak terdaftar"));
      }
   } else {
      echo json_encode(array("kode" => 0, "pesan" => "Request not valid"));
   }
?>