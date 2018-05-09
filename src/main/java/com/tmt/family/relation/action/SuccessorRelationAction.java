package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class SuccessorRelationAction extends RelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

        GenderType gType = getGender(relationName);

        Person child = FamilyFactory.createPerson(relativeName, gType);
        parent.addChild(child);

    }

    public Set<String> findRelation(Person person, String relationName) {
        GenderType gType = getGender(relationName);
        Set<String> grandChildrenNames = new LinkedHashSet<String>();
        Set<Person> children = person.getChildren();

        for (Person child : children) {
            if (child == null) {
                continue;
            }

            for (Person grandChild : child.getChildren()) {
                if (grandChild.getGender() == gType) {
                    grandChildrenNames.add(grandChild.getName());
                }

            }
            

        }

        return grandChildrenNames;

    }
}
