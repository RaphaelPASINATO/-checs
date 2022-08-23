package controleurs;
import classes.*;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
public class controleurEchec {

    Plateau lePlateau ;
    Piece[][] pieces;
    JPanel squares[][] = new JPanel[7][8];
    JLabel labels[][]= new JLabel[7][8];

    public controleurEchec(int nb, Plateau unPlateau) {
        if (nb == 1) {
            lePlateau = new Plateau(7,8);
            lePlateau.initPlateau();
            pieces = lePlateau.getLePlateau();
        }
        if (nb == 2) {
            lePlateau = unPlateau;
            Piece[][] p = unPlateau.getLePlateau();

            for (int i  =0;i < 7;i++) {
                for (int j = 0; j < 8; j++){
                    if ( p[i][j] != null)
                    {
                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == Pion.class) {
                            Pion PionBlanc = new Pion(1,"Pion blanc",1);
                            lePlateau.placerPiece(i, j, PionBlanc);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == Pion.class) {
                            Pion PionNoir = new Pion(2,"Pion noir",2);
                            lePlateau.placerPiece(i, j, PionNoir);
                        }
                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == Tour.class) {
                            Tour tourBlanche = new Tour(1,"Tour blanche",3);
                            lePlateau.placerPiece(i, j, tourBlanche);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == Tour.class) {
                            Tour tourNoire = new Tour(2,"Tour noire",4);
                            lePlateau.placerPiece(i, j, tourNoire);
                        }
                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == Cavalier.class) {
                            Cavalier cavalierBlanc = new Cavalier(1,"Cavalier blanc",5);
                            lePlateau.placerPiece(i, j, cavalierBlanc);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == Cavalier.class) {
                            Cavalier cavalierBlanc = new Cavalier(2,"Cavalier noir",6);
                            lePlateau.placerPiece(i, j, cavalierBlanc);
                        }
                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == fou.class) {
                            fou fouBlanc = new fou(1,"Fou blanc",7);
                            lePlateau.placerPiece(i, j, fouBlanc);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == fou.class) {
                            fou fouNoir = new fou(2,"Fou noir",8);
                            lePlateau.placerPiece(i, j, fouNoir);
                        }
                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == Reine.class) {
                            Reine reineBlanche = new Reine(1,"Reine blanche",9);
                            lePlateau.placerPiece(i, j, reineBlanche);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == Reine.class) {
                            Reine reineNoire = new Reine(2,"Reine noire",10);
                            lePlateau.placerPiece(i, j, reineNoire);
                        }

                        if (p[i][j].getCouleur() == 1 && p[i][j].getClass() == Roi.class) {
                            Roi RoiBlanc = new Roi(1,"Roi blanc",11);
                            lePlateau.placerPiece(i, j, RoiBlanc);
                        }
                        if (p[i][j].getCouleur() == 2 && p[i][j].getClass() == Roi.class) {
                            Roi RoiNoir = new Roi(2,"Roi noir",12);
                            lePlateau.placerPiece(i, j, RoiNoir);
                        }
                    }
                   
                   
                }
            }
            pieces = unPlateau.getLePlateau();
            setPlateau(unPlateau);
        }
      
    }

    public  Plateau getPlateau() {
        return lePlateau;
    }
    
    public void setPlateau (Plateau unPlateau) {
        lePlateau = unPlateau;
        pieces =unPlateau.getLePlateau();

    }
       


    public int verificationVictoireOuDefaite() {
        return lePlateau.verificationVictoireOuDefaite();
    }

    public int deplacerPiece(int xDepart, int yDepart, int xArrive, int yArrive) {
        int deplacementValide = lePlateau.dePLacerPiece(xDepart, yDepart, xArrive, yArrive);   
        pieces = lePlateau.getLePlateau();
        return deplacementValide;
    }

    public List<Integer> deplacementOrdinateur() {        
        return lePlateau.deplacementOrdinateur();
    }


    public int getIdPiece (int x, int y) {
        if (pieces[x][y] != null) {
            return pieces[x][y].getId();
        }
        else {
            return 0;
        }
    }

    public boolean promotionPion(int x, int y) {
        return lePlateau.pionPromotion(x, y);
    }

    public void promotion (int x, int y, int promotion) {
        lePlateau.promotion(x, y, promotion);
    }
    public void promotionNoire (int x, int y, int promotion) {
        lePlateau.promotionNoire(x, y, promotion);
    }


    public void  test(JFrame laFrame) {
        Component[] component = laFrame.getComponents();

        for(int i=0; i<component.length; i++)
        {
            if (component[i] instanceof JLabel)
            {  
                JLabel button = (JLabel)component[i];
                button.setBackground(Color.CYAN);
            }
    
        }
    }
}
