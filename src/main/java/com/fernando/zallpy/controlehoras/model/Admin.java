package com.fernando.zallpy.controlehoras.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
        this.setAdmin(true);
    }





}
