package xyz.joethei.aoc_2018;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 5
 */
public class Day5 implements Day {

    @Override
    public String getName() {
        return "day5";
    }

    @Override
    public String partOne(List<String> input) {

       String result = react(input.get(0));

        return String.valueOf(result.length());
    }

    @Override
    public String partTwo(List<String> input) {
        String in = input.get(0);
        char[] alphabet = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();

        int min = Integer.MAX_VALUE;
        for(char c : alphabet) {
            String tmp = in;
            tmp = tmp.replace("" + c, "");
            tmp = tmp.replace("" + Character.toUpperCase(c), "");
            String reaction = react(tmp);
            if(reaction.length() <= min) {
                min = reaction.length();
            }
        }

        return String.valueOf(min);
    }

    private String react(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        boolean doneNothing = false;
        while (!doneNothing) {
            int doneSomething = 0;
            for (int i = 0; i < stringBuilder.length(); i++) {
                char lastChar = ' ';
                if (i != 0) lastChar = stringBuilder.charAt(i - 1);

                char currentChar = stringBuilder.charAt(i);
                if (Character.toLowerCase(currentChar) == Character.toLowerCase(lastChar)) {
                    if (Character.isUpperCase(lastChar) && Character.isLowerCase(currentChar) || Character.isLowerCase(lastChar) && Character.isUpperCase(currentChar)) {
                        stringBuilder.deleteCharAt(i);
                        if (i != 0) stringBuilder.deleteCharAt(i - 1);
                        doneSomething++;
                    }
                }
            }
            if(doneSomething == 0) doneNothing = true;
        }
        return stringBuilder.toString();
    }
}