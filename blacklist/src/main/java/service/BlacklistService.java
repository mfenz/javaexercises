package service;

import java.util.List;

public interface BlacklistService {
    // Fügt Namen zur Blacklist hinzu
    public void addNames(List<String> names);

    // Gibt  alle Blacklist-Namen zurück
    public List<String> getNames();

    // Löscht die angegebenen Namen aus der Blacklist
    public void removeNames(List<String> names);
}
