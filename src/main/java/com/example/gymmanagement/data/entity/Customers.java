package com.example.gymmanagement.data.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Customers implements Comparable<Customers> {
    private int customerId;
    private LocalDate dateJoined;
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty middleName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty contacts = new SimpleStringProperty();
    private final SimpleStringProperty gander = new SimpleStringProperty();
    private final SimpleStringProperty shift = new SimpleStringProperty();
    private final SimpleStringProperty address = new SimpleStringProperty();
    private final SimpleDoubleProperty weight = new SimpleDoubleProperty();
    private final SimpleDoubleProperty height = new SimpleDoubleProperty();
    private final SimpleDoubleProperty waist = new SimpleDoubleProperty();
    private final SimpleStringProperty note = new SimpleStringProperty();
    private final SimpleStringProperty whoAdded = new SimpleStringProperty();
    private final byte[] image;
    private ObservableList<Payment> payments;

    public Customers(int customerId, LocalDate dateJoined, String firstName, String middleName, String lastName, String contacts, String gander, String shift, String address, double weight, double height, double waist, String note, String whoAdded, byte[] image) {
        this.customerId = customerId;
        this.dateJoined = dateJoined;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleName(middleName);
        this.setContacts(contacts);
        this.setGander(gander);
        this.setShift(shift);
        this.setAddress(address);
        this.image = image;
        this.setWeight(weight);
        this.setHeight(height);
        this.setWaist(waist);
        this.setWhoAdded(whoAdded);
        this.setNote(note);
        this.payments = FXCollections.observableArrayList();
    }

    public Customers(String firstName, String middleName, String lastName, String contacts, String gander, String shift, String address, double weight, double height, double waist, String note, String whoAdded, byte[] image) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleName(middleName);
        this.setContacts(contacts);
        this.setGander(gander);
        this.setShift(shift);
        this.setAddress(address);
        this.image = image;
        this.setWeight(weight);
        this.setHeight(height);
        this.setWaist(waist);
        this.setWhoAdded(whoAdded);
        this.setNote(note);
        this.payments = FXCollections.observableArrayList();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setContacts(String contacts) {
        this.contacts.set(contacts);
    }

    public void setGander(String gander) {
        this.gander.set(gander);
    }

    public void setShift(String shift) {
        this.shift.set(shift);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public void setWaist(double waist) {
        this.waist.set(waist);
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public void setWhoAdded(String whoAdded) {
        this.whoAdded.set(whoAdded);
    }

    //--------------------Getters--------------------


    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public SimpleStringProperty middleNameProperty() {
        return middleName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getContacts() {
        return contacts.get();
    }

    public SimpleStringProperty contactsProperty() {
        return contacts;
    }

    public String getGander() {
        return gander.get();
    }

    public SimpleStringProperty ganderProperty() {
        return gander;
    }

    public String getShift() {
        return shift.get();
    }

    public SimpleStringProperty shiftProperty() {
        return shift;
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public double getWeight() {
        return weight.get();
    }

    public SimpleDoubleProperty weightProperty() {
        return weight;
    }

    public double getHeight() {
        return height.get();
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public double getWaist() {
        return waist.get();
    }

    public SimpleDoubleProperty waistProperty() {
        return waist;
    }

    public String getNote() {
        return note.get();
    }

    public SimpleStringProperty noteProperty() {
        return note;
    }

    public String getWhoAdded() {
        return whoAdded.get();
    }

    public SimpleStringProperty whoAddedProperty() {
        return whoAdded;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public ObservableList<Payment> getPayments() {
        return payments;
    }

    @Override
    public int compareTo(Customers o) {
        if (this.payments.get(0).getExpDate().isBefore(o.payments.get(0).getExpDate())) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return firstName.get() + " " + contacts.get();
    }
}
