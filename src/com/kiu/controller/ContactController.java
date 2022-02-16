package com.kiu.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kiu.model.Contact;


public class ContactController implements GeneralController<Contact>, ReadFile, WriteFile {
    private List<Contact> contacts = new ArrayList<>();
    private static final String PATH_CONTACT = "contact.csv";

    public ContactController() {
        File file = new File(PATH_CONTACT);
        if (file.exists()) {
            try {
                readFile(PATH_CONTACT);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public int arraySize() {
        return contacts.size();
    }

    public int findContactByName(String name) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().contains(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findContactByPhone(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Contact getByIndex(String name) {
        int contactIndex = findContactByName(name);
        return contacts.get(contactIndex);
    }

    @Override
    public void displayAll() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    @Override
    public void addNew(Contact contact) {
        this.contacts.add(contact);
        try {
            writeFile(PATH_CONTACT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean confirmDelete(String id) {
        return false;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {

    }

    @Override
    public void writeFile(String path) throws IOException {

    }
}
