package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class AncestorRelationAction extends RelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {
        throw new RuntimeException("Invalid action");

    }

    public Set<String> findRelation(Person person, String relationName) {
        GenderType gType = getGender(relationName);
        Person grandParent = null;
        Person parent = person.getParent();//person.getFather() != null ? person.getFather() : person.getMother();
        Set<String> grandParentName = new LinkedHashSet<String>();
        String name = "";

        if (parent != null) {
            if (gType == GenderType.FEMALE) {
                grandParent = parent.getMother();
            } else if (gType == GenderType.MALE) {
                grandParent = parent.getFather();
            }else{
                throw new RuntimeException("Invalid Relation!");
            }
        }
        if (grandParent != null) {
            name = grandParent.getName();
        }
        grandParentName.add(name);


        return grandParentName;

    }
}
