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

    public String getAuthor() {
        return author;
    }

    public String getNameGame() {
        return nameGame;
    }
     private  final  static ArrayList<Game> GAMES = new ArrayList<Game>(
        Arrays.asList(
                new Game("Watch Dogs", "Ubisoft"),
                new Game("Assassin's Creed","Ubisoft"),
                new Game("Tom Clancy's RainbowSix", "Ubisoft"),
                new Game("Tom Clancy's Ghost Recon", "Ubisoft"),
                new Game("Tom Clancy's The Division", "Ubisoft"),
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
        for(Game b : GAMES){
            if(b.getAuthor().equals(author)){
                gameslist.add(b);
            }
        }
        return  gameslist;
    }

}
