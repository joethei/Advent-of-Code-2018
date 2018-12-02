package xyz.joethei.aoc_2018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 1
 */
class Day1 implements Day{

    @Override
    public String getName() {
        return "day1";
    }

    @Override
    public String partOne(List<String> input) {
        int result = 0;
        for (String line : input)
            result += Integer.valueOf(line);
        return String.valueOf(result);
    }

    @Override
    public String partTwo(List<String> input) {
        List<Integer> integers = new ArrayList<>();
        int result = 0;
        while(true) {
            for (String line : input) {
                if (integers.contains(result)) {
                    return String.valueOf(result);
                }
                integers.add(result);
                result += Integer.valueOf(line);
            }
        }
    }
}