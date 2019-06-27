/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unmsm.fisi.javaservermaven.archivo;

/**
 *
 * @author CARLOS
 */
public class LogServidor {
    private String sTiempoRespuesta;
    private String sIp;
    private String sFecha;
    private String sVerbo;
    private String sURL;
    private String sResponse;

    public String getsTiempoRespuesta() {
        return sTiempoRespuesta;
    }

    public void setsTiempoRespuesta(String sTiempoRespuesta) {
        this.sTiempoRespuesta = sTiempoRespuesta;
    }

    public String getsIp() {
        return sIp;
    }

    public void setsIp(String sIp) {
        this.sIp = sIp;
    }

    public String getsFecha() {
        return sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }

    public String getsVerbo() {
        return sVerbo;
    }

    public void setsVerbo(String sVerbo) {
        this.sVerbo = sVerbo;
    }

    public String getsURL() {
        return sURL;
    }

    public void setsURL(String sURL) {
        this.sURL = sURL;
    }

    public String getsResponse() {
        return sResponse;
    }

    public void setsResponse(String sResponse) {
        this.sResponse = sResponse;
    }
}
