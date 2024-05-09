package com.example.Employee.Management.System.personDetails.domain;

import com.example.Employee.Management.System.common.StringUtil;
import com.example.Employee.Management.System.personDetails.personCommon.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "address")
public abstract class Address {

    @Id
    @Column(name = "address_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;


    @NotNull(message = "Address line 1 cannot be null")
    @NotBlank(message = "Address line 1 cannot be blank")
    @Column(name = "address_line_1", nullable = false)
    private String addressLine1;

    @NotNull(message = "Address line 2 cannot be null")
    @NotBlank(message = "Address line 2 cannot be blank")
    @Column(name = "address_line_2", nullable = false)
    private String addressLine2;

    @NotNull(message = "City cannot be null")
    @NotBlank(message = "City cannot be blank")
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull(message = "Country cannot be null")
    @Column(name = "country", nullable = false, updatable = false)
    private Country country;

    @NotNull(message = "Postal code cannot be null")
    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @NotNull(message = "Creation timestamp cannot be null")
    @Column(name = "creation_time_stamp", nullable = false, updatable = false)
    private Date creationTimeStamp;

    @NotNull(message = "Updated timestamp cannot be null")
    @Column(name = "updated_time_stamp", nullable = false)
    private Date updatedTimeStamp;

    Address() {
        super();
    }

    public Address(final String addressLine1,
                   final String addressLine2,
                   final String city,
                   final String postalCode,
                   final Country country) {
        this();

        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        setCreationTimeStamp();
        setUpdatedTimeStamp();
    }

    /**
     * Get the address line1 of the address
     *
     * @return the address line1 of the address
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Get the address line2 of the address
     *
     * @return the address line2 of the address
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Get the city of the address
     *
     * @return the city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the country of the address
     *
     * @return the country of the address
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Get the creation Time Stamp of the address
     *
     * @return the creation time stamp of the address
     */
    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    /**
     * Get the postal code of the address
     *
     * @return the postal code of the address
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Get the updated Time stamp of the address
     *
     * @return the updated time stamp of the address
     */
    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setAddressLine1(final String addressLine1) {
        if (StringUtil.isBlank(addressLine1)) {
            throw new IllegalArgumentException("Address line 1 cannot be null, empty, or contain only whitespace");
        }
        this.addressLine1 = addressLine1.trim();
        setUpdatedTimeStamp();
    }

    public void setAddressLine2(final String addressLine2) {
        if (StringUtil.isBlank(addressLine2)) {
            throw new IllegalArgumentException("Address line 2 cannot be null, empty, or contain only whitespace");
        }
        this.addressLine2 = addressLine2.trim();
        setUpdatedTimeStamp();
    }

    public void setCity(final String city) {
        if (StringUtil.isBlank(city)) {
            throw new IllegalArgumentException("City cannot be null, empty, or contain only whitespace");
        }
        this.city = city.trim();
        setUpdatedTimeStamp();
    }

    public void setCountry(final Country country) {
        this.country = country;
        setUpdatedTimeStamp();
    }

    private void setCreationTimeStamp() {
        this.creationTimeStamp = new Date();
    }

    public void setPostalCode(final String postalCode) {
        if (StringUtil.isBlank(postalCode)) {
            throw new IllegalArgumentException("Postal code cannot be null, empty, or contain only whitespace");
        }
        this.postalCode = postalCode.trim();
        setUpdatedTimeStamp();
    }

    public void setUpdatedTimeStamp() {
        this.updatedTimeStamp = new Date();
    }
}