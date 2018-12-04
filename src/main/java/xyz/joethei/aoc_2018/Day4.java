package xyz.joethei.aoc_2018;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Johannes Theiner <kontakt@joethei.xyz>
 * @since Day 4
 */
public class Day4 implements Day{

    @Override
    public String getName() {
        return "day4";
    }

    @Override
    public String partOne(List<String> input) {
        Collections.sort(input);
        int currentGuard = 0;
        int startTime = 0;
        Map<Integer, AtomicInteger> times = new HashMap<>();
        for(String line : input) {
            String[] split = line.split("[^\\d]+");
            if(line.contains("Guard #")) {
                currentGuard = Integer.parseInt(split[6].substring(1));
                if(!times.containsKey(currentGuard)) times.put(currentGuard, new AtomicInteger(0));
            }
            if(line.contains("falls asleep")) {
                startTime = Integer.parseInt(line.substring(15, 17));
            }
            if(line.contains("wakes up")) {
                times.get(currentGuard).getAndAdd(Integer.parseInt(line.substring(15, 17)) - startTime);
            }
        }
        Optional<Map.Entry<Integer, AtomicInteger>> guard = times.entrySet().stream().max((o1, o2) -> Math.max(o1.getValue().get(), o2.getValue().get()));
        System.out.println(guard.toString());

        return null;
    }

    @Override
    public String partTwo(List<String> input) {
        return null;
    }
}