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
        Map<Integer, Map<Integer, AtomicInteger>> mostTimes = new HashMap<>();
        for(String line : input) {
            String[] split = line.split("[^\\d]+");
            if(line.contains("Guard #")) {
                currentGuard = Integer.parseInt(split[6].substring(1));
                if(!times.containsKey(currentGuard)) times.put(currentGuard, new AtomicInteger(0));
                if(!mostTimes.containsKey(currentGuard)) mostTimes.put(currentGuard, new HashMap<>());
            }
            if(line.contains("falls asleep")) {
                startTime = Integer.parseInt(line.substring(15, 17));
            }
            if(line.contains("wakes up")) {
                int currentTime = Integer.parseInt(line.substring(15, 17));
                times.get(currentGuard).getAndAdd(currentTime - startTime);
                for (int i = startTime; i < currentTime; i++) {
                    if(!mostTimes.get(currentGuard).containsKey(i)) mostTimes.get(currentGuard).put(i, new AtomicInteger(0));
                    mostTimes.get(currentGuard).get(i).getAndIncrement();
                }
            }
        }
        int maxGuard = 0;
        int max = 0;
        for(Map.Entry<Integer, AtomicInteger> entry : times.entrySet()) {
            if(entry.getValue().get() > max) {
                maxGuard = entry.getKey();
                max = entry.getValue().get();
            }
        }

        max = 0;
        int time = -1;
        Map<Integer, AtomicInteger> sleepTimes = mostTimes.get(maxGuard);
        for(Map.Entry<Integer, AtomicInteger> entry : times.entrySet()) {
            System.out.println(entry.getValue().get());
            if(entry.getValue().get() > max) {
                time = entry.getKey();
                max = entry.getValue().get();
            }
        }

        return String.valueOf(maxGuard * time);
    }

    @Override
    public String partTwo(List<String> input) {
        return null;
    }
}