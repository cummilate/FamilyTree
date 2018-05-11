package com.tmt.family.entity;

import com.tmt.family.enums.GenderType;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private String name;
    private GenderType gender;

    private Person spouse;
    private Set<Person> children = new LinkedHashSet<Person>();
    private Person father;
    private Person mother;


    public Person(String name, GenderType gender) {
        this.name = name;
        this.gender = gender;
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;

    }

    public Set<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        if (spouse == null) {
            throw new RuntimeException("Cannot have a child without Spouse");
        }
        this.children.add(child);
        this.spouse.getChildren().add(child); //maintain sync
        child.setFather(this.gender == GenderType.MALE ? this : spouse);
        child.setMother(this.gender == GenderType.FEMALE ? this : spouse);
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    /**
     * return either mother or father who belongs to family tree
     */
    public Person getParent() {
        Person parent = null;
        if (this.getFather() != null && this.getMother() != null) { // person part of family tree
            if (getMother().getMother() != null && getMother().getFather() != null) { //mother is part of family tree
                parent = getMother();
            } else {
                parent = getFather();
            }
        }
        return parent;

    }

    public Person getRoot() {
        Person parent = null;
        do {
            parent = parent.getParent();
        } while (parent != null);

        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
