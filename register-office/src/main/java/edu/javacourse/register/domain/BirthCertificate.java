package edu.javacourse.register.domain;

import java.time.LocalDate;

public class BirthCertificate {
    private long birthCertificateId;
    private String number;
    private LocalDate issueDate;
    private Person person;
    private PersonMale father;
    private PersonFemale mother;
}
