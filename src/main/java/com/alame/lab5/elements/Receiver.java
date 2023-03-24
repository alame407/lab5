package com.alame.lab5.elements;

import com.alame.lab5.csv.CsvElementsWriter;
import com.alame.lab5.exceptions.CollectionIsEmptyException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;

import java.io.IOException;
import java.util.*;

/**
 * class for collection control
 */
public class Receiver {
    /**
     * collection
     */
    private final Map<String, StudyGroup> studyGroupMap;
    /**
     * date the collection was created
     */
    private final java.time.LocalDate creationDate;
    /**
     * type of collection
     */
    private final String COLLECTION_TYPE = "TreeMap";
    public Receiver(){
        studyGroupMap = new TreeMap<>();
        creationDate = java.time.LocalDate.now();
    }

    /**
     * @return info about collection
     */
    public String info(){
        return "тип коллекции: " + COLLECTION_TYPE + " дата создания коллекции: " + creationDate +
                " количество элементов: " + studyGroupMap.size();
    }

    /**
     * @return all studyGroups in collection
     */
    public List<StudyGroup> show(){
        return new ArrayList<>(studyGroupMap.values());
    }

    /**
     * insert a pair of key and element in collection
     * @param key - key in map
     * @param element - value in map
     */
    public void insert(String key, StudyGroup element){
        studyGroupMap.put(key, element);
    }

    /**
     * update fields of element
     * @param id - id of element
     * @param name - name of element
     * @param coordinates - coordinates of element
     * @param studentsCount - studentsCount of element
     * @param expelledStudents - expelledStudents of element
     * @param formOfEducation - formOfEducation of element
     * @param semester - semester of element
     * @param groupAdmin - groupAdmin of element
     * @throws IncorrectElementFieldException if fields are not valid
     */
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

    /**
     * delete value by key
     * @param key - key in map
     */
    public void removeKey(String key){
        studyGroupMap.remove(key);
    }

    /**
     * clear collection
     */
    public void clear(){
        studyGroupMap.clear();
    }

    /**
     * delete all keys which less than iven
     * @param key - key for compare
     */
    public void removeLowerKey(String key){
        studyGroupMap.keySet().removeIf(keyElement -> keyElement.compareTo(key)<0);
    }

    /**
     * replace element by key if element less than given
     * @param key - key in map
     * @param newStudyGroup - new element value
     */
    public void replaceIfLower(String key, StudyGroup newStudyGroup){
        if(studyGroupMap.containsKey(key)){
            StudyGroup studyGroup = studyGroupMap.get(key);
            if (newStudyGroup.compareTo(studyGroup) < 0) studyGroupMap.replace(key, newStudyGroup);
        }
    }

    /**
     * delete all elements where formOfEducation equals to given
     * @param formOfEducation - formOfEducation to delete
     */
    public void removeAllByFormOfEducation(FormOfEducation formOfEducation){
        studyGroupMap.entrySet().removeIf(entry -> entry.getValue().getFormOfEducation()==formOfEducation);
    }

    /**
     * find max element by creationDate
     * @return max element by creation date
     * @throws CollectionIsEmptyException - if collection size=0
     */
    public StudyGroup maxByCreationDate() throws CollectionIsEmptyException {
        if (studyGroupMap.size()==0) throw new CollectionIsEmptyException("в коллекции нет элементов");
        return  Collections.max(studyGroupMap.values(), Comparator.comparing(StudyGroup::getCreationDate));
    }

    /**
     * group groupAdmins
     * @return list of grouped admins
     */
    public List<Person> printFieldDescendingGroupAdmin(){
        List<Person> result = new ArrayList<>();
        studyGroupMap.values().forEach(studyGroup -> result.add(studyGroup.getGroupAdmin()));
        result.sort(Comparator.reverseOrder());
        return result;
    }

    /**
     * save collection in file
     * @throws IOException if something goes wrong with file
     */
    public void save() throws IOException{
        CsvElementsWriter csvElementsWriter = new CsvElementsWriter();
        csvElementsWriter.write(studyGroupMap);
        csvElementsWriter.close();
    }

    /**
     * put all values in map in collection
     * @param studyGroupMap - values to put
     */
    public void putAll(Map<String, StudyGroup> studyGroupMap){
        this.studyGroupMap.putAll(studyGroupMap);
    }

    /**
     * check if id represented in collection
     * @param id - id of element
     * @return true if id represented in collection, else false
     */
    public boolean idExist(int id){
        for (StudyGroup studyGroup: studyGroupMap.values()){
            if (studyGroup.getId()==id) return true;
        }
        return false;
    }
    public boolean keyExist(String key){
        return studyGroupMap.containsKey(key);
    }
}
