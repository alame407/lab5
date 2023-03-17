package com.alame.lab5.utility.parsers;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.PersonValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * class for parsing person from string
 */
public class PersonParser {
    /**
     * parse name from string
     * @param s - string to parse
     * @return name
     * @throws IncorrectElementFieldException if name is not valid
     */
    public static String parseName(String s) throws IncorrectElementFieldException {
        if (PersonValidator.validName(s)) return s;
        throw new IncorrectElementFieldException("Имя не должно быть null или равняться пустой строке");
    }

    /**
     * parse eyesColor from string
     * @param s - string to parse
     * @return eyesColor
     * @throws IncorrectElementFieldException if eyesColor is not valid
     */
    public static EyesColor parseEyesColor(String s) throws IncorrectElementFieldException {
        if (! (PersonValidator.validEyeColor(s))) throw new IncorrectElementFieldException("цвет глаз должен быть " +
                "одним из " + EyesColor.possibleValues());
        if (s==null) return null;
        return EyesColor.valueOf(s);
    }

    /**
     * parse hairColor from string
     * @param s - string to parse
     * @return hairColor
     * @throws IncorrectElementFieldException if hairColor is not valid
     */
    public static HairColor parseHairColor(String s) throws IncorrectElementFieldException {
        if (!(PersonValidator.validHairColor(s))) throw new IncorrectElementFieldException("цвет волос должен быть " +
                "одним из " + HairColor.possibleValues());
        if (s==null) return null;
        return HairColor.valueOf(s);
    }

    /**
     * parse country from string
     * @param s - string to parse
     * @return country
     * @throws IncorrectElementFieldException if country is not valid
     */
    public static Country parseCountry(String s) throws IncorrectElementFieldException {
        if(!(PersonValidator.validNationality(s))) throw new IncorrectElementFieldException("национальность должна " +
                "быть одной из " + Country.possibleValues());
        if (s==null) return null;
        return Country.valueOf(s);
    }

    /**
     * parse birthday from string
     * @param s - string to parse
     * @return birthday
     * @throws IncorrectElementFieldException if birthday is not valid
     */
    public static LocalDate parseBirthday(String s) throws IncorrectElementFieldException{
        try {
            LocalDate birthday = LocalDate.parse(s);
            if (PersonValidator.validBirthday(birthday)) return birthday;
            throw new IncorrectElementFieldException("день рождение должен быть датой в формате гггг-мм-дд");
        }
        catch (DateTimeParseException | NullPointerException e){
            throw new IncorrectElementFieldException("день рождение должен быть датой в формате гггг-мм-дд");
        }

    }
}
