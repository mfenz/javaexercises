/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.service;

import at.cb.kontaktformular.dao.KontaktanfrageDAO;
import at.cb.kontaktformular.model.Kontaktanfrage;
import java.util.List;

/**
 *
 * @author mfenz
 */
public class KontaktformularService {
    public static int addKontaktanfrage(String name, String nachricht){
        return KontaktanfrageDAO.createKontaktanfrage(name, nachricht);
    }
    
    public static List<Kontaktanfrage> getKontaktanfragen(){
        return KontaktanfrageDAO.getKontaktanfragen();
    }
}
