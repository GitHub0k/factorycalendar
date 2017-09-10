**factorycalendar** - REST-сервис для работы с производственным календарем в заданной стране.
В текущей версии реализована фцнкциональность получения
- даты следующего рабочего дня 2017 года в с учетом празников, выходных и предпраздничных выходных дней
- даты предыдущего рабочего дня  
для следующих стран:
- Russia
- Luxembourg

Перечень с стран и дат, приходящихся на праздники, задаётся в *.properties файлах. Вы можете задать праздники на 2018 год.


1. Запуск из IDE `mvn spring-boot:run`
2. Тестовые запросы (GET):
- `http://localhost:8080/getNextWorkingDate?InDate=31.12.2016&Country=Russia`
- `http://localhost:8080/getNextWorkingDate?InDate=07.03.2017&Country=Russia`
- `http://localhost:8080/getNextWorkingDate?InDate=24.05.2017&Country=Luxembourg`
- `http://localhost:8080/getPreviousWorkingDate?InDate=26.05.2017&Country=Luxembourg`
- `http://localhost:8080/getPreviousWorkingDate?InDate=02.05.2017&Country=Russia`
3. Сборка `mvn package`


**ENGLISH**

**factorycalendar** - REST-service for working with a production calendar in a specified country.
In the current version, the functionality for getting 
- next and
- previous working date 
is set up for holidays in 2017 and for next countries:
- Russia
- Luxembourg

The list of countries and dates of holidays is specified in * .properties files. You may set up holidays for 2018 year.


1. Running from the IDE `mvn spring-boot: run`
2. Test Requests (GET):
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 31.12.2016 & Country = Russia`
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 03/07/2017 & Country = Russia`
- `http: // localhost: 8080 / getNextWorkingDate? InDate = 24/05/2017 & Country = Luxembourg`
- `http://localhost:8080/getPreviousWorkingDate?InDate=26.05.2017&Country=Luxembourg`
- `http://localhost:8080/getPreviousWorkingDate?InDate=02.05.2017&Country=Russia`
3. Assembling to standalone jar -`mvn package`