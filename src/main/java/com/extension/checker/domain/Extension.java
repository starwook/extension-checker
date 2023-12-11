package com.extension.checker.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@Builder
public class Extension {
    @Id
    private Long id;
    private String name;
    private boolean isChecked = false;
    private boolean isCustom = false;
    public Extension() {

    }
    public void changeCheckedStatus(){
        if(isChecked) isChecked =false;
        if(!isChecked) isChecked = true;
    }
    public void changeCustomStatus(){
        if(isCustom) isCustom = false;
        if(!isCustom) isCustom = true;
    }

    public boolean isChecked() {
        return isChecked;
    }
    public boolean isCustom() {
        return isCustom;
    }

}
