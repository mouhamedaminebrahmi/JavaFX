/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Creneau;
import java.util.List;

/**
 *
 * @author Meedoch
 */
public interface CreneauServiceInterface {

    public void ajouterCreneau(Creneau c, Integer id);

    public void supprimerCreneauxEvenement(Integer id);

    public List<Creneau> getPlanningByEvent(Integer id);
}
