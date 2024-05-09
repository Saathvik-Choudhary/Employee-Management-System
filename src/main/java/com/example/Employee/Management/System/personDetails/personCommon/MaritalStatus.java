package com.example.Employee.Management.System.personDetails.personCommon;

public enum MaritalStatus {
    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    SEPARATED("Separated"),
    CIVIL_UNION("Civil Union"),
    DOMESTIC_PARTNERSHIP("Domestic Partnership"),
    REGISTERED_PARTNERSHIP("Registered Partnership"),
    OTHER("Other");

    private final String label;

    MaritalStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
