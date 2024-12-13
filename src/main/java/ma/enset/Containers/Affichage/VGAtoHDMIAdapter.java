package ma.enset.Containers.Affichage;


public class VGAtoHDMIAdapter implements Afficheur {
    private final AfficheurVGA afficheurVGA;

    public VGAtoHDMIAdapter(AfficheurVGA afficheurVGA) {
        this.afficheurVGA = afficheurVGA;
    }

    @Override
    public void afficher(String etat) {
        afficheurVGA.afficherVGA(etat);
    }
}