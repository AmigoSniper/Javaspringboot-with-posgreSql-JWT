package com.pwl.tokosaya.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwl.tokosaya.dto.PenjualDTO;
import com.pwl.tokosaya.model.Penjual;
import com.pwl.tokosaya.repo.PenjualRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjualServiceImpl implements PenjualService{
    @Autowired
    PenjualRepo penjualRepo;
    @Override
    public Penjual create(Penjual penjual) {
        final Penjual result = penjualRepo.save(penjual);
        return result;
    }
    @Override
    public Penjual update(Long kode, Penjual penjual) {
        final Penjual result = findById(kode);
        if(result != null){
            result.setNama(penjual.getNama());
            return penjualRepo.save(result);
        }
        return null;
    }
    @Override
    public Boolean delete(Long kode) {
        final Penjual result = findById(kode);
        if(result != null){
            penjualRepo.deleteById(kode);
            return true;
        }
        return false;
    }
    @Override
    public List<Penjual> findAll() {
        return penjualRepo.findAll();
    }
    @Override
    public Page<Penjual> findAll(Pageable pageable) {
        return penjualRepo.findAll(pageable);
    }
    @Override
    public Penjual findById(Long kode) {
        Optional<Penjual> result = penjualRepo.findById(kode);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public PenjualDTO mapToDto(Penjual penjual) {
        return mapper.convertValue(penjual, PenjualDTO.class);
    }

    @Override
    public Penjual mapToEntity(PenjualDTO penjualDTO) {
        return mapper.convertValue(penjualDTO, Penjual.class);
    }
}
