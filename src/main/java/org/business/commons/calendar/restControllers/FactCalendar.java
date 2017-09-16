package org.business.commons.calendar.restControllers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.DAYS;

/**
 * Created by User on 9/2/2017.
 */
@Service
public class FactCalendar {

    private static final Logger log = LoggerFactory.getLogger(FactCalendar.class);


    @Value("#{${holidays.map}}")
    private Map<String, String> holMap;

    /**
     * Является ли дата празником в стране
     *
     * @param d       дата
     * @param country страна
     * @return
     */
    public boolean isHoliday(Date d, String country) {


        String countryHoilidays = holMap.get(country);

        Calendar c = new GregorianCalendar();
        c.setTime(d);
        if ((Calendar.SATURDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SUNDAY == c.get(c.DAY_OF_WEEK)) || StringUtils.contains(countryHoilidays, DateFormatUtils.format(d, "dd.MM.yy"))) {
            log.info(DateFormatUtils.format(d, "dd.MM.yyyy") + " является праздником, выходным или предпраздничным выходным днём в " + country);
            return true;
        } else {
            log.info(DateFormatUtils.format(d, "dd.MM.yyyy") + " НЕ является праздником или выходным днем в " + country);
            return false;
        }
    }


    /**
     * Метод возвращает следующий рабочий день
     *
     * @param d       дата
     * @param country страна
     * @return
     */

    public Date getNextWorkingDate(Date d, String country) {

        d = DateUtils.addDays(d, 1);

        while (isHoliday(d, country)) {
            d = DateUtils.addDays(d, 1);
        }
        return d;
    }


    /**
     * Метод возвращает предыдущий рабочий день
     *
     * @param d       дата
     * @param country страна
     * @return
     */

    public Date getPreviousWorkingDate(Date d, String country) {

        d = DateUtils.addDays(d, -1);

        while (isHoliday(d, country)) {
            d = DateUtils.addDays(d, -1);
        }
        return d;
    }


    /**
     * Returns the number of working days between two dates
     *
     * @param beginDate begin Date
     * @param endDate   end Date
     * @return
     */
    public int getWorkingDaysBetweenDates(String beginDate, String endDate, String country) {

          return 0;
    }


    /**Method returns date array between two dates
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Date> getDatesBetweenInclusive(
            Date beginDate, Date endDate) {

        List<Date> out = new ArrayList<>();

        List<LocalDate> localDates = new ArrayList<LocalDate>();
        for (LocalDate date = asLocalDate(beginDate); !date.isAfter(asLocalDate(endDate)); date = date.plusDays(1)) {
            localDates.add(date);
        }


        for (int i = 0; i <localDates.size() ; i++) {

            out.add(asDate(localDates.get(i)));
        }

        return out;

    }


    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }



    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }



    }



