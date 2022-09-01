package com.example.PhoneBook.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "phone_book")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "contact_name")
    private String nameAndSurname;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
