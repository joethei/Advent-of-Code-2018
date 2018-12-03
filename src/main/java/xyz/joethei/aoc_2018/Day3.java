package xyz.joethei.aoc_2018;

import java.util.Arrays;
import java.util.List;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 3
 */
public class Day3 implements Day{

    @Override
    public String getName() {
        return "day3";
    }

    @Override
    public String partOne(List<String> input) {
        int result = 0;
        for(int[] row : generateMatrix(input)) {
            for(int line : row) {
                if(line > 1) result++;
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String partTwo(List<String> input) {
        int[][] squares = generateMatrix(input);
        for(String square2 : input) {
            String[] split = square2.substring(1).split("[^\\d]+");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            boolean found = true;
            x: for (int i = ints[1]; i < ints[3] + ints[1]; i++) {
                for (int j = ints[2]; j < ints[4] + ints[2]; j++) {
                    if (squares[i][j] > 1) {
                        found = false;
                        break x;
                    }
                }
            }
            if (found) return String.valueOf(ints[0]);
        }
        return null;
    }

    private int[][] generateMatrix(List<String> input) {
        int[][] squares = new int[1000][1000];
        for(String square : input) {
            String[] split = square.substring(1).split("[^\\d]+");
            int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            for (int i = ints[1]; i < ints[3] + ints[1]; i++) {
                for (int j = ints[2]; j < ints[4] + ints[2]; j++) {
                    squares[i][j] = squares[i][j] + 1;
                }
            }
        }
        return squares;
    }
}