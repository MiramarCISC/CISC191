package edu.sdccd.cisc191;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/**
 * countries-aggregated.csv retrived from https://www.kaggle.com/pranjalverma08/coronavirus-covid19-indepth-dataset
 */

public class StreamAPILab {
    public static void main(String[] args) {
        List<CovidStats> stats = new CsvToBeanBuilder<CovidStats>(new InputStreamReader(StreamAPILab.class.getResourceAsStream("/countries-aggregated.csv")))
                .withType(CovidStats.class)
                .build()
                .parse();

        long streamTime = computeDeathsPerCountryStream(stats);
        long loopTime = computeDeathsPerCountryLoop(stats);

        System.out.println("\n-----RESULTS-----");
        System.out.println("Loop took " + loopTime + "ms to complete");
        System.out.println("Stream took " +  streamTime + "ms to complete");
    }
    public static long computeDeathsPerCountryStream(List<CovidStats> stats) {
        long startTime = System.currentTimeMillis();

        stats.stream()
                .collect(Collectors.groupingBy(CovidStats::getCountry, Collectors.summingInt((CovidStats::getDeaths))))
                .forEach((country, deaths) -> System.out.println(country + " " + deaths));
        return System.currentTimeMillis() - startTime;
    }

    public static long computeDeathsPerCountryLoop(List<CovidStats> stats) {
        long startTime = System.currentTimeMillis();

        Map<String, Integer> countryToDeaths = new HashMap<>();
        for(CovidStats stat: stats) {
            if(countryToDeaths.containsKey(stat.getCountry())) {
                countryToDeaths.put(stat.getCountry(), countryToDeaths.get(stat.getCountry()) + stat.getDeaths() );
            } else {
                countryToDeaths.put(stat.getCountry(), stat.getDeaths());
            }
        }
        for(Map.Entry<String,Integer> entry: countryToDeaths.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return System.currentTimeMillis() - startTime;
    }
}
