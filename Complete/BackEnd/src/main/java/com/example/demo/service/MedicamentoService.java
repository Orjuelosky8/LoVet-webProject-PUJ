package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Medicamento;
import com.example.demo.repository.MedsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MedicamentoService {
    private static final Logger logger = LoggerFactory.getLogger(MedicamentoService.class);
    private MedsRepository medsRepository; 

    public MedicamentoService(MedsRepository medsRepository) {
        logger.debug("\n\n   0. *******************************************************");
        this.medsRepository = medsRepository;
    }

    public void saveMedsToDatabase() {
        try{
            logger.debug("\n\n   1. *******************************************************");
            List<Medicamento> list = ExcelLoadService.loadExcelFile();
            logger.debug("\n\n   2. *******************************************************");
            medsRepository.saveAll(list);
        } catch (IOException e) {
            throw new IllegalArgumentException("Carga de datos fallida" + e);
        }
    }

    public List<Medicamento> getMeds() {
        return medsRepository.findAll();
    }
}
