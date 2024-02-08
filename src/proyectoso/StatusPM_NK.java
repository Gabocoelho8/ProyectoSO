/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StatusPM_NK extends Thread{
    private int dayDuration_NK;
    public String statusPM_NK = "Working";
    private int counter_NK = 0;
    private Interface GUI;
    public boolean caught = false;
    
    public StatusPM_NK(int duration, Interface i){
        this.dayDuration_NK = duration;
        this.GUI = i;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                while (counter_NK != 32){
                    watchAnime_NK();
                    this.GUI.setStatusPM_NK(statusPM_NK);
                    sleep(this.dayDuration_NK/48);
                }
                caught = false;
                counter_NK = 0;
                statusPM_NK = "Working";
                this.GUI.setStatusPM_NK(statusPM_NK);
                sleep(this.dayDuration_NK/3);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.dayDuration_NK = this.GUI.simulaSegundos_NK;
    }

    public void watchAnime_NK(){
        counter_NK += 1;
        caught = true;
        if (statusPM_NK.equals("Working")){
            statusPM_NK = "Anime";
        }
        else{
            statusPM_NK = "Working";
        }
    }
}