package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day;
import xyz.joethei.aoc_2018.Day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    private Day day = new Day4();

    @Test
    void partOne() {
        assertEquals("240", day.partOne(AdventOfCode.readFile("examples/day4")));
        assertEquals("140932", day.partOne(AdventOfCode.readFile("puzzle/day4")));
    }

    @Test
    void partTwo() {
        assertEquals("4455", day.partTwo(AdventOfCode.readFile("examples/day4")));
        assertEquals("51232", day.partTwo(AdventOfCode.readFile("puzzle/day4")));
    }
}
