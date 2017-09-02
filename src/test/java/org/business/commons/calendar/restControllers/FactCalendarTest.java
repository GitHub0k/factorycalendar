package org.business.commons.calendar.restControllers;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.business.commons.calendar.FactoryCalendarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by User on 9/2/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FactoryCalendarConfig.class)
public class FactCalendarTest {


    private static final Logger log = LoggerFactory.getLogger(FactCalendarTest.class);

    @Autowired
    FactCalendar factCalendar;


    @Test
    public void getNextWorkingDate() throws Exception {
        Date nextWorkingDate = factCalendar.getNextWorkingDate(DateUtils.parseDate("02.09.2017", "dd.MM.yyyy"), "Russia");
        assertEquals("04.09.2017", DateFormatUtils.format(nextWorkingDate, "dd.MM.yyyy"));


        Date nextWorkingDate0101 = factCalendar.getNextWorkingDate(DateUtils.parseDate("01.01.2017", "dd.MM.yyyy"), "Russia");
        log.info(DateFormatUtils.format(nextWorkingDate0101, "dd.MM.yyyy"));
        assertEquals("09.01.2017", DateFormatUtils.format(nextWorkingDate0101, "dd.MM.yyyy"));


        Date nextWorkingDateLux = factCalendar.getNextWorkingDate(DateUtils.parseDate("31.10.2017", "dd.MM.yyyy"), "Luxembourg");
        log.info(DateFormatUtils.format(nextWorkingDateLux, "dd.MM.yyyy"));
        assertEquals("02.11.2017", DateFormatUtils.format(nextWorkingDateLux, "dd.MM.yyyy"));

        Date nextWorkingDateNYRussia = factCalendar.getNextWorkingDate(DateUtils.parseDate("31.12.2016", "dd.MM.yyyy"), "Russia");
        log.info(DateFormatUtils.format(nextWorkingDateNYRussia, "dd.MM.yyyy"));
        assertEquals("09.01.2017", DateFormatUtils.format(nextWorkingDateNYRussia, "dd.MM.yyyy"));


        Date nextWorkingDate3108 = factCalendar.getNextWorkingDate(DateUtils.parseDate("31.08.2017", "dd.MM.yyyy"), "Russia");
        log.info(DateFormatUtils.format(nextWorkingDate3108, "dd.MM.yyyy"));
        assertEquals("01.09.2017", DateFormatUtils.format(nextWorkingDate3108, "dd.MM.yyyy"));


    }



    @Test
    public void isHoliday() throws Exception {
        assertTrue(factCalendar.isHoliday(DateUtils.parseDate("02.09.2017", "dd.MM.yyyy"), "Russia"));
        assertFalse(factCalendar.isHoliday(DateUtils.parseDate("04.09.2017", "dd.MM.yyyy"), "Russia"));
        assertTrue(factCalendar.isHoliday(DateUtils.parseDate("12.06.2017", "dd.MM.yyyy"), "Russia"));
    }

}