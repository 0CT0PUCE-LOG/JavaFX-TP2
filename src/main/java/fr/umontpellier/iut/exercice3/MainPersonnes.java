package fr.umontpellier.iut.exercice3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList();

        unChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()){
                    if (change.wasAdded()) {
                        //si la personne ajouté est Pierre alors on affiche "Ajout de Pierre"
                        if (change.getAddedSubList().get(0).getNom().equals("Pierre"))
                            System.out.println("Ajout de Pierre");
                        else{
                            System.out.println("Ajout de " + change.getAddedSubList());
                        }
                    }
                    else if (change.wasRemoved()) {
                        //si la personne supprimé est Paul alors on affiche "Suppression de Paul"
                        if (change.getRemoved().get(0).getNom().equals("Paul"))
                            System.out.println("Suppression de Paul");
                        else{
                            System.out.println("Suppression de " + change.getRemoved());
                        }
                    }
                    else if (change.wasUpdated()) {
                        System.out.println("Mise à jour de " + change.getList());
                    }
                }
            }
        };

        lesPersonnes.addListener(unChangementListener);

        question3();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

