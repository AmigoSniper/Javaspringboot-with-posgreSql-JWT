package com.pwl.tokosaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "toko")
public class Toko {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kode;
    @Column(name = "nama")
    private String nama;
    @Column(name = "alamat")
    private String alamat;
}
