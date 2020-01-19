<?php
require_once 'koneksi.php';
header('Content-Type: application/json');

$query = "SELECT level_user
FROM tbl_user";
$result = mysqli_query($con, $query);
$array = array();
while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}
echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'Gagal menemukan data laporan'));
?>