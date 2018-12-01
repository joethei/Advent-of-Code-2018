package xyz.joethei.advent_of_code_2018.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 1
 */
public class Day1 {

    public static void main(String[] args) {
        new Day1().partOne();
        new Day1().partTwo();
    }

    private Day1() {

    }

    private List<Integer> readFile() {
        List<Integer> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day1/input.txt"))) {
            for (String line = br.readLine(); line != null; line = br.readLine())
                lines.add(Integer.valueOf(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void partOne() {
        List<Integer> lines = readFile();
        int result = 0;
        for (int i : lines)
            result += i;
        System.out.println("PartOne=" + result);
    }

    private void partTwo() {
        List<Integer> lines = readFile();
        List<Integer> integers = new ArrayList<>();
        int result = 0;
        boolean found = true;
        while(found) {
            for (int i : lines) {
                if (integers.contains(result)) {
                    System.out.println("PartTwo=" + result);
                    found = false;
                    break;
                }
                integers.add(result);
                result += i;
            }
        }

    }
}