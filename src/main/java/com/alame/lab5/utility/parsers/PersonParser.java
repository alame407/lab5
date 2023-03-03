package com.alame.lab5.utility.parsers;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.PersonValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonParser {
    public static String parseName(String s) throws IncorrectElementFieldException {
        if (PersonValidator.validName(s)) return s;
        throw new IncorrectElementFieldException("Имя не должно быть null или равняться пустой строке");
    }
    public static EyesColor parseEyesColor(String s) throws IncorrectElementFieldException {
        if (! (PersonValidator.validEyeColor(s))) throw new IncorrectElementFieldException("цвет глаз должен быть " +
                "одним из " + EyesColor.possibleValues());
        if (s==null) return null;
        return EyesColor.valueOf(s);
    }
    public static HairColor parseHairColor(String s) throws IncorrectElementFieldException {
        if (!(PersonValidator.validHairColor(s))) throw new IncorrectElementFieldException("цвет волос должен быть " +
                "одним из " + HairColor.possibleValues());
        if (s==null) return null;
        return HairColor.valueOf(s);
    }
    public static Country parseCountry(String s) throws IncorrectElementFieldException {
        if(!(PersonValidator.validNationality(s))) throw new IncorrectElementFieldException("национальность должна " +
                "быть одной из " + Country.possibleValues());
        if (s==null) return null;
        return Country.valueOf(s);
    }
    public static LocalDate parseBirthday(String s) throws IncorrectElementFieldException{
        try {
            LocalDate birthday = LocalDate.parse(s);
            if (PersonValidator.validBirthday(birthday)) return birthday;
            throw new IncorrectElementFieldException("день рождение должен быть датой в формате год-месяц-день");
        }
        catch (DateTimeParseException | NullPointerException e){
            throw new IncorrectElementFieldException("день рождение должен быть датой в формате год-месяц-день");
        }

    }
}
