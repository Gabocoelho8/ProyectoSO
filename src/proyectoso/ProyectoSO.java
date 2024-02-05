/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class ProyectoSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //CARTOON NETWOKR-------------------------------------------------------
        int totalGuionistas_CN = 1;
        int totalAnimadores_CN = 1;
        int totalActores_CN = 1;
        int totalEnsambladores_CN = 1;
        int totalPlottwists_CN = 1;
        int totalDiseñadores_CN = 1;
        int simulaSegundos_CN = 1;
        int simulaDeadline_CN = 1;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Cartoon_Network.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 4){
                        totalPlottwists_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_CN = Integer.parseInt(ln);
                    }
                if (lineIndex == 6){
                        simulaSegundos_CN = Integer.parseInt(ln)*1000;
                    }
                else if (lineIndex == 7){
                        simulaDeadline_CN = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int[] roles_CN = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] salaries_CN = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int y = 0;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Cartoon_Network.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 4){
                        totalPlottwists_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_CN = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(y = 0; y != totalGuionistas_CN; y++){
            roles_CN[y] = 1;
            salaries_CN[y] = 20;
        }
        for(y = totalGuionistas_CN; y != totalAnimadores_CN + totalGuionistas_CN; y++){
            roles_CN[y] = 2;
            salaries_CN[y] = 40;
        }
        for(y = totalAnimadores_CN + totalGuionistas_CN; y != totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            roles_CN[y] = 3;
            salaries_CN[y] = 16;
        }
        for(y = totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            roles_CN[y] = 4;
            salaries_CN[y] = 50;
        }
        for(y = totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            roles_CN[y] = 5;
            salaries_CN[y] = 34;
        }
        for(y = totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalDiseñadores_CN + totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            roles_CN[y] = 6;
            salaries_CN[y] = 26;
        }
        
        Interface GUI = new Interface();
        GUI.setVisible(true);
        GUI.setLocationRelativeTo(null);
        
        Semaphore mutex_CN = new Semaphore(1);
        Drive_CN drive_CN = new Drive_CN(GUI);
        Calculations_CN calculations_CN = new Calculations_CN(simulaSegundos_CN, drive_CN, mutex_CN, GUI, totalEnsambladores_CN);
        StatusPM_CN statusPM_CN = new StatusPM_CN(simulaSegundos_CN, GUI);
        Director1_CN director1_CN = new Director1_CN(simulaSegundos_CN, 60, calculations_CN, statusPM_CN,GUI);
        PM_CN pm_CN = new PM_CN(simulaSegundos_CN, 40, "PM", drive_CN, mutex_CN, calculations_CN, GUI, simulaDeadline_CN, director1_CN);
        
        pm_CN.start();
        calculations_CN.start();
        statusPM_CN.start();
        director1_CN.start();
        
        Workers_CN hilo1_CN = new Workers_CN(0, roles_CN[0], simulaSegundos_CN, salaries_CN[0], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo2_CN = new Workers_CN(1, roles_CN[1], simulaSegundos_CN, salaries_CN[1], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo3_CN = new Workers_CN(2, roles_CN[2], simulaSegundos_CN, salaries_CN[2], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo4_CN = new Workers_CN(3, roles_CN[3], simulaSegundos_CN, salaries_CN[3], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo5_CN = new Workers_CN(4, roles_CN[4], simulaSegundos_CN, salaries_CN[4], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo6_CN = new Workers_CN(5, roles_CN[5], simulaSegundos_CN, salaries_CN[5], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo7_CN = new Workers_CN(6, roles_CN[6], simulaSegundos_CN, salaries_CN[6], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo8_CN = new Workers_CN(7, roles_CN[7], simulaSegundos_CN, salaries_CN[7], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo9_CN = new Workers_CN(8, roles_CN[8], simulaSegundos_CN, salaries_CN[8], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo10_CN = new Workers_CN(9, roles_CN[9], simulaSegundos_CN, salaries_CN[9], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo11_CN = new Workers_CN(10, roles_CN[10], simulaSegundos_CN, salaries_CN[10], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo12_CN = new Workers_CN(11, roles_CN[11], simulaSegundos_CN, salaries_CN[11], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo13_CN = new Workers_CN(12, roles_CN[12], simulaSegundos_CN, salaries_CN[12], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo14_CN = new Workers_CN(13, roles_CN[13], simulaSegundos_CN, salaries_CN[13], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo15_CN = new Workers_CN(14, roles_CN[14], simulaSegundos_CN, salaries_CN[14], drive_CN, mutex_CN, calculations_CN, GUI);
        Workers_CN hilo16_CN = new Workers_CN(15, roles_CN[15], simulaSegundos_CN, salaries_CN[15], drive_CN, mutex_CN, calculations_CN, GUI);
        
        hilo1_CN.start();
        hilo2_CN.start();
        hilo3_CN.start();
        hilo4_CN.start();
        hilo5_CN.start();
        hilo6_CN.start();
        hilo7_CN.start();
        hilo8_CN.start();
        hilo9_CN.start();
        hilo10_CN.start();
        hilo11_CN.start();
        hilo12_CN.start();
        hilo13_CN.start();
        hilo14_CN.start();
        hilo15_CN.start();
        hilo16_CN.start();
        
        //NICKELODEON-----------------------------------------------------------
        int totalGuionistas_NK = 1;
        int totalAnimadores_NK = 1;
        int totalActores_NK = 1;
        int totalEnsambladores_NK = 1;
        int totalPlottwists_NK = 1;
        int totalDiseñadores_NK = 1;
        int simulaSegundos_NK = 1;
        int simulaDeadline_NK = 1;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Nickelodeon.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 4){
                        totalPlottwists_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_NK = Integer.parseInt(ln);
                    }
                if (lineIndex == 6){
                        simulaSegundos_NK = Integer.parseInt(ln)*1000;
                    }
                else if (lineIndex == 7){
                        simulaDeadline_NK = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int[] roles_NK = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] salaries_NK = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int z = 0;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Nickelodeon.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 4){
                        totalPlottwists_NK = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_NK = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(z = 0; z != totalGuionistas_NK; z++){
            roles_NK[z] = 1;
            salaries_NK[z] = 20;
        }
        for(z = totalGuionistas_NK; z != totalAnimadores_NK + totalGuionistas_NK; z++){
            roles_NK[z] = 2;
            salaries_NK[z] = 40;
        }
        for(z = totalAnimadores_NK + totalGuionistas_NK; z != totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
            roles_NK[z] = 3;
            salaries_NK[z] = 16;
        }
        for(z = totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
            roles_NK[z] = 4;
            salaries_NK[z] = 50;
        }
        for(z = totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
            roles_NK[z] = 5;
            salaries_NK[z] = 34;
        }
        for(z = totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalDiseñadores_NK + totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
            roles_NK[z] = 6;
            salaries_NK[z] = 26;
        }

        Semaphore mutex_NK = new Semaphore(1);
        Drive_NK drive_NK = new Drive_NK(GUI);
        Calculations_NK calculations_NK = new Calculations_NK(simulaSegundos_NK, drive_NK, mutex_NK, GUI, totalEnsambladores_NK);
        StatusPM_NK statusPM_NK = new StatusPM_NK(simulaSegundos_NK, GUI);
        Director1_NK director1_NK = new Director1_NK(simulaSegundos_NK, 60, calculations_NK, statusPM_NK,GUI);
        PM_NK pm_NK = new PM_NK(simulaSegundos_NK, 40, "PM", drive_NK, mutex_NK, calculations_NK, GUI, simulaDeadline_NK, director1_NK);
        
        pm_NK.start();
        calculations_NK.start();
        statusPM_NK.start();
        director1_NK.start();
        
        Workers_NK hilo1_NK = new Workers_NK(0, roles_NK[0], simulaSegundos_NK, salaries_NK[0], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo2_NK = new Workers_NK(1, roles_NK[1], simulaSegundos_NK, salaries_NK[1], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo3_NK = new Workers_NK(2, roles_NK[2], simulaSegundos_NK, salaries_NK[2], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo4_NK = new Workers_NK(3, roles_NK[3], simulaSegundos_NK, salaries_NK[3], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo5_NK = new Workers_NK(4, roles_NK[4], simulaSegundos_NK, salaries_NK[4], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo6_NK = new Workers_NK(5, roles_NK[5], simulaSegundos_NK, salaries_NK[5], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo7_NK = new Workers_NK(6, roles_NK[6], simulaSegundos_NK, salaries_NK[6], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo8_NK = new Workers_NK(7, roles_NK[7], simulaSegundos_NK, salaries_NK[7], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo9_NK = new Workers_NK(8, roles_NK[8], simulaSegundos_NK, salaries_NK[8], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo10_NK = new Workers_NK(9, roles_NK[9], simulaSegundos_NK, salaries_NK[9], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo11_NK = new Workers_NK(10, roles_NK[10], simulaSegundos_NK, salaries_NK[10], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo12_NK = new Workers_NK(11, roles_NK[11], simulaSegundos_NK, salaries_NK[11], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo13_NK = new Workers_NK(12, roles_NK[12], simulaSegundos_NK, salaries_NK[12], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo14_NK = new Workers_NK(13, roles_NK[13], simulaSegundos_NK, salaries_NK[13], drive_NK, mutex_NK, calculations_NK, GUI);
        Workers_NK hilo15_NK = new Workers_NK(14, roles_NK[14], simulaSegundos_NK, salaries_NK[14], drive_NK, mutex_NK, calculations_NK, GUI);
        
        hilo1_NK.start();
        hilo2_NK.start();
        hilo3_NK.start();
        hilo4_NK.start();
        hilo5_NK.start();
        hilo6_NK.start();
        hilo7_NK.start();
        hilo8_NK.start();
        hilo9_NK.start();
        hilo10_NK.start();
        hilo11_NK.start();
        hilo12_NK.start();
        hilo13_NK.start();
        hilo14_NK.start();
        hilo15_NK.start();
        
    }
        
}

