package com.example.praktikum2.service.Impl;

import com.example.praktikum2.mapper.KtpMapper;
import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.model.entity.Ktp;
import com.example.praktikum2.repository.KtpRepository;
import com.example.praktikum2.service.KtpService;
import com.example.praktikum2.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    @Override
    public KtpDto create(KtpDto dto) {

        // VALIDASI INPUT
        ValidationUtil.validateKtp(
                dto.getNomorKtp(),
                dto.getNamaLengkap(),
                dto.getAlamat(),
                dto.getJenisKelamin()
        );

        // VALIDASI NOMOR KTP DUPLIKAT
        repository.findByNomorKtp(dto.getNomorKtp())
                .ifPresent(k -> {
                    throw new RuntimeException("Nomor KTP sudah ada");
                });

        Ktp ktp = KtpMapper.MAPPER.toEntity(dto);

        return KtpMapper.MAPPER.toDto(repository.save(ktp));
    }

    @Override
    public List<KtpDto> getAll() {

        return repository.findAll()
                .stream()
                .map(KtpMapper.MAPPER::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public KtpDto getById(Integer id) {

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return KtpMapper.MAPPER.toDto(ktp);
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto) {

        ValidationUtil.validateKtp(
                dto.getNomorKtp(),
                dto.getNamaLengkap(),
                dto.getAlamat(),
                dto.getJenisKelamin()
        );

        Ktp ktp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        repository.save(ktp);

        return KtpMapper.MAPPER.toDto(ktp);
    }

    @Override
    public void delete(Integer id) {

        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        repository.deleteById(id);

    }
}