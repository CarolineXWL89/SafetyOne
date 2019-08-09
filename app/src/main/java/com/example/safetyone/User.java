package com.example.safetyone;

public class User implements java.io.Serializable{
    private String firstName, lastName, username, password, state, cardType, city, email;
    private double income;
    private long cardNum;
    private int dateTwo, yearOne, monthTwo, yearTwo, monthOne, dateOne, cvv, zip;
    private Address address;
    private CardInfo cardInfo;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }*/

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /*public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    /*public long getCardNum() {
        return cardNum;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public int getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(int dateTwo) {
        this.dateTwo = dateTwo;
    }

    public int getYearOne() {
        return yearOne;
    }

    public void setYearOne(int yearOne) {
        this.yearOne = yearOne;
    }

    public int getMonthTwo() {
        return monthTwo;
    }

    public void setMonthTwo(int monthTwo) {
        this.monthTwo = monthTwo;
    }

    public int getYearTwo() {
        return yearTwo;
    }

    public void setYearTwo(int yearTwo) {
        this.yearTwo = yearTwo;
    }

    public int getMonthOne() {
        return monthOne;
    }

    public void setMonthOne(int monthOne) {
        this.monthOne = monthOne;
    }

    public int getDateOne() {
        return dateOne;
    }

    public void setDateOne(int dateOne) {
        this.dateOne = dateOne;
    }*/

   /* public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }*/

    /*public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }*/

    public CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(CardType cardType, long cardNum, int cvv, int dateOne, int dateTwo,
                            int monthOne, int monthTwo, int yearOne, int yearTwo, Address address) {
        this.cardInfo = new CardInfo(cardType, cardNum, cvv, dateOne * 10 + dateTwo, monthOne
                * 10 + monthTwo, yearOne * 10 + yearTwo, address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(int number, String street, String additional, String city, String state, int zip) {
        this.address = new Address(number, street, additional, city, state, zip);
    }
}
