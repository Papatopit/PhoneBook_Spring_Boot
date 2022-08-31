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

    @Column(name = "_phone_number")
    private Long phoneNumber;

    @Column(name = "_contact_name")
    private String nameAndSurname;

    @Column(name = "_update_date")
    private LocalDate updateDate;
}
