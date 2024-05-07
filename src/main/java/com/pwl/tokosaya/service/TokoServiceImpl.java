package com.pwl.tokosaya.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwl.tokosaya.dto.TokoDTO;
import com.pwl.tokosaya.model.Penjual;
import com.pwl.tokosaya.model.Toko;
import com.pwl.tokosaya.repo.TokoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TokoServiceImpl implements TokoService{
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    PenjualService penjualService;
    @Autowired
    TokoRepo tokoRepo;
    @Override
    public Toko addData(Long kodePenjual, Toko toko) {
        final Penjual penjual = penjualService.findById(kodePenjual);
        if(penjual != null){
            toko = tokoRepo.save(toko);
            if(penjual.getTokos() != null){
                List<Toko> tokos = penjual.getTokos();
                tokos.add(toko);
                penjual.setTokos(tokos);
            }else{
                penjual.setTokos(Collections.singletonList(toko));
            }
            penjualService.create(penjual);
            return toko;
        }
        return null;
    }

    @Override
    public Toko mapToEntity(TokoDTO tokoDTO) {
        return mapper.convertValue(tokoDTO, Toko.class);
    }

    @Override
    public TokoDTO mapToDto(Toko toko) {
        return mapper.convertValue(toko, TokoDTO.class);
    }
}
