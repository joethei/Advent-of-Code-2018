package xyz.joethei.aoc_2018;

import java.util.*;

public class Day7 implements Day {

    @Override
    public String getName() {
        return "day7";
    }

    private Map<Character, List<Character>> requirements = new HashMap<>();

    @Override
    public String partOne(List<String> input) {

        List<Character> one = new ArrayList<>();
        List<Character> two = new ArrayList<>();
        requirements.forEach((character, characters) -> Collections.sort(characters));


        for (String line : input) {
            String[] split = line.split(" ");
            Character finished = split[1].toCharArray()[0];
            Character begin = split[7].toCharArray()[0];

            if(!requirements.containsKey(finished)) {
                requirements.put(finished, new ArrayList<>());
            }
            requirements.get(finished).add(begin);
            one.add(finished);
            two.add(begin);
        }
        System.out.println(requirements.toString());

        final char[] best = {' '};
        one.forEach(character -> {
            if(!two.contains(character)) {
                best[0] = character;
            }
        });
        System.out.println("best: " + best[0]);

        return recPart1("" + best[0]);
    }


    private String recPart1(String current) {
        char next = ' ';
        char cur = current.charAt(current.length()-1);
        if(requirements.get(cur) == null ||requirements.get(cur).size() == 0) {
            requirements.remove(cur);
        }else {
            next = requirements.get(cur).get(0);
            requirements.get(cur).remove(0);
            current += next;
        }
        if(next != ' ') return recPart1(current + next);
        else return current;
    }

    @Override
    public String partTwo(List<String> input) {
        return null;
    }
}
