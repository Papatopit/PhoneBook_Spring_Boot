package com.example.PhoneBook.controller;

import com.example.PhoneBook.entity.Contact;
import com.example.PhoneBook.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/")
public class MyRESTController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> showAllContacts(){

        List<Contact> allContacts = contactService.getAllContacts();
        log.info("show All contacts: " + allContacts);
        return allContacts;
    }

    @PostMapping("/contacts")
    public Contact addNewContact(@RequestBody Contact contact){
        contactService.saveContact(contact);

        log.info("save contact - " + contact);
        return contact;
    }

    @PutMapping("/contacts")
    public Contact updateContact(@RequestBody Contact contact){
        contactService.saveContact(contact);

        log.info("update contact - " + contact);
        return contact;
    }

    @DeleteMapping("/contacts/{id}")
    public String deleteContact(@PathVariable long id){

       Contact contact = contactService.getContact(id);

        contactService.deleteContact(id);
        log.info("delete contact - " + contact);
        return "Contact with ID = " + id + " was deleted.";
    }



}
