package edu.sdccd.cisc191;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.sql.Date;

public class CovidStats {
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "Date")
    private Date date;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Confirmed")
    private int confirmed;

    @CsvBindByName(column = "Recovered")
    private int recovered;

    @CsvBindByName(column = "Deaths")
    private int deaths;

    @Override
    public String toString() {
        return String.format(
                "CovidStats[date=%s, country=%s, confirmed=%d, recovered=%d, deaths=%d]",
                date, country, confirmed, recovered, deaths);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
