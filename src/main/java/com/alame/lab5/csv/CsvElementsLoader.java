package com.alame.lab5.csv;

import com.alame.lab5.elements.Coordinates;
import com.alame.lab5.elements.Person;
import com.alame.lab5.elements.Receiver;
import com.alame.lab5.elements.StudyGroup;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.exceptions.IncorrectKeyException;
import com.alame.lab5.utility.parsers.CoordinatesParser;
import com.alame.lab5.utility.parsers.KeyParser;
import com.alame.lab5.utility.parsers.PersonParser;
import com.alame.lab5.utility.parsers.StudyGroupParser;
import com.alame.lab5.utility.validators.StudyGroupValidator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;

public class CsvElementsLoader {
    private final static String[] HEADERS = { "key", "id", "name", "Coordinates x", "Coordinates y", "creationDate",
            "studentsCount", "expelledStudents", "formOfEducation", "semesterEnum", "groupAdmin name",
            "groupAdmin birthday", "groupAdmin eyeColor", "groupAdmin hairColor", "groupAdmin nationality"};
    private final Receiver receiver;
    private final Reader reader;
    public CsvElementsLoader(Reader reader, Receiver receiver){
        this.reader = reader;
        this.receiver = receiver;
    }
    public void load() throws IOException, IncorrectElementFieldException, IncorrectKeyException {
        Map<String, StudyGroup> elements = new TreeMap<>();
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .setNullString("")
                .setDelimiter(",")
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(reader);

        for (CSVRecord record : records) {
            String key = record.get("key");
            String id = record.get("id");
            String name = record.get("name");
            String coordinatesX = record.get("Coordinates x");
            String coordinatesY = record.get("Coordinates y");
            String creationDate = record.get("creationDate");
            String studentsCount = record.get("studentsCount");
            String expelledStudents = record.get("expelledStudents");
            String formOfEducation = record.get("formOfEducation");
            String semesterEnum = record.get("semesterEnum");
            String groupAdminName = record.get("groupAdmin name");
            String groupAdminBirthday = record.get("groupAdmin birthday");
            String groupAdminEyeColor = record.get("groupAdmin eyeColor");
            String groupAdminHairColor = record.get("groupAdmin hairColor");
            String groupAdminNationality = record.get("groupAdmin nationality");
            Coordinates coordinates = new Coordinates(CoordinatesParser.parseX(coordinatesX),
                    CoordinatesParser.parseY(coordinatesY));
            Person groupAdmin = new Person(PersonParser.parseName(groupAdminName),
                    PersonParser.parseBirthday(groupAdminBirthday),
                    PersonParser.parseEyesColor(groupAdminEyeColor), PersonParser.parseHairColor(groupAdminHairColor),
                    PersonParser.parseCountry(groupAdminNationality));
            StudyGroup studyGroup = new StudyGroup(StudyGroupParser.parseId(id),StudyGroupParser.parseName(name),
                    coordinates, StudyGroupParser.parseCreationDate(creationDate),
                    StudyGroupParser.parseStudentsCount(studentsCount),
                    StudyGroupParser.parseExpelledStudents(expelledStudents),
                    StudyGroupParser.parseFormOfEducation(formOfEducation),
                    StudyGroupParser.parseSemester(semesterEnum), groupAdmin);
            elements.put(KeyParser.parseKey(key), studyGroup);
        }
        if (!(StudyGroupValidator.validCollectionId(elements.values())))
            throw new IncorrectElementFieldException("id должны быть различны");
        receiver.putAll(elements);
    }
}
