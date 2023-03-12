package com.alame.lab5.elements;

import com.alame.lab5.csv.CsvElementsWriter;
import com.alame.lab5.exceptions.CollectionIsEmptyException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

import java.io.IOException;
import java.util.*;

public class Receiver {
    private final Map<String, StudyGroup> studyGroupMap;
    private final java.time.LocalDate creationDate;
    private final String COLLECTION_TYPE = "TreeMap";
    public Receiver(){
        studyGroupMap = new TreeMap<>();
        creationDate = java.time.LocalDate.now();
    }
    public String info(){
        return "тип коллекции: " + COLLECTION_TYPE + " дата создания коллекции: " + creationDate +
                " количество элементов: " + studyGroupMap.size();
    }
    public List<StudyGroup> show(){
        return new ArrayList<>(studyGroupMap.values());
    }
    public void insert(String key, StudyGroup element){
        studyGroupMap.put(key, element);
    }
    public void update(int id, String name, Coordinates coordinates, int studentsCount, long expelledStudents,
                       FormOfEducation formOfEducation, Semester semester, Person groupAdmin)
            throws IncorrectElementFieldException{
        for(Map.Entry<String, StudyGroup> entry: studyGroupMap.entrySet()){
            StudyGroup studyGroup = entry.getValue();
            if (studyGroup.getId()==id) {
                studyGroup.setGroupAdmin(groupAdmin);
                studyGroup.setName(name);
                studyGroup.setCoordinates(coordinates);
                studyGroup.setExpelledStudents(expelledStudents);
                studyGroup.setFormOfEducation(formOfEducation);
                studyGroup.setSemesterEnum(semester);
                studyGroup.setStudentsCount(studentsCount);
                return;
            }

        }
    }
    public void removeKey(String key){
        studyGroupMap.remove(key);
    }
    public void clear(){
        studyGroupMap.clear();
    }
    public void removeLowerKey(String key){
        studyGroupMap.keySet().removeIf(keyElement -> keyElement.compareTo(key)<0);
    }
    public void replaceIfLower(String key, StudyGroup newStudyGroup){
        if(studyGroupMap.containsKey(key)){
            StudyGroup studyGroup = studyGroupMap.get(key);
            if (newStudyGroup.compareTo(studyGroup) < 0) studyGroupMap.replace(key, newStudyGroup);
        }
    }
    public void removeAllByFormOfEducation(FormOfEducation formOfEducation){
        studyGroupMap.entrySet().removeIf(entry -> entry.getValue().getFormOfEducation()==formOfEducation);
    }
    public StudyGroup maxByCreationDate() throws CollectionIsEmptyException {
        if (studyGroupMap.size()==0) throw new CollectionIsEmptyException("в коллекции нет элементов");
        return  Collections.max(studyGroupMap.values(), Comparator.comparing(StudyGroup::getCreationDate));
    }
    public List<Person> printFieldDescendingGroupAdmin(){
        List<Person> result = new ArrayList<>();
        studyGroupMap.values().forEach(studyGroup -> result.add(studyGroup.getGroupAdmin()));
        result.sort(Comparator.reverseOrder());
        return result;
    }
    public void save() throws IOException{
        CsvElementsWriter csvElementsWriter = new CsvElementsWriter();
        csvElementsWriter.write(studyGroupMap);
        csvElementsWriter.close();
    }
    public void putAll(Map<String, StudyGroup> studyGroupMap){
        this.studyGroupMap.putAll(studyGroupMap);
    }
    public boolean idExist(int id){
        for (StudyGroup studyGroup: studyGroupMap.values()){
            if (studyGroup.getId()==id) return true;
        }
        return false;
    }
}
