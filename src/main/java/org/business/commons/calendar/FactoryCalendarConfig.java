package org.business.commons.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;


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


}
