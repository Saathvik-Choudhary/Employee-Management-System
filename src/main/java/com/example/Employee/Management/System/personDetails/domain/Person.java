package com.example.Employee.Management.System.personDetails.domain;

import com.example.Employee.Management.System.personDetails.personCommon.Gender;
import com.example.Employee.Management.System.personDetails.personCommon.MaritalStatus;
import com.example.Employee.Management.System.personDetails.personCommon.Nationality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false, updatable = false)
    private Long personId;

    @NotNull(message = "The address of the person in mandatory")
    @OneToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @NotNull(message = "Created date cannot be null")
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @NotNull(message = "Date of birth cannot be null")
    @Column(name = "dob", nullable = false, updatable = false)
    private Date dob;

    @NotNull(message = "Email ID cannot be null")
    @NotBlank(message = "Email ID cannot be blank")
    @Email(message = "Invalid email format")
    @Column(name = "email_id", nullable = false)
    private String emailId;

    @NotBlank(message = "First name cannot be blank")
    @Column(name = "first_name", nullable = false, updatable = false)
    private String firstName;

    @NotBlank(message = "File path cannot be blank")
    @Column(name = "file_path", nullable = false, updatable = false)
    private String filePath;

    @NotNull(message = "Gender cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotBlank(message = "ID number cannot be blank")
    @Column(name = "id_number", nullable = false, updatable = false)
    private String idNumber;

    @NotBlank(message = "Identification type cannot be blank")
    @Column(name = "identification_type", nullable = false, updatable = false)
    private String identificationType;

    @NotBlank(message = "Last name cannot be blank")
    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @NotNull(message = "Marital status cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", updatable = false)
    private MaritalStatus maritalStatus;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull(message = "Nationality cannot be null")
    @Column(name = "nationality", nullable = false, updatable = false)
    private Nationality nationality;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull(message = "Health details cannot be null")
    @OneToOne
    @JoinColumn(name = "health")
    private Health health;

    @NotNull(message = "Family details cannot be null")
    @OneToOne
    @JoinColumn(name = "family")
    private Family family;

    Person(){
        super();
    }

    public Person(final String firstName,
                  final String lastName,
                  final Date dob,
                  final String phoneNumber,
                  final String emailId,
                  final Address address,
                  final Gender gender,
                  final String idNumber,
                  final String identificationType,
                  final MaritalStatus maritalStatus) {
        setAddress(address);
        setDob(dob);
        setEmailId(emailId);
        setFirstName(firstName);
        setGender(gender);
        setIdNumber(idNumber);
        setIdentificationType(identificationType);
        setLastName(lastName);
        setMaritalStatus(maritalStatus);
        setPhoneNumber(phoneNumber);
    }

    /**
     * Get the address of the person
     *
     * @return the address of the person
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Get the created date and time of the person object
     *
     * @return the created date and time of the person object
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Get the date of birth of the person
     *
     * @return the date of birth of the person
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Get the email id of the person
     *
     * @return the email id of the person
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Get the first name of the person
     *
     * @return the first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the file path of where the person's documents have been stored
     *
     * @return the file path of where the person's documents have been stored
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Get the gender of the person
     *
     * @return the gender of the person
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Get the id number of the person as per official documentation
     *
     * @return the id number of the person as per official documentation
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Get the type of identification submitted by the person
     *
     * @return the type of identification submitted by the person
     */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * Get the last name of the person
     *
     * @return the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the marital status of the person
     *
     * @return the marital status of the person
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Get the middle name of the person
     *
     * @return the middle name of the person
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Get the nationality of the person
     *
     * @return the nationality of the person
     */
    public Nationality getNationality() {
        return nationality;
    }

    /**
     * Get the phone number of the person
     *
     * @return the phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the health details of the person
     *
     * @return health object containing the health details of the person
     */
    public Health getHealth() {
        return health;
    }

    /**
     * Get the family details of the person
     *
     * @return family object containing the family details of the person
     */
    public Family getFamily() {
        return family;
    }


    public void setAddress(final Address address) {
        this.address = address;
    }

    private void setCreatedDate() {
        this.createdDate = new Date();
    }

    private void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}

