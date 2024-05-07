package com.pwl.tokosaya.controller;

import com.pwl.tokosaya.dto.PenjualDTO;
import com.pwl.tokosaya.model.Penjual;
import com.pwl.tokosaya.service.PenjualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/penjual")
public class PenjualController {
    @Autowired
    PenjualService penjualService;
    @PostMapping("/create")
    public PenjualDTO create(@RequestBody PenjualDTO request){
        final Penjual penjual = penjualService.mapToEntity(request);
        final Penjual result = penjualService.create(penjual);
        return penjualService.mapToDto(result);
    }

    @PutMapping("/update/{kode}")
    public PenjualDTO update(@PathVariable Long kode, @RequestBody PenjualDTO request){
        final Penjual penjual = penjualService.mapToEntity(request);
        final Penjual result = penjualService.update(kode, penjual);
        return penjualService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<PenjualDTO> findAll(){
        return penjualService.findAll().stream().map(penjual -> penjualService.mapToDto(penjual))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<PenjualDTO> findAllPagination(@PageableDefault Pageable pageable){
        return penjualService.findAll(pageable).map(penjual -> penjualService.mapToDto(penjual));
    }

    @DeleteMapping("/delete/{kode}")
    public Boolean delete(@PathVariable Long kode){
        return penjualService.delete(kode);
    }
}
