package org.example.day2;

import org.example.day2.game.components.CubeDraw;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.day2.utils.InputParser.INPUT_PARSER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class InputParserTest {

    @Test
    void getMinigameIdFromInput(){
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        String input2 = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";

        assertEquals(1, INPUT_PARSER.parseMinigameId(input));
        assertEquals(2, INPUT_PARSER.parseMinigameId(input2));

    }

    @Test
    void extractAllCubeDrawsFromInput(){
        final String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        assertEquals("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",INPUT_PARSER.extractAllCubeDrawsStringFromInput(input));
    }

    @Test
    void extractAllCubeDrawsFromInputWhenNoneProvided(){
        String input = "Game 1: ";

        assertEquals("No CubeDraws provided", INPUT_PARSER.extractAllCubeDrawsStringFromInput(input));

    }

    @Test
    void getCubeDrawsStringFromInput(){
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        input = INPUT_PARSER.extractAllCubeDrawsStringFromInput(input);

        assertFalse(INPUT_PARSER.parseCubeDraws(input).isEmpty());
    }

    @Test
    void getCubeDrawsFromString(){
        String input ="3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        CubeDraw firstTestCubeDraw = new CubeDraw(4,0,3);
        CubeDraw secondTestCubeDraw = new CubeDraw(1,2,6);
        CubeDraw thirthTestCubeDraw = new CubeDraw(0,2,0);

        List<CubeDraw> returnedList = INPUT_PARSER.parseCubeDraws(input).get();
        assertEquals(3,returnedList.size());
        assertEquals(firstTestCubeDraw.redCubes(), returnedList.getFirst().redCubes());
        assertEquals(firstTestCubeDraw.greenCubes(), returnedList.getFirst().greenCubes());
        assertEquals(firstTestCubeDraw.blueCubes(), returnedList.getFirst().blueCubes());

        assertEquals(secondTestCubeDraw.redCubes(), returnedList.get(1).redCubes());
        assertEquals(secondTestCubeDraw.greenCubes(), returnedList.get(1).greenCubes());
        assertEquals(secondTestCubeDraw.blueCubes(), returnedList.get(1).blueCubes());

        assertEquals(thirthTestCubeDraw.redCubes(), returnedList.get(2).redCubes());
        assertEquals(thirthTestCubeDraw.greenCubes(), returnedList.get(2).greenCubes());
        assertEquals(thirthTestCubeDraw.blueCubes(), returnedList.get(2).blueCubes());
    }



}