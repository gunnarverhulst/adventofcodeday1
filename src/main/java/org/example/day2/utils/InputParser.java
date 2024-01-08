package org.example.day2.utils;

import org.example.day2.game.components.CubeDraw;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum InputParser {
    INPUT_PARSER;


    private int blue;
    private int green;
    private int red;

    public int parseMinigameId(String input) {
        if(input.contains("Game"))
            return Integer.parseInt(input.substring(5, input.indexOf(":") ));
        else
            return 0;
    }

    public Optional<List<CubeDraw>> parseCubeDraws(String input) {
        List<CubeDraw> cubeDraws = Arrays.stream(input.split(";")).map(this::parseCubeDraw).toList();

        return Optional.of(cubeDraws);
    }

    private CubeDraw parseCubeDraw(String input) {
        List<String> colorKeyValueList = Arrays.stream(input.split(",")).toList();

        resetColorValues();

        colorKeyValueList.forEach(this::assignCollor);

        return new CubeDraw(red, green, blue);

    }

    private void resetColorValues() {
        red = 0;
        green = 0;
        blue = 0;
    }

    private void assignCollor(String x) {
        if(x.contains("red"))
            red = Integer.parseInt(x.substring(0, x.indexOf("red") - 1).trim());
        if(x.contains("green"))
            green = Integer.parseInt(x.substring(0, x.indexOf("green") - 1).trim());
        if(x.contains("blue"))
            blue = Integer.parseInt(x.substring(0, x.indexOf("blue") - 1).trim());
    }

    public String extractAllCubeDrawsStringFromInput(String input) {
        if(input.contains(":") && input.length() > input.indexOf(":") + 2)
            return input.substring(input.indexOf(":") + 2);
        else
            return "No CubeDraws provided";
    }
}
