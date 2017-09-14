package org.business.commons.calendar.restControllers;

import org.business.commons.calendar.FactoryCalendarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by User on 9/2/2017.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FactoryCalendarConfig.class)
public class CalendarControllerTest {


    private static final Logger log = LoggerFactory.getLogger(CalendarControllerTest.class);

    @Autowired
    CalendarController calendarController;

    @Test
    public void getNextWorkingDate() throws Exception {

        String nextWorkingDateInRussia = calendarController.getNextWorkingDate("01.09.2017", "Russia");
        assertEquals("04.09.2017", nextWorkingDateInRussia);

        String prevWorkingDateInRussia = calendarController.getPreviousWorkingDate("12.06.2017", "Russia");
        assertEquals("09.06.2017", prevWorkingDateInRussia);


        String prevWorkingDateInLux = calendarController.getPreviousWorkingDate("26.05.2017", "Luxembourg");
        assertEquals("24.05.2017", prevWorkingDateInLux);


    }


    @Test
    public void isDateWorkingDay() throws Exception {

        boolean workingDay = calendarController.isDateWorkingDay("16.09.2017", "Luxembourg");
        assertFalse(workingDay);


        boolean workingDay1 = calendarController.isDateWorkingDay("09.05.2017", "Russia");
        assertFalse(workingDay1);


        boolean workingDay2 = calendarController.isDateWorkingDay("14.09.2017", "Russia");
        assertTrue(workingDay2);



    }

}