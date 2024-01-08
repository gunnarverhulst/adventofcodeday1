package org.example.day2.game;

import org.example.day2.game.components.Game;

public interface GameType {

    void addMiniGame(Game game);

    long sumOfValidGames(int redCubes, int greenCubes, int blueCubes);

    int calcSumOfPowerOfMinRequiredCubeDrawSet();
}
