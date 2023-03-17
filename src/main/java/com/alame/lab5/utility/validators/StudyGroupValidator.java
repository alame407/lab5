package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * class for valid studyGroup fields
 */
public class StudyGroupValidator {
    /**
     * valid studyGroup
     * @param studyGroup - studyGroup to valid
     * @return result of validation
     */
    public static boolean validStudyGroup(StudyGroup studyGroup){
        return validId(studyGroup.getId()) && validName(studyGroup.getName()) &&
                validCoordinates(studyGroup.getCoordinates()) &&  validCreationDate(studyGroup.getCreationDate()) &&
                validStudentsCount(studyGroup.getStudentsCount()) &&
                validExpelledStudents(studyGroup.getExpelledStudents()) &&
                validFormOfEducation(studyGroup.getFormOfEducation()) &&
                validSemester(studyGroup.getSemesterEnum()) && validPerson(studyGroup.getGroupAdmin());
    }

    /**
     * valid name
     * @param name - name to valid
     * @return result of validation
     */
    public static boolean validName(String name){
        return !(name == null || name.equals(""));
    }

    /**
     * valid id
     * @param id - id to valid
     * @return result of validation
     */
    public static boolean validId(int id){
        return id>0;
    }

    /**
     * valid coordinates
     * @param coordinates - coordinates to valid
     * @return result of validation
     */
    public static boolean validCoordinates(Coordinates coordinates){
        return CoordinatesValidator.validCoordinates(coordinates);
    }

    /**
     * valid creationDate
     * @param creationDate - creationDate to valid
     * @return result of validation
     */
    public static boolean validCreationDate(LocalDate creationDate){
        return !(creationDate == null);
    }

    /**
     * valid studentsCount
     * @param studentsCount - studentsCount to valid
     * @return result of validation
     */
    public static boolean validStudentsCount(int studentsCount){
        return studentsCount>0;
    }

    /**
     * valid expelledStudents
     * @param expelledStudents - expelledStudents to valid
     * @return resultOfValidation
     */
    public static boolean validExpelledStudents(long expelledStudents){
        return expelledStudents>0;
    }

    /**
     * valid formOfEducation
     * @param formOfEducation - formOfEducation to valid
     * @return result of validation
     */
    public static boolean validFormOfEducation(String formOfEducation){
        return formOfEducation==null || FormOfEducation.constantExist(formOfEducation);
    }
    /**
     * valid formOfEducation
     * @param formOfEducation - formOfEducation to valid
     * @return result of validation
     */
    public static boolean validFormOfEducation(FormOfEducation formOfEducation){
        return true;
    }

    /**
     * calid semester
     * @param semester - semester to valid
     * @return result of validation
     */
    public static boolean validSemester(String semester){
        return semester==null || Semester.constantExist(semester);
    }
    /**
     * calid semester
     * @param semester - semester to valid
     * @return result of validation
     */
    public static boolean validSemester(Semester semester){
        return true;
    }

    /**
     * valid person
     * @param person - person to valid
     * @return result of validation
     */
    public static boolean validPerson(Person person){
        return PersonValidator.validPerson(person);
    }

    /**
     * valid ids in collection
     * @param studyGroups - collection of studyGroup yo valid
     * @return result of validation
     */
    public static boolean validCollectionId(Collection<StudyGroup> studyGroups){
        Set<Integer> id = new HashSet<>();
        studyGroups.forEach(element -> id.add(element.getId()));
        return id.size() == studyGroups.size();
    }
}
