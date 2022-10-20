package com.example.laboratoriofinal.Model;

public class Monitor extends Persona {
    LoginCredential loginCredentials;
    private boolean loginStatus = false;

    private double salary=0;
    private int loansRealized=0;

    public Monitor(String name, String email, String cellphoneNumber, String id) {
        super(name, email, cellphoneNumber, id);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLoansRealized() {
        return loansRealized;
    }

    public void setLoansRealized(int loansRealized) {
        this.loansRealized = loansRealized;
    }

    public LoginCredential getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredential loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
