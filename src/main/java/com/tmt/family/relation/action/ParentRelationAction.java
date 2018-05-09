package com.tmt.family.relation.action;

import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class ParentRelationAction extends RelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

        throw new RuntimeException("Invalid action");

    }

    public Set<String> findRelation(Person person, String relationName) {

        GenderType gType = getGender(relationName);
        Set<String> parentName = new LinkedHashSet<String>();
        String name;
        if (gType == GenderType.FEMALE && person.getMother() != null) {

            name = person.getMother().getName();

        } else if (gType == GenderType.MALE && person.getFather() != null) {

            name = person.getFather().getName();

        } else {

            throw new RuntimeException("No Information!");

        }
        parentName.add(name);

        return parentName;
    }
}
