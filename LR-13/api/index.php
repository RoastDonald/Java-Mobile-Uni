<?php
require 'config.php';
require 'db.php';
require 'model.php';

header('Content-type: application/json');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-methods: GET, PUT, POST, DELETE, OPTIONS');
header('Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token, Authorization');

$action = $_REQUEST['action'];
if ($action == 'get_authors_list') {
	$data = Model::getAuthorsList();
} elseif($action == 'get_author' && isset($_REQUEST['author_id'])) {
	$author = Model::getAuthor($_REQUEST['author_id']);
	if (count($author) > 0) {
		$data = $author[0];
	} else {
		$data = ['err' => 'brand was not found'];
	}
}elseif ($action == 'get_games_list' && isset($_REQUEST['id']))
{
	$data = Model::getGames($_REQUEST['id']);
}elseif ($action == 'add_author' && $_POST){
    $input = json_decode(file_get_contents('php://input'),true);
    $res = Model::addAuthor($input);
	$data = [
        $res
    ];
}elseif ($action == 'edit_author' && $_POST){
    $input = json_decode(file_get_contents('php://input'),true);
    $res = Model::editAuthor($input);
	$data = [
        $res
    ];
}elseif ($action == 'remove_author' && $_POST){
    $input = json_decode(file_get_contents('php://input'),true);
    $res = Model::removeAuthor($input);
	$data = [
        $res
    ];
}
else {
	$data = ['err' => 'no action was sent'];
}
echo json_encode($data);
