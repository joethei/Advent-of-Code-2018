package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    private Day3 day = new Day3();

    @Test
    void partOne() {
        assertEquals("4", day.partOne(AdventOfCode.readFile("examples/day3")));
        assertEquals("115348", day.partOne(AdventOfCode.readFile("puzzle/day3")));
    }

    @Test
    void partTwo() {
        assertEquals("3", day.partTwo(AdventOfCode.readFile("examples/day3")));
        assertEquals("188", day.partTwo(AdventOfCode.readFile("puzzle/day3")));
    }
}