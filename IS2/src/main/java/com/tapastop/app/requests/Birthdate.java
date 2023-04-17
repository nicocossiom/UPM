package com.tapastop.app.requests;

/**
 * The type Birthdate.
 */
import java.time.LocalDate;

public class Birthdate {
    private static final int MINIMUM_AGE = 18;
    private String day;
    private String month;
    private String year;

    /**
     * Checks if the minimum birthdate is met
     *
     * @return whether the birthdate is valid to continue
     */
    public boolean checkBirthDate() {
        LocalDate currentDate = LocalDate.now();
        int curDay = currentDate.getDayOfMonth();
        int curMonth = currentDate.getMonthValue();
        int curYear = currentDate.getYear();
        int birthDay;
        int birthMonth;
        int baseYear;
        try {
            birthDay = Integer.parseInt(day);
            birthMonth = Integer.parseInt(month);
            baseYear = Integer.parseInt(year);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (baseYear < 1900 || baseYear > curYear) {
            return false;
        }
        if (curMonth < birthMonth || (curMonth == birthMonth && curDay < birthDay)) {
            baseYear++;
        }
        return curYear - baseYear >= MINIMUM_AGE;
    }

    /**
     * Gets day.
     *
     * @return the day
     */

    public String getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(String year) {
        this.year = year;
    }
}
