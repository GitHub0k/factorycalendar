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



    }

}