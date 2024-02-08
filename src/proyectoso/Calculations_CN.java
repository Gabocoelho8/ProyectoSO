/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class Calculations_CN extends Thread{
    private int dayDuration_CN;
    private Drive_CN drive_CN;
    private Semaphore mutex_CN;
    public float totalSalaryDir_CN = 0;
    public float totalSalary_CN = 0;
    private float totalNet_CN = 0;
    public float totalProfit_CN = 0;
    public float totalGross_CN = 0;
    private Workers_CN workers_CN;
    public float totalSalaryWorkers_CN = 0;
    public float totalSalaryPM_CN = 0;
    private Interface GUI;
    public float totalSalaryAssembler_CN = 0;
    public float amountAssembler = 0;
    
    public Calculations_CN(int duration, Drive_CN d, Semaphore m, Interface i, int am){
      this.dayDuration_CN = duration;
      this.drive_CN = d;
      this.mutex_CN = m;
      this.GUI = i;
      this.amountAssembler = am;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                calculateProfit_CN();
                this.GUI.totalSalaries_CN = totalSalary_CN;
                sleep(this.dayDuration_CN);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.dayDuration_CN = this.GUI.simulaSegundos_CN;
        this.amountAssembler = this.GUI.amountAssembler_CN;
    }
    
    public void calculateProfit_CN(){
            totalSalaryAssembler_CN += amountAssembler * 24 * 50;
            totalSalary_CN = this.totalSalaryWorkers_CN + this.totalSalaryAssembler_CN + this.totalSalaryPM_CN + this.totalSalaryDir_CN;
            totalProfit_CN = 300000*this.drive_CN.standardEpisodes_CN + 650000*this.drive_CN.twistEpisodes_CN - totalSalary_CN;
            totalGross_CN = 300000*this.drive_CN.standardEpisodes_CN + 650000*this.drive_CN.twistEpisodes_CN;
        }

}
