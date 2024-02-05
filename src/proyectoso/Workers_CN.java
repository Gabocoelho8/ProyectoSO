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


public class Workers_CN extends Thread{
    private String name_CN;
    private int type_CN;
    public float salaryAcc_CN = 0;
    private int dayDuration_CN;
    private Drive_CN drive_CN;
    private Calculations_CN calculations_CN;
    private int salary_CN;
    private float scripts_CN = 0;
    private float stages_CN = 0;
    private float animations_CN = 0;
    private float dubs_CN = 0;
    private float twists_CN = 0;
    private Semaphore mutex_CN;
    public int totalSalaryWorkers_CN = 0;
    private Interface GUI;
    private int position_CN;
    private int episodesAssembled = 0;
    private int twistsAssembled = 0;
    public float test = 0;
    
    public Workers_CN(int position, int type, int duration, int hourlySalary, Drive_CN d, Semaphore m, Calculations_CN calculations_CN, Interface i) throws IOException{
      this.type_CN = type;
      this.dayDuration_CN = duration;
      this.salary_CN = hourlySalary;
      this.drive_CN = d;
      this.mutex_CN = m;
      this.calculations_CN = calculations_CN;
      this.GUI = i;
      this.position_CN = position;

    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                if(this.type_CN != 4){
                calculateSalary_CN();
                }
                work_CN();
                sleep(this.dayDuration_CN);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        this.type_CN = this.GUI.rolesUpdated_CN[this.position_CN];
        this.salary_CN = this.GUI.salariesUpdated_CN[this.position_CN];
        this.dayDuration_CN = this.GUI.simulaSegundos_CN;
    }
    
    public void calculateSalary_CN() throws InterruptedException{
        this.mutex_CN.acquire(); //wait
        this.calculations_CN.totalSalaryWorkers_CN += this.salary_CN*24;
        this.mutex_CN.release();// signal
    }
    
    public void work_CN(){
        if (this.type_CN == 1){
            scripts_CN += 0.34;
            if (scripts_CN >= 1){
                try {
                    this.mutex_CN.acquire(); //wait
                    this.drive_CN.updateDrive_CN(this.type_CN, (int) this.scripts_CN);//critica
                    this.mutex_CN.release();// signal
                    scripts_CN = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_CN == 2){
            animations_CN += 2;
            if (animations_CN >= 1){
                try {
                    this.mutex_CN.acquire(); //wait
                    this.drive_CN.updateDrive_CN(this.type_CN, (int) this.animations_CN);//critica
                    this.mutex_CN.release();// signal
                    animations_CN = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_CN == 3){
            dubs_CN += 3;
            if (dubs_CN >= 1){
                try {
                    this.mutex_CN.acquire(); //wait
                    this.drive_CN.updateDrive_CN(this.type_CN, (int) this.dubs_CN);//critica
                    this.mutex_CN.release();// signal
                    dubs_CN = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(this.type_CN == 5){
            twists_CN += 0.34;
            if (twists_CN >= 1){
                try {
                    this.mutex_CN.acquire(); //wait
                    this.drive_CN.updateDrive_CN(this.type_CN, (int) this.twists_CN);//critica
                    this.mutex_CN.release();// signal
                    twists_CN = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_CN == 6){
            stages_CN += 0.34;
            if (stages_CN >= 1){
                try {
                    this.mutex_CN.acquire(); //wait
                    this.drive_CN.updateDrive_CN(this.type_CN, (int) this.stages_CN);//critica
                    this.mutex_CN.release();// signal
                    stages_CN = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (this.type_CN == 4){
            try {
                this.mutex_CN.acquire(); //wait
                this.drive_CN.updateDrive_CN(this.type_CN, 0);//critica
                if(this.drive_CN.twistEpisodes_CN != twistsAssembled){
                    twistsAssembled += 1;
                    this.drive_CN.standardAssembled_CN += 1;
                    this.drive_CN.twistsAssembled_CN = twistsAssembled;
                    this.GUI.settwistEpisodes_CN(this.drive_CN.twistEpisodes_CN);
                    }
                else if(this.drive_CN.finishedEpisodes_CN != episodesAssembled){
                    episodesAssembled += 1;
                    this.drive_CN.standardAssembled_CN += 1;
                    this.GUI.setStandardEpisodes_CN(this.drive_CN.standardEpisodes_CN);
                    }
                this.GUI.setfinishedEpisodes_CN(this.drive_CN.finishedEpisodes_CN);
                this.mutex_CN.release();// signal
                sleep(this.dayDuration_CN);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
        }
    }
        
}

