package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day;
import xyz.joethei.aoc_2018.Day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    private Day day = new Day6();

    @Test
    void partOne() {
        assertEquals("17", day.partOne(AdventOfCode.readFile("examples/day6")));
        assertEquals("3358", day.partOne(AdventOfCode.readFile("puzzle/day6")));
    }

    @Test
    void partTwo() {
        //assertEquals("4", day.partTwo(AdventOfCode.readFile("examples/day6")));
        //assertEquals("6336", day.partTwo(AdventOfCode.readFile("puzzle/day6")));
    }
}