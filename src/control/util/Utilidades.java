/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.util;

import java.util.ArrayList;
import modelo.hospital.HoraMedica;

/**
 *
 * @author edisonarango
 */
public class Utilidades {
	
    
    public static HoraMedica horaEnCalendario(ArrayList<HoraMedica> horasLibres,ArrayList<String> fechasRango,int i,int j){
        HoraMedica horaEncontrada = null;
            for (int k=0;k<horasLibres.size();k++){
                if (horasLibres.get(k).getFecha().equals(fechasRango.get(j))&&horasLibres.get(k).getHora().equals(i+"")) {
                   horaEncontrada = horasLibres.get(k);
                   break;
                }
            }
        return horaEncontrada;
    }
    
    public static ArrayList<HoraMedica> horasEnCalendario(ArrayList<HoraMedica> horasLibres,ArrayList<String> fechasRango,int i,int j){
        ArrayList<HoraMedica> horasEncontradas = new ArrayList<>();
            for (int k=0;k<horasLibres.size();k++){
                if (horasLibres.get(k).getFecha().equals(fechasRango.get(j))&&horasLibres.get(k).getHora().equals(i+"")) {
                   horasEncontradas.add(horasLibres.get(k));
                }
            }
        return horasEncontradas;
    }
    
    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    
    public static ArrayList<String> diasDeRango(String fechaIn,String fechaFin){
            ArrayList<String> fechas = new ArrayList<>();
            String fechaActual = fechaIn;
            int diaActual,mesActual,añoActual;
            diaActual = Integer.valueOf(fechaActual.split("/")[0]);
            mesActual = Integer.valueOf(fechaActual.split("/")[1]);
            añoActual = Integer.valueOf(fechaActual.split("/")[2]);
            fechas.add(fechaActual);
            while (!fechaActual.equals(fechaFin)) {                
                if (diaActual==31) {
                    diaActual=1;
                    if (mesActual==12) {
                        mesActual=1;
                        añoActual+=1;
                    }
                    else{
                        mesActual+=1;
                    }
                }
                else{
                    diaActual+=1;
                }
                fechaActual = String.format("%02d",diaActual)+"/"+String.format("%02d",mesActual)+"/"+añoActual;
                fechas.add(fechaActual);    
            }
            return fechas;
        }
    
}
