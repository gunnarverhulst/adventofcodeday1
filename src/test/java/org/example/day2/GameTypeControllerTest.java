package org.example.day2;

import org.example.day2.game.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.InputFileReader.INPUT_FILE_READER;

public class GameTypeControllerTest {

    private GameController controller;

    @BeforeEach
    void init(){
        controller = new GameController();
        controller.createGameType("CubeConundrumGameType");
    }

    @Test
    void givenInputOf5Minigames_DoesFirstMinigameHaveCubDraws(){

        controller.handleInputStream(INPUT_FILE_READER.readInputFromStream("inputDay2test.txt"));
        controller.printSumOfIDOfValidGames();

        assertEquals(8,controller.printSumOfIDOfValidGames());
    }

    @Test
    void givenInputstream_DoesFirstMinigameHaveCubDraws(){

        controller.handleInputStream(INPUT_FILE_READER.readInputFromStream("inputDay2test.txt"));
        controller.printSumOfIDOfValidGames();

        assertEquals(8,controller.printSumOfIDOfValidGames());
    }

    @Test
    void givenInputstreamFullInput_DoesFirstMinigameHaveCubDraws(){

        controller.handleInputStream(INPUT_FILE_READER.readInputFromStream("inputDay2.txt"));
        controller.printSumOfIDOfValidGames();

        assertEquals(1734,controller.printSumOfIDOfValidGames());
    }

    @Test
    void calculateSumOfPowerOfMinCubeDrawSet(){

        controller.handleInputStream(INPUT_FILE_READER.readInputFromStream("inputDay2test2.txt"));
        controller.printSumOfIDOfValidGames();
        int sum = controller.calculateSumOfPowerOfMinCubeDrawSet();

        assertEquals(2286,sum);
    }

    @Test
    void calculateFullSetSumOfPowerOfMinCubeDrawSet(){

        controller.handleInputStream(INPUT_FILE_READER.readInputFromStream("inputDay2.txt"));
        controller.printSumOfIDOfValidGames();
        int sum = controller.calculateSumOfPowerOfMinCubeDrawSet();

        assertEquals(70387,sum);
    }

}
