package com.tmt.family.relation.action;

import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class RelationAction {

    public abstract void addRelation(Person person, String relationName, String relativeName);
    public abstract Set<String> findRelation(Person person, String relationName);

    List<String> maleRelations = Arrays.asList("Husband", "Son", "Sons","Brother", "Brothers", "Father",  "GrandFather", "GrandSon", "GrandSons", "Uncle");
    List<String> femaleRelations = Arrays.asList("Wife", "Daughter","Daughters","Sister", "Sisters", "Mother", "GrandMother","GrandDaughter","GrandDaughters", "Aunt");

    protected GenderType getGender(String relationName) {
        if(maleRelations.contains(relationName)){
            return GenderType.MALE;
        } else if(femaleRelations.contains(relationName)){
            return  GenderType.FEMALE;
        } else {
            throw new RuntimeException("Invalid Relation : " + relationName);
        }
    }

}
