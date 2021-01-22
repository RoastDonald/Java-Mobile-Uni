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
    /*
    
    select b.id _id, name_game, author\n"+
                    "from Games b inner join Authors a on b.author_id = a.id\n"+
                    "where a.id = ?
    */
}
?>