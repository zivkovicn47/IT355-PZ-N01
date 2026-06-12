package com.metropolitan.it355pz.service;

import com.metropolitan.it355pz.model.*;

import java.util.List;

public interface IAutomatizacijaService {

    // --- Projekat ---
    List<Projekat> getSveProjekte();
    Projekat getProjekatById(Long id);
    void sacuvajProjekat(Projekat p);
    void obrisiProjekat(Long id);

    // --- Komponenta ---
    List<Komponenta> getSveKomponente();
    Komponenta getKomponentaById(Long id);
    void sacuvajKomponentu(Komponenta k);
    void obrisiKomponentu(Long id);

    // --- Inzenjer ---
    List<Inzenjer> getSveInzenjere();
    Inzenjer getInzenjerById(Long id);
    void sacuvajInzenjer(Inzenjer i);
    void obrisiInzenjer(Long id);

    // --- Licenca ---
    List<Licenca> getSveLicence();
    Licenca getLicencaById(Long id);
    void sacuvajLicencu(Licenca l);
    void obrisiLicencu(Long id);

    // --- Zadatak ---
    List<Zadatak> getSveZadatke();
    Zadatak getZadatakById(Long id);
    void sacuvajZadatak(Zadatak z);
    void obrisiZadatak(Long id);
}
