package org.example.day2.game;

public enum GameFactory {
    GAME_FACTORY;


    public GameType createRunningGame(String gametype) {

        if(gametype.equals("CubeConundrumGameType"))
            return new CubeConundrumGameType();
        else
            return null;
    }
}
