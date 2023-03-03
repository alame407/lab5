package com.alame.lab5.utility.parsers;

import com.alame.lab5.elements.FormOfEducation;
import com.alame.lab5.elements.Semester;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.StudyGroupValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StudyGroupParser {
    public static int parseId(String s) throws IncorrectElementFieldException{
        try{
            int id = Integer.parseInt(s);
            if (StudyGroupValidator.validId(id)) return id;
            throw new IncorrectElementFieldException("id должно быть целым числом больше 0");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("id должно быть целым числом больше 0");
        }
    }
    public static String parseName(String s) throws IncorrectElementFieldException {
        if (StudyGroupValidator.validName(s)) return s;
        throw new IncorrectElementFieldException("Имя группы не должно быть null или равняться пустой строке");
    }
    public static LocalDate parseCreationDate(String s) throws IncorrectElementFieldException{
        try {
            LocalDate creationDate = LocalDate.parse(s);
            if (StudyGroupValidator.validCreationDate(creationDate)) return creationDate;
            throw new IncorrectElementFieldException("дата создания должна быть датой в формате год-месяц-день");
        }
        catch (DateTimeParseException | NullPointerException e){
            throw new IncorrectElementFieldException("дата создания должна быть датой в формате год-месяц-день");
        }
    }
    public static int parseStudentsCount(String s) throws IncorrectElementFieldException {
        try{
            int studentsCount = Integer.parseInt(s);
            if (StudyGroupValidator.validStudentsCount(studentsCount) ) return studentsCount;
            throw new IncorrectElementFieldException("Количество студентов должно быть целым числом больше 0");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("Количество студентов должно быть целым числом больше 0");
        }
    }
    public static long parseExpelledStudents(String s) throws IncorrectElementFieldException {
        try{
            long expelledStudents = Long.parseLong(s);
            if (StudyGroupValidator.validExpelledStudents(expelledStudents) ) return expelledStudents;
            throw new IncorrectElementFieldException("Количество отчисленных студентов должно быть целым" +
                    " числом больше 0");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("Количество отчисленных студентов должно быть целым" +
                    " числом больше 0");
        }
    }
    public static FormOfEducation parseFormOfEducation(String s) throws IncorrectElementFieldException {
        if (!(StudyGroupValidator.validFormOfEducation(s))) throw new IncorrectElementFieldException("форма обучения " +
                "должна быть null или одним из " + FormOfEducation.possibleValues());
        if (s==null) return null;
        return FormOfEducation.valueOf(s);
    }
    public static Semester parseSemester(String s) throws IncorrectElementFieldException {
        if (!(StudyGroupValidator.validSemester(s))) throw new IncorrectElementFieldException("семестр " +
                "должен быть null или одним из " + Semester.possibleValues());
        if (s==null) return null;
        return Semester.valueOf(s);
    }
}
