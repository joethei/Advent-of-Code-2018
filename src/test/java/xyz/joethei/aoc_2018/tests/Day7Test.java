package xyz.joethei.aoc_2018.tests;

import org.junit.jupiter.api.Test;
import xyz.joethei.aoc_2018.AdventOfCode;
import xyz.joethei.aoc_2018.Day;
import xyz.joethei.aoc_2018.Day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    private Day day = new Day7();

    @Test
    void partOne() {
        assertEquals("CABDFE", day.partOne(AdventOfCode.readFile("examples/day7")));
        //assertEquals("3358", day.partOne(AdventOfCode.readFile("puzzle/day7")));
    }

    @Test
    void partTwo() {
        //assertEquals("45909", day.partTwo(AdventOfCode.readFile("puzzle/day7")));
        //assertEquals("16", day.partTwo(AdventOfCode.readFile("examples/day7")));
    }
}