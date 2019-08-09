package com.example.safetyone;

public class CardInfo implements java.io.Serializable{
    private CardType cardType;
    private long cardNum;
    private int cvv;
    private int date;
    private int month;
    private int year;

    private Address address;

    public CardInfo(CardType cardType, long cardNum, int cvv, int date, int month, int year, Address address) {
        this.cardType = cardType;
        this.cardNum = cardNum;
        this.cvv = cvv;
        this.date = date;
        this.month = month;
        this.year = year;
        this.address = address;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public long getCardNum() {
        return cardNum;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
