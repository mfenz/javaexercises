/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.model;

/**
 *
 * @author BBRZ
 */
public class Kontaktanfrage {
    private int id;
    private String name;
    private String nachricht;

    public Kontaktanfrage(int id, String name, String nachricht) {
        this.id = id;
        this.name = name;
        this.nachricht = nachricht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }
    
}
