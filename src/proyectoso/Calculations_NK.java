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


public class Calculations_NK extends Thread{
    private int dayDuration_NK;
    private Drive_NK drive_NK;
    private Semaphore mutex_NK;
    public float totalSalaryDir_NK = 0;
    public float totalSalary_NK = 0;
    private float totalNet_NK = 0;
    public float totalProfit_NK = 0;
    public float totalGross_NK = 0;
    private Workers_NK workers_NK;
    public float totalSalaryWorkers_NK = 0;
    public float totalSalaryPM_NK = 0;
    private Interface GUI;
    public float totalSalaryAssembler_NK = 0;
    public float amountAssembler = 0;
    
    public Calculations_NK(int duration, Drive_NK d, Semaphore m, Interface i, int am){
      this.dayDuration_NK = duration;
      this.drive_NK = d;
      this.mutex_NK = m;
      this.GUI = i;
      this.amountAssembler = am;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                calculateProfit_NK();
                this.GUI.totalSalaries_NK = totalSalary_NK;
                sleep(this.dayDuration_NK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.dayDuration_NK = this.GUI.simulaSegundos_NK;
        this.amountAssembler = this.GUI.amountAssembler_NK;
    }
    
    public void calculateProfit_NK(){
            totalSalaryAssembler_NK += amountAssembler * 24 * 50;
            totalSalary_NK = this.totalSalaryWorkers_NK + this.totalSalaryAssembler_NK + this.totalSalaryPM_NK + this.totalSalaryDir_NK;
            totalProfit_NK = 300000*this.drive_NK.standardEpisodes_NK + 650000*this.drive_NK.twistEpisodes_NK - totalSalary_NK;
            totalGross_NK = 300000*this.drive_NK.standardEpisodes_NK + 650000*this.drive_NK.twistEpisodes_NK;
        }

}