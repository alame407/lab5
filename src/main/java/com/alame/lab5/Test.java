package com.alame.lab5;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.elements.Person;
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
        new File("."+FileSystems.getDefault().getSeparator() + "files").mkdirs();
        File file = new File("files" + FileSystems.getDefault().getSeparator() + "elements.csv");
        FileWriter fileWriter = new FileWriter(file);
        String[] HEADERS = {"key", "id", "name", "Coordinates x", "Coordinates y", "creationDate",
                "studentsCount", "expelledStudents", "formOfEducation", "semesterEnum", "groupAdmin name",
                "groupAdmin birthday", "groupAdmin eyeColor", "groupAdmin hairColor", "groupAdmin nationality"};
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setNullString("")
                .setDelimiter(",")
                .build();
        CSVPrinter printer = csvFormat.print(fileWriter);
        Map<String, StudyGroup> studyGroupMap = new HashMap<>() {
            {
                put("1", new StudyGroup("2", new Coordinates(2L,2),2,5L,DISTANCE_EDUCATION,FIRST,new Person("name",LocalDate.now(),RED,GREEN,VATICAN)));

            }
        };
        for (Map.Entry<String, StudyGroup> entry : studyGroupMap.entrySet()) {
            String key = entry.getKey();
            StudyGroup studyGroup = entry.getValue();
            Person groupAdmin = studyGroup.getGroupAdmin();
            Coordinates coordinates = studyGroup.getCoordinates();
            printer.printRecord(key, String.valueOf(studyGroup.getId()), studyGroup.getName(), coordinates.getX().toString(),
                    String.valueOf(coordinates.getY()),
                    studyGroup.getCreationDate().toString(), studyGroup.getStudentsCount().toString(),
                    studyGroup.getExpelledStudents().toString(),
                    studyGroup.getFormOfEducation().toString(), studyGroup.getSemesterEnum().toString(),
                    groupAdmin.getName(),
                    groupAdmin.getBirthday(), groupAdmin.getEyeColor(),
                    groupAdmin.getHairColor(),
                    groupAdmin.getNationality());
        }
        fileWriter.close();
    }
}
