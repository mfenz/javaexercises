package service;

import java.io.File;

public interface PersistenceService {
    void save(String text, File file);
}
