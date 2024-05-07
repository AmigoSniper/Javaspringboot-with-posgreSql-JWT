package com.pwl.tokosaya.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "penjual")
public class Penjual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kode;
    private String nama;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "toko")
    private List<Toko> tokos;
}
