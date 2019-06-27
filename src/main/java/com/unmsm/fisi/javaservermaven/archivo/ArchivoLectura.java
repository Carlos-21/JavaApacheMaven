/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unmsm.fisi.javaservermaven.archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author CARLOS
 */
public class ArchivoLectura {
    
    private static List<String> tiemposRespuesta = new ArrayList<>();
    private static List<LogServidor> lLogServidor = new ArrayList<>();
    
    public static void lecturaArchivo(String sRutaLog, String sRuta, String sHilo, String sMaxUsuario, String sRuta2, String sRuta3) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(sRutaLog);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] sCadena = linea.split(" ");

                LogServidor oLogServidor = new LogServidor();
                oLogServidor.setsTiempoRespuesta(sCadena[0]);
                oLogServidor.setsIp(sCadena[1]);
                oLogServidor.setsFecha(sCadena[2].substring(1, sCadena[2].length()));
                oLogServidor.setsVerbo(sCadena[4].substring(1, sCadena[4].length()));
                oLogServidor.setsURL(sCadena[5] + " " + sCadena[6]);
                oLogServidor.setsResponse(sCadena[7]);

                lLogServidor.add(oLogServidor);

                int nPos = linea.indexOf(" ");

                linea = linea.substring(0, nPos);
                tiemposRespuesta.add(linea);
            }
            ArchivoEscritura.escrituraExcel(sRuta, sMaxUsuario, sHilo, String.valueOf(Promedio.tiempoPromedio(tiemposRespuesta)));
            ArchivoEscritura.escrituraExcel2(sRuta2, lLogServidor, sMaxUsuario, sHilo);
            JOptionPane.showMessageDialog(null, "Promedio de tiempo calculado", "Lectura del Log", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ArchivoLectura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                    ArchivoEliminar.borrarLog(sRutaLog);
                }
            } catch (IOException e2) {
            } catch (InvalidFormatException ex) {
                Logger.getLogger(ArchivoLectura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String direccionLog() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("./archivos/ruta.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = br.readLine();

            return linea;

        } catch (IOException e) {
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
            }
        }
        return null;
    }
}
