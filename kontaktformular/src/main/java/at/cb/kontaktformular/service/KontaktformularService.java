/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.cb.kontaktformular.service;

import at.cb.kontaktformular.dao.KontaktanfrageDAO;
import at.cb.kontaktformular.model.Kontaktanfrage;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mfenz
 */
public class KontaktformularService {

    /**
     * Einfügen einer neuen Kontaktanfrage
     *
     * @param name
     * @param nachricht
     * @return
     */
    public static int addKontaktanfrage(String name, String nachricht) {
        return KontaktanfrageDAO.createKontaktanfrage(name, nachricht);
    }

    /**
     * Gibt alle Kontaktanfragen zurück
     *
     * @return
     */
    public static List<Kontaktanfrage> getKontaktanfragen() {
        return KontaktanfrageDAO.getKontaktanfragen();
    }

    /**
     * Lädt eine Kontaktanfrage anhand der ID
     *
     * @param id
     * @return
     */
    public static Optional<Kontaktanfrage> getKontaktanfrageById(int id) {
        return KontaktanfrageDAO.getKontaktanfrageById(id);
    }

    /**
     * Löscht eine Kontaktanfrage anhand der ID
     *
     * @param id
     * @return
     */
    public static boolean deleteKontaktanfrage(int id) {
        return KontaktanfrageDAO.deleteKontaktanfrageById(id);
    }

    /**
     * Bearbeitet den Inhalt einer Kontaktanfrage
     *
     * @param id
     * @param name
     * @param nachricht
     */
    public static void updateKontaktanfrage(int id, String name, String nachricht) {
        // zuerst die Kontaktanfrage anhand der ID aus der Datenbank laden
        Optional<Kontaktanfrage> optionalKontaktanfrage = getKontaktanfrageById(id);
        if (optionalKontaktanfrage.isPresent()) {
            
            // Objekt bearbeiten
            Kontaktanfrage kontaktanfrage = optionalKontaktanfrage.get();
            // ID nicht bearbeiten!

            kontaktanfrage.setNachricht(nachricht);
            kontaktanfrage.setName(name);

            // Objekt zum Speichern an DAO übergeben ...
            KontaktanfrageDAO.updateKontaktanfrage(kontaktanfrage);
        }
    }
}
