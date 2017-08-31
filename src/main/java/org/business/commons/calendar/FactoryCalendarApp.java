package org.business.commons.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by d.tsaprilov on 16.04.2017.
 */

@SpringBootApplication
/*@ComponentScan
@EnableAutoConfiguration*/
public class FactoryCalendarApp {

    public static void main(String[] args) {
        SpringApplication.run(FactoryCalendarApp.class, args);
    }

}
