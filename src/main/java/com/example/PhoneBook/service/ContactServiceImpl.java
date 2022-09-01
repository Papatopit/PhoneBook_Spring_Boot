package com.example.PhoneBook.service;

import com.example.PhoneBook.entity.Contact;
import com.example.PhoneBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact getContact(Long id) {
        return  contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not find any contacts by ID"));
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
