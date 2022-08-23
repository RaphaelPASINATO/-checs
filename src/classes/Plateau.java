package classes;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.Random;

public class Plateau implements Serializable {

    private int longueur; //7
    private int largeur; //8
    private Piece[][] lePLateau;


    public Plateau (int laLongueur, int laLargeur) {
        lePLateau=new Piece[laLongueur][laLargeur];
        longueur = longueur;
        largeur = laLargeur;

      
    }

    public void  initPlateau() {
        Tour TourBlancheUne = new Tour(1,"Tour blanche", 3);
        Cavalier CavalierBlancUn = new Cavalier(1,"Cavalier blanc",5);
        fou fouBlancUn = new fou(1, "Fou blanc",7);
        Reine ReineBlanche = new Reine(1,"Reine blanche",9);
        Roi RoiBlanc = new Roi(1,"Roi blanc",11);
        fou fouBlancDeux = new fou(1, "Fou blanc",7);
        Cavalier CavalierBlancDeux = new Cavalier(1,"Cavalier blanc",5);
        Tour TourBlancheDeux = new Tour(1,"Tour blanche",3);

        Pion PionBlancUn = new Pion(1,"Pion blanc",1);
        Pion PionBlancDeux = new Pion(1,"Pion blanc",1);
        Pion PionBlancTrois = new Pion(1,"Pion blanc",1);
        Pion PionBlancQuatre = new Pion(1,"Pion blanc",1);
        Pion PionBlancCinq = new Pion(1,"Pion blanc",1);
        Pion PionBlancSix = new Pion(1,"Pion blanc",1);
        Pion PionBlancSept = new Pion(1,"Pion blanc",1);
        Pion PionBlancHuit = new Pion(1,"Pion blanc",1);



        Tour TourNoireUne = new Tour(2,"Tour noire",4);
        Cavalier CavalierNoirUn = new Cavalier(2,"Cavalier noir",6);
        fou fouNoirUn = new fou(2, "Fou noir",8);
        Reine ReineNoire = new Reine(2,"Reine noire",10);
        Roi RoiNoir = new Roi(2,"Roi noir",12);
        fou fouNoirDeux = new fou(2, "Fou noir",8);
        Cavalier CavalierNoirDeux = new Cavalier(2,"Cavalier noir",6);
        Tour TourNoireDeux = new Tour(2,"Tour noire",4);

        Pion PionNoirUn = new Pion(2,"Pion noir",2);
        Pion PionNoirDeux = new Pion(2,"Pion noir",2);
        Pion PionNoirTrois = new Pion(2,"Pion noir",2);
        Pion PionNoirQuatre = new Pion(2,"Pion noir",2);
        Pion PionNoirCinq = new Pion(2,"Pion noir",2);
        Pion PionNoirSix = new Pion(2,"Pion noir",2);
        Pion PionNoirSept = new Pion(2,"Pion noir",2);
        Pion PionNoirHuit = new Pion(2,"Pion noir",2);
        //placement des pièces blanches
        placerPiece(6, 0, TourBlancheUne);
        placerPiece(6, 1, CavalierBlancUn);
        placerPiece(6, 2, fouBlancDeux);
        placerPiece(6, 3, ReineBlanche);
        placerPiece(6, 4, RoiBlanc);
        placerPiece(6, 5, fouBlancUn);
        placerPiece(6, 6, CavalierBlancDeux);
        placerPiece(6, 7, TourBlancheDeux);
        //placements des pions blans
        placerPiece(5, 0, PionBlancUn);
        placerPiece(5, 1, PionBlancDeux);
        placerPiece(5, 2, PionBlancTrois);
        placerPiece(5, 3, PionBlancQuatre);
        placerPiece(5, 4, PionBlancCinq);
        placerPiece(5, 5, PionBlancSix);
        placerPiece(5, 6, PionBlancSept);
        placerPiece(5, 7, PionBlancHuit);


        //placement des pièces noires
        placerPiece(0, 0, TourNoireUne);
        placerPiece(0, 1, CavalierNoirUn);
        placerPiece(0, 2, fouNoirUn);
        placerPiece(0, 3, ReineNoire);
        placerPiece(0, 4, RoiNoir);
        placerPiece(0, 5, fouNoirDeux);
        placerPiece(0, 6, CavalierNoirDeux);
        placerPiece(0,7, TourNoireDeux);
        //placement des pions noirs
        placerPiece(1, 0, PionNoirUn);
        placerPiece(1, 1, PionNoirDeux);
        placerPiece(1, 2, PionNoirTrois);
        placerPiece(1, 3, PionNoirQuatre);
        placerPiece(1, 4, PionNoirCinq);
        placerPiece(1, 5, PionNoirSix);
        placerPiece(1, 6, PionNoirSept);
        placerPiece(1, 7, PionNoirHuit);

    }

     

    public void placerPiece(int x, int y, Piece laPiece ) {
        lePLateau[x][y] = laPiece;

    }

    public Piece[][] getLePlateau() {
        return lePLateau;
    }

    public void setLesPieces ( Piece[][] piecesNouvelles){
        lePLateau =piecesNouvelles;
    }

    public Piece getPiece (int x, int y) {
        if (lePLateau[x][y] == null) {
            return null;
        }
        else {
            return  lePLateau[x][y];
        }
       
    }

    public int getPieceId (int x, int y) {
        if (lePLateau[x][y] == null) {
            return 0;
        }
        else {
            return  lePLateau[x][y].getId();
        }
       
    }

    public void enleverPiece (int x, int y) {
        lePLateau[x][y] = null;
    }

    public Boolean caseVide (int x,int y) {
        if (lePLateau[x][y] == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public int estDansLeTableau (int x,int y) {
        if ( x >= 0 && x <= 6 && y >= 0 && y <= 7) {
            return 1;
        }
        else {
            return 2;
        }

      
    } 
    

    public int verificationVictoireOuDefaite () {
        int roiBlancVivant = 0;
        int roiNoirVivant = 0;
        for (int i  =0;i < 7;i++)
        {
            for (int j = 0; j < 8; j++){
                if ( lePLateau[i][j] != null)
                {
                    if (lePLateau[i][j].getNom() == "Roi noir") {
                        roiNoirVivant = 1;
                    }
                    if (lePLateau[i][j].getNom() == "Roi blanc") {
                        roiBlancVivant = 1;
                    }
            
                    
                }
               
            }
        }
        if (roiBlancVivant == 0) {
            return 1;
        }
        if (roiNoirVivant == 0) {
            return 2;
        }
        return 0;
    }

    public int dePLacerPiece (int xDepart, int yDepart, int xArrive, int yArrive ) {
        if (getPiece(xDepart, yDepart) != null) {
            if (xDepart == xArrive && yDepart == yArrive ) {
                //case de départ ciblée
                return 2;
            }
            if (getPiece(xDepart, yDepart).getCouleur() == 1) {
                if(deplacement(xDepart, yDepart, xArrive, yArrive) == 1) {
                     //deplacement valide
                    if (caseVide(xArrive, yArrive) == true) {
                        placerPiece(xArrive,yArrive,getPiece(xDepart, yDepart));
                        enleverPiece(xDepart, yDepart);
                    }
                    else {
                        enleverPiece(xArrive, yArrive);
                        placerPiece(xArrive,yArrive,getPiece(xDepart, yDepart));
                        enleverPiece(xDepart, yDepart);
            
                    }
                    return 1;
                }
               
            }
            else {
                //piece noire ciblée
                return 2;
                }
                
           
        }
         //case vide ciblée
        return 2;
        
    }


    public int deplacement(int xDepart, int yDepart, int xArrive, int yArrive) {
        if (getPiece(xDepart, yDepart).getNom() == "Pion blanc") {
            if ( getPiece(xArrive, yArrive) == null && xDepart == xArrive+1 &&  yDepart == yArrive) {
                return 1;
            }
            if (xDepart == xArrive+1 &&  yDepart == yArrive+1 && getPiece(xArrive, yArrive) != null || xDepart == xArrive+1 &&  yDepart == yArrive-1 && getPiece(xArrive, yArrive) != null) {
                if (getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Tour blanche") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
            }
            if (xArrive != xDepart && yArrive == yDepart) {
                if ( xArrive < xDepart) {
                    for (int i = xArrive+1; i < xDepart;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                if ( xArrive > xDepart) {
                    for (int i = xDepart+1; i < xArrive;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            if (xArrive == xDepart && yArrive != yDepart) {
                 if ( yArrive < yDepart) {
                    for (int i = yArrive+1; i < yDepart;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                if ( yArrive > yDepart) {
                    for (int i = yDepart+1; i < yArrive;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
             return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Roi blanc") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
            }
            if (  xDepart == xArrive+1 &&  yDepart == yArrive ||xDepart == xArrive-1 &&  yDepart == yArrive ||xDepart == xArrive &&  yDepart == yArrive+1 ||xDepart == xArrive &&  yDepart == yArrive-1 ) {
                return 1; 
            }
            if (xDepart == xArrive+1 &&  yDepart == yArrive+1 || xDepart == xArrive+1 &&  yDepart == yArrive-1 || xDepart == xArrive-1 &&  yDepart == yArrive+1 || xDepart == xArrive-1 &&  yDepart == yArrive-1)  {
                return 1;
            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Fou blanc") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
            }
            int x = xDepart;
            int y = yDepart;
            if ( xArrive < xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                   
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y++;

                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                 
                }

            }
            x = xDepart;
            y = yDepart;
            if ( xArrive < xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y++;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                    
                }

            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Reine blanche") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
            }
            if (xArrive != xDepart && yArrive == yDepart) {
                if ( xArrive < xDepart) {
                    for (int i = xArrive+1; i < xDepart;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                if ( xArrive > xDepart) {
                    for (int i = xDepart+1; i < xArrive;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            if (xArrive == xDepart && yArrive != yDepart) {
                 if ( yArrive < yDepart) {
                    for (int i = yArrive+1; i < yDepart;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                if ( yArrive > yDepart) {
                    for (int i = yDepart+1; i < yArrive;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            int x = xDepart;
            int y = yDepart;
            if ( xArrive < xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                   
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y++;

                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                 
                }

            }
            x = xDepart;
            y = yDepart;
            if ( xArrive < xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y++;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 1 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                    
                }

            }
             return 2;

        }
        if (getPiece(xDepart, yDepart).getNom() == "Cavalier blanc") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 1) {
                    return 2;
                }
            }
            // deux vers le haut et un à droite
            if ( xDepart == xArrive+2 &&  yDepart == yArrive-1) {
                return 1;
            }
            // deux vers le haut et un à gauche
            if ( xDepart == xArrive+2 &&  yDepart == yArrive+1) {
                return 1;
            }
            // un vers le haut et deux à droite
            if ( xDepart == xArrive+1 &&  yDepart == yArrive-2) {
                return 1;
            }
             // un vers le haut et deux à gauche
             if ( xDepart == xArrive+1 &&  yDepart == yArrive+2) {
                return 1;
            }
             // deux vers le bas et un à droite
             if ( xDepart == xArrive-2 &&  yDepart == yArrive-1) {
                return 1;
            }
              // deux vers le bas et un à gauche
              if ( xDepart == xArrive-2 &&  yDepart == yArrive+1) {
                return 1;
            }
              // un vers le bas et deux à droite
              if ( xDepart == xArrive-1 &&  yDepart == yArrive-2) {
                return 1;
            }
              // un vers le bas et deux à gauche
              if ( xDepart == xArrive-1 &&  yDepart == yArrive+2) {
                return 1;
            }
            return 2;
        }
            
       return 2;
        
       
    }
    public List<Integer> deplacementOrdinateur() {
        boolean pieceTrouve = false;
        boolean deplacementTrouvee = false;
        int xDepart = 0;
        int yDepart = 0;
        int xArrive = 0;
        int yArrive = 0;
        int deplacementPiece;
        Random rand = new Random();
        Piece laPieceTrouvee = null;
     
       int scorePoint = -1;
       int xDepartFinal = 0;
       int yDepartFinal = 0;
       int xArriveFinal = 0;
       int yArriveFinal = 0;
       boolean pieceMange = false;
       while (deplacementTrouvee == false) {
           
       
        for (int i  =0;i < 7;i++) {
            for (int j = 0; j < 8; j++){

                pieceTrouve = false;
                xDepart =i;
                yDepart = j;
                if (getPiece(xDepart, yDepart) != null) {
                    if (getPiece(xDepart, yDepart).getCouleur() == 2) {
                        pieceTrouve = true;
                    
                    }
                }

                if ( pieceTrouve == true) {
                    for (int k  =0;k < 7;k++) {
                        for (int l = 0; l < 8; l++){
                            xArrive = k;
                            yArrive = l;
                            deplacementPiece = dePLacerPieceOrdinateur(xDepart,yDepart, xArrive, yArrive);
                            if(deplacementPiece == 1) {
                                int leScore= getPieceId(xArrive, yArrive);
        
                                if (leScore >= scorePoint && leScore == 0) { 
                                    scorePoint = leScore;
                                    xDepartFinal = xDepart;
                                    yDepartFinal = yDepart;
                                    xArriveFinal = xArrive;
                                    yArriveFinal = yArrive;
                                }
                                else {
                                    if (leScore == 13) {
                                        scorePoint = 500;
                                        xDepartFinal = xDepart;
                                        yDepartFinal = yDepart;
                                        xArriveFinal = xArrive;
                                        yArriveFinal = yArrive;
                                    }
                                    else {
                                        if (leScore - (getPieceId(xDepartFinal, yDepartFinal)-1)  >= scorePoint ) {
                                            scorePoint = leScore;
                                            xDepartFinal = xDepart;
                                            yDepartFinal = yDepart;
                                            xArriveFinal = xArrive;
                                            yArriveFinal = yArrive;
                                            pieceMange = true;
                                        }
                                    }
                                    
                                  
                                }
        
                           
                                deplacementTrouvee = true;
                            }
                            

                        }
                    }
                }
    


            }
        }

       /* for (int p = 0; p  < 100; p++) {
            pieceTrouve = false;
            xDepart = rand.nextInt(7);
            yDepart = rand.nextInt(8);
            if (getPiece(xDepart, yDepart) != null) {
                if (getPiece(xDepart, yDepart).getCouleur() == 2) {
                    pieceTrouve = true;
                
                }
            }

            if ( pieceTrouve == true) {
                for (int i =0; i <300; i++) {
                    xArrive = rand.nextInt(7);
                    yArrive = rand.nextInt(8);
                    deplacementPiece = dePLacerPieceOrdinateur(xDepart,yDepart, xArrive, yArrive);
                    if(deplacementPiece == 1) {                        int leScore= getPieceId(xArrive, yArrive);

                        if (leScore >= scorePoint && leScore == 0) { 
                            scorePoint = leScore;
                            xDepartFinal = xDepart;
                            yDepartFinal = yDepart;
                            xArriveFinal = xArrive;
                            yArriveFinal = yArrive;
                        }
                        else {
                            if (leScore == 13) {
                                scorePoint = 500;
                                xDepartFinal = xDepart;
                                yDepartFinal = yDepart;
                                xArriveFinal = xArrive;
                                yArriveFinal = yArrive;
                            }
                            else {
                                if (leScore - (getPieceId(xDepartFinal, yDepartFinal)-1)  >= scorePoint ) {
                                    scorePoint = leScore;
                                    xDepartFinal = xDepart;
                                    yDepartFinal = yDepart;
                                    xArriveFinal = xArrive;
                                    yArriveFinal = yArrive;
                                }
                            }
                            
                          
                        }

                   
                        deplacementTrouvee = true;
                    }
                }
            }
       }*/
       }
       if (scorePoint == 0 && pieceMange == false) {
        deplacementTrouvee = false;
        while (deplacementTrouvee == false) {
            for (int p = 0; p  < 100; p++) {
                pieceTrouve = false;
                xDepart = rand.nextInt(7);
                yDepart = rand.nextInt(8);
                if (getPiece(xDepart, yDepart) != null) {
                    if (getPiece(xDepart, yDepart).getCouleur() == 2) {
                        pieceTrouve = true;
                    
                    }
                }
    
                if ( pieceTrouve == true) {
                    for (int i =0; i <300; i++) {
                        xArrive = rand.nextInt(7);
                        yArrive = rand.nextInt(8);
                        deplacementPiece = dePLacerPieceOrdinateur(xDepart,yDepart, xArrive, yArrive);
                        if(deplacementPiece == 1) {
                            int leScore= getPieceId(xArrive, yArrive);
    
                            if (leScore >= scorePoint && leScore == 0) { 
                                scorePoint = leScore;
                                xDepartFinal = xDepart;
                                yDepartFinal = yDepart;
                                xArriveFinal = xArrive;
                                yArriveFinal = yArrive;
                            }
                            else {
                                if (leScore == 13) {
                                    scorePoint = 500;
                                    xDepartFinal = xDepart;
                                    yDepartFinal = yDepart;
                                    xArriveFinal = xArrive;
                                    yArriveFinal = yArrive;
                                }
                                else {
                                    if (leScore - (getPieceId(xDepartFinal, yDepartFinal)-1)  >= scorePoint ) {
                                        scorePoint = leScore;
                                        xDepartFinal = xDepart;
                                        yDepartFinal = yDepart;
                                        xArriveFinal = xArrive;
                                        yArriveFinal = yArrive;
                                    }
                                }
                                
                              
                            }
    
                       
                            deplacementTrouvee = true;
                        }
                    }
                }
           }

        }
       }

        List<Integer> listDeplacement = new ArrayList<Integer>();
        listDeplacement.add(xDepartFinal);
        listDeplacement.add(yDepartFinal);
        listDeplacement.add(xArriveFinal);
        listDeplacement.add(yArriveFinal);
        placerPiece(listDeplacement.get(2),listDeplacement.get(3),getPiece(listDeplacement.get(0), listDeplacement.get(1)));
        enleverPiece(listDeplacement.get(0), listDeplacement.get(1));
        return listDeplacement;
    }

    public int dePLacerPieceOrdinateur (int xDepart, int yDepart, int xArrive, int yArrive ) {
        if (getPiece(xDepart, yDepart).getNom() == "Pion noir") {
            if ( getPiece(xArrive, yArrive) == null && xDepart == xArrive-1 &&  yDepart == yArrive) {
                return 1;
            }
            if (xDepart == xArrive-1 &&  yDepart == yArrive+1 && getPiece(xArrive, yArrive) != null || xDepart == xArrive-1 &&  yDepart == yArrive-1 && getPiece(xArrive, yArrive) != null) {
                if (getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Tour noire") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
            }
            if (xArrive != xDepart && yArrive == yDepart) {
                if ( xArrive < xDepart) {
                    for (int i = xArrive+1; i < xDepart;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                if ( xArrive > xDepart) {
                    for (int i = xDepart+1; i < xArrive;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            if (xArrive == xDepart && yArrive != yDepart) {
                 if ( yArrive < yDepart) {
                    for (int i = yArrive+1; i < yDepart;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                if ( yArrive > yDepart) {
                    for (int i = yDepart+1; i < yArrive;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
             return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Fou noir") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
            }
            int x = xDepart;
            int y = yDepart;
            if ( xArrive < xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                   
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y++;

                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                 
                }

            }
            x = xDepart;
            y = yDepart;
            if ( xArrive < xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y++;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                    
                }

            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Reine noire") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
            }
            if (xArrive != xDepart && yArrive == yDepart) {
                if ( xArrive < xDepart) {
                    for (int i = xArrive+1; i < xDepart;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                if ( xArrive > xDepart) {
                    for (int i = xDepart+1; i < xArrive;i++) {
                        if (getPiece(i, yDepart) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            if (xArrive == xDepart && yArrive != yDepart) {
                 if ( yArrive < yDepart) {
                    for (int i = yArrive+1; i < yDepart;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                if ( yArrive > yDepart) {
                    for (int i = yDepart+1; i < yArrive;i++) {
                        if (getPiece(xDepart, i) != null){
                            return 2;
                        }
                    }
                }
                return 1;
            }
            int x = xDepart;
            int y = yDepart;
            if ( xArrive < xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                   
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y++;

                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
                }
            }
            x = xDepart;
            y = yDepart;
            if ( xArrive > xDepart && yArrive < yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x++;
                    y--;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                 
                }

            }
            x = xDepart;
            y = yDepart;
            if ( xArrive < xDepart && yArrive > yDepart) {
                for (int i =0; i < 7; i++ ) {
                    x--;
                    y++;
                    if (estDansLeTableau(x, y) == 1) {
                        if (getPiece(x,  y) != null && x != xArrive &&  y != yArrive) {
                            return 2 ;
                         }
                        if (x == xArrive &&  y == yArrive) {
                            if (getPiece(x,  y) != null) {
                                if(getPiece(x,  y).getCouleur() == 2 ) {
                                    return 2;
                                }
                                else {
                                    return 1;
                                }
                            }
                            else {
                                return 1;
                            }

                            
                        }
                    }
    
                    
                }

            }
             return 2;

        }
        if (getPiece(xDepart, yDepart).getNom() == "Cavalier noir") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
            }
            // deux vers le haut et un à droite
            if ( xDepart == xArrive+2 &&  yDepart == yArrive-1) {
                return 1;
            }
            // deux vers le haut et un à gauche
            if ( xDepart == xArrive+2 &&  yDepart == yArrive+1) {
                return 1;
            }
            // un vers le haut et deux à droite
            if ( xDepart == xArrive+1 &&  yDepart == yArrive-2) {
                return 1;
            }
             // un vers le haut et deux à gauche
             if ( xDepart == xArrive+1 &&  yDepart == yArrive+2) {
                return 1;
            }
             // deux vers le bas et un à droite
             if ( xDepart == xArrive-2 &&  yDepart == yArrive-1) {
                return 1;
            }
              // deux vers le bas et un à gauche
              if ( xDepart == xArrive-2 &&  yDepart == yArrive+1) {
                return 1;
            }
              // un vers le bas et deux à droite
              if ( xDepart == xArrive-1 &&  yDepart == yArrive-2) {
                return 1;
            }
              // un vers le bas et deux à gauche
              if ( xDepart == xArrive-1 &&  yDepart == yArrive+2) {
                return 1;
            }
            return 2;
        }
        if (getPiece(xDepart, yDepart).getNom() == "Roi noir") {
            if (getPiece(xArrive, yArrive) != null) {
                if(getPiece(xArrive, yArrive).getCouleur() == 2) {
                    return 2;
                }
            }
            if (  xDepart == xArrive+1 &&  yDepart == yArrive ||xDepart == xArrive-1 &&  yDepart == yArrive ||xDepart == xArrive &&  yDepart == yArrive+1 ||xDepart == xArrive &&  yDepart == yArrive-1 ) {
                return 1; 
            }
            if (xDepart == xArrive+1 &&  yDepart == yArrive+1 || xDepart == xArrive+1 &&  yDepart == yArrive-1 || xDepart == xArrive-1 &&  yDepart == yArrive+1 || xDepart == xArrive-1 &&  yDepart == yArrive-1)  {
                return 1;
            }
            return 2;
        }
            
        return 2;
    }

    public boolean pionPromotion(int x, int y) {
        if (getPiece(0, y) !=  null) {
            if(getPiece(0, y).getNom() == "Pion blanc") {
                return true;
            }
        }
        if (getPiece(6, y) !=  null) {
            if(getPiece(6, y).getNom() == "Pion noir") {
                return true;
            }
        }
        return false;
    }

    public void promotion (int x, int y, int promotion) {
        if (promotion == 1) {
            Reine ReineBlanche = new Reine(1,"Reine blanche",9);
            placerPiece(x, y, ReineBlanche);
        }
        if (promotion == 2) {
            Tour TourBlanche = new Tour(1,"Tour blanche", 3);
            placerPiece(x, y, TourBlanche);
        }
        if (promotion == 3) {
            Cavalier CavalierBlanc = new Cavalier(1,"Cavalier blanc",5);
            placerPiece(x, y, CavalierBlanc);
        }
        if (promotion == 4) {
            fou fouBlanc = new fou(1, "Fou blanc",7);
            placerPiece(x, y, fouBlanc);
        }  
        
        
    }
    public void promotionNoire (int x, int y, int promotion) {
        if (promotion == 1) {
            Reine ReineNoire = new Reine(2,"Reine noire",10);
            placerPiece(x, y, ReineNoire);
        }
        if (promotion == 2) {
            Tour TourNoire = new Tour(2,"Tour noire",4);
            placerPiece(x, y, TourNoire);
        }
        if (promotion == 3) {
            Cavalier CavalierNoir = new Cavalier(2,"Cavalier noir",6);
            placerPiece(x, y, CavalierNoir);
        }
        if (promotion == 4) {
            fou fouNoir = new fou(2, "Fou noir",8);
            placerPiece(x, y, fouNoir);
        }  
        
        
    }


    







    
}
