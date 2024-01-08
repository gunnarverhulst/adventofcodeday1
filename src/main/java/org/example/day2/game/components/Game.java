package org.example.day2.game.components;

import java.util.List;

public class Game {
    private final int ID;
    private final List<CubeDraw> cubeDraws;

    public Game(int id, List<CubeDraw> cubeDraws) {
        this.ID = id;
        this.cubeDraws=cubeDraws;
    }

    public int getID() {
        return ID;
    }

    public boolean isGameValid(int redCubes, int greenCubes, int blueCubes){
        return cubeDraws.stream()
                .map(cubeDraw -> cubeDraw.redCubes() <= redCubes && cubeDraw.greenCubes() <= greenCubes && cubeDraw.blueCubes() <= blueCubes)
                .reduce(true, Boolean::logicalAnd);
    }

    public int calcPowerRecursive(){
        CubeDraw cubeDraw = getMinRequiredCubesRecursive(new CubeDraw(0,0,0), cubeDraws);

        return cubeDraw.redCubes() * cubeDraw.greenCubes() * cubeDraw.blueCubes();
    }

    private CubeDraw getMinRequiredCubesRecursive(CubeDraw minRequiredCubes, List<CubeDraw> cubeDraws){

        CubeDraw firstCubeDraw = cubeDraws.getFirst();

        CubeDraw minReq = calculateMin(minRequiredCubes, firstCubeDraw);

        if(cubeDraws.size() > 1)
            return getMinRequiredCubesRecursive(minReq, cubeDraws.subList(1,cubeDraws.size()));
        else
            return minReq;

    }

    private static CubeDraw calculateMin(CubeDraw minRequiredCubes, CubeDraw firstCubeDraw) {
        int minRed = Math.max(firstCubeDraw.redCubes(), minRequiredCubes.redCubes());
        int minGreen = Math.max(firstCubeDraw.greenCubes(), minRequiredCubes.greenCubes());
        int minBlue = Math.max(firstCubeDraw.blueCubes(), minRequiredCubes.blueCubes());
        return new CubeDraw(minRed, minGreen, minBlue);
    }
}
