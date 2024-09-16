package com.danco.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EBOOK_QUERY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ebook {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String autor;
    private String isbn;
}
