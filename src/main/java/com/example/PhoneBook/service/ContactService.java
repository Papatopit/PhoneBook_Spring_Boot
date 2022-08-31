package com.example.PhoneBook.service;

import com.example.PhoneBook.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();

    public void saveContact(Contact contact);

    public Contact getContact(Long id);

    public void deleteContact(Long id);



}
