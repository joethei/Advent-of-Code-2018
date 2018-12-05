package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    private Day1 day = new Day1();

    @Test
    void partOne() {
        assertEquals("1", day.partOne(AdventOfCode.readFile("examples/day1")));
        assertEquals("502", day.partOne(AdventOfCode.readFile("puzzle/day1")));
    }

    @Test
    void partTwo() {
        assertEquals("14", day.partTwo(AdventOfCode.readFile("examples/day1")));
        assertEquals("71961", day.partTwo(AdventOfCode.readFile("puzzle/day1")));
    }

}