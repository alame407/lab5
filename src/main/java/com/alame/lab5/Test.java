package com.alame.lab5;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.elements.Person;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.exceptions.IncorrectKeyException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.alame.lab5.elements.Country.VATICAN;
import static com.alame.lab5.elements.EyesColor.RED;
import static com.alame.lab5.elements.FormOfEducation.DISTANCE_EDUCATION;
import static com.alame.lab5.elements.HairColor.GREEN;
import static com.alame.lab5.elements.Semester.FIRST;

public class Test {
    public static void main(String[] args) throws IOException, IncorrectElementFieldException, IncorrectKeyException {
        Map<String, StudyGroup> studyGroupMap = new HashMap<>() {
            {
                put("1", new StudyGroup("2", new Coordinates(2L,2),2,5L,DISTANCE_EDUCATION,FIRST,new Person("name",LocalDate.now(),RED,GREEN,VATICAN)));

            }
        };
        Receiver receiver = new Receiver();
        receiver.putAll(studyGroupMap);
        receiver.save();
    }

}
