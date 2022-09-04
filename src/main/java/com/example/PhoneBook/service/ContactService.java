package com.example.PhoneBook.service;

import com.example.PhoneBook.entity.Contact;
import com.example.PhoneBook.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContact(Long id) {
        return contactRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("Can not find any contacts by ID:%s", id)));
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}

