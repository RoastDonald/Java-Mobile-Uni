package com.example.students;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Games_genre {
    private int id;
    private String author;
    private String genre;
    private int countryOfIssue;
    private boolean criticallyTestedFlg;
    private boolean onSaleFlg;


    public Games_genre(String author, String genre, int countryOfIssue, boolean criticallyTestedFlg, boolean onSaleFlg){
        this.author = author;
        this.genre = genre;
        this.countryOfIssue = countryOfIssue;
        this.criticallyTestedFlg = criticallyTestedFlg;
        this.onSaleFlg = onSaleFlg;
    }

    public Games_genre(int id, String author, String genre, int countryOfIssue, boolean criticallyTestedFlg, boolean onSaleFlg) {
        this(author, genre, countryOfIssue, criticallyTestedFlg, onSaleFlg);
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public int getCountryOfIssue(){
        return countryOfIssue;
    }

    public boolean isCriticallyTestedFlg(){
        return criticallyTestedFlg;
    }

    public boolean isOnSaleFlg(){
        return onSaleFlg;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCriticallyTestedFlg(boolean criticallyTestedFlg) {
        this.criticallyTestedFlg = criticallyTestedFlg;
    }

    public void setOnSaleFlg(boolean onSaleFlg) {
        this.onSaleFlg = onSaleFlg;
    }

    public void setCountryOfIssue(int countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    private static ArrayList<Games_genre> genreList = new ArrayList<Games_genre>(Arrays.asList(
            new Games_genre("Electronic Arts", "Приключения, шутер, аркада",0,true, true),
            new Games_genre("Ubisoft", "Экшен, шутеры, приключения",0, true, true),
            new Games_genre("Relic Entertainment", "Стратегия, аркада", 1, false, true)
    ));

    public static Games_genre getGenreList(String genre){
        for(Games_genre b: genreList){
            if(b.getAuthor().equals(genre)){
                return b;
            }
        }
        return null;
    }
    public static ArrayList<Games_genre> getGenres() {return genreList;}

    @Override
    public String toString() {return author; }

    public static  void addGenre (Games_genre genre) {
        genreList.add(genre);
    }

    public static  ArrayList<Games_genre>httpGetGenre(){
        ArrayList<Games_genre> arr = new ArrayList<>();
        String res = new HttpDataGetter(
                "http://10.0.2.2/?action=get_authors_list"
        ).getData();
        try{
            JSONArray jsonArray = new JSONArray(res);
            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                arr.add(
                        new Games_genre(
                                obj.getInt("id"),
                                obj.getString("author"),
                                obj.getString("genre"),
                                obj.getInt("countryOfIssue"),
                                (obj.getInt("criticallyTestedFlg")!=0),
                                (obj.getInt("onSaleFlg")!=0)
                        )
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public static  Games_genre httpGetGenre(int $id){
        Games_genre games_genre = null;
        ArrayList<Games_genre> arr = new ArrayList<>();
        String res = new HttpDataGetter(
                "http://10.0.2.2/?action=get_author&author_id=" + Integer.toString($id)
        ).getData();
        try{
            JSONObject obj = new JSONObject(res);

            games_genre =new Games_genre(
                    obj.getInt("id"),
                    obj.getString("author"),
                    obj.getString("genre"),
                    obj.getInt("countryOfIssue"),
                    (obj.getInt("criticallyTestedFlg")!=0),
                    (obj.getInt("onSaleFlg")!=0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return games_genre;
    }

}
