**factorycalendar** - REST-сервис для работы с производственным календарем в заданной стране.
В текущей версии реализована фцнкциональность получения следующего рабочего дня 2017 года в с учетом празников
следующих стран:
- Russia
- Luxembourg

Перечень с стран и дат, приходящихся на праздники, задаётся в *.properties файлах. Вы можете задать праздники на 2018 год.


1. Запуск из IDE `mvn spring-boot:run`
2. Тестовый запрос 
- `http://localhost:8080/getNextWorkingDate?InDate=31.12.2016&Country=Russia`
- `http://localhost:8080/getNextWorkingDate?InDate=07.03.2017&Country=Russia`
- `http://localhost:8080/getNextWorkingDate?InDate=24.05.2017&Country=Luxembourg`
3. Сборка `mvn package`


**ENGLISH**

**factorycalendar** - REST-service for working with a production calendar in a specified country.
In the current version, the functionality is set up for holidays in 2017 and for next countries:
- Russia
- Luxembourg

The list of countries and dates of holidays is specified in * .properties files. You may set up holidays for 2018 year.


1. Running from the IDE `mvn spring-boot: run`
2. Test Request
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 31.12.2016 & Country = Russia`
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 03/07/2017 & Country = Russia`
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 24/05/2017 & Country = Luxembourg`
3. Assembling to standalone jar the `mvn package`