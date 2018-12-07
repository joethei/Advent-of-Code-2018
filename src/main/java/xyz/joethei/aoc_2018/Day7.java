package xyz.joethei.aoc_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 implements Day {

    @Override
    public String getName() {
        return "day7";
    }

    @Override
    public String partOne(List<String> input) {
        Map<Character, List<Character>> requirements = new HashMap<>();
        for (String line : input) {
            String[] split = line.split(" ");
            Character finished = split[1].toCharArray()[0];
            Character begin = split[7].toCharArray()[0];

            if(!requirements.containsKey(finished)) {
                requirements.put(finished, new ArrayList<>());
            }
            requirements.get(finished).add(begin);
        }

        char best = ' ';
        for(Character key : requirements.keySet()) {
            System.out.println(key);
            for(List<Character> values : requirements.values()) {
                if(!values.contains(key)) best = key;
                else {

                }
            }
        }
        System.out.println(best);

        for(Map.Entry<Character, List<Character>> entry : requirements.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for(Character c : entry.getValue()) {
                System.out.print(c + " ");
            }
            System.out.println();
        }



        return null;
    }

    @Override
    public String partTwo(List<String> input) {
        return null;
    }
}
