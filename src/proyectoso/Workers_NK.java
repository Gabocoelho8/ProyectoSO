/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Workers_NK extends Thread{
    private String name_NK;
    private int type_NK;
    public float salaryAcc_NK = 0;
    private int dayDuration_NK;
    private Drive_NK drive_NK;
    private Calculations_NK calculations_NK;
    private int salary_NK;
    private float scripts_NK = 0;
    private float stages_NK = 0;
    private float animations_NK = 0;
    private float dubs_NK = 0;
    private float twists_NK = 0;
    private Semaphore mutex_NK;
    public int totalSalaryWorkers_NK = 0;
    private Interface GUI;
    private int position_NK;
    private int episodesAssembled = 0;
    private int twistsAssembled = 0;
    public float test = 0;
    
    public Workers_NK(int position, int type, int duration, int hourlySalary, Drive_NK d, Semaphore m, Calculations_NK calculations_NK, Interface i) throws IOException{
      this.type_NK = type;
      this.dayDuration_NK = duration;
      this.salary_NK = hourlySalary;
      this.drive_NK = d;
      this.mutex_NK = m;
      this.calculations_NK = calculations_NK;
      this.GUI = i;
      this.position_NK = position;

    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                if(this.type_NK != 4){
                calculateSalary_NK();
                }
                work_NK();
                sleep(this.dayDuration_NK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.type_NK = this.GUI.rolesUpdated_NK[this.position_NK];
        this.salary_NK = this.GUI.salariesUpdated_NK[this.position_NK];
        this.dayDuration_NK = this.GUI.simulaSegundos_NK;
    }
    
    public void calculateSalary_NK() throws InterruptedException{
        this.mutex_NK.acquire(); //wait
        this.calculations_NK.totalSalaryWorkers_NK += this.salary_NK*24;
        this.mutex_NK.release();// signal
    }
    
    public void work_NK(){
        if (this.type_NK == 1){
            scripts_NK += 0.34;
            if (scripts_NK >= 1){
                try {
                    this.mutex_NK.acquire(); //wait
                    this.drive_NK.updateDrive_NK(this.type_NK, (int) this.scripts_NK);//critica
                    this.mutex_NK.release();// signal
                    scripts_NK = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_NK == 2){
            animations_NK += 2;
            if (animations_NK >= 1){
                try {
                    this.mutex_NK.acquire(); //wait
                    this.drive_NK.updateDrive_NK(this.type_NK, (int) this.animations_NK);//critica
                    this.mutex_NK.release();// signal
                    animations_NK = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_NK == 3){
            dubs_NK += 3;
            if (dubs_NK >= 1){
                try {
                    this.mutex_NK.acquire(); //wait
                    this.drive_NK.updateDrive_NK(this.type_NK, (int) this.dubs_NK);//critica
                    this.mutex_NK.release();// signal
                    dubs_NK = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(this.type_NK == 5){
            twists_NK += 0.34;
            if (twists_NK >= 1){
                try {
                    this.mutex_NK.acquire(); //wait
                    this.drive_NK.updateDrive_NK(this.type_NK, (int) this.twists_NK);//critica
                    this.mutex_NK.release();// signal
                    twists_NK = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_NK == 6){
            stages_NK += 0.34;
            if (stages_NK >= 1){
                try {
                    this.mutex_NK.acquire(); //wait
                    this.drive_NK.updateDrive_NK(this.type_NK, (int) this.stages_NK);//critica
                    this.mutex_NK.release();// signal
                    stages_NK = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_NK == 4){
            try {
                this.mutex_NK.acquire(); //wait
                this.drive_NK.updateDrive_NK(this.type_NK, 0);//critica
                if(this.drive_NK.twistEpisodes_NK != twistsAssembled){
                    twistsAssembled += 1;
                    this.drive_NK.standardAssembled_NK += 1;
                    this.drive_NK.twistsAssembled_NK = twistsAssembled;
                    this.GUI.settwistEpisodes_NK(this.drive_NK.twistEpisodes_NK);
                    }
                else if(this.drive_NK.finishedEpisodes_NK != episodesAssembled){
                    episodesAssembled += 1;
                    this.drive_NK.standardAssembled_NK += 1;
                    this.GUI.setStandardEpisodes_NK(this.drive_NK.standardEpisodes_NK);
                    }
                this.GUI.setfinishedEpisodes_NK(this.drive_NK.finishedEpisodes_NK);
                this.mutex_NK.release();// signal
                sleep(this.dayDuration_NK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
        }
    }
        
}
