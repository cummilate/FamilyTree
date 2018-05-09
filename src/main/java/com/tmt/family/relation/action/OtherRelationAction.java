package com.tmt.family.relation.action;

import com.tmt.family.FamilyFactory;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class OtherRelationAction extends RelationAction {


    protected Set<Person> getPersonsAtLevel(Person head, int level, boolean includeSpouse) {
        Set<Person> interestedPersons = new LinkedHashSet<Person>();

        for (Person child : head.getChildren()) {

            if (level - 1 > 0) { //one level down from starting position, and still has level to traverse?
                interestedPersons.addAll(getPersonsAtLevel(child, level - 1, includeSpouse));
            } else {
                interestedPersons.add(child);
                if (includeSpouse && child.getSpouse() != null) {
                    interestedPersons.add(child.getSpouse());
                }
            }
        }
        return interestedPersons;
    }


    protected int getDepth(Person person, int position) {
        int depth = position;
        if (person.getParent() != null) {
            depth = getDepth(person.getParent(), depth + 1);
        }
        return depth;
    }
}
