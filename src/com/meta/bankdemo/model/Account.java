package com.meta.bankdemo.model;

public class Account {

    private Integer id;
    private String accountNumber;
    private String accountOpenDate;
    private String accountClosedDate;
    private Double primaryBalance;
    private Double interestAccured;
    private Double totalBalance;
    private String accountType;
    private Integer customerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public String getAccountClosedDate() {
        return accountClosedDate;
    }

    public void setAccountClosedDate(String accountClosedDate) {
        this.accountClosedDate = accountClosedDate;
    }

    public Double getPrimaryBalance() {
        return primaryBalance;
    }

    public void setPrimaryBalance(Double primaryBalance) {
        this.primaryBalance = primaryBalance;
    }

    public Double getInterestAccured() {
        return interestAccured;
    }

    public void setInterestAccured(Double interestAccured) {
        this.interestAccured = interestAccured;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
