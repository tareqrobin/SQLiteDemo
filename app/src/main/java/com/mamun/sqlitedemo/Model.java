package com.mamun.sqlitedemo;

public class Model {
    String ID, NAME, AGE;

    public Model() {
    }

    public Model(String ID, String NAME, String AGE) {
        this.ID = ID;
        this.NAME = NAME;
        this.AGE = AGE;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public String getAGE() {
        return AGE;
    }
    public void setAGE(String AGE) {
        this.AGE = AGE;
    }
}
