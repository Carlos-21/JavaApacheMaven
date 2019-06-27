/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unmsm.fisi.javaservermaven.archivo;

import java.util.List;

/**
 *
 * @author CARLOS
 */
public class Promedio {

    public static double tiempoPromedio(List<String> tiemposRespuesta) {
        double dTiempo = 0;
        for (String tiempo : tiemposRespuesta) {
            dTiempo += Double.parseDouble(tiempo);
        }
        System.out.println("Tiempo promedio : " + (dTiempo / tiemposRespuesta.size()));
        return dTiempo / tiemposRespuesta.size();
    }

}
