package com.example.pawansiwakoti.project2;

import java.io.Serializable;

public class Player  implements Serializable{
    public String getStnames() {
        return stnames;
    }

    public String getStmessage() {
        return stmessage;
    }

    public Player(String stnames, String stmessage) {

        this.stnames = stnames;
        this.stmessage = stmessage;
    }

    String stnames, stmessage;
}
