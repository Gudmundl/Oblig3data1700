package com.example.oblig3data1700;

public class BilettLagring {

    private String firstName;
    private String lastName;
    private String film;
    private String email;
    private String phone;
    private Integer quantity;

    public BilettLagring() {

    }

    public BilettLagring(String firstName, String lastName, String film, String email, String phone, Integer quantity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.film = film;
        this.email = email;
        this.phone = phone;
        this.quantity = quantity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}