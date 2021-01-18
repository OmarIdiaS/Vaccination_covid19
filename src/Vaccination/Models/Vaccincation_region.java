package Vaccination.Models;

import java.time.LocalDate;
import java.util.Date;

public class Vaccincation_region implements Comparable<Vaccincation_region>{
    private LocalDate date;
    private String code;
    private String nom;
    private Integer total_vaccinations;

    @Override
    public String toString(){
        return "\n Region " + nom +"\n [ Date : \n" + date + "\n total de vaccinations : " +total_vaccinations + "] \n";
    }

    public String getNom() {
        return nom;
    }

    public Integer getTotal_vaccinations() {
        return total_vaccinations;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotal_vaccinations(Integer total_vaccinations) {
        this.total_vaccinations = total_vaccinations;
    }

    @Override
    public int compareTo(Vaccincation_region o) {
        return 0;
    }
}
