package com.example.PhoneBook.service;

import com.example.PhoneBook.entity.Contact;
import com.example.PhoneBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {

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
        Contact contact = null;
        Optional<Contact> optional = contactRepository.findById(id);
        if (optional.isPresent()){
            contact = optional.get();
        }
        return contact ;
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
