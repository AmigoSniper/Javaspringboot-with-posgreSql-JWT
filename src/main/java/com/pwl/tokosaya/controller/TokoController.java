package com.pwl.tokosaya.controller;

import com.pwl.tokosaya.dto.TokoDTO;
import com.pwl.tokosaya.model.Toko;
import com.pwl.tokosaya.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toko")
public class TokoController {
    @Autowired
    TokoService tokoService;
    @PostMapping("/add/{kodePenjual}")
    public TokoDTO addTokoToPenjual(@PathVariable Long kodePenjual, @RequestBody TokoDTO request){
        final Toko toko = tokoService.mapToEntity(request);
        final Toko result = tokoService.addData(kodePenjual, toko);
        return tokoService.mapToDto(result);
    }
}
