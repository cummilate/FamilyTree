package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public class AuntUncleRelationAction extends OtherRelationAction {

    public void addRelation(Person parent, String relationName, String relativeName) {

        throw new RuntimeException("Invalid action");

    }

    public Set<String> findRelation(Person person, String relationName) {

        int depth = getDepth(person, 0);
        int height = 1; //aunts and uncles are one level up
        Person head = person.getRoot();
        Set<Person> interestedPersons = getPersonsAtLevel(head, depth - height, true);

        GenderType gType = getGender(relationName);
        Set<String> auntOrUncleNames = new LinkedHashSet<String>();
        for (Person interestedPerson : interestedPersons) {


            if (interestedPerson.getGender() == gType && !person.getFather().equals(interestedPerson) && !person.getMother().equals(interestedPerson)) {
                auntOrUncleNames.add(interestedPerson.getName());
            }


        }

        return auntOrUncleNames;

    }


}
