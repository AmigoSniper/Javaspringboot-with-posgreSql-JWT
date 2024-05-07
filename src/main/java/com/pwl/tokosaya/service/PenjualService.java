package com.pwl.tokosaya.service;

import com.pwl.tokosaya.dto.PenjualDTO;
import com.pwl.tokosaya.model.Penjual;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PenjualService {
    Penjual create(Penjual penjual);
    Penjual update(Long kode, Penjual penjual);
    Boolean delete(Long kode);
    List<Penjual> findAll();
    Page<Penjual> findAll(Pageable pageable);
    Penjual findById(Long kode);
    PenjualDTO mapToDto(Penjual penjual);
    Penjual mapToEntity(PenjualDTO penjualDTO);
}
