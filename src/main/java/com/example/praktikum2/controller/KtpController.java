package com.example.praktikum2.controller;

import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.service.KtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
@RequiredArgsConstructor
@CrossOrigin
public class KtpController {

    private final KtpService service;

    @PostMapping
    public KtpDto create(@RequestBody KtpDto dto){
        return service.create(dto);
    }

    @GetMapping
    public List<KtpDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public KtpDto getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public KtpDto update(@PathVariable Integer id,
                         @RequestBody KtpDto dto){
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable Integer id){

        service.delete(id);

        Map<String,String> response = new HashMap<>();
        response.put("message","Data berhasil dihapus");

        return response;
    }
}