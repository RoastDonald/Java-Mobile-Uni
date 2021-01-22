package com.example.students;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private String nameGame;
    private String author;
    public Game(String nameGame, String author){
        this.author = author;
        this.nameGame = nameGame;
    }

    public static ArrayList<Game> getGames() {
        return getGames("");
    }

    public String getAuthor() {
        return author;
    }

    public String getNameGame() {
        return nameGame;
    }
     private  final  static ArrayList<Game> games = new ArrayList<Game>(
        Arrays.asList(
                new Game("Watch Dogs", "Ubisoft"),
                new Game("Assassins Creed","Ubisoft"),
                new Game("Tom Clancys RainbowSix", "Ubisoft"),
                new Game("Tom Clancys Ghost Recon", "Ubisoft"),
                new Game("Tom Clancys The Division", "Ubisoft"),
                new Game("The Crew", "Ubisoft"),
                new Game("Anno 1800", "Ubisoft"),
                new Game("Steep", "Ubisoft"),
                new Game("For Honor", "Ubisoft"),
                new Game("FIFA", "Electronic Arts"),
                new Game("Apex Legends","Electronic Arts"),
                new Game("The Sims", "Electronic Arts"),
                new Game("Battlefield", "Electronic Arts"),
                new Game("Need For Speed", "Electronic Arts"),
                new Game("Star Wars: The Old Republic", "Electronic Arts"),
                new Game("Titanfall", "Electronic Arts"),
                new Game("Mass Effect", "Electronic Arts"),
                new Game("Spore", "Electronic Arts"),
                new Game("Star Wars: Battlefront", "Electronic Arts"),
                new Game("Company Of Heroes", "Relic Entertainment"),
                new Game("Warhammer 40,000", "Relic Entertainment"),
                new Game("Homeworld", "Relic Entertainment"),
                new Game("Age Of Empires", "Relic Entertainment"),
                new Game("Impossible Creatures", "Relic Entertainment")



        )
     );
    public static  ArrayList<Game> getGames (String author){
        ArrayList<Game> gameslist = new ArrayList<>();
        for(Game g : games){
            if(g.getAuthor().equals(author) || (author == "")) {
                gameslist.add(g);
            }
        }
        return  gameslist;
    }


    @Override
    public String toString() {return nameGame;}

}
