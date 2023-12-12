package com.extension.checker.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
public class Extension {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private boolean isChecked = false;
    private boolean isCustom = false;

    public void changeCheckedStatus(){
        if(isChecked){
            isChecked = false;
            return;
        }
        if(!isChecked) isChecked = true;
    }
    public void changeCustomStatus(){
        if(isCustom) {
            isCustom = false;
            return;
        }
        if(!isCustom) isCustom = true;
    }

    public boolean isChecked() {
        return isChecked;
    }
    public boolean isCustom() {
        return isCustom;
    }

}
