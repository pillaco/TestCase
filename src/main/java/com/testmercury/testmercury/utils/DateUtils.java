package com.testmercury.testmercury.utils;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@Log4j2
public class DateUtils {

    public static Date getNearestDate(List<Date> dates, Date targetDate) {

        log.info("entering getNearestDate method");

        Date fechaSuperior = new TreeSet<>(dates).ceiling(targetDate);
        Date fechaInferior = new TreeSet<>(dates).lower(targetDate);

        // este if controla si nos pasan una fecha inferior a todas las que hubiera registradas en bbdd
        if(null == fechaInferior){

            return fechaSuperior;
        }

        long diff1 = Math.abs(fechaSuperior.getTime() - targetDate.getTime());
        long diff2 = Math.abs(fechaInferior.getTime() - targetDate.getTime());

        if(diff1 > diff2){

            return fechaInferior;
        }

        return fechaSuperior;

    }



    public static String dateToStringFormatted(Date nearestDate){

        log.info("entering dateToStringFormatted method");


        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

        return s.format(nearestDate);
    }


    public static Date stringToDate(String date) throws ParseException {

        log.info("entering stringToDate method");

        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

}