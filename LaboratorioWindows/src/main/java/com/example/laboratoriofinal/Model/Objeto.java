package com.example.laboratoriofinal.Model;

import com.example.laboratoriofinal.Enums.ObjectStatus;

public class Objeto {

    private String objectName;
    private  String id;
    private int amount;
    private int loanPrice;
    private boolean status;
    private int loanActives=0;
    private String tableStatus;
    private int avaibleAmount;
    private int totalLoans=0;

    public int getTotalLoans() {
        return totalLoans;
    }

    public void setTotalLoans(int totalLoans) {
        this.totalLoans = totalLoans;
    }

    public Objeto(String objectName, int amount, int loanPrice, boolean status) {
        this.objectName = objectName;
        this.amount = amount;
        this.loanPrice = loanPrice;
        this.status = status;
        avaibleAmount=amount;
        tableStatus = (status)? ObjectStatus.ACTIVE.getStatusString(): ObjectStatus.INACTIVE.getStatusString();
    }

    public int getAvaibleAmount() {
        return avaibleAmount;
    }

    public void setAvaibleAmount(int avaibleAmount) {
        this.avaibleAmount = avaibleAmount;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLoanPrice() {
        return loanPrice;
    }

    public void setLoanPrice(int loanPrice) {
        this.loanPrice = loanPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getLoanActives() {
        return loanActives;
    }

    public void setLoanActives(int loanActives) {
        this.loanActives = loanActives;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

}
