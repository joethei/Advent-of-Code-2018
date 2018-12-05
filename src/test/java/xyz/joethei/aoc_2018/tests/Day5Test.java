package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day;
import xyz.joethei.aoc_2018.Day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {

    private Day day = new Day5();

    @Test
    void partOne() {
        assertEquals("10", day.partOne(AdventOfCode.readFile("examples/day5")));
        assertEquals("10564", day.partOne(AdventOfCode.readFile("puzzle/day5")));
    }

    @Test
    void partTwo() {
        assertEquals("4", day.partTwo(AdventOfCode.readFile("examples/day5")));
        assertEquals("6336", day.partTwo(AdventOfCode.readFile("puzzle/day5")));
    }
}