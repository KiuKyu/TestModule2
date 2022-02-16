package com.kiu.controller;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.kiu.model.Contact;


public class ContactController implements GeneralController<Contact>, ReadFile, WriteFile {
    private List<Contact> contacts = new ArrayList<>();
    private static final String PATH_CONTACT = "contact.txt";

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

    public Contact getByIndex(int index) {
        return contacts.get(index);
    }

    public void udpateByPhone(String phoneNumber, Contact contact) {
        int contactIndex = findContactByPhone(phoneNumber);
        contacts.set(contactIndex, contact);
        try {
            writeFile(PATH_CONTACT);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public boolean confirmDelete(String phoneNumber) {
        int contactIndex = findContactByPhone(phoneNumber);
        if (contactIndex != -1) {
            contacts.remove(contactIndex);
            try {
                writeFile(PATH_CONTACT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        contacts = (List<Contact>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(contacts);
    }
}
