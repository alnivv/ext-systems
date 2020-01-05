package edu.javacourse.register.domain;

import java.time.LocalDate;
import java.util.List;

public class Person {
    private Long personId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private List<Passport> passports;
}
