package org.business.commons.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by d.tsaprilov on 26.01.2017.
 */


@Configuration

@ComponentScan(basePackages = {"org.business.commons.calendar"})
@PropertySource("classpath:factorycalendar-dev.properties")
public class FactoryCalendarConfig {

    private static final Logger log = LoggerFactory.getLogger(FactoryCalendarConfig.class);

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() throws IOException {

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);

        return propertySourcesPlaceholderConfigurer;
    }

    @Autowired
    Environment environment;

     /*@Bean (name = "authMap")
     public Map<String, String> authMap() {
        log.info("Получение массива данных для Basic Auth");
        Map<String, String> resultList = new HashMap<>();
        resultList = spectrumCommons.splitToMap(environment.getProperty("holidays.map"));
        log.info("В массиве " + resultList.size() + " элементов.");

       //MapUtils.debugPrint(System.out, "Map'a c парамаи логин/пароль: " , resultList);
        return resultList;

    }*/






}
