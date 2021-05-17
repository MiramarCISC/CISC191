package edu.sdccd.cisc191;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/**
 * StreamAPILab compiles the COVID deaths of countries between Jan 22, 2020 through May 11, 2021
 * using both Stream API as well as for loops, comparing the time it takes to process
 *
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

    /**
     * Computes deaths per country using stream api, sorted alphabetically by country
     * @param stats List of CovidStats to compute deaths per country
     * @return Time to process in ms
     */
    public static long computeDeathsPerCountryStream(List<CovidStats> stats) {
        System.out.println("\n-----Stream-----");
        long startTime = System.currentTimeMillis();

        stats.stream()
                .collect(Collectors.groupingBy(CovidStats::getCountry, Collectors.summingInt((CovidStats::getDeaths))))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, TreeMap::new))
                .forEach((country, deaths) -> System.out.println(country + " " + deaths));
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Computes deaths per country using for loops, sorted alphabetically by country
     * @param stats List of CovidStats to compute deaths per country
     * @return Time to process in ms
     */
    public static long computeDeathsPerCountryLoop(List<CovidStats> stats) {
        System.out.println("\n-----Loop-----");
        long startTime = System.currentTimeMillis();

        Map<String, Integer> countryToDeaths = new TreeMap<>();
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
