package ma.enset.Containers.Affichage;

public class AfficheurHDMI implements Afficheur {
    @Override
    public void afficher(String etat) {
        System.out.println("Affichage via HDMI: " + etat);
    }
}
