
package ma.enset.Containers;

import ma.enset.Agent.Agent;
import ma.enset.Containers.Affichage.Afficheur;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private final Map<String, Agent> agents;

    private Container() {
        agents = new HashMap<>();
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void ajouterAgent(Agent agent) {
        agents.put(agent.getNom(), agent);
    }

    public void supprimerAgent(String nom) {
        agents.remove(nom);
    }

    public Agent rechercherAgent(String nom) {
        return agents.get(nom);
    }

    public void afficherEtat(Afficheur afficheur) {
        afficheur.afficher(agents.toString());
    }
}

