package org.business.commons.calendar.restControllers;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;


/**
 * Created by d.tsaprilov on 16.04.2017.
 */

@RestController
public class CalendarController {

    private static final Logger log = LoggerFactory.getLogger(CalendarController.class);

    @Value("#{${holidays.map}}")
    private Map<String,String> holMap;

    @Autowired
    FactCalendar factCalendar;

    /**
     * Метод возвращает следующий рабочий день в виде даты
     * @param inDate Дата в формате dd.MM.yyyyy
     * @param country Наименование страны
     * @return
     * @throws ParseException
     */
    @RequestMapping("/getNextWorkingDate")
    public String getNextWorkingDate(@RequestParam(value="InDate") String inDate,
                                     @RequestParam(value="Country") String country
                                   ) throws ParseException {


        String out = DateFormatUtils.format(factCalendar.getNextWorkingDate(DateUtils.parseDate(inDate, "dd.MM.yyyy"), country), "dd.MM.yyyy");
        log.info("Next working day in " + country + " is " +   out);
        return   out;
    }

}
