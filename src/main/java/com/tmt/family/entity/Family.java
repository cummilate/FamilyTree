package com.tmt.family.entity;

import com.tmt.family.entity.Person;

public class Family {

    private Person head;

    public Family(Person head) {
        this.head = head;
    }

    public Person getHead() {
        return head;
    }

    private static Person getPerson(String name, Person person) {
        Person p = null;
        if (person != null) {

            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
            if (person.getSpouse() != null && person.getSpouse().getName().equalsIgnoreCase(name)) {
                return person.getSpouse();
            }

            if (person.getChildren() != null) {

                for (Person child : person.getChildren()) {
                    p = getPerson(name, child);
                    if (p != null) {
                        break;
                    }
                }

            }

        }

        return p;

    }

    public Person getPerson(String name) {
        Person p = getPerson(name, head);
        if (p == null) {
            throw new RuntimeException("Person Not Found in the Family : " + name);
        }
        return p;
    }

}
