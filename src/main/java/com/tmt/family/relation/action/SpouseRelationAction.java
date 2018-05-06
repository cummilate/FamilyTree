package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.Set;

/**
 * This class can have subclasses like HusbandRelationAction, WifeRelationAction by overriding #getGender()
 */
public class SpouseRelationAction extends RelationAction {
    public void addRelation(Person person, String relationName, String relativeName) {
        GenderType gType = getGender(relationName);

        Person spouse = FamilyFactory.createPerson(relativeName, gType);
        person.setSpouse(spouse);
        spouse.setSpouse(person);


    }


    public Set<String> findRelation(Person person, String relationName) {
        throw new RuntimeException("Invalid action");
    }
}
