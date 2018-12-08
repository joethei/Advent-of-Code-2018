package xyz.joethei.aoc_2018;

import lombok.Getter;

import java.util.*;

public class Day7 implements Day {

    @Override
    public String getName() {
        return "day7";
    }


    List<Step> steps = new ArrayList<>();

    @Getter
    private class Step {
        private char name;
        private List<Character> childs = new ArrayList<>();
        private List<Character> parents = new ArrayList<>();

        Step(char name) {
            this.name = name;
        }
    }

    private Step getStep(char c) {
        for(Step step : steps) {
            System.out.println(step.name +  "==" + c);
            if(step.name == c) {
                System.out.println(true);
                return step;
            }
        }
        return null;
    }

    @Override
    public String partOne(List<String> input) {

        List<Character> one = new ArrayList<>();
        List<Character> two = new ArrayList<>();


        for (String line : input) {
            String[] split = line.split(" ");
            char finished = split[1].toCharArray()[0];
            char begin = split[7].toCharArray()[0];

            Step step = getStep(finished);

            if(step == null) {
                step = new Step(finished);
            }

            step.getChilds().add(begin);
            steps.add(step);


            one.add(begin);
            two.add(finished);
        }
        System.out.println(steps.size());
        for(Step step : steps) {
            System.out.println(step.getName());
            System.out.println(step.getChilds());
            System.out.println(step.getParents());
        }

        final char[] best = {' '};
        two.forEach(character -> {
            if (!one.contains(character)) {
                best[0] = character;
            }
        });
        System.out.println("best: " + best[0]);

        StringBuilder result = new StringBuilder();
        char next = ' ';


        while(true) {


            break;
        }


        char current = best[0];

        return result.toString();
    }


    @Override
    public String partTwo(List<String> input) {
        return null;
    }
}
