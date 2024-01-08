package org.example.day2.game;

import org.example.day2.game.components.Game;

import java.util.ArrayList;
import java.util.List;

public class CubeConundrumGameType implements GameType {

    private final List<Game> gameList;

    public CubeConundrumGameType() {
        this.gameList = new ArrayList<>();
    }

    @Override
    public void addMiniGame(Game game) {
        gameList.add(game);
    }

    @Override
    public long sumOfValidGames(int redCubes, int greenCubes, int blueCubes){
        return gameList
                .stream()
                .filter(game -> game.isGameValid(redCubes,greenCubes,blueCubes))
                .mapToInt(Game::getID)
                .sum();
    }

    @Override
    public int calcSumOfPowerOfMinRequiredCubeDrawSet(){

        return gameList.stream()
                .mapToInt(Game::calcPowerRecursive)
                .sum();
    }

}
