package com.example.Employee.Management.System.personDetails.personCommon;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NON_BINARY("Non-Binary"),
    GENDERQUEER("Genderqueer"),
    GENDERFLUID("Genderfluid"),
    AGENDER("Agender"),
    BIGENDER("Bigender"),
    TWO_SPIRIT("Two-Spirit"),
    TRANS_MALE("Trans Male"),
    TRANS_FEMALE("Trans Female"),
    OTHER("Other"),
    UNKNOWN("Unknown");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
