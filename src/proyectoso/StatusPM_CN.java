/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StatusPM_CN extends Thread{
    private int dayDuration_CN;
    public String statusPM_CN = "Working";
    private int counter_CN = 0;
    private Interface GUI;
    public boolean caught = false;
    
    public StatusPM_CN(int duration, Interface i){
        this.dayDuration_CN = duration;
        this.GUI = i;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                while (counter_CN != 32){
                    watchAnime_CN();
                    this.GUI.setStatusPM_CN(statusPM_CN);
                    sleep(this.dayDuration_CN/48);
                }
                caught = false;
                counter_CN = 0;
                statusPM_CN = "Working";
                this.GUI.setStatusPM_CN(statusPM_CN);
                sleep(this.dayDuration_CN/3);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.dayDuration_CN = this.GUI.simulaSegundos_CN;
    }

    public void watchAnime_CN(){
        counter_CN += 1;
        caught = true;
        if (statusPM_CN.equals("Working")){
            statusPM_CN = "Anime";
        }
        else{
            statusPM_CN = "Working";
        }
    }
}