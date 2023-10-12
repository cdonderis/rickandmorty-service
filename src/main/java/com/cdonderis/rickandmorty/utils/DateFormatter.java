package com.cdonderis.rickandmorty.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    public static Date dateFormatString(String stringDate) throws ParseException {
        DateTimeFormatter inputDate = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        DateTimeFormatter outputDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate stringToDate = LocalDate.parse(stringDate, inputDate);

        String formatDate = stringToDate.format(outputDate);

        return new SimpleDateFormat("yyyy-MM-dd").parse(formatDate);

    }
}
