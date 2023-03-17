package com.alame.lab5.utility.parsers;

import com.alame.lab5.elements.FormOfEducation;
import com.alame.lab5.elements.Semester;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.utility.validators.StudyGroupValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * class for parsing studyGroup from string
 */
public class StudyGroupParser {
    /**
     * parse id from string
     * @param s - string to parse
     * @return id
     * @throws IncorrectElementFieldException if id is not valid
     */
    public static int parseId(String s) throws IncorrectElementFieldException{
        try{
            int id = Integer.parseInt(s);
            if (StudyGroupValidator.validId(id)) return id;
            throw new IncorrectElementFieldException("id должно быть целым числом больше 0 типа int");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("id должно быть целым числом больше 0 типа Int");
        }
    }

    /**
     * parse name from string
     * @param s - string to parse
     * @return name
     * @throws IncorrectElementFieldException if name is not valid
     */
    public static String parseName(String s) throws IncorrectElementFieldException {
        if (StudyGroupValidator.validName(s)) return s;
        throw new IncorrectElementFieldException("Имя группы не должно быть null или равняться пустой строке");
    }

    /**
     * parse creationDate from string
     * @param s - string to parse
     * @return creationDate
     * @throws IncorrectElementFieldException if creationDate is not valid
     */
    public static LocalDate parseCreationDate(String s) throws IncorrectElementFieldException{
        try {
            LocalDate creationDate = LocalDate.parse(s);
            if (StudyGroupValidator.validCreationDate(creationDate)) return creationDate;
            throw new IncorrectElementFieldException("дата создания должна быть датой в формате гггг-мм-дд");
        }
        catch (DateTimeParseException | NullPointerException e){
            throw new IncorrectElementFieldException("дата создания должна быть датой в формате гггг-мм-дд");
        }
    }

    /**
     * parse studentsCount from string
     * @param s - string to parse
     * @return studentsCount
     * @throws IncorrectElementFieldException if studentsCount is not valid
     */
    public static int parseStudentsCount(String s) throws IncorrectElementFieldException {
        try{
            int studentsCount = Integer.parseInt(s);
            if (StudyGroupValidator.validStudentsCount(studentsCount) ) return studentsCount;
            throw new IncorrectElementFieldException("Количество студентов должно быть целым числом больше 0 типа int");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("Количество студентов должно быть целым числом больше 0 типа int");
        }
    }

    /**
     * parse expelledStudents from string
     * @param s - string to parse
     * @return expelledStudents
     * @throws IncorrectElementFieldException if expelledStudents is not valid
     */
    public static long parseExpelledStudents(String s) throws IncorrectElementFieldException {
        try{
            long expelledStudents = Long.parseLong(s);
            if (StudyGroupValidator.validExpelledStudents(expelledStudents) ) return expelledStudents;
            throw new IncorrectElementFieldException("Количество отчисленных студентов должно быть целым" +
                    " числом больше 0 ипа long");
        }
        catch (NumberFormatException e){
            throw new IncorrectElementFieldException("Количество отчисленных студентов должно быть целым" +
                    " числом больше 0 типа long");
        }
    }

    /**
     * parse formOfEducation from string
     * @param s - string to parse
     * @return formOfEducation
     * @throws IncorrectElementFieldException if formOfEducation is not valid
     */
    public static FormOfEducation parseFormOfEducation(String s) throws IncorrectElementFieldException {
        if (!(StudyGroupValidator.validFormOfEducation(s))) throw new IncorrectElementFieldException("форма обучения " +
                "должна быть null или одним из " + FormOfEducation.possibleValues());
        if (s==null) return null;
        return FormOfEducation.valueOf(s);
    }

    /**
     * parse semester from string
     * @param s - string to parse
     * @return semester
     * @throws IncorrectElementFieldException if semester is not valid
     */
    public static Semester parseSemester(String s) throws IncorrectElementFieldException {
        if (!(StudyGroupValidator.validSemester(s))) throw new IncorrectElementFieldException("семестр " +
                "должен быть null или одним из " + Semester.possibleValues());
        if (s==null) return null;
        return Semester.valueOf(s);
    }
}
