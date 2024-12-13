package ma.enset.Containers;

import ma.enset.Agent.Agent;
import ma.enset.Containers.Affichage.Afficheur;
import ma.enset.Containers.Affichage.AfficheurHDMI;

public class TestContainer {
    public static void main(String[] args) {
        // Créer des agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");

        // Obtenir l'instance du conteneur
        Container container = Container.getInstance();

        // Ajouter des agents au conteneur
        container.ajouterAgent(agent1);
        container.ajouterAgent(agent2);

        // Créer un afficheur HDMI
        Afficheur afficheurHDMI = new AfficheurHDMI();

        // Afficher l'état du conteneur
        container.afficherEtat(afficheurHDMI);
    }
}