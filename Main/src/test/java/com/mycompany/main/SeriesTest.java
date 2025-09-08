/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesTest {

    Series series;

    @BeforeEach
    public void setUp() {
        series = new Series();
        series.addSeries("S001", "The Last Kingdom", 18, 10);
    }

    @AfterEach
    public void tearDown() {
        series = null;
    }

    @Test
    public void testSearchSeries() {
        Series.SeriesModel found = series.getSeriesById("S001");
        assertNotNull(found);
        assertEquals("The Last Kingdom", found.seriesName);
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        Series.SeriesModel found = series.getSeriesById("INVALID_ID");
        assertNull(found);
    }

    @Test
    public void testUpdateSeries() {
        boolean updated = series.updateSeries("S001", "Vikings", 16, 8);
        assertTrue(updated);
        Series.SeriesModel updatedSeries = series.getSeriesById("S001");
        assertEquals("Vikings", updatedSeries.seriesName);
        assertEquals(16, updatedSeries.seriesAge);
        assertEquals(8, updatedSeries.numberOfEpisodes);
    }

    @Test
    public void testDeleteSeries() {
        boolean deleted = series.deleteSeriesById("S001");
        assertTrue(deleted);
        assertNull(series.getSeriesById("S001"));
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
        boolean deleted = series.deleteSeriesById("NON_EXISTENT");
        assertFalse(deleted);
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        assertTrue(series.isAgeRestrictionValid(18));
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        assertFalse(series.isAgeRestrictionValid(25));
    }
}
