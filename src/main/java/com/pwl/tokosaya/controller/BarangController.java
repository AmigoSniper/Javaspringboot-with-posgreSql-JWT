package com.pwl.tokosaya.controller;

import com.pwl.tokosaya.dto.BarangDTO;
import com.pwl.tokosaya.model.Barang;
import com.pwl.tokosaya.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;
    @PostMapping("/create")
    public BarangDTO create(@RequestBody BarangDTO request){
        final Barang barang = barangService.mapToEntity(request);
        final Barang result = barangService.create(barang);
        return barangService.mapToDto(result);
    }

    @PutMapping("/update/{kode}")
    public BarangDTO update(@PathVariable Long kode, @RequestBody BarangDTO request){
        final Barang barang = barangService.mapToEntity(request);
        final Barang result = barangService.update(kode, barang);
        return barangService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<BarangDTO> findAll(){
        return barangService.findAll().stream().map(barang -> barangService.mapToDto(barang))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<BarangDTO> findAllPagination(@PageableDefault Pageable pageable){
        return barangService.findAll(pageable).map(barang -> barangService.mapToDto(barang));
    }

    @DeleteMapping("/delete/{kode}")
    public Boolean delete(@PathVariable Long kode){
        return barangService.delete(kode);
    }
}
