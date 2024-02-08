/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PM_CN extends Thread{
    private int dayDuration_CN;
    private String status_CN = "Working";
    private Drive_CN drive_CN;
    private Calculations_CN calculations_CN;
    private String name_CN;
    private int salary_CN;
    private Semaphore mutex_CN;
    public int simulaDeadline_CN;
    public float salaryPM_CN = 0;
    private Interface GUI;
    private int temp;
    private Director1_CN director1_CN;
    
    public PM_CN(int duration, int hourlySalary, String name, Drive_CN d, Semaphore m, Calculations_CN calculations_CN, Interface i, int simulaDeadline_CN, Director1_CN dir){
      this.dayDuration_CN = duration;
      this.name_CN = name;
      this.salary_CN = hourlySalary;
      this.drive_CN = d;
      this.mutex_CN = m;
      this.calculations_CN = calculations_CN;
      this.GUI = i;
      this.simulaDeadline_CN = simulaDeadline_CN;
      this.director1_CN = dir;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                updateDeadline_CN();
                calculateSalaryPM_CN();
                this.GUI.setDeadline_CN(simulaDeadline_CN);
                sleep(this.dayDuration_CN);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_CN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        temp = this.GUI.simulaDeadline_CN;
        this.dayDuration_CN = this.GUI.simulaSegundos_CN;
    }
    
    public void calculateSalaryPM_CN(){
        this.salaryPM_CN += this.salary_CN*24;
        this.calculations_CN.totalSalaryPM_CN = this.salaryPM_CN;
    }
    
    public void updateDeadline_CN(){
            if (simulaDeadline_CN != 0){
                simulaDeadline_CN -= 1;
            }
            else{
                try {
                    this.GUI.setNetProfit_CN(this.calculations_CN.totalProfit_CN - this.director1_CN.totalFaults_CN*100);
                    this.GUI.netProfit_CN = this.calculations_CN.totalProfit_CN - this.director1_CN.totalFaults_CN*100;
                    this.GUI.setGrossProfit_CN(this.calculations_CN.totalGross_CN);
                    this.GUI.profitChart();
                    this.GUI.salariesChart();
                    sleep(this.dayDuration_CN);
                    simulaDeadline_CN = temp;
                } catch (InterruptedException ex) {
                    Logger.getLogger(PM_CN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

}