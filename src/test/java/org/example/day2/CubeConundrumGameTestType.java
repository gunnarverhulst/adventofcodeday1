package org.example.day2;

import org.example.day2.game.CubeConundrumGameType;
import org.example.day2.game.GameType;
import org.example.day2.game.components.CubeDraw;
import org.example.day2.game.components.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CubeConundrumGameTestType {

    private GameType gameType;

    @BeforeEach
    void init(){

        gameType = new CubeConundrumGameType();

    }

    @Test
    void add1ValidMiniGameWith1ValidCubeDraw_SumOfValidGamesisOne(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(0,0,0))));


        assertEquals(1, gameType.sumOfValidGames(12,13,14));
    }

    @Test
    void addInvalidMiniGame_SumOfValidGamesis(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(20,0,0))));


        assertEquals(0, gameType.sumOfValidGames(12,13,14));
    }

    @Test
    void add1ValidMiniGameWith2ValidCubeDraw_SumOfValidGamesisOne(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(1,2,3))));


        assertEquals(1, gameType.sumOfValidGames(12,13,14));
    }

    @Test
    void add1ValidMiniGameWith1Valid1InvalidCubeDraw_SumOfValidGames(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(20,2,3))));


        assertEquals(0, gameType.sumOfValidGames(12,13,14));
    }

    @Test
    void add2ValidMiniGameWith2ValidCubeDraw_SumOfValidGamesisOne(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(1,2,3))));
        gameType.addMiniGame(new Game(2,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(1,2,3))));


        assertEquals(3, gameType.sumOfValidGames(12,13,14));
    }

    @Test
    void add1Valid1InValidMiniGameWith1ValidCubeDraw_SumOfValidGamesisOneReversed(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(20,0,0),
                        new CubeDraw(1,2,3))));
        gameType.addMiniGame(new Game(2,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(1,2,3))));


        assertEquals(2, gameType.sumOfValidGames(12,13,14));
    }


    @Test
    void add1Valid1InValidMiniGameWith1ValidCubeDraw_SumOfValidGamesisOne(){

        gameType.addMiniGame(new Game(1,
                List.of(
                        new CubeDraw(0,0,0),
                        new CubeDraw(1,2,3))));
        gameType.addMiniGame(new Game(2,
                List.of(
                        new CubeDraw(20,0,0),
                        new CubeDraw(1,2,3))));


        assertEquals(1, gameType.sumOfValidGames(12,13,14));
    }


}