package Pradeep.Java8.DateTime;

import java.time.*;

public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Date: " + date + "\nTime: " + time);
        System.out.println("Date " + date.getDayOfMonth() + " Month " + date.getMonth() + " Year " + date.getYear());
        System.out.println("Hour " + time.getHour() + "Minute " + time.getMinute() +
                " Second " + time.getSecond() + " Nanosecond " + time.getNano());

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Local date time : " + dateTime);

        LocalDateTime parsedDT = LocalDateTime.parse("2026-01-23T15:43:43.635");
        System.out.println("Parsed Local date time : " + parsedDT);


        LocalDateTime pastDateTime = LocalDateTime.of(2001, Month.SEPTEMBER, 17, 01, 45);
        System.out.println("Past date time : " + pastDateTime);

        System.out.println("After adding 10 days into past date : " + pastDateTime.plusDays(10));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current zone date time : " + zonedDateTime);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("System zone : " + zoneId);

        ZoneId zd = ZoneId.of("America/Los_Angeles");
        ZonedDateTime currentDateTimeOfAmericaLosAngeles = ZonedDateTime.now(zd);
        System.out.println("Current date time of " + zd + " is " + currentDateTimeOfAmericaLosAngeles);


        // Period
        LocalDate localDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2001, Month.SEPTEMBER, 17);
        Period p = Period.between(localDate, birthDate);
        System.out.println("Age is " + p.getYears() + " and Years " + p.getYears() +
                " and Months " + p.getMonths() + " days " + p.getDays());


        // Year
        Year year = Year.now();
        System.out.println("Year is " + year);
        System.out.println("Value is " + year.getValue());
        System.out.println("isLeap year " + year.isLeap());

    }
}
