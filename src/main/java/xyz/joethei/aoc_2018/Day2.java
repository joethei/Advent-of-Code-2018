package xyz.joethei.aoc_2018;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 2
 */
public class Day2 implements Day{


    @Override
    public String getName() {
        return "Day 2";
    }

    @Override
    public String partOne() {
        List<String> lines = AdventOfCode.readFile("day2");
        int twice = 0;
        int bla = 0;
        for (String line : lines) {
            Map<Character, AtomicInteger> charCount = new HashMap<>();
            for(char c : line.toCharArray()) {
                if(!charCount.containsKey(c)) charCount.put(c, new AtomicInteger(0));
                charCount.get(c).getAndIncrement();
            }
            boolean two = false;
            boolean three = false;
            for (Map.Entry<Character, AtomicInteger> entry : charCount.entrySet()) {
                int value = entry.getValue().get();
                if(value == 2 && !two) {
                    two = true;
                    twice++;
                }
                if(value == 3 && !three) {
                    three = true;
                    bla++;
                }
            }
        }
        return  twice + "*" + bla + "=" + twice * bla;
    }

    @Override
    public String partTwo() {
        List<String> lines = AdventOfCode.readFile("day2");
        StringBuilder result = new StringBuilder();

        for(String line : lines) {
            for(String line2 : lines) {
                int changes = 0;
                for (int j = 0; j < line.length(); j++) {
                    if(line.charAt(j) != line2.charAt(j)) changes++;
                }
                if(changes == 1) {
                    for (int j = 0; j < line.length(); j++) {
                        if(line.charAt(j) == line2.charAt(j)) result.append(line.charAt(j));
                    }
                    return result.toString();
                }
            }
        }

        return null;
    }
}