package com.example.springdatajpahibernate.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // this annotation is used to tell the JPA that this class is an embedded class
public class OrderId implements Serializable {

    private String userName;
    private LocalDateTime orderDate;

}
