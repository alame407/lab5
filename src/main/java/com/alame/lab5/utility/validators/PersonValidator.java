package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.elements.Person;

import java.time.LocalDate;

/**
 * class for valid person
 */
public class PersonValidator {
    /**
     * valid person
     * @param person - person to valid
     * @return result of validation
     */
    public static boolean validPerson(Person person){
        return validName(person.getName()) && validBirthday(person.getBirthday()) &&
                validEyeColor(person.getEyeColor()) && validHairColor(person.getHairColor())
                && validNationality(person.getNationality());

    }

    /**
     * valid name
     * @param name - name to valid
     * @return result of validation
     */
    public static boolean validName(String name){
        return !(name==null || name.equals(""));
    }

    /**
     * valid birthday
     * @param birthday - birthday to valid
     * @return result of validation
     */
    public static boolean validBirthday(LocalDate birthday){
        return !(birthday==null);
    }

    /**
     * valid eyeColor
     * @param eyeColor - eyeColor to valid
     * @return result of validation
     */
    public static boolean validEyeColor(String eyeColor){
        return eyeColor != null && EyesColor.constantExist(eyeColor);
    }

    /**
     * valid eyesColor
     * @param eyesColor - eyesColor to valid
     * @return result of validation
     */
    public static boolean validEyeColor(EyesColor eyesColor){
        return eyesColor!=null;
    }

    /**
     * valid hairColor
     * @param hairColor - hairColor to valid
     * @return result of validation
     */
    public static boolean validHairColor(String hairColor){
        return hairColor==null || HairColor.constantExist(hairColor);
    }
    /**
     * valid hairColor
     * @param hairColor - hairColor to valid
     * @return result of validation
     */
    public static boolean validHairColor(HairColor hairColor){
        return true;
    }

    /**
     * valid nationality
     * @param nationality - nationality to valid
     * @return result of validation
     */
    public static boolean validNationality(String nationality){
        return nationality!=null && Country.constantExist(nationality);
    }

    /**
     * valid nationality
     * @param nationality - nationality to valid
     * @return result of validation
     */
    public static boolean validNationality(Country nationality){
        return nationality!=null;
    }
}
