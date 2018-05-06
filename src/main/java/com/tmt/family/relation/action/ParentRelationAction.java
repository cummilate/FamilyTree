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

        if(gType == GenderType.FEMALE){
            parentName.add( person.getMother().getName());
            return parentName;
        }

        if(gType == GenderType.MALE){
            parentName.add( person.getFather().getName());
            return parentName;
        }

        throw new RuntimeException("Invalid Relation!");

    }
}
