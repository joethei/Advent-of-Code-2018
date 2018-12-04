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
        Map<Integer, AtomicInteger> sleepingTimeSpent = getSleepingTimeSpent(input);
        Map<Integer, Map<Integer, AtomicInteger>> sleepingTimeAtMinute = getSleepingTimeAtMinute(input);

        int maxGuard = 0;
        int max = 0;
        for(Map.Entry<Integer, AtomicInteger> entry : sleepingTimeSpent.entrySet()) {
            if(entry.getValue().get() > max) {
                maxGuard = entry.getKey();
                max = entry.getValue().get();
            }
        }

        max = 0;
        int time = -1;
        Map<Integer, AtomicInteger> sleepTimes = sleepingTimeAtMinute.get(maxGuard);
        for(Map.Entry<Integer, AtomicInteger> entry : sleepTimes.entrySet()) {
            if(entry.getValue().get() > max) {
                time = entry.getKey();
                max = entry.getValue().get();
            }
        }

        return String.valueOf(maxGuard * time);
    }

    @Override
    public String partTwo(List<String> input) {
        //Time, Map<Guard, Times>
        Map<Integer, Map<Integer, AtomicInteger>> guardsSleepingAtMinute = getGuardsSleepingAtMinute(input);


        int maxGuard = 0;
        int maxGuardTimes = 0;
        int maxMinute = 0;

        for(Map.Entry<Integer, Map<Integer, AtomicInteger>> entry : guardsSleepingAtMinute.entrySet()) {
            //System.out.print(entry.getKey());
            for (Map.Entry<Integer, AtomicInteger> entry1 : entry.getValue().entrySet()) {
                //System.out.println(" : " + entry1.getKey() + " | " + entry1.getValue().get());
                //if Guard Times >= maxGuardTimes
                if(entry1.getValue().get() >= maxGuardTimes) {
                    maxGuard = entry1.getKey();
                    maxGuardTimes = entry1.getValue().get();
                    maxMinute = entry.getKey();
                }

            }
        }

        //System.out.println(maxGuard + " * " + maxMinute);
        return String.valueOf(maxGuard * maxMinute);
    }

    //returns Map<Minute, Map<Guard, Times>>
    private Map<Integer, Map<Integer, AtomicInteger>> getGuardsSleepingAtMinute(List<String> input) {
        Collections.sort(input);
        int currentGuard = 0;
        int startTime = 0;
        Map<Integer, Map<Integer, AtomicInteger>> guardsSleepingAtMinute = new HashMap<>();
        for(String line : input) {
            String[] split = line.split("[^\\d]+");
            if(line.contains("Guard #")) {
                currentGuard = Integer.parseInt(split[6]);
            }
            if(line.contains("falls asleep")) {
                startTime = Integer.parseInt(line.substring(15, 17));
            }
            if(line.contains("wakes up")) {
                int currentTime = Integer.parseInt(line.substring(15, 17));
                for (int i = startTime; i < currentTime; i++) {
                    if(!guardsSleepingAtMinute.containsKey(i)) guardsSleepingAtMinute.put(i, new HashMap<>());
                    if(!guardsSleepingAtMinute.get(i).containsKey(currentGuard)) guardsSleepingAtMinute.get(i).put(currentGuard, new AtomicInteger(0));
                    guardsSleepingAtMinute.get(i).get(currentGuard).getAndIncrement();
                }
            }
        }
        return guardsSleepingAtMinute;
    }

    //returns Map<Guard, Time spend sleeping>
    private Map<Integer, AtomicInteger> getSleepingTimeSpent(List<String> input) {
        Collections.sort(input);
        int currentGuard = 0;
        int startTime = 0;
        Map<Integer, AtomicInteger> guardsSleepingTime = new HashMap<>();
        for(String line : input) {
            String[] split = line.split("[^\\d]+");
            if(line.contains("Guard #")) {
                currentGuard = Integer.parseInt(split[6]);
                if(!guardsSleepingTime.containsKey(currentGuard)) guardsSleepingTime.put(currentGuard, new AtomicInteger(0));
            }
            if(line.contains("falls asleep")) {
                startTime = Integer.parseInt(line.substring(15, 17));
            }
            if(line.contains("wakes up")) {
                int currentTime = Integer.parseInt(line.substring(15, 17));
                guardsSleepingTime.get(currentGuard).getAndAdd(currentTime - startTime);

            }
        }
        return guardsSleepingTime;
    }

    //returns Map<Guard, Map<Minute, times spend sleeping>>
    private Map<Integer, Map<Integer, AtomicInteger>> getSleepingTimeAtMinute(List<String> input) {
        Collections.sort(input);
        int currentGuard = 0;
        int startTime = 0;
        Map<Integer, Map<Integer, AtomicInteger>> sleepingTimes = new HashMap<>();
        for(String line : input) {
            String[] split = line.split("[^\\d]+");
            if(line.contains("Guard #")) {
                currentGuard = Integer.parseInt(split[6]);
                if(!sleepingTimes.containsKey(currentGuard)) sleepingTimes.put(currentGuard, new HashMap<>());
            }
            if(line.contains("falls asleep")) {
                startTime = Integer.parseInt(line.substring(15, 17));
            }
            if(line.contains("wakes up")) {
                int currentTime = Integer.parseInt(line.substring(15, 17));
                for (int i = startTime; i < currentTime; i++) {
                    if(!sleepingTimes.get(currentGuard).containsKey(i)) sleepingTimes.get(currentGuard).put(i, new AtomicInteger(0));
                    sleepingTimes.get(currentGuard).get(i).getAndIncrement();
                }
            }
        }
        return sleepingTimes;
    }

}