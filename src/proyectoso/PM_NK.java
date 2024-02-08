/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PM_NK extends Thread{
    private int dayDuration_NK;
    private String status_NK = "Working";
    private Drive_NK drive_NK;
    private Calculations_NK calculations_NK;
    private String name_NK;
    private int salary_NK;
    private Semaphore mutex_NK;
    public int simulaDeadline_NK;
    public float salaryPM_NK = 0;
    private Interface GUI;
    private int temp;
    private Director1_NK director1_NK;
    
    public PM_NK(int duration, int hourlySalary, String name, Drive_NK d, Semaphore m, Calculations_NK calculations_NK, Interface i, int simulaDeadline_NK, Director1_NK dir){
      this.dayDuration_NK = duration;
      this.name_NK = name;
      this.salary_NK = hourlySalary;
      this.drive_NK = d;
      this.mutex_NK = m;
      this.calculations_NK = calculations_NK;
      this.GUI = i;
      this.simulaDeadline_NK = simulaDeadline_NK;
      this.director1_NK = dir;
    }
    
@Override
    public void run(){
        while(true) {
            try {
                checkUpdate();
                updateDeadline_NK();
                calculateSalaryPM_NK();
                this.GUI.setDeadline_NK(simulaDeadline_NK);
                sleep(this.dayDuration_NK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers_NK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void checkUpdate(){
        temp = this.GUI.simulaDeadline_NK;
        this.dayDuration_NK = this.GUI.simulaSegundos_NK;
    }
    
    public void calculateSalaryPM_NK(){
        this.salaryPM_NK += this.salary_NK*24;
        this.calculations_NK.totalSalaryPM_NK = this.salaryPM_NK;
    }
    
    public void updateDeadline_NK(){
            if (simulaDeadline_NK != 0){
                simulaDeadline_NK -= 1;
            }
            else{
                try {
                    this.GUI.setNetProfit_NK(this.calculations_NK.totalProfit_NK - this.director1_NK.totalFaults_NK*100);
                    this.GUI.netProfit_NK = this.calculations_NK.totalProfit_NK - this.director1_NK.totalFaults_NK*100;
                    this.GUI.setGrossProfit_NK(this.calculations_NK.totalGross_NK);
                    this.GUI.profitChart();
                    this.GUI.salariesChart();
                    sleep(this.dayDuration_NK);
                    simulaDeadline_NK = temp;
                } catch (InterruptedException ex) {
                    Logger.getLogger(PM_NK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

}
