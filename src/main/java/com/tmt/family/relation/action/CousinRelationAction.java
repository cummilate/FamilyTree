package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;

import java.util.LinkedHashSet;
import java.util.Set;

public class CousinRelationAction extends OtherRelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

        throw new RuntimeException("Invalid action");

    }

    public Set<String> findRelation(Person person, String relationName) {

        int depth = getDepth(person, 0);
        int height = 0; //Cousins are at same level
        Person head = FamilyFactory.getFamily().getHead();
        Set<Person> interestedPersons = getPersonsAtLevel(head, depth - height, false);
        Set<String> cousins = new LinkedHashSet<String>();
        for (Person interestedPerson : interestedPersons) {
            if (person.getParent() != null && !person.getParent().getChildren().contains(interestedPerson)) {
                cousins.add(interestedPerson.getName());
            }

        }

        return cousins;

    }


}
