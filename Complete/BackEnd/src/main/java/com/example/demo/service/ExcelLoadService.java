package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.example.demo.model.Medicamento;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelLoadService {
    private static final Logger logger = LoggerFactory.getLogger(MedicamentoService.class);

    public static List<Medicamento> loadExcelFile() throws IOException{
        logger.debug("\n\n   ENTRE FUNCION LOADING. *******************************************************");
        List<Medicamento> meds = new ArrayList<>();
        logger.debug("\n\n   DECLARE LISTA MEDS. *******************************************************");
        Resource resource = new FileSystemResource("D:\\Apps Programación\\medicamentos.xlsx");
        // Resource resource = new FileSystemResource("C:\\Users\\estudiante\\Desktop\\Web\\medicamentos.xlsx");
        InputStream is = resource.getInputStream();
        logger.debug("\n\n   RECIBI EL ARCCHIVO. *******************************************************");
        try {
           XSSFWorkbook workbook = new XSSFWorkbook(is);
           XSSFSheet sheet = workbook.getSheet("medicamentos");
           int rowIndex =0;
           for (Row row : sheet){
               if (rowIndex == 0){
                   rowIndex++;
                   continue;
                }
               Iterator<Cell> cellIterator = row.iterator();
               int cellIndex = 0;
               Medicamento med = new Medicamento();
               while (cellIterator.hasNext()){
                   Cell cell = cellIterator.next();
                   switch (cellIndex){
                       case 0 -> med.setId((long) cell.getNumericCellValue());
                       case 1 -> med.setNombre(cell.getStringCellValue());
                       case 2 -> med.setLaboratorio(cell.getStringCellValue());
                       case 3 -> med.setDescripcion(cell.getStringCellValue());
                       case 4 -> med.setClasificacion(cell.getStringCellValue());
                       case 5 -> med.setPrecio(cell.getNumericCellValue());
                       case 6 -> med.setDosis(cell.getStringCellValue());
                       case 7 -> med.setStock((int) cell.getNumericCellValue());
                       case 8 -> med.setIndicacionesAdicionales(cell.getStringCellValue());
                       default -> { }
                   }
                   cellIndex++;
               }
               logger.debug("\n\n   CARGANDO MEDICAMENTO. *******************************************************");
               meds.add(med);
           }
       } catch (IOException e) {
           e.getStackTrace();
       }
       return meds;
    }
}
