/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unmsm.fisi.javaservermaven.archivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/**
 *
 * @author CARLOS
 */
public class ArchivoEliminar {
    
    public static void borrarLog(String sRuta) throws InvalidFormatException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(sRuta);
            pw = new PrintWriter(fichero);
            
            pw.println("");
        } catch (IOException e) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
    }

}
