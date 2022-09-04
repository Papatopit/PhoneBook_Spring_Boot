package com.example.PhoneBook.controller;

import com.example.PhoneBook.entity.Contact;
import com.example.PhoneBook.service.ContactService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactRestController {

  private final ContactService contactService;

  @Builder
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class ContactDto {
    private Long id;
    private String name;
    private String phone;
    private Date date;
  }

  @GetMapping
  public @ResponseBody List<ContactDto> getContacts() {
    List<Contact> contacts = contactService.getContacts();
    log.info("contacts: {}", contacts);
    return contacts.stream()
            .map(
                    contact ->
                            new ContactDto(
                                    contact.getId(),
                                    contact.getName(),
                                    contact.getPhone(),
                                    contact.getModifiedAt()))
            .collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody ContactDto createContact(@RequestBody ContactDto contactDto) {
    Contact contact =
        Contact.builder().name(contactDto.getName()).phone(contactDto.getPhone()).build();

    Contact created = contactService.saveContact(contact);
    log.info("saved contact: {}", created);

    return new ContactDto(
        created.getId(), created.getName(), created.getPhone(), created.getModifiedAt());
  }

  @PutMapping
  public @ResponseBody ContactDto updateContact(@RequestBody ContactDto contactDto) {
    Contact contact =
        Contact.builder().name(contactDto.getName()).phone(contactDto.getPhone()).build();

    Contact updated = contactService.saveContact(contact);
    log.info("updated contact: {}", updated);
    return new ContactDto(
        updated.getId(), updated.getName(), updated.getPhone(), updated.getModifiedAt());
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteContact(@PathVariable long id) {
    contactService.deleteContact(id);
    log.info("removed contact: {}", id);
  }
}
