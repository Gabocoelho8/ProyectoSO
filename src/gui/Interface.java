/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import proyectoso.ProyectoSO;


public class Interface extends javax.swing.JFrame {
    public int y = 0;
    public int z = 0;
    public int[] rolesUpdated_CN = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int[] salariesUpdated_CN = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int[] rolesUpdated_NK = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int[] salariesUpdated_NK = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int simulaDeadline_CN = 1;
    public int simulaSegundos_CN = 1;
    public int simulaDeadline_NK = 1;
    public int simulaSegundos_NK = 1;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private CategoryPlot categoryPlot;
    private ChartPanel chartPanel;
    public float netProfit_CN = 0;
    public float netProfit_NK = 0;
    public float totalSalaries_CN = 0;
    public float totalSalaries_NK = 0;
    public int Penalized_CN = 0;
    public int Penalized_NK = 0;
    public int amountAssembler_CN = 0;
    public int amountAssembler_NK = 0;
    
    
    public Interface() throws IOException {
        initComponents();
        profitChart();
        salariesChart();
        
        //Cartoon Network-------------------------------------------------------
        int totalGuionistas_CN = 1;
        int totalAnimadores_CN = 1;
        int totalActores_CN = 1;
        int totalEnsambladores_CN = 1;
        int totalPlottwists_CN = 1;
        int totalDiseñadores_CN = 1;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Cartoon_Network.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_CN = Integer.parseInt(ln);
                        amountAssembler_CN = totalEnsambladores_CN;
                    }
                else if (lineIndex == 4){
                        totalPlottwists_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_CN = Integer.parseInt(ln);
                    }
                if (lineIndex == 6){
                        simulaSegundos_CN = Integer.parseInt(ln)*1000;
                    }
                else if (lineIndex == 7){
                        simulaDeadline_CN = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int y = 0;
        
        try {
            String ln;
            int lineIndex = 0;
            BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Cartoon_Network.txt"));
            while((ln = br.readLine())!= null){
                if (lineIndex == 0) {
                        totalGuionistas_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 1){
                        totalAnimadores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 2){
                        totalActores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 3){
                        totalEnsambladores_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 4){
                        totalPlottwists_CN = Integer.parseInt(ln);
                    }
                else if (lineIndex == 5){
                        totalDiseñadores_CN = Integer.parseInt(ln);
                    }
                lineIndex ++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(y = 0; y != totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 1;
            salariesUpdated_CN[y] = 20;
        }
        for(y = (Integer) totalGuionistas_CN; y != totalAnimadores_CN + totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 2;
            salariesUpdated_CN[y] = 40;
        }
        for(y = totalAnimadores_CN + totalGuionistas_CN; y != totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 3;
            salariesUpdated_CN[y] = 16;
        }
        for(y = totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 4;
            salariesUpdated_CN[y] = 50;
        }
        for(y = totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 5;
            salariesUpdated_CN[y] = 34;
        }
        for(y = totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y != totalDiseñadores_CN + totalPlottwists_CN + totalEnsambladores_CN + totalActores_CN + totalAnimadores_CN + totalGuionistas_CN; y++){
            rolesUpdated_CN[y] = 6;
            salariesUpdated_CN[y] = 26;
        }
        
        //Nickelodeon-----------------------------------------------------------
            int totalGuionistas_NK = 1;
            int totalAnimadores_NK = 1;
            int totalActores_NK = 1;
            int totalEnsambladores_NK = 1;
            int totalPlottwists_NK = 1;
            int totalDiseñadores_NK = 1;

            try {
                String ln;
                int lineIndex = 0;
                BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Cartoon_Network.txt"));
                while((ln = br.readLine())!= null){
                    if (lineIndex == 0) {
                            totalGuionistas_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 1){
                            totalAnimadores_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 2){
                            totalActores_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 3){
                            totalEnsambladores_NK = Integer.parseInt(ln);
                            amountAssembler_NK = totalEnsambladores_NK;
                        }
                    else if (lineIndex == 4){
                            totalPlottwists_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 5){
                            totalDiseñadores_NK = Integer.parseInt(ln);
                        }
                    if (lineIndex == 6){
                            simulaSegundos_NK = Integer.parseInt(ln)*1000;
                        }
                    else if (lineIndex == 7){
                            simulaDeadline_NK = Integer.parseInt(ln);
                        }
                    lineIndex ++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
            }

            int z = 0;
            
            try {
                String ln;
                int lineIndex = 0;
                BufferedReader br = new BufferedReader(new FileReader("src\\txt\\Nickelodeon.txt"));
                while((ln = br.readLine())!= null){
                    if (lineIndex == 0) {
                            totalGuionistas_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 1){
                            totalAnimadores_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 2){
                            totalActores_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 3){
                            totalEnsambladores_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 4){
                            totalPlottwists_NK = Integer.parseInt(ln);
                        }
                    else if (lineIndex == 5){
                            totalDiseñadores_NK = Integer.parseInt(ln);
                        }
                    lineIndex ++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(z = 0; z != totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 1;
                salariesUpdated_NK[z] = 20;
            }
            for(z = (Integer) totalGuionistas_NK; z != totalAnimadores_NK + totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 2;
                salariesUpdated_NK[z] = 40;
            }
            for(z = totalAnimadores_NK + totalGuionistas_NK; z != totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 3;
                salariesUpdated_NK[z] = 16;
            }
            for(z = totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 4;
                salariesUpdated_NK[z] = 50;
            }
            for(z = totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 5;
                salariesUpdated_NK[z] = 34;
            }
            for(z = totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z != totalDiseñadores_NK + totalPlottwists_NK + totalEnsambladores_NK + totalActores_NK + totalAnimadores_NK + totalGuionistas_NK; z++){
                rolesUpdated_NK[z] = 6;
                salariesUpdated_NK[z] = 26;
            }
        }
    
/**
     * Creates new form Interfaz
     */
    public void profitChart(){
        
        dataset = new DefaultCategoryDataset();
        
        dataset.addValue(netProfit_CN/1000000, "Cartoon Network", "");
        dataset.addValue(netProfit_NK/1000000, "Nickelodeon", "");
        
        chart = ChartFactory.createBarChart("Ganancia Neta", "", "Millones de Dolares", dataset, PlotOrientation.VERTICAL, true, true, false);
    
        categoryPlot = chart.getCategoryPlot();
        
        chartPanel = new ChartPanel(chart);
        jPanel8.removeAll();
        jPanel8.add(chartPanel, BorderLayout.CENTER);
        jPanel8.validate();
    }
    
    public void salariesChart(){
        
        dataset = new DefaultCategoryDataset();
        
        dataset.addValue(totalSalaries_CN/1000, "Cartoon Network", "");
        dataset.addValue(totalSalaries_NK/1000, "Nickelodeon", "");
        
        chart = ChartFactory.createBarChart("Salarios Pagados", "", "Miles de Dolares", dataset, PlotOrientation.VERTICAL, true, true, false);
    
        categoryPlot = chart.getCategoryPlot();
        
        chartPanel = new ChartPanel(chart);
        jPanel10.removeAll();
        jPanel10.add(chartPanel, BorderLayout.CENTER);
        jPanel10.validate();
    }
    
    public void setDeadline_CN(int deadline_CN){
        String showDeadline_CN = String.valueOf(deadline_CN);
        TextDeadline_CN.setText(showDeadline_CN);
    }
    
    public void setDeadline_NK(int deadline_NK){
        String showDeadline_NK = String.valueOf(deadline_NK);
        TextDeadline_NK.setText(showDeadline_NK);
    }
    
    public void setStatusPM_CN(String status_PM_CN){
        TextStatusPM_CN.setText(status_PM_CN);
    }
    
    public void setStatusPM_NK(String status_PM_NK){
        TextStatusPM_NK.setText(status_PM_NK);
    }
    
    public void setStatusDirector_CN(String status_Director_CN){
        TextStatusDirector_CN.setText(status_Director_CN);
    }
    
    public void setStatusDirector_NK(String status_Director_NK){
        TextStatusDirector_NK.setText(status_Director_NK);
    }
    
    public void setfinishedEpisodes_CN(int finishedEpisodes_CN){
        String showFinishedEpisodes_CN = String.valueOf(finishedEpisodes_CN);
        TextFinishedEpisodes_CN.setText(showFinishedEpisodes_CN);
    }
    
    public void setfinishedEpisodes_NK(int finishedEpisodes_NK){
        String showFinishedEpisodes_NK = String.valueOf(finishedEpisodes_NK);
        TextFinishedEpisodes_NK.setText(showFinishedEpisodes_NK);
    }
    
    public void setStandardEpisodes_CN(int standardEpisodes_CN){
        String showStandardEpisodes_CN = String.valueOf(standardEpisodes_CN);
        TextStandardEpisodes_CN.setText(showStandardEpisodes_CN);
    }
    
    public void setStandardEpisodes_NK(int standardEpisodes_NK){
        String showStandardEpisodes_NK = String.valueOf(standardEpisodes_NK);
        TextStandardEpisodes_NK.setText(showStandardEpisodes_NK);
    }
    
    public void settwistEpisodes_CN(int twistEpisodes_CN){
        String showTwistEpisodes_CN = String.valueOf(twistEpisodes_CN);
        TextTwistsEpisodes_CN.setText(showTwistEpisodes_CN);
    }
     
    public void settwistEpisodes_NK(int twistEpisodes_NK){
        String showTwistEpisodes_NK = String.valueOf(twistEpisodes_NK);
        TextTwistsEpisodes_NK.setText(showTwistEpisodes_NK);
    }
    
    public void setScripts_CN(int scripts_CN){
        String showScripts_CN = String.valueOf(scripts_CN);
        TextScripts_CN.setText(showScripts_CN);
    }
    
    public void setScripts_NK(int scripts_NK){
        String showScripts_NK = String.valueOf(scripts_NK);
        TextScripts_NK.setText(showScripts_NK);
    }
    
    public void setStages_CN(int stages_CN){
        String showStages_CN = String.valueOf(stages_CN);
        TextStages_CN.setText(showStages_CN);
    }
    
    public void setStages_NK(int stages_NK){
        String showStages_NK = String.valueOf(stages_NK);
        TextStages_NK.setText(showStages_NK);
    }
    
    public void setAnimations_CN(int animations_CN){
        String showAnimations_CN = String.valueOf(animations_CN);
        TextAnimations_CN.setText(showAnimations_CN);
    }
    
    public void setAnimations_NK(int animations_NK){
        String showAnimations_NK = String.valueOf(animations_NK);
        TextAnimations_NK.setText(showAnimations_NK);
    }

    public void setDubs_CN(int dubs_CN){
        String showDubs_CN = String.valueOf(dubs_CN);
        TextDubs_CN.setText(showDubs_CN);
    }
    
    public void setDubs_NK(int dubs_NK){
        String showDubs_NK = String.valueOf(dubs_NK);
        TextDubs_NK.setText(showDubs_NK);
    }
    
    public void setTwists_CN(int twists_CN){
        String showTwists_CN = String.valueOf(twists_CN);
        TextTwists_CN.setText(showTwists_CN);
    }
    
    public void setTwists_NK(int twists_NK){
        String showTwists_NK = String.valueOf(twists_NK);
        TextTwists_NK.setText(showTwists_NK);
    }
    
    public void setTotalFaults_CN(int totalFaults_CN){
        String showTotalFaults_CN = String.valueOf(totalFaults_CN);
        TextTotalFaults_CN.setText(showTotalFaults_CN);
    }
    
    public void setTotalFaults_NK(int totalFaults_NK){
        String showTotalFaults_NK = String.valueOf(totalFaults_NK);
        TextTotalFaults_NK.setText(showTotalFaults_NK);
    }
    
    public void setPenalized_CN(int totalFaults_CN){
        Penalized_CN = totalFaults_CN * 100;
        String showPenalized_CN = String.valueOf(Penalized_CN);
        TextPenalized_CN.setText(showPenalized_CN);
    }
    
    public void setPenalized_NK(int totalFaults_NK){
        Penalized_NK = totalFaults_NK * 100;
        String showPenalized_NK = String.valueOf(Penalized_NK);
        TextPenalized_NK.setText(showPenalized_NK);
    }
    
    public void setCost_CN(float totalSalary_CN){
        float salaryWithPenalized_CN = totalSalary_CN;
        String showCost_CN = String.valueOf(salaryWithPenalized_CN);
        TextCost_CN.setText(showCost_CN);
    }
    
    public void setCost_NK(float totalSalary_NK){
        float salaryWithPenalized_NK = totalSalary_NK - Penalized_NK;
        String showCost_NK = String.valueOf(salaryWithPenalized_NK);
        TextCost_NK.setText(showCost_NK);
    }
    
    public void setNetProfit_CN(float totalProfit_CN){
        String showNetProfit_CN = String.valueOf(totalProfit_CN);
        TextNetProfit_CN.setText(showNetProfit_CN);
    }
    
    public void setNetProfit_NK(float totalProfit_NK){
        String showNetProfit_NK = String.valueOf(totalProfit_NK);
        TextNetProfit_NK.setText(showNetProfit_NK);
    }
    
    public void setGrossProfit_CN(float totalGross_CN){
        String showGrossProfit_CN = String.valueOf(totalGross_CN);
        TextGrossProfit_CN.setText(showGrossProfit_CN);
    }
    
    public void setGrossProfit_NK(float totalGross_NK){
        String showGrossProfit_NK = String.valueOf(totalGross_NK);
        TextGrossProfit_NK.setText(showGrossProfit_NK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ActoresTXT_NK = new javax.swing.JSpinner();
        AnimadoresTXT_NK = new javax.swing.JSpinner();
        GuionistasTXT_NK = new javax.swing.JSpinner();
        DiseñadoresTXT_NK = new javax.swing.JSpinner();
        PlottwistsTXT_NK = new javax.swing.JSpinner();
        EnsambladoresTXT_NK = new javax.swing.JSpinner();
        jLabel46 = new javax.swing.JLabel();
        DeadlineTXT_NK = new javax.swing.JSpinner();
        jLabel49 = new javax.swing.JLabel();
        SegundosTXT_NK = new javax.swing.JSpinner();
        jLabel50 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Logo_CN1 = new javax.swing.JLabel();
        ActoresTXT_CN = new javax.swing.JSpinner();
        AnimadoresTXT_CN = new javax.swing.JSpinner();
        GuionistasTXT_CN = new javax.swing.JSpinner();
        DiseñadoresTXT_CN = new javax.swing.JSpinner();
        PlottwistsTXT_CN = new javax.swing.JSpinner();
        EnsambladoresTXT_CN = new javax.swing.JSpinner();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        SegundosTXT_CN = new javax.swing.JSpinner();
        jLabel48 = new javax.swing.JLabel();
        DeadlineTXT_CN = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        TextDeadline_CN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextScripts_CN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TextStages_CN = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TextDubs_CN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TextAnimations_CN = new javax.swing.JTextField();
        TextStatusPM_CN = new javax.swing.JTextField();
        TextStatusDirector_CN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TextPenalized_CN = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TextTotalFaults_CN = new javax.swing.JTextField();
        TextFinishedEpisodes_CN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextTwistsEpisodes_CN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TextGrossProfit_CN = new javax.swing.JTextField();
        TextCost_CN = new javax.swing.JTextField();
        TextNetProfit_CN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Logo_CN = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        TextTwists_CN = new javax.swing.JTextField();
        TextStandardEpisodes_CN = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        TextDeadline_NK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TextScripts_NK = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TextStages_NK = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TextDubs_NK = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TextAnimations_NK = new javax.swing.JTextField();
        TextStatusPM_NK = new javax.swing.JTextField();
        TextStatusDirector_NK = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TextPenalized_NK = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TextTotalFaults_NK = new javax.swing.JTextField();
        TextFinishedEpisodes_NK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextTwistsEpisodes_NK = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TextTwists_NK = new javax.swing.JTextField();
        TextGrossProfit_NK = new javax.swing.JTextField();
        TextCost_NK = new javax.swing.JTextField();
        TextNetProfit_NK = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        TextStandardEpisodes_NK = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Aplicar y Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jLabel38.setFont(new java.awt.Font("HP Simplified", 1, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 153, 51));
        jLabel38.setText("NICKELODEON");

        jLabel39.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 153, 51));
        jLabel39.setText("Actores");

        jLabel40.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 153, 51));
        jLabel40.setText("Animadores");

        jLabel41.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 153, 51));
        jLabel41.setText("Guionistas");

        jLabel42.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 153, 51));
        jLabel42.setText("Ensambladores");

        jLabel43.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 153, 51));
        jLabel43.setText("Guionistas Plottwist");

        jLabel44.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 153, 51));
        jLabel44.setText("Diseñadores");

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Aplicar y Guardar Cambios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ActoresTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        AnimadoresTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        GuionistasTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        DiseñadoresTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        PlottwistsTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        EnsambladoresTXT_NK.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel46.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 153, 51));
        jLabel46.setText("(15 Empleados)");

        DeadlineTXT_NK.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 1));

        jLabel49.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 153, 0));
        jLabel49.setText("SEGUNDOS");

        SegundosTXT_NK.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        jLabel50.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 153, 0));
        jLabel50.setText("DEADLINE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel43)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel44))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ActoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(AnimadoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(GuionistasTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel41)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(EnsambladoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PlottwistsTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(DiseñadoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addComponent(DeadlineTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(18, 18, 18)
                                .addComponent(SegundosTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(83, 83, 83))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel46))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(SegundosTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(DeadlineTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ActoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnimadoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuionistasTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PlottwistsTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EnsambladoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiseñadoresTXT_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Guionistas");

        jLabel33.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Animadores");

        jLabel34.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Actores");

        jLabel35.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Ensambladores");

        jLabel36.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Guionistas Plottwist");

        jLabel37.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Diseñadores");

        Logo_CN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CartoonNetwork.png"))); // NOI18N
        Logo_CN1.setText("jLabel6");

        ActoresTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        AnimadoresTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        GuionistasTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        DiseñadoresTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        PlottwistsTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        EnsambladoresTXT_CN.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        jLabel45.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("(16 Empleados)");

        jLabel47.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("SEGUNDOS");

        SegundosTXT_CN.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        jLabel48.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("DEADLINE");

        DeadlineTXT_CN.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel36)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel37))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(AnimadoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(ActoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel33)))
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(GuionistasTXT_CN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(EnsambladoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(PlottwistsTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DiseñadoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DeadlineTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Logo_CN1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SegundosTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45)
                            .addComponent(Logo_CN1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SegundosTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeadlineTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuionistasTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnimadoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PlottwistsTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EnsambladoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiseñadoresTXT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Config", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TextDeadline_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextDeadline_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDeadline_CNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Deadline");

        jLabel9.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Guiones (Max 25)");

        TextScripts_CN.setEditable(false);
        TextScripts_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextScripts_CN.setText("0");
        TextScripts_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextScripts_CNActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Escenarios (Max 20)");

        TextStages_CN.setEditable(false);
        TextStages_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextStages_CN.setText("0");
        TextStages_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStages_CNActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Doblajes (Max 35)");

        TextDubs_CN.setEditable(false);
        TextDubs_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextDubs_CN.setText("0");
        TextDubs_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDubs_CNActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Animaciones (Max 55)");

        TextAnimations_CN.setEditable(false);
        TextAnimations_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextAnimations_CN.setText("0");
        TextAnimations_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAnimations_CNActionPerformed(evt);
            }
        });

        TextStatusPM_CN.setEditable(false);
        TextStatusPM_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStatusPM_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStatusPM_CNActionPerformed(evt);
            }
        });

        TextStatusDirector_CN.setEditable(false);
        TextStatusDirector_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStatusDirector_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStatusDirector_CNActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Status PM");

        jLabel14.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Status Director");

        TextPenalized_CN.setEditable(false);
        TextPenalized_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextPenalized_CN.setText("0");
        TextPenalized_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPenalized_CNActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Descontado");

        jLabel16.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Faltas");

        TextTotalFaults_CN.setEditable(false);
        TextTotalFaults_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextTotalFaults_CN.setText("0");
        TextTotalFaults_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTotalFaults_CNActionPerformed(evt);
            }
        });

        TextFinishedEpisodes_CN.setEditable(false);
        TextFinishedEpisodes_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextFinishedEpisodes_CN.setText("0");
        TextFinishedEpisodes_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFinishedEpisodes_CNActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CAPITULOS COMPLETOS");

        TextTwistsEpisodes_CN.setEditable(false);
        TextTwistsEpisodes_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextTwistsEpisodes_CN.setText("0");
        TextTwistsEpisodes_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTwistsEpisodes_CNActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CAPITULOS PLOTTWIST");

        TextGrossProfit_CN.setEditable(false);
        TextGrossProfit_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextGrossProfit_CN.setText("0");
        TextGrossProfit_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextGrossProfit_CNActionPerformed(evt);
            }
        });

        TextCost_CN.setEditable(false);
        TextCost_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextCost_CN.setText("0");
        TextCost_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCost_CNActionPerformed(evt);
            }
        });

        TextNetProfit_CN.setEditable(false);
        TextNetProfit_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextNetProfit_CN.setText("0");
        TextNetProfit_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNetProfit_CNActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("GANANCIAS BRUTAS");

        jLabel5.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("COSTOS");

        jLabel3.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("GANANCIAS NETAS");

        Logo_CN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CartoonNetwork.png"))); // NOI18N
        Logo_CN.setText("jLabel6");

        jLabel32.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Plottwist (Max 10)");

        TextTwists_CN.setEditable(false);
        TextTwists_CN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextTwists_CN.setText("0");
        TextTwists_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTwists_CNActionPerformed(evt);
            }
        });

        TextStandardEpisodes_CN.setEditable(false);
        TextStandardEpisodes_CN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStandardEpisodes_CN.setText("0");
        TextStandardEpisodes_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStandardEpisodes_CNActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("CAPITULOS ESTANDAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Logo_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TextDeadline_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(TextScripts_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel32))
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(TextAnimations_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(36, 36, 36)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(TextDubs_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(TextStages_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGap(16, 16, 16))))
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextTotalFaults_CN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPenalized_CN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextStatusDirector_CN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextStatusPM_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164)
                .addComponent(TextTwists_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextCost_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextGrossProfit_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextNetProfit_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFinishedEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TextStandardEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextTwistsEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextDeadline_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Logo_CN)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextStatusPM_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextStatusDirector_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextPenalized_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextTotalFaults_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextStages_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextDubs_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextScripts_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addGap(4, 4, 4)
                                        .addComponent(TextAnimations_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextTwists_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFinishedEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextTwistsEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(TextStandardEpisodes_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextGrossProfit_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextCost_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextNetProfit_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jTabbedPane1.addTab("Cartoon Network", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        TextDeadline_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextDeadline_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDeadline_NKActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Deadline");

        jLabel18.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 51));
        jLabel18.setText("Guiones (Max 25)");

        TextScripts_NK.setEditable(false);
        TextScripts_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextScripts_NK.setText("0");
        TextScripts_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextScripts_NKActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 51));
        jLabel19.setText("Escenarios (Max 20)");

        TextStages_NK.setEditable(false);
        TextStages_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextStages_NK.setText("0");
        TextStages_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStages_NKActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 51));
        jLabel20.setText("Doblajes (Max 35)");

        TextDubs_NK.setEditable(false);
        TextDubs_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextDubs_NK.setText("0");
        TextDubs_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDubs_NKActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 51));
        jLabel21.setText("Animaciones (Max 55)");

        TextAnimations_NK.setEditable(false);
        TextAnimations_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextAnimations_NK.setText("0");
        TextAnimations_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAnimations_NKActionPerformed(evt);
            }
        });

        TextStatusPM_NK.setEditable(false);
        TextStatusPM_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStatusPM_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStatusPM_NKActionPerformed(evt);
            }
        });

        TextStatusDirector_NK.setEditable(false);
        TextStatusDirector_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStatusDirector_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStatusDirector_NKActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 153, 51));
        jLabel22.setText("Status PM");

        jLabel23.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 153, 51));
        jLabel23.setText("Status Director");

        TextPenalized_NK.setEditable(false);
        TextPenalized_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextPenalized_NK.setText("0");
        TextPenalized_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPenalized_NKActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 153, 51));
        jLabel24.setText("Descontado");

        jLabel25.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 153, 51));
        jLabel25.setText("Faltas");

        TextTotalFaults_NK.setEditable(false);
        TextTotalFaults_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextTotalFaults_NK.setText("0");
        TextTotalFaults_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTotalFaults_NKActionPerformed(evt);
            }
        });

        TextFinishedEpisodes_NK.setEditable(false);
        TextFinishedEpisodes_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextFinishedEpisodes_NK.setText("0");
        TextFinishedEpisodes_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFinishedEpisodes_NKActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("CAPITULOS COMPLETOS");

        TextTwistsEpisodes_NK.setEditable(false);
        TextTwistsEpisodes_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextTwistsEpisodes_NK.setText("0");
        TextTwistsEpisodes_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTwistsEpisodes_NKActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 153, 51));
        jLabel26.setText("CAPITULOS PLOTTWIST");

        jLabel27.setFont(new java.awt.Font("HP Simplified", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 153, 51));
        jLabel27.setText("Plottwist (Max 10)");

        TextTwists_NK.setEditable(false);
        TextTwists_NK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextTwists_NK.setText("0");
        TextTwists_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTwists_NKActionPerformed(evt);
            }
        });

        TextGrossProfit_NK.setEditable(false);
        TextGrossProfit_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextGrossProfit_NK.setText("0");
        TextGrossProfit_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextGrossProfit_NKActionPerformed(evt);
            }
        });

        TextCost_NK.setEditable(false);
        TextCost_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextCost_NK.setText("0");
        TextCost_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCost_NKActionPerformed(evt);
            }
        });

        TextNetProfit_NK.setEditable(false);
        TextNetProfit_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextNetProfit_NK.setText("0");
        TextNetProfit_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNetProfit_NKActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 153, 51));
        jLabel28.setText("GANANCIAS BRUTAS");

        jLabel29.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 153, 51));
        jLabel29.setText("COSTOS");

        jLabel30.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 153, 51));
        jLabel30.setText("GANANCIAS NETAS");

        jLabel31.setFont(new java.awt.Font("HP Simplified", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 153, 51));
        jLabel31.setText("NICKELODEON");

        TextStandardEpisodes_NK.setEditable(false);
        TextStandardEpisodes_NK.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextStandardEpisodes_NK.setText("0");
        TextStandardEpisodes_NK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextStandardEpisodes_NKActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 153, 51));
        jLabel52.setText("CAPITULOS ESTANDAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextTotalFaults_NK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPenalized_NK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextStatusDirector_NK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextStatusPM_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(TextScripts_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(TextAnimations_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21))
                                .addGap(39, 39, 39))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(TextTwists_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 89, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(TextDubs_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(TextStages_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(83, 83, 83)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(TextDeadline_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator8)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextCost_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextGrossProfit_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextNetProfit_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFinishedEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextStandardEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextTwistsEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextDeadline_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextScripts_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextAnimations_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextStages_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextDubs_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextTwists_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextStatusPM_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextStatusDirector_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextPenalized_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextTotalFaults_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(31, 31, 31)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextFinishedEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(TextStandardEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(TextTwistsEpisodes_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(TextGrossProfit_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(TextCost_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(TextNetProfit_NK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nickelodeon", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("BONO 10%", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextNetProfit_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNetProfit_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNetProfit_NKActionPerformed

    private void TextCost_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCost_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCost_NKActionPerformed

    private void TextGrossProfit_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextGrossProfit_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextGrossProfit_NKActionPerformed

    private void TextTwists_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTwists_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTwists_NKActionPerformed

    private void TextTwistsEpisodes_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTwistsEpisodes_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTwistsEpisodes_NKActionPerformed

    private void TextFinishedEpisodes_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFinishedEpisodes_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFinishedEpisodes_NKActionPerformed

    private void TextTotalFaults_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTotalFaults_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTotalFaults_NKActionPerformed

    private void TextPenalized_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPenalized_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPenalized_NKActionPerformed

    private void TextStatusDirector_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStatusDirector_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStatusDirector_NKActionPerformed

    private void TextStatusPM_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStatusPM_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStatusPM_NKActionPerformed

    private void TextAnimations_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextAnimations_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextAnimations_NKActionPerformed

    private void TextDubs_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDubs_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDubs_NKActionPerformed

    private void TextStages_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStages_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStages_NKActionPerformed

    private void TextScripts_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextScripts_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextScripts_NKActionPerformed

    private void TextDeadline_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDeadline_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDeadline_NKActionPerformed

    private void TextTwists_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTwists_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTwists_CNActionPerformed

    private void TextNetProfit_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNetProfit_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNetProfit_CNActionPerformed

    private void TextCost_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCost_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCost_CNActionPerformed

    private void TextGrossProfit_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextGrossProfit_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextGrossProfit_CNActionPerformed

    private void TextTwistsEpisodes_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTwistsEpisodes_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTwistsEpisodes_CNActionPerformed

    private void TextFinishedEpisodes_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFinishedEpisodes_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFinishedEpisodes_CNActionPerformed

    private void TextTotalFaults_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTotalFaults_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTotalFaults_CNActionPerformed

    private void TextPenalized_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPenalized_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPenalized_CNActionPerformed

    private void TextStatusDirector_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStatusDirector_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStatusDirector_CNActionPerformed

    private void TextStatusPM_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStatusPM_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStatusPM_CNActionPerformed

    private void TextAnimations_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextAnimations_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextAnimations_CNActionPerformed

    private void TextDubs_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDubs_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDubs_CNActionPerformed

    private void TextStages_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStages_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStages_CNActionPerformed

    private void TextScripts_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextScripts_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextScripts_CNActionPerformed

    private void TextDeadline_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDeadline_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDeadline_CNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if((Integer) GuionistasTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) EnsambladoresTXT_NK.getValue() + (Integer) PlottwistsTXT_NK.getValue() + (Integer) DiseñadoresTXT_NK.getValue() == 15){
            if((Integer) GuionistasTXT_CN.getValue() != 0 && (Integer) AnimadoresTXT_CN.getValue() != 0 && (Integer) ActoresTXT_CN.getValue() != 0 && (Integer) EnsambladoresTXT_CN.getValue() != 0 && (Integer) PlottwistsTXT_CN.getValue() != 0 && (Integer) DiseñadoresTXT_CN.getValue() != 0){
                try{
                    simulaDeadline_NK = (Integer) DeadlineTXT_NK.getValue();
                    simulaSegundos_NK = (Integer) SegundosTXT_NK.getValue() *1000;
                    amountAssembler_NK = (Integer) EnsambladoresTXT_NK.getValue();
                    File file1 = new File("src\\txt\\Nickelodeon.txt");

                    PrintWriter pw = new PrintWriter(file1);
                    pw.println(GuionistasTXT_NK.getValue());
                    pw.println(AnimadoresTXT_NK.getValue());
                    pw.println(ActoresTXT_NK.getValue());
                    pw.println(EnsambladoresTXT_NK.getValue());
                    pw.println(PlottwistsTXT_NK.getValue());
                    pw.println(DiseñadoresTXT_NK.getValue());
                    pw.println(SegundosTXT_NK.getValue());
                    pw.println(DeadlineTXT_NK.getValue());
                    pw.close();

                    for(z = 0; z != (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 1;
                        this.salariesUpdated_NK[z] = 20;
                    }
                    for(z = (Integer) GuionistasTXT_NK.getValue(); z != (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 2;
                        this.salariesUpdated_NK[z] = 40;
                    }
                    for(z = (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z != (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 3;
                        this.salariesUpdated_NK[z] = 16;
                    }
                    for(z = (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z != (Integer) EnsambladoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 4;
                        this.salariesUpdated_NK[z] = 50;
                    }
                    for(z = (Integer) EnsambladoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z != (Integer) PlottwistsTXT_NK.getValue() + (Integer) EnsambladoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 5;
                        this.salariesUpdated_NK[z] = 34;
                    }
                    for(z = (Integer) PlottwistsTXT_NK.getValue() + (Integer) EnsambladoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z != (Integer) DiseñadoresTXT_NK.getValue() + (Integer) PlottwistsTXT_NK.getValue() + (Integer) EnsambladoresTXT_NK.getValue() + (Integer) ActoresTXT_NK.getValue() + (Integer) AnimadoresTXT_NK.getValue() + (Integer) GuionistasTXT_NK.getValue(); z++){
                        this.rolesUpdated_NK[z] = 6;
                        this.salariesUpdated_NK[z] = 26;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "¡Minimo 1 empleado de cada tipo!");
            }
        }
            else{
                JOptionPane.showMessageDialog(null, "¡Tienen que ser 15 Empleados!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if((Integer) GuionistasTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) EnsambladoresTXT_CN.getValue() + (Integer) PlottwistsTXT_CN.getValue() + (Integer) DiseñadoresTXT_CN.getValue() == 16){
            if((Integer) GuionistasTXT_CN.getValue() != 0 && (Integer) AnimadoresTXT_CN.getValue() != 0 && (Integer) ActoresTXT_CN.getValue() != 0 && (Integer) EnsambladoresTXT_CN.getValue() != 0 && (Integer) PlottwistsTXT_CN.getValue() != 0 && (Integer) DiseñadoresTXT_CN.getValue() != 0){
                try{
                    simulaDeadline_CN = (Integer) DeadlineTXT_CN.getValue();
                    simulaSegundos_CN = (Integer) SegundosTXT_CN.getValue() *1000;
                    amountAssembler_CN = (Integer) EnsambladoresTXT_CN.getValue();
                    File file1 = new File("src\\txt\\Cartoon_Network.txt");

                    PrintWriter pw = new PrintWriter(file1);
                    pw.println(GuionistasTXT_CN.getValue());
                    pw.println(AnimadoresTXT_CN.getValue());
                    pw.println(ActoresTXT_CN.getValue());
                    pw.println(EnsambladoresTXT_CN.getValue());
                    pw.println(PlottwistsTXT_CN.getValue());
                    pw.println(DiseñadoresTXT_CN.getValue());
                    pw.println(SegundosTXT_CN.getValue());
                    pw.println(DeadlineTXT_CN.getValue());
                    pw.close();

                    for(y = 0; y != (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 1;
                        this.salariesUpdated_CN[y] = 20;
                    }
                    for(y = (Integer) GuionistasTXT_CN.getValue(); y != (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 2;
                        this.salariesUpdated_CN[y] = 40;
                    }
                    for(y = (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y != (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 3;
                        this.salariesUpdated_CN[y] = 16;
                    }
                    for(y = (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y != (Integer) EnsambladoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 4;
                        this.salariesUpdated_CN[y] = 50;
                    }
                    for(y = (Integer) EnsambladoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y != (Integer) PlottwistsTXT_CN.getValue() + (Integer) EnsambladoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 5;
                        this.salariesUpdated_CN[y] = 34;
                    }
                    for(y = (Integer) PlottwistsTXT_CN.getValue() + (Integer) EnsambladoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y != (Integer) DiseñadoresTXT_CN.getValue() + (Integer) PlottwistsTXT_CN.getValue() + (Integer) EnsambladoresTXT_CN.getValue() + (Integer) ActoresTXT_CN.getValue() + (Integer) AnimadoresTXT_CN.getValue() + (Integer) GuionistasTXT_CN.getValue(); y++){
                        this.rolesUpdated_CN[y] = 6;
                        this.salariesUpdated_CN[y] = 26;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ProyectoSO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                JOptionPane.showMessageDialog(null, "¡Minimo 1 empleado de cada tipo!");
                }
        } else{
            JOptionPane.showMessageDialog(null, "¡Tienen que ser 16 Empleados!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextStandardEpisodes_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStandardEpisodes_CNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStandardEpisodes_CNActionPerformed

    private void TextStandardEpisodes_NKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextStandardEpisodes_NKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextStandardEpisodes_NKActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ActoresTXT_CN;
    private javax.swing.JSpinner ActoresTXT_NK;
    private javax.swing.JSpinner AnimadoresTXT_CN;
    private javax.swing.JSpinner AnimadoresTXT_NK;
    private javax.swing.JSpinner DeadlineTXT_CN;
    private javax.swing.JSpinner DeadlineTXT_NK;
    private javax.swing.JSpinner DiseñadoresTXT_CN;
    private javax.swing.JSpinner DiseñadoresTXT_NK;
    private javax.swing.JSpinner EnsambladoresTXT_CN;
    private javax.swing.JSpinner EnsambladoresTXT_NK;
    private javax.swing.JSpinner GuionistasTXT_CN;
    private javax.swing.JSpinner GuionistasTXT_NK;
    private javax.swing.JLabel Logo_CN;
    private javax.swing.JLabel Logo_CN1;
    private javax.swing.JSpinner PlottwistsTXT_CN;
    private javax.swing.JSpinner PlottwistsTXT_NK;
    private javax.swing.JSpinner SegundosTXT_CN;
    private javax.swing.JSpinner SegundosTXT_NK;
    private javax.swing.JTextField TextAnimations_CN;
    private javax.swing.JTextField TextAnimations_NK;
    private javax.swing.JTextField TextCost_CN;
    private javax.swing.JTextField TextCost_NK;
    private javax.swing.JTextField TextDeadline_CN;
    private javax.swing.JTextField TextDeadline_NK;
    private javax.swing.JTextField TextDubs_CN;
    private javax.swing.JTextField TextDubs_NK;
    private javax.swing.JTextField TextFinishedEpisodes_CN;
    private javax.swing.JTextField TextFinishedEpisodes_NK;
    private javax.swing.JTextField TextGrossProfit_CN;
    private javax.swing.JTextField TextGrossProfit_NK;
    private javax.swing.JTextField TextNetProfit_CN;
    private javax.swing.JTextField TextNetProfit_NK;
    private javax.swing.JTextField TextPenalized_CN;
    private javax.swing.JTextField TextPenalized_NK;
    private javax.swing.JTextField TextScripts_CN;
    private javax.swing.JTextField TextScripts_NK;
    private javax.swing.JTextField TextStages_CN;
    private javax.swing.JTextField TextStages_NK;
    private javax.swing.JTextField TextStandardEpisodes_CN;
    private javax.swing.JTextField TextStandardEpisodes_NK;
    private javax.swing.JTextField TextStatusDirector_CN;
    private javax.swing.JTextField TextStatusDirector_NK;
    private javax.swing.JTextField TextStatusPM_CN;
    private javax.swing.JTextField TextStatusPM_NK;
    private javax.swing.JTextField TextTotalFaults_CN;
    private javax.swing.JTextField TextTotalFaults_NK;
    private javax.swing.JTextField TextTwistsEpisodes_CN;
    private javax.swing.JTextField TextTwistsEpisodes_NK;
    private javax.swing.JTextField TextTwists_CN;
    private javax.swing.JTextField TextTwists_NK;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
