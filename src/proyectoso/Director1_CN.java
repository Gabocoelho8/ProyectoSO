/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class Director1_CN extends Thread{
    private int dayDuration_CN;
    private String statusDirector_CN = "Working";
    private int counter_CN = 0;
    private Calculations_CN calculations_CN;
    private Interface GUI;
    private StatusPM_CN statusPM_CN;
    public int totalFaults_CN = 0;
    private int salary_CN;
    public float salaryDir_CN = 0;
    Random rand = new Random();
    private int slept = 0;
    public int random = 0;
    
    public Director1_CN(int duration, int hourlySalary, Calculations_CN calculations_CN, StatusPM_CN pm,Interface i){
        this.dayDuration_CN = duration;
        this.salary_CN = hourlySalary;
        this.calculations_CN = calculations_CN;
        this.GUI = i;
        this.statusPM_CN = pm;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                this.GUI.setCost_CN(this.calculations_CN.totalSalary_CN - totalFaults_CN*100);
                this.GUI.setStatusDirector_CN(statusDirector_CN);
                random = (rand.nextInt(40-2+1)+2);
                sleep(this.dayDuration_CN/(random));
                slept = this.dayDuration_CN/(random);
                statusDirector_CN = "Checking PM";
                this.GUI.setStatusDirector_CN(statusDirector_CN);
                checkPM();
                sleep(this.dayDuration_CN/41);
                slept += this.dayDuration_CN/41;
                statusDirector_CN = "Working";
                this.GUI.setStatusDirector_CN(statusDirector_CN);
                sleep(this.dayDuration_CN - slept);
                slept = 0;
                this.GUI.setStatusDirector_CN(statusDirector_CN);
                calculateSalaryDir_CN();
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void calculateSalaryDir_CN(){
        this.salaryDir_CN += this.salary_CN*24;
        this.calculations_CN.totalSalaryDir_CN = this.salaryDir_CN;
    }
    
    public void checkUpdate(){
        this.dayDuration_CN = this.GUI.simulaSegundos_CN;
    }
    

    public void checkPM(){
        if (this.statusPM_CN.caught == true){
            totalFaults_CN += 1;
            this.GUI.setTotalFaults_CN(totalFaults_CN);
            this.GUI.setPenalized_CN(totalFaults_CN);
        }
    }
}

