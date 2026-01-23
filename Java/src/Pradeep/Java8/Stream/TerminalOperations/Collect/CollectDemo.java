package Pradeep.Java8.Stream.TerminalOperations.Collect;

import java.util.*;
import java.util.stream.*;

class City {
    private String name;
    private double temperature;

    public City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public Double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return name + " --> " + temperature;
    }
}

public class CollectDemo {
    private static List<City> prepareTemperature() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 14));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 43));
        cities.add(new City("London", 15));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 14));  // duplicate
        cities.add(new City("Dubai", 43));   // duplicate
        return cities;
    }

    public static void main(String[] args) {
        System.out.println(prepareTemperature().stream()
                .filter(f -> f.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.toList()));
        // [New Delhi, Mexico, New York, Dubai, London, Kolkata, Sydney, Mexico, Dubai]

        System.out.println(prepareTemperature()
                .stream()
                .filter(f -> f.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.toSet()));
        // [New York, New Delhi, London, Mexico, Kolkata, Dubai, Sydney]

        System.out.println(String.valueOf(prepareTemperature()
                .stream()
                .map(f -> f.getName())
                .collect(Collectors.toCollection(ArrayList::new))));
        // [New Delhi, Mexico, New York, Dubai, London, Alaska, Kolkata, Sydney, Mexico, Dubai]

        System.out.println(prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .collect(Collectors.toMap(
                        City::getName,
                        City::getTemperature,
                        (key, identicalKey) -> key)));
        // {New York=13.0, New Delhi=33.5, London=15.0, Mexico=14.0, Kolkata=30.0, Dubai=43.0, Sydney=11.0}

        System.out.println(prepareTemperature()
                .stream()
                .collect(Collectors.groupingBy(
                        City::getName,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                f -> f.intValue()))));
        // {New York=1, New Delhi=1, London=1, Alaska=1, Mexico=2, Kolkata=1, Dubai=2, Sydney=1}

        System.out.println(prepareTemperature()
                .stream()
                .collect(Collectors.groupingBy(
                        City::getName,
                        Collectors.counting())));
        // {New York=1, New Delhi=1, London=1, Alaska=1, Mexico=2, Kolkata=1, Dubai=2, Sydney=1}

        System.out.println(prepareTemperature()
                .stream()
                .collect(Collectors.groupingBy(City::getName)));
        // {New York=[New York --> 13.0], New Delhi=[New Delhi --> 33.5], London=[London --> 15.0],
        // Alaska=[Alaska --> 1.0], Mexico=[Mexico --> 14.0, Mexico --> 14.0], Kolkata=[Kolkata --> 30.0],
        // Dubai=[Dubai --> 43.0, Dubai --> 43.0], Sydney=[Sydney --> 11.0]}

        System.out.println(prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.joining(", ")));
        // New Delhi, Mexico, New York, Dubai, London, Kolkata, Sydney, Mexico, Dubai

        System.out.println(prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.joining(" ",
                        "Prefix:", ":Suffix")));
        // Prefix:New Delhi Mexico New York Dubai London Kolkata Sydney Mexico Dubai:Suffix

        System.out.println(prepareTemperature()
                .stream()
                .collect(Collectors.groupingBy(
                        City::getName,
                        Collectors.mapping(
                                City::getTemperature,
                                Collectors.toList()))));
        //{New York=[13.0], New Delhi=[33.5], London=[15.0], Alaska=[1.0], Mexico=[14.0, 14.0],
        // Kolkata=[30.0], Dubai=[43.0, 43.0], Sydney=[11.0]}


    }
}
