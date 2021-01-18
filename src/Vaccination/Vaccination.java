package Vaccination;

import Vaccination.Models.Vaccincation_region;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vaccination {
    public static void main(String[] args) throws Exception{

        Stream<String> lines = Files.lines(Paths.get("files" , "vaccination-regional.csv"));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRANCE);

        List<Vaccincation_region> vr = lines.map(
                v -> {

                    String [] strings = v.split(",");
                    Vaccincation_region v_region = new Vaccincation_region();

                    v_region.setDate(LocalDate.parse(strings[0], format));
                    v_region.setCode(strings[1]);
                    v_region.setNom(strings[2]);
                    v_region.setTotal_vaccinations(Integer.parseInt(strings[3]));

                    return v_region;
                })
                .collect(Collectors.toList());

        System.out.println("Nb de regions " + vr.size());


        List<Vaccincation_region> vaccinations_plus_10000 = vr.stream()
                .filter(v -> v.getTotal_vaccinations() > 10000)
                .collect(Collectors.toList());
/*
        System.out.println(
                "Les régions qui ont passés plus de 10 000 tests" + vaccinations_plus_10000
        );


 */
        List<Vaccincation_region> collect = vr.stream()
                .sorted(Comparator.comparing(entry -> -entry.getTotal_vaccinations()))
                .collect(Collectors.toList());

        System.out.println(" Maximum des vaccinations" + collect);

    }
}
