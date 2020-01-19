<?php 
 require_once 'koneksi.php';
 header('Content-Type: application/json');
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 	$id_brg_keluar = $_POST['id_brg_keluar'];
 	$longitude = $_POST['longitude'];
 	$latitude = $_POST['latitude'];
 	$query = "INSERT INTO koordinat (id_brg_keluar, longitude, latitude, status_brg) VALUES ('DO00010015-1','$longitude','$latitude', 'Sedang Dikirim')";
 	$exeQuery = mysqli_query($con, $query); 
 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'berhasil menambahkan data')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal ditambahkan'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }
 ?>