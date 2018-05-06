package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class ChildRelationAction extends RelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

        GenderType gType = getGender(relationName);

        Person child = FamilyFactory.createPerson(relativeName, gType);
        parent.addChild(child);

    }

    public Set<String> findRelation(Person person, String relationName) {
        GenderType gType = getGender(relationName);
        Set<String> childrenNames = new LinkedHashSet<String>();
        Set<Person> children = person.getChildren();
        if (children != null && !children.isEmpty()) {

            for (Person child : children) {
                if (child.getGender() == gType) {
                    childrenNames.add(child.getName());
                }

            }

        }
        return childrenNames;

    }
}
