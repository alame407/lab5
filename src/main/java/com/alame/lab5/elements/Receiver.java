package com.alame.lab5.elements;

import com.alame.lab5.csv.CsvElementsWriter;
import com.alame.lab5.exceptions.CollectionIsEmptyException;

import java.io.IOException;
import java.util.*;

public class Receiver {
    private final Map<String, StudyGroup> studyGroupMap;
    private final java.time.LocalDate creationDate;
    private final String collectionType = "TreeMap";
    public Receiver(){
        studyGroupMap = new TreeMap<>();
        creationDate = java.time.LocalDate.now();
    }
    public String info(){
        return "тип коллекции: " + collectionType + " дата создания коллекции: " + creationDate +
                " количество элементов: " + studyGroupMap.size();
    }
    public List<StudyGroup> show(){
        return new ArrayList<>(studyGroupMap.values());
    }
    public void insert(String key, StudyGroup element){
        studyGroupMap.put(key, element);
    }
    public void update(int id, StudyGroup newStudyGroup){
        for(Map.Entry<String, StudyGroup> entry: studyGroupMap.entrySet()){
            if (entry.getValue().getId()==id) {
                studyGroupMap.replace(entry.getKey(), newStudyGroup);
            }
            return;
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
}
