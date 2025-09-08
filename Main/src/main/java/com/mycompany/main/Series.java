/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author RC_Student_lab
 */
import java.util.List;
import java.util.ArrayList;

public class Series {

    public static class SeriesModel {
        public String seriesId;
        public String seriesName;
        public int seriesAge;
        public int numberOfEpisodes;

        public SeriesModel(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
            this.seriesId = seriesId;
            this.seriesName = seriesName;
            this.seriesAge = seriesAge;
            this.numberOfEpisodes = numberOfEpisodes;
        }
    }

    private List<SeriesModel> seriesList = new ArrayList<>();

    public void addSeries(String id, String name, int age, int episodes) {
        seriesList.add(new SeriesModel(id, name, age, episodes));
    }

    public SeriesModel getSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateSeries(String id, String newName, int newAge, int newEpisodes) {
        SeriesModel s = getSeriesById(id);
        if (s != null) {
            s.seriesName = newName;
            s.seriesAge = newAge;
            s.numberOfEpisodes = newEpisodes;
            return true;
        }
        return false;
    }

    public boolean deleteSeriesById(String id) {
        SeriesModel s = getSeriesById(id);
        if (s != null) {
            seriesList.remove(s);
            return true;
        }
        return false;
    }

    public boolean isAgeRestrictionValid(int age) {
        return age >= 13 && age <= 21;
    }
}
    

