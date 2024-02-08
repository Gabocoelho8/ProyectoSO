/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class Director1_NK extends Thread{
    private int dayDuration_NK;
    private String statusDirector_NK = "Working";
    private int counter_NK = 0;
    private Calculations_NK calculations_NK;
    private Interface GUI;
    private StatusPM_NK statusPM_NK;
    public int totalFaults_NK = 0;
    private int salary_NK;
    public float salaryDir_NK = 0;
    Random rand = new Random();
    private int slept = 0;
    public int random = 0;
    
    public Director1_NK(int duration, int hourlySalary, Calculations_NK calculations_NK, StatusPM_NK pm,Interface i){
        this.dayDuration_NK = duration;
        this.salary_NK = hourlySalary;
        this.calculations_NK = calculations_NK;
        this.GUI = i;
        this.statusPM_NK = pm;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                this.GUI.setCost_NK(this.calculations_NK.totalSalary_NK - totalFaults_NK*100);
                this.GUI.setStatusDirector_NK(statusDirector_NK);
                random = (rand.nextInt(40-2+1)+2);
                sleep(this.dayDuration_NK/(random));
                slept = this.dayDuration_NK/(random);
                statusDirector_NK = "Checking PM";
                this.GUI.setStatusDirector_NK(statusDirector_NK);
                checkPM();
                sleep(this.dayDuration_NK/41);
                slept += this.dayDuration_NK/41;
                statusDirector_NK = "Working";
                this.GUI.setStatusDirector_NK(statusDirector_NK);
                sleep(this.dayDuration_NK - slept);
                slept = 0;
                this.GUI.setStatusDirector_NK(statusDirector_NK);
                calculateSalaryDir_NK();
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void calculateSalaryDir_NK(){
        this.salaryDir_NK += this.salary_NK*24;
        this.calculations_NK.totalSalaryDir_NK = this.salaryDir_NK;
    }
    
    public void checkUpdate(){
        this.dayDuration_NK = this.GUI.simulaSegundos_NK;
    }
    

    public void checkPM(){
        if (this.statusPM_NK.caught == true){
            totalFaults_NK += 1;
            this.GUI.setTotalFaults_NK(totalFaults_NK);
            this.GUI.setPenalized_NK(totalFaults_NK);
        }
    }
}

