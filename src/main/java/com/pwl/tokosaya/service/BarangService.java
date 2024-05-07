package com.pwl.tokosaya.service;

import com.pwl.tokosaya.dto.BarangDTO;
import com.pwl.tokosaya.model.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BarangService {
    Barang create(Barang barang);
    Barang update(Long kode, Barang barang);
    Boolean delete(Long kode);
    List<Barang> findAll();
    Page<Barang> findAll(Pageable pageable);
    Barang findById(Long kode);
    BarangDTO mapToDto(Barang barang);
    Barang mapToEntity(BarangDTO barangDTO);
}
