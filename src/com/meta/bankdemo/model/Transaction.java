package com.meta.bankdemo.model;

public class Transaction {
    private Integer Id;
    private Integer accountId;
    private Integer transactionTypeId;
    private Double amount;
    private boolean cashBackApplicable;
    private String status;

    public Transaction() {
    }

    public Transaction(Integer id, Integer accountId, Integer transactionTypeId, Double amount, boolean cashBackApplicable, String status) {
        Id = id;
        this.accountId = accountId;
        this.transactionTypeId = transactionTypeId;
        this.amount = amount;
        this.cashBackApplicable = cashBackApplicable;
        this.status = status;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isCashBackApplicable() {
        return cashBackApplicable;
    }

    public void setCashBackApplicable(boolean cashBackApplicable) {
        this.cashBackApplicable = cashBackApplicable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
