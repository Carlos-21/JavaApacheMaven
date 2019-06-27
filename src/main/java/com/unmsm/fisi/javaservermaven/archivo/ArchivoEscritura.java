/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unmsm.fisi.javaservermaven.archivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author CARLOS
 */
public class ArchivoEscritura {

    public static void escrituraExcel(String sRuta, String sMaxCli, String sHilo, String sPromedio) throws InvalidFormatException {
        try {
            FileInputStream inputStream = new FileInputStream(new File(sRuta));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();

            Row row = sheet.createRow(++rowCount);

            Cell cell = row.createCell(1);
            cell.setCellValue(sHilo);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(sMaxCli);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(sPromedio);

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(sRuta);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void escrituraExcel2(String sRuta, List<LogServidor> lLogServidor, String sMaxCli, String sHilo) throws InvalidFormatException {
        try {
            FileInputStream inputStream = new FileInputStream(new File(sRuta));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();

            for (LogServidor oLogServidor : lLogServidor) {
                Row row = sheet.createRow(++rowCount);

                Cell cell = row.createCell(1);
                cell.setCellValue(sHilo);

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(sMaxCli);

                Cell cell3 = row.createCell(3);
                cell3.setCellValue(oLogServidor.getsIp());

                Cell cell4 = row.createCell(4);
                cell4.setCellValue(oLogServidor.getsURL());

                Cell cell5 = row.createCell(5);
                cell5.setCellValue(oLogServidor.getsVerbo());

                Cell cell6 = row.createCell(6);
                cell6.setCellValue(oLogServidor.getsResponse());

                Cell cell7 = row.createCell(7);
                cell7.setCellValue(oLogServidor.getsFecha());

                Cell cell8 = row.createCell(8);
                cell8.setCellValue(oLogServidor.getsTiempoRespuesta());

            }
            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(sRuta);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
}
