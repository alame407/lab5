package com.alame.lab5.utility.validators;

import com.alame.lab5.elements.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StudyGroupValidator {
    public static boolean validStudyGroup(StudyGroup studyGroup){
        return validId(studyGroup.getId()) && validName(studyGroup.getName()) &&
                validCoordinates(studyGroup.getCoordinates()) &&  validCreationDate(studyGroup.getCreationDate()) &&
                validStudentsCount(studyGroup.getStudentsCount()) &&
                validExpelledStudents(studyGroup.getExpelledStudents()) &&
                validFormOfEducation(studyGroup.getFormOfEducation()) &&
                validSemester(studyGroup.getSemesterEnum()) && validPerson(studyGroup.getGroupAdmin());
    }
    public static boolean validName(String name){
        return !(name == null || name.equals(""));
    }
    public static boolean validId(int id){
        return id>0;
    }
    public static boolean validCoordinates(Coordinates coordinates){
        return CoordinatesValidator.validCoordinates(coordinates);
    }
    public static boolean validCreationDate(LocalDate creationDate){
        return !(creationDate == null);
    }
    public static boolean validStudentsCount(int studentsCount){
        return studentsCount>0;
    }
    public static boolean validExpelledStudents(long expelledStudents){
        return expelledStudents>0;
    }
    public static boolean validFormOfEducation(String formOfEducation){
        return formOfEducation==null || FormOfEducation.constantExist(formOfEducation);
    }
    public static boolean validFormOfEducation(FormOfEducation formOfEducation){
        return true;
    }
    public static boolean validSemester(String semester){
        return semester==null || Semester.constantExist(semester);
    }
    public static boolean validSemester(Semester semester){
        return true;
    }
    public static boolean validPerson(Person person){
        return PersonValidator.validPerson(person);
    }
    public static boolean validCollectionId(Collection<StudyGroup> studyGroups){
        Set<Integer> id = new HashSet<>();
        studyGroups.forEach(element -> id.add(element.getId()));
        return id.size() == studyGroups.size();
    }
}
