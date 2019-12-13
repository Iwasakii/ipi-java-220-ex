package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe {

    private Integer grade;

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public Double getPrimeAnnuelle() {
     return Entreprise.primeAnnuelleBase() + Entreprise.primeAnnuelleBase() * ((double) grade / 10) + (this.getNombreAnneeAnciennete() * Entreprise.PRIME_ANCIENNETE);

    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire + grade * 100);
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + getNombreAnneeAnciennete();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }
}
