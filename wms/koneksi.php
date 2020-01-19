<?php
// mengkoneksikan ke database
$server = "localhost";
$server_username = "root";
$server_password = "";
$database_name = "db_wms";
$con = new Mysqli($server, $server_username, $server_password, $database_name);