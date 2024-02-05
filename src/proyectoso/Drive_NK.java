/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso;

import gui.Interface;


public class Drive_NK {
    
    public int animations_NK;
    public int dubs_NK;
    public int scripts_NK;
    public int twists_NK;
    public int stages_NK;
    public int finishedEpisodes_NK = 0;
    public int twistEpisodes_NK = 0;
    public int standardEpisodes_NK = 0;
    public int standardAssembled_NK = 0;
    public int twistsAssembled_NK = 0;
    private Interface GUI;
    
    public Drive_NK(Interface i){
        this.GUI = i;
    }
    
    public void updateDrive_NK(int type, int amount){
        if (type == 1 && this.scripts_NK < 25){
            this.scripts_NK += amount;
            this.GUI.setScripts_NK(this.scripts_NK);
            if (this.scripts_NK > 25){
                this.scripts_NK = 25;
                this.GUI.setScripts_NK(this.scripts_NK);
            }
        }
        else if (type == 2 && this.animations_NK < 55){
            this.animations_NK += amount;
            this.GUI.setAnimations_NK(this.animations_NK);
            if (this.animations_NK > 55){
                this.animations_NK = 55;
                this.GUI.setAnimations_NK(this.animations_NK);
            }
        }
        else if (type == 3 && this.dubs_NK < 35){
            this.dubs_NK += amount;
            this.GUI.setDubs_NK(this.dubs_NK);
            if (this.dubs_NK > 35){
                this.dubs_NK = 35;
                this.GUI.setDubs_NK(this.dubs_NK);
            }
        }
        else if (type == 5 && this.twists_NK < 10){
            this.twists_NK += amount;
            this.GUI.setTwists_NK(this.twists_NK);
            if (this.twists_NK > 10){
                this.twists_NK = 10;
                this.GUI.setTwists_NK(this.twists_NK);
            }
        }
        else if (type == 4 && this.scripts_NK >= 1 && this.stages_NK >= 2 && this.animations_NK >= 6 && this.dubs_NK >= 5 && this.twists_NK >= 1){
                finishedEpisodes_NK += 1;
                this.scripts_NK -= 1;
                this.stages_NK -= 2;
                this.animations_NK -= 6;
                this.dubs_NK -= 5;
                this.GUI.setScripts_NK(scripts_NK);
                this.GUI.setStages_NK(stages_NK);
                this.GUI.setAnimations_NK(animations_NK);
                this.GUI.setDubs_NK(dubs_NK);
                standardEpisodes_NK = finishedEpisodes_NK - twistEpisodes_NK;
                
                if(finishedEpisodes_NK %5 == 0 && finishedEpisodes_NK != 0){
                    this.twists_NK -= 1;
                    twistEpisodes_NK = standardEpisodes_NK/5;
                    this.GUI.setTwists_NK(twists_NK);
                }
                
        }
        else if (type == 6 && this.stages_NK < 20){
            this.stages_NK += amount;
            this.GUI.setStages_NK(this.stages_NK);
            if (this.stages_NK > 20){
                this.stages_NK = 20;
                this.GUI.setStages_NK(this.stages_NK);
            }
        }
        else{}
    }
}

