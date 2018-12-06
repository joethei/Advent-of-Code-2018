package xyz.joethei.aoc_2018;

import java.util.ArrayList;
import java.util.List;

public class Day6 implements Day {

    private int fieldSize = 1000;

    @Override
    public String getName() {
        return "day6";
    }

    @Override
    public String partOne(List<String> input) {
        int[][] areas = new int[fieldSize][fieldSize];
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                int closest = Integer.MAX_VALUE;
                int lineNr = 0;
                for (String line : input) {
                    lineNr++;


                    String[] split = line.split(", ");
                    int currentX = Integer.parseInt(split[0]);
                    int currentY = Integer.parseInt(split[1]);

                    int distance = calculateManhattanDistance(currentX, x, currentY, y);

                    if(distance == closest) {
                        areas[x][y] = 0;
                    }
                    if (distance < closest) {
                        closest = distance;
                        areas[x][y] = lineNr;
                    }
                }

            }
        }

        //filter out all that touch edges, they would be infinite
        List<Integer> edges = new ArrayList<>();


        for (int i = 0; i < fieldSize-1; i++) {
            int edge = areas[fieldSize-1][i];
            edges.add(edge);

            edge = areas[i][fieldSize-1];
            edges.add(edge);

            edge = areas[i][0];
            edges.add(edge);

            edge = areas[0][i];
            edges.add(edge);
        }

        //count all non infinite
        int[] count = new int[input.size()];
        for (int[] area : areas) {
            for (int area1 : area) {
                if(!edges.contains(area1)) {
                    count[area1 - 1]++;
                }
            }
        }

        int max = 0;

        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }


        return String.valueOf(max);
    }

    @Override
    public String partTwo(List<String> input) {
        return null;
    }

    private int calculateManhattanDistance(int x0, int x1, int y0, int y1) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }
}
