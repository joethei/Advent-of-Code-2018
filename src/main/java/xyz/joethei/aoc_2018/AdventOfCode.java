package xyz.joethei.aoc_2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 2
 */
public class AdventOfCode {

    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();
        days.add(new Day1());
        days.add(new Day2());

        for(Day day : days) {
            System.out.println(day.getName());
            System.out.println("partOne: " + day.partOne());
            System.out.println("partTwo: " + day.partTwo());
        }
    }

    static List<String> readFile(String name) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name + ".txt"))) {
            for (String line = br.readLine(); line != null; line = br.readLine())
                lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}