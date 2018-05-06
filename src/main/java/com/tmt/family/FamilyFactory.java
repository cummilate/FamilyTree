package com.tmt.family;

import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

import java.util.HashMap;
import java.util.Map;

public class FamilyFactory {

    private static Map<String, Family> families = new HashMap();

    public static Family getFamily(String familyHeadName) {
        Family f = families.get(familyHeadName);
        return f;
    }

    public static Family createFamily(Person person) {

        Family f = new Family(person);
        families.put(person.getName(), f);
        return f;
    }

    public static Person createPerson(String name, GenderType genderType) {
        Person person = new Person(name, genderType);
        return person;
    }

}
