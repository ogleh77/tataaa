package com.example.gymmanagement.data.entity;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.Period;

public class Payment {
    private int paymentID;
    private LocalDate startDate;
    private LocalDate expDate;
    private final SimpleStringProperty month = new SimpleStringProperty();
    private final SimpleStringProperty year = new SimpleStringProperty();
    private final SimpleDoubleProperty amountPaid = new SimpleDoubleProperty();
    private final SimpleStringProperty paidBy = new SimpleStringProperty();
    private final SimpleDoubleProperty discount = new SimpleDoubleProperty();
    private final SimpleBooleanProperty poxing = new SimpleBooleanProperty();
    private Box box;
    private String customerFK;
    private final SimpleBooleanProperty online = new SimpleBooleanProperty();
    private final SimpleBooleanProperty pending = new SimpleBooleanProperty();

    public Payment() {
    }

    public Payment(int paymentID, LocalDate startDate, LocalDate expDate, String month, String year, double amountPaid, String paidBy, double discount, boolean poxing, String customerFK, boolean online, boolean pending) {
        this.paymentID = paymentID;
        this.setStartDate(startDate);
        this.expDate = expDate;
        this.setMonth(month);
        this.setYear(year);
        this.setAmountPaid(amountPaid);
        this.setPaidBy(paidBy);
        this.setDiscount(discount);
        this.setPoxing(poxing);
        this.customerFK = customerFK;
        this.setOnline(online);
        this.setPending(pending);

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getMonth() {
        return month.get();
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getYear() {
        return year.get();
    }

    public double getAmountPaid() {
        return amountPaid.get();
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid.set(amountPaid);
    }

    public String getPaidBy() {
        return paidBy.get();
    }

    public void setPaidBy(String paidBy) {
        this.paidBy.set(paidBy);
    }

    public double getDiscount() {
        return discount.get();
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public boolean isPoxing() {
        return poxing.get();
    }

    public void setPoxing(boolean poxing) {
        this.poxing.set(poxing);
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public boolean isOnline() {
        return online.get();
    }

    public void setOnline(boolean online) {
        this.online.set(online);
    }

    public boolean isPending() {
        return pending.get();
    }

    public void setPending(boolean pending) {
        this.pending.set(pending);
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getDaysRemind() {
        Period period = Period.between(LocalDate.now(), expDate);

        if (period.getYears() > 0) {
            return period.getYears() + " sano " + (period.getMonths() > 0 ? "& " + period.getMonths() + " bilood" : "")
                    + (period.getDays() > 0 ? " & " + period.getDays() + "malmood" : "");
        } else if (period.getMonths() > 0) {
            return period.getMonths() + " bilood " + (period.getDays() > 0 ? " & " + period.getDays() + "malmood" : "");
        } else if (period.getDays() > 0) {
            return period.getDays() == 1 ? "1 maalin" : period.getDays() + " malmood";
        }
        return "outdated";
    }

    @Override
    public String toString() {
        return expDate + " " + amountPaid.get() + " " + paidBy.get() + " online " + online.get() + " pend: " + pending.get();
    }
}
