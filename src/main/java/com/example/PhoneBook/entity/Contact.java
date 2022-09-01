package com.example.PhoneBook.entity;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "phone_book")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "contact_name")
    private String nameAndSurname;

    @Column(name = "modified_date")
    @LastModifiedDate
    private Long modifiedDate;
}
