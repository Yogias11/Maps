<?php
require_once 'koneksi.php';
header('Content-Type: application/json');

$query = "SELECT b.id_penerima, MAX(a.status_brg) as status_brg, a.id_brg_keluar, b.status_otb, MAX(a.longitude) as longitude, MAX(a.latitude) as latitude, MAX(a.waktu) as waktu
FROM koordinat a 
INNER JOIN tbl_barang_keluar b ON b.id_barang_keluar = a.id_brg_keluar
GROUP BY a.id_brg_keluar";
$result = mysqli_query($con, $query);
$array = array();
while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}
echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'Gagal menemukan data laporan'));
?>