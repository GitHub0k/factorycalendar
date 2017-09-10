package org.business.commons.calendar.restControllers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by User on 9/2/2017.
 */
@Service
public class FactCalendar {

    private static final Logger log = LoggerFactory.getLogger(FactCalendar.class);


    @Value("#{${holidays.map}}")
    private Map<String,String> holMap;

    /**
     * Является ли дата празником в стране
     * @param d дата
     * @param country страна
     * @return
     */
    public boolean isHoliday(Date d, String country) {


        String countryHoilidays = holMap.get(country);

        Calendar c = new GregorianCalendar();
        c.setTime(d);
        if((Calendar.SATURDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SUNDAY == c.get(c.DAY_OF_WEEK)) || StringUtils.contains(countryHoilidays, DateFormatUtils.format(d, "dd.MM.yy"))) {
            log.info(DateFormatUtils.format(d, "dd.MM.yyyy") + " является праздником, выходным или предпраздничным выходным днём в " + country);
            return true;
        } else {
            log.info(DateFormatUtils.format(d, "dd.MM.yyyy") + " НЕ является праздником или выходным днем в " + country);
            return false;
        }
    }


    /**
     * Метод возвращает следующий рабочий день
     * @param d дата
     * @param country страна
     * @return
     */

    public Date getNextWorkingDate (Date d, String country) {

        d = DateUtils.addDays(d, 1);

        while (isHoliday(d, country)) {
            d = DateUtils.addDays(d, 1);
        }
        return d;
    }


    /**
     * Метод возвращает предыдущий рабочий день
     * @param d дата
     * @param country страна
     * @return
     */

    public Date getPreviousWorkingDate (Date d, String country) {

        d = DateUtils.addDays(d, -1);

        while (isHoliday(d, country)) {
            d = DateUtils.addDays(d, -1);
        }
        return d;
    }

}
