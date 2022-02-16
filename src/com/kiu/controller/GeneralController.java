package com.kiu.controller;

public interface GeneralController<E> {
    void displayAll();

    void addNew(E e);

    boolean confirmDelete(String id);
}
