package com.tmt.family;

import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;

public class FamilyFactory {

    private static Family defaultFamily;


    public static Family getDefaultFamily() {
        if (defaultFamily == null) {
            defaultFamily = createDefaultFamily();
        }
        return defaultFamily;

    }

    private static Family createDefaultFamily() {
        Person husband = createPerson("Evan", GenderType.MALE);
        Person wife = createPerson("Diana", GenderType.FEMALE);

        husband.setSpouse(wife);
        wife.setSpouse(husband);

        Family family = createFamily(husband);
        return family;
    }

    public static Family createFamily(Person person) {
        Family f = new Family(person);
        return f;
    }

    public static Person createPerson(String name, GenderType genderType) {
        Person person = new Person(name, genderType);
        return person;
    }

}
