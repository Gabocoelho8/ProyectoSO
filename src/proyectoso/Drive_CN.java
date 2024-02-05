/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;


public class Drive_CN {
    
    public int animations_CN;
    public int dubs_CN;
    public int scripts_CN;
    public int twists_CN;
    public int stages_CN;
    public int finishedEpisodes_CN = 0;
    public int twistEpisodes_CN = 0;
    public int standardEpisodes_CN = 0;
    public int standardAssembled_CN = 0;
    public int twistsAssembled_CN = 0;
    private Interface GUI;
    
    public Drive_CN(Interface i){
        this.GUI = i;
    }
    
    public void updateDrive_CN(int type, int amount){
        if (type == 1 && this.scripts_CN < 25){
            this.scripts_CN += amount;
            this.GUI.setScripts_CN(this.scripts_CN);
            if (this.scripts_CN > 25){
                this.scripts_CN = 25;
                this.GUI.setScripts_CN(this.scripts_CN);
            }
        }
        else if (type == 2 && this.animations_CN < 55){
            this.animations_CN += amount;
            this.GUI.setAnimations_CN(this.animations_CN);
            if (this.animations_CN > 55){
                this.animations_CN = 55;
                this.GUI.setAnimations_CN(this.animations_CN);
            }
        }
        else if (type == 3 && this.dubs_CN < 35){
            this.dubs_CN += amount;
            this.GUI.setDubs_CN(this.dubs_CN);
            if (this.dubs_CN > 35){
                this.dubs_CN = 35;
                this.GUI.setDubs_CN(this.dubs_CN);
            }
        }
        else if (type == 5 && this.twists_CN < 10){
            this.twists_CN += amount;
            this.GUI.setTwists_CN(this.twists_CN);
            if (this.twists_CN > 10){
                this.twists_CN = 10;
                this.GUI.setTwists_CN(this.twists_CN);
            }
        }
        else if (type == 4 && this.scripts_CN >= 1 && this.stages_CN >= 2 && this.animations_CN >= 6 && this.dubs_CN >= 5 && this.twists_CN >= 1){
                finishedEpisodes_CN += 1;
                this.scripts_CN -= 1;
                this.stages_CN -= 2;
                this.animations_CN -= 6;
                this.dubs_CN -= 5;
                this.GUI.setScripts_CN(scripts_CN);
                this.GUI.setStages_CN(stages_CN);
                this.GUI.setAnimations_CN(animations_CN);
                this.GUI.setDubs_CN(dubs_CN);
                standardEpisodes_CN = finishedEpisodes_CN - twistEpisodes_CN;
                
                if(finishedEpisodes_CN %3 == 0 && finishedEpisodes_CN != 0){
                    this.twists_CN -= 1;
                    twistEpisodes_CN = standardEpisodes_CN/3;
                    this.GUI.setTwists_CN(twists_CN);
                }
                
        }
        else if (type == 6 && this.stages_CN < 20){
            this.stages_CN += amount;
            this.GUI.setStages_CN(this.stages_CN);
            if (this.stages_CN > 20){
                this.stages_CN = 20;
                this.GUI.setStages_CN(this.stages_CN);
            }
        }
        else{}
    }
}

