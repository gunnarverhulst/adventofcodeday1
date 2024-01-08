package org.example.day2.game;

import org.example.day2.game.components.Game;

import java.util.stream.Stream;

import static org.example.day2.game.GameFactory.GAME_FACTORY;
import static org.example.day2.utils.InputParser.INPUT_PARSER;

public class GameController {

    private GameType gameType;

    public void createGameType(String cubeConundrumGame) {
        gameType = GAME_FACTORY.createRunningGame(cubeConundrumGame);

    }

    public void handleInputStream(Stream<String> input) {
        input.forEach(this::handleGame);
    }

    private void handleGame(String minigameString) {
        int id = INPUT_PARSER.parseMinigameId(minigameString);
        String cubeDraws = INPUT_PARSER.extractAllCubeDrawsStringFromInput(minigameString);

        if(INPUT_PARSER.parseCubeDraws(cubeDraws).isPresent())
            gameType.addMiniGame(new Game(id, INPUT_PARSER.parseCubeDraws(cubeDraws).get()));

    }

    public long printSumOfIDOfValidGames(){
        return gameType.sumOfValidGames(12,13,14);
    }

    public int calculateSumOfPowerOfMinCubeDrawSet(){

        return gameType.calcSumOfPowerOfMinRequiredCubeDrawSet();
    }
}
