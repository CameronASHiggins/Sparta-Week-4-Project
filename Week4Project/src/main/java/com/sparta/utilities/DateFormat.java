package com.sparta.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateFormat {

    public static LocalDate dateFormatter(String inputDate) { // converts date format from MM/dd/YYYY to YYYY-M-d
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
        try {
            return LocalDate.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
        }
        return null;
    }
}
