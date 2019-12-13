package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;
import java.util.HashSet;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<>();

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }
    public void ajoutTechnicienEquipe(Technicien technicien) {
        equipe.add(technicien);

    }

    @Override
    public Double getPrimeAnnuelle() {
        return getEquipe().size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN + Entreprise.primeAnnuelleBase();
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire((salaire * Entreprise.INDICE_MANAGER) + ((10d / 100d * salaire) * equipe.size()));
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }

    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        augmenterSalaireEquipe(pourcentage);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate date, Double salaire, Integer grade) {
        Technicien technicien = new Technicien(nom, prenom, matricule, date, salaire, grade);
        equipe.add(technicien);

    }
}
