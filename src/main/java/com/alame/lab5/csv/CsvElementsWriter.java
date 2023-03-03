package com.alame.lab5.csv;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.elements.Person;
import com.alame.lab5.elements.StudyGroup;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Map;

public class CsvElementsWriter {
    private final static String[] HEADERS = { "key", "id", "name", "Coordinates x", "Coordinates y", "creationDate",
            "studentsCount", "expelledStudents", "formOfEducation", "semesterEnum", "groupAdmin name",
            "groupAdmin birthday", "groupAdmin eyeColor", "groupAdmin hairColor", "groupAdmin nationality"};
    FileWriter fileWriter;
    CSVFormat csvFormat;
    public CsvElementsWriter() throws IOException {
        new File("."+FileSystems.getDefault().getSeparator() +"files").mkdirs();
        File file = new File("files"+ FileSystems.getDefault().getSeparator() + "records.csv");
        fileWriter = new FileWriter(file);
        csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setNullString("")
                .setDelimiter(",")
                .build();
    }
    public void write(Map<String, StudyGroup> studyGroupMap) throws IOException{
        CSVPrinter printer = csvFormat.print(fileWriter);
        for(Map.Entry<String, StudyGroup> entry: studyGroupMap.entrySet()){
            String key = entry.getKey();
            StudyGroup studyGroup = entry.getValue();
            Person groupAdmin = studyGroup.getGroupAdmin();
            Coordinates coordinates = studyGroup.getCoordinates();
            printer.printRecord(key, studyGroup.getId(), studyGroup.getName(), coordinates.getX(), coordinates.getY(),
                    studyGroup.getCreationDate(), studyGroup.getStudentsCount(), studyGroup.getExpelledStudents(),
                    studyGroup.getFormOfEducation(), studyGroup.getSemesterEnum(), groupAdmin.getName(),
                    groupAdmin.getBirthday(), groupAdmin.getEyeColor(), groupAdmin.getHairColor(),
                    groupAdmin.getNationality());
        }
    }
    public void close() throws IOException{
        fileWriter.close();
    }
}
