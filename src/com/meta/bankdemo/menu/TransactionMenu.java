package com.meta.bankdemo.menu;

import com.meta.bankdemo.db.services.AccountDataBaseService;
import com.meta.bankdemo.db.services.TransactionDataBaseServices;
import com.meta.bankdemo.db.services.TransactionTypeDateBaseService;
import com.meta.bankdemo.model.Account;
import com.meta.bankdemo.model.TransactionType;
import com.meta.bankdemo.userIO.TransactionIO;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMenu extends TransactionIO {

    public TransactionMenu() {

        display("********** Welcome to Transaction Section *********");
        AccountDataBaseService accountDataBaseService = new AccountDataBaseService();
        boolean status = true;
        String accountNumber = null;
        TransactionTypeDateBaseService ttds = new TransactionTypeDateBaseService();
        TransactionDataBaseServices tds = new TransactionDataBaseServices();
        while (status) {
            display("1 \tExit");
            display("2 \tCheck current balance");
            List<TransactionType> transactionTypeList = ttds.findAll();
            int count = 3;
            for (TransactionType type : transactionTypeList) {
                display(count++ + "\t" + type.getName());
            }
            int choice;
            try {
                choice = Integer.parseInt(readChoice("Enter your choice"));

            } catch (Exception ex) {
                display(ex.getMessage());
                choice = 0;
            }
            switch (choice) {
                case 1:
                    status = false;
                    break;
                case 2:
                    display("Checking your current balance");
                    accountNumber = readAccountNumber();
                    Account account = accountDataBaseService.findByAccountNumber(accountNumber);
                    if (account != null) {
                        display("----------------------------");
                        display("Primary Balance\t" + account.getPrimaryBalance());
                        display("Interest Balance\t" + account.getInterestAccured());
                        display("Total Balance\t" + account.getTotalBalance());
                        display("----------------------------");
                    } else {
                        display("----------------------------");
                        display("Account doesn't exists.");
                        display("----------------------------");
                    }

                    break;
                case 3:
                    display("Deposit in progress");
                    accountNumber = readAccountNumber();
                    account = accountDataBaseService.findByAccountNumber(accountNumber);
                    if (account != null) {
                        double depositAmount = Double.parseDouble(read("deposit amount"));
                        if (depositAmount >= 0) {
                            accountDataBaseService.deposit(depositAmount, account.getAccountNumber());
                            int transactionTypeId = transactionTypeList.stream().filter(x -> x.getCode().equalsIgnoreCase("DEP")).collect(Collectors.toList()).get(0).getId();
                            tds.createTransactionLog(account.getId(),transactionTypeId,depositAmount, "'COMPLETED'");
                        } else {
                            display("Invalid amount !!!");
                        }
                    } else {
                        display("Account doesn't exists");

                    }

                    break;
                case 4:
                    display("Under development");
                    break;
                case 5:
                    display("Under development");
                    break;
                case 6:
                    display("Under development");
                    break;
                case 7:
                    display("Withdraw in progress");
                    accountNumber = readAccountNumber();
                    account = accountDataBaseService.findByAccountNumber(accountNumber);
                    if (account != null) {
                        double withDrawAmount = Double.parseDouble(read("withdraw amount"));
                        if (account.getPrimaryBalance() >= withDrawAmount) {
                        if (withDrawAmount >= 0) {
                            accountDataBaseService.withDraw(withDrawAmount, account.getAccountNumber());
                            int transactionTypeId = transactionTypeList.stream().filter(x -> x.getCode().equalsIgnoreCase("WIT")).collect(Collectors.toList()).get(0).getId();
                            tds.createTransactionLog(account.getId(), transactionTypeId, withDrawAmount, "'COMPLETED'");
                        } else {
                            display("Invalid amount !!!");
                        }
                    }else {
                            display("Not enough balance");
                        }
                    } else {
                        display("Account doesn't exists");

                    }

                    break;
                default:
                    break;

            }
        }

    }
}
