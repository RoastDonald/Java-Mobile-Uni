<?php

class Model {
	public static function getAuthorsList() {
		return (new DB())->getArrFromQuery(
			"SELECT * FROM `authors` ");
	}

	public static function getAuthor($id) {
		return (new DB())->getArrFromQuery(
            "SELECT * FROM `authors` where id=$id"
        );
	}
    
    
	public static function getGames($id) {
		return (new DB())->getArrFromQuery("select * from Games b inner join Authors a 
        on b.author_id = a.id 
        where a.id = $id");
	}
    
    public static function addAuthor($author){
        return (new DB())->getArrFromQuery("INSERT INTO `authors`(`author`, `genre`, `countryOfIssue`, `criticallyTestedFlg`, `onSaleFlg`) VALUES ('".$author['author']."','".$author['genre']."',
        ".$author['countryOfIssue'].", ".$author['criticallyTestedFlg'].", ".$author['onSaleFlg'].")");
    }
    
    public static function editAuthor($author){
        return (new DB())->getArrFromQuery("UPDATE `authors` SET `author`= '".$author['author']."',`genre`='".$author['genre']."',`countryOfIssue`=".$author['countryOfIssue'].",`criticallyTestedFlg`=".$author['criticallyTestedFlg'].",`onSaleFlg`= ".$author['onSaleFlg']." WHERE `id`= ".$author['id']);
    }
    public static function removeAuthor($author){
        return (new DB())->getArrFromQuery("DELETE FROM `authors` WHERE `id`=".$author['id']);
    }
}
?>