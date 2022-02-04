package at.cb.kfzteile.service;

import at.cb.kfzteile.dao.DokumenteDao;
import at.cb.kfzteile.model.Dokument;

import java.util.List;
import java.util.Optional;

public class DokumenteService {
    public static int createDokumente(Dokument dokument){
        return DokumenteDao.createDokumente(dokument);
    }

    public static List<Dokument> getDokumenteByWarengruppeId(int warengruppeId){
        return DokumenteDao.getDokumenteByWarengruppeId(warengruppeId);
    }

    public static Optional<Dokument> getDokumentById(int id){
        return DokumenteDao.getDokumentById(id);
    }
}
