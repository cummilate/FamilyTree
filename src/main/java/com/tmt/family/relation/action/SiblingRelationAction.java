package com.tmt.family.relation.action;

import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class SiblingRelationAction extends RelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

       throw new RuntimeException("Invalid action");

    }

    public Set<String> findRelation(Person person, String relationName) {

        GenderType gType = getGender(relationName);
        Set<String> siblingNames = new LinkedHashSet<String>();
        Set<Person> siblings = person.getFather().getChildren();
        if (siblings != null && !siblings.isEmpty()) {

            for (Person child : siblings) {
                if (child.getGender() == gType && !child.equals(person)) {
                    siblingNames.add(child.getName());
                }

            }

        }
        return siblingNames;

    }
}
