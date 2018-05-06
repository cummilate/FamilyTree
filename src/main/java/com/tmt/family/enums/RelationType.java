package com.tmt.family.enums;

import java.util.Arrays;

public enum RelationType {
    /*List<String> relationNames;
    GenderType gender;

    RelationType(String[] relationNames, GenderType gender){
        this.relationNames = Arrays.asList(relationNames);
        this.gender = gender;

    }
    */
    FATHER, BROTHER, MOTHER, SISTER, SON, DAUGHTER, COUSIN, GRANDMOTHER, GRANDFATHER, GRANDSON, GRANDDAUGHTER,
    AUNT, UNCLE, WIFE, HUSBAND;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }


}
