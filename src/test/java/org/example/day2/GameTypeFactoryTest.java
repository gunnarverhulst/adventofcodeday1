package org.example.day2;

import org.example.day2.game.CubeConundrumGameType;
import org.junit.jupiter.api.Test;

import static org.example.day2.game.GameFactory.GAME_FACTORY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTypeFactoryTest {
    public GameTypeFactoryTest() {
    }

    @Test
    void givenGameController_whenStartUp_thenIsNotNull() {

        assertNotNull(GAME_FACTORY.createRunningGame("CubeConundrumGameType"));

    }

    @Test
    void givenGameController_whenStartGame_thenGameIsNotNull() {

        assertNotNull(GAME_FACTORY.createRunningGame("CubeConundrumGameType"));
    }

    @Test
    void givenGAME_CONTROLLER_whenStartGame_thenShouldBeCubeConundrumGame() {
        assertEquals(CubeConundrumGameType.class, GAME_FACTORY.createRunningGame("CubeConundrumGameType").getClass());
    }
}