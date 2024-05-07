package com.pwl.tokosaya.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwl.tokosaya.dto.BarangDTO;
import com.pwl.tokosaya.model.Barang;
import com.pwl.tokosaya.repo.BarangRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BarangServiceImpl implements BarangService {
    @Autowired
    BarangRepo barangRepo;
    @Override
    public Barang create(Barang barang) {
        final Barang result = barangRepo.save(barang);
        return result;
    }

    @Override
    public Barang update(Long kode, Barang barang) {
        final Barang result = findById(kode);
        if(result != null){
            result.setNama(barang.getNama());
            return barangRepo.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long kode) {
        final Barang result = findById(kode);
        if(result != null){
            barangRepo.deleteById(kode);
            return true;
        }
        return false;
    }

    @Override
    public List<Barang> findAll() {
        return barangRepo.findAll();
    }

    @Override
    public Page<Barang> findAll(Pageable pageable) {
        return barangRepo.findAll(pageable);
    }

    @Override
    public Barang findById(Long kode) {
        Optional<Barang> result = barangRepo.findById(kode);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public BarangDTO mapToDto(Barang barang) {
        return mapper.convertValue(barang, BarangDTO.class);
    }

    @Override
    public Barang mapToEntity(BarangDTO barangDTO) {
        return mapper.convertValue(barangDTO, Barang.class);
    }
}
