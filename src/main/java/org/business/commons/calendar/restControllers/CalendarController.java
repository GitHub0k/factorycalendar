package org.business.commons.calendar.restControllers;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


/**
 * Created by d.tsaprilov on 16.04.2017.
 */

@RestController
public class CalendarController {

    private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

    @RequestMapping("/getNextWorkingDate")
    public String getNextWorkingDate(@RequestParam(value="InDate") String inDate,
                                   @RequestParam(value="Country") String country
                                   ) throws ParseException {
        String out = DateFormatUtils.format(DateUtils.addDays(DateUtils.parseDate(inDate, "dd.MM.yyyy"), 1), "dd.MM.yyyy");
        log.info("Next workin day in " + country + " is " + out);
        return  out;
    }

}
