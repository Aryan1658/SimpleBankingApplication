package com.meta.bankdemo.model;

public class Customer {
    private Integer id;
    private String fullName;
    private String mobileNumber;
    private String emailAddress;
    private boolean isPremium;
    private String dateOfBirth;
    private String idType;
    private String idName;

    public Customer() {
    }

    public Customer(Integer id, String fullName, String mobileNumber, String emailAddress, boolean isPremium, String dateOfBirth, String idType, String idName) {
        this.id = id;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.isPremium = isPremium;
        this.dateOfBirth = dateOfBirth;
        this.idType = idType;
        this.idName = idName;
    }

    public Customer(Integer id, String fullName, String mobileNumber, String emailAddress, boolean isPremium, String dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.isPremium = isPremium;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String  idType) {
        this.idType = idType;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
