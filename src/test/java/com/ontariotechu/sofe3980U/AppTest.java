package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test Design Assignment 1: NextDate
 * Unit test for App.java which holds the NextDate function.
 */

public class AppTest 
{
    @Test
    public void invalidDay(){           //Checks for invalid values for day
        assertEquals(App.NextDate(2022, 3, 43), "Invalid day value.");
        assertEquals(App.NextDate(2000, 8, -57), "Invalid day value.");
        assertEquals(App.NextDate(1994, 12, 0), "Invalid day value.");
        assertEquals(App.NextDate(1830, 11, 32), "Invalid day value.");

    }

    @Test
    public void invalidMonth(){             //Checks for invalid values for month
        assertEquals(App.NextDate(2019, 34, 2), "Invalid month value.");
        assertEquals(App.NextDate(1895, 0, 31), "Invalid month value.");
        assertEquals(App.NextDate(1962, -1, 27), "Invalid month value.");
        assertEquals(App.NextDate(2001, 102, 3), "Invalid month value.");
    }

    @Test                                      //Checks for invalid values for year
    public void invalidYear(){
        assertEquals(App.NextDate(2000000, 2, 4), "Invalid year value.");
        assertEquals(App.NextDate(1810, 5, 16), "Invalid year value.");
        assertEquals(App.NextDate(-1990, 2, 22), "Invalid year value.");
    }

    @Test
    public void correctNextDate(){              //Checks for the correct next date
        assertEquals(App.NextDate(2010, 1, 23), "2010 1 24");
        assertEquals(App.NextDate(1985, 6, 9), "1985 6 10");
        assertEquals(App.NextDate(1834, 11, 15), "1834 11 16");
        assertEquals(App.NextDate(2110, 8, 1), "2110 8 2");
    }

    @Test
    public void correctNextYear(){           //Checks for the correct next year after Dec 31 on various years
       assertEquals(App.NextDate(2021, 12, 31), "2022 1 1");
        assertEquals(App.NextDate(1888, 12, 31), "1889 1 1");
        assertEquals(App.NextDate(2100, 12, 31), "2101 1 1");
        assertEquals(App.NextDate(2212, 12, 31), "Next date is not within the interval.");
    }

    @Test
    public void testLeapYearDates(){        //Checks for the values in a leap year
        assertEquals(App.NextDate(2020, 2, 28), "2020 2 29");
       assertEquals(App.NextDate(2024, 2, 30), "Invalid day for leap year.");
       assertEquals(App.NextDate(1992, 2, 29), "1992 3 1");

    }

    @Test
    public void testNonLeapYearDates(){     //Checks for the values in a non-leap year
      assertEquals(App.NextDate(2021, 2, 28), "2021 3 1");
      assertEquals(App.NextDate(1990, 2, 29), "Invalid day, no leap year.");
     assertEquals(App.NextDate(1881, 2, 28), "1881 3 1");

        
    }

    @Test
    public void correctNextMonth(){            //Checks for the correct next date after the last day of the month
        assertEquals(App.NextDate(2020, 4, 30), "2020 5 1");
        assertEquals(App.NextDate(2000, 6, 30), "2000 7 1");
        assertEquals(App.NextDate(1932, 3, 31), "1932 4 1");
        assertEquals(App.NextDate(1899, 10, 31), "1899 11 1");

    }

}
