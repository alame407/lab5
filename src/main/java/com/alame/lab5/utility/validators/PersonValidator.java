package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.Country;
import com.alame.lab5.elements.EyesColor;
import com.alame.lab5.elements.HairColor;
import com.alame.lab5.elements.Person;

import java.time.LocalDate;

public class PersonValidator {
    public static boolean validPerson(Person person){
        return validName(person.getName()) && validBirthday(person.getBirthday()) &&
                validEyeColor(person.getEyeColor()) && validHairColor(person.getHairColor())
                && validNationality(person.getNationality());

    }
    public static boolean validName(String name){
        return !(name==null || name.equals(""));
    }
    public static boolean validBirthday(LocalDate birthday){
        return !(birthday==null);
    }
    public static boolean validEyeColor(String eyeColor){
        return eyeColor != null && EyesColor.constantExist(eyeColor);
    }
    public static boolean validEyeColor(EyesColor eyesColor){
        return eyesColor!=null;
    }
    public static boolean validHairColor(String hairColor){
        return hairColor==null || HairColor.constantExist(hairColor);
    }
    public static boolean validHairColor(HairColor hairColor){
        return true;
    }
    public static boolean validNationality(String nationality){
        return nationality!=null && Country.constantExist(nationality);
    }
    public static boolean validNationality(Country nationality){
        return nationality!=null;
    }
}
