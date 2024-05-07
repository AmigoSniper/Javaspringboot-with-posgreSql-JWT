package com.pwl.tokosaya.service;

import com.pwl.tokosaya.dto.TokoDTO;
import com.pwl.tokosaya.model.Toko;

public interface TokoService {
    Toko addData(Long kodePenjual, Toko toko);
    Toko mapToEntity(TokoDTO tokoDTO);
    TokoDTO mapToDto(Toko toko);
}
