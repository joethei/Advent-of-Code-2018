package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    private Day2 day = new Day2();

    @Test
    void partOne() {
        assertEquals("12", day.partOne(AdventOfCode.readFile("examples/day2.1")));
        assertEquals("5904", day.partOne(AdventOfCode.readFile("puzzle/day2")));
    }

    @Test
    void partTwo() {
        assertEquals("fgij", day.partTwo(AdventOfCode.readFile("examples/day2.2")));
        assertEquals("jiwamotgsfrudclzbyzkhlrvp", day.partTwo(AdventOfCode.readFile("puzzle/day2")));
    }
}