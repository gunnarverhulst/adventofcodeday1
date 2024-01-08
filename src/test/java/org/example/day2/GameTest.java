package org.example.day2;

import org.example.day2.game.components.CubeDraw;
import org.example.day2.game.components.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setup(){
        game = new Game(1,
                List.of(
                        new CubeDraw(4,0,3),
                        new CubeDraw(1,2,20),
                        new CubeDraw(5,2,0)));
    }
    @Test
    void onCreation_hasID(){

        assertEquals(1, game.getID());
    }

    @Test
    void testMinigameValid_withValidInput(){
        game = new Game(1,
                List.of(
                        new CubeDraw(4,0,3),
                        new CubeDraw(1,2,0),
                        new CubeDraw(5,2,0)));

        assertTrue(game.isGameValid(12,13,14));

    }

    @Test
    void testMinigameInvalid_withValidInput(){
        game = new Game(1,
                List.of(
                        new CubeDraw(4,0,3),
                        new CubeDraw(1,2,0),
                        new CubeDraw(20,2,0)));

        assertFalse(game.isGameValid(12,13,14));

    }

}