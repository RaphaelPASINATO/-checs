package vues;
import controleurs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import javax.swing.JFrame;
import javax.swing.JPanel;
import classes.Plateau;
import java.util.Random;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Thread;

public class MainFrame extends JFrame {

    JFrame laFenetre = this;
    JPanel squares[][] = new JPanel[7][8];
    JLabel labels[][]= new JLabel[7][8];
    Icon iconeSelec;
    boolean res = false;
    JLabel pieceSelec;
    controleurEchec  leControleur;
    int xOrigine;
    int yOrigine;
    int xArrive;
    int yArrive;
    Timer timer;
    TimerTask task;
    vueFinDePartie  vueVictoire = new vueFinDePartie();
    vuePromotion vuePromotion = new vuePromotion();
    JLabel tempsRestant=new JLabel("Temps restant");
    JLabel tempsRestantCompteur=new JLabel(":");
    boolean tempsres = true;
    int fileExiste = 2;
    Thread threadPrincipal;

    public void run() {

    }

    public static  void main(String[] args) throws Exception {
       
 



        MainFrame myFrame = new MainFrame();
        

        myFrame.init(1);
        
      
       
    }

   

    public void CloseFrame(){
        super.dispose();
    }

    public void temps () {
        if (timer != null) {
            timer.cancel();
        }
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int compteur = 180;
            public void run() {
                if ( compteur / 60> 0) {
                    tempsRestantCompteur.setText(compteur / 60 + " min "+ compteur % 60 +" s");
                }
                else {
                    tempsRestantCompteur.setText( compteur % 60 +" s");
                }
               
                compteur--;

                if (compteur < 1) {
                    timer.cancel();
                    try {
                        laFenetre.dispose();
                        initVictoire("Partie perdue, plus de temps.",laFenetre);
                     }
                     catch (IOException ioe)
                     {
                        throw new RuntimeException(ioe);
                     }
                }
            }
            
        public void initVictoire(String text, JFrame fenetre)throws IOException  {
            vueVictoire.init(text, fenetre);
        }
        }, 0, 1000);
    }

    public void seria() {
        try{
            File file = new File("plateauSauve");
            Plateau lePlateau = null;
            if(!file.exists() || fileExiste == 3){
                lePlateau = new Plateau(7, 8);
                FileOutputStream fos = new FileOutputStream("plateauSauve");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lePlateau);
                fileExiste = 1;
                leControleur = new controleurEchec(1,null);
            }
            FileInputStream fis = new FileInputStream("plateauSauve");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lePlateau = (Plateau) ois.readObject();  
            if ( fileExiste != 1) {
                leControleur = new controleurEchec(2,lePlateau);
            }	
            ois.close();
            } catch (IOException ioe) {
                System.out.println(" erreur :" + ioe.toString());
            } catch(ClassNotFoundException ioe){
                System.out.println("Erreur au niveau de la classe : " + ioe.toString());
            }
        



            addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                try {
                	Plateau lePlateau = leControleur.getPlateau();
                	FileOutputStream fos = new FileOutputStream("plateauSauve");
                	ObjectOutputStream oos = new ObjectOutputStream(fos);
                	oos.writeObject(lePlateau);
                	oos.close();               	
                } catch (IOException ioe) {
                	System.out.println(" erreur :" + ioe.toString());
                }
            }
          } );

    }

    public void init(int nb)throws IOException  {
        if (nb == 3) {
            fileExiste =3;
        }
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        seria();
        
        PanelListener listener = new PanelListener();
        setTitle("Echec");
        setSize(700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(8,8));
        for ( int i = 0; i < 7;i++) {
            for (int j = 0; j  < 8; j++){
                squares[i][j] = new JPanel();
                squares[i][j].setSize(73,70);
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.gray);
                    squares[i][j].addMouseListener(listener);
                } else {
                    squares[i][j].setBackground(Color.white);
                    squares[i][j].addMouseListener(listener);
                }

                add(squares[i][j]);
            }
        }
        for (int j = 0; j  < 8; j++){

            JPanel panelTimer = new JPanel();
            panelTimer.setBackground(Color.LIGHT_GRAY);
            add(panelTimer);
            if (j == 3) {
                panelTimer.add(tempsRestant);
            }
            if (j == 4) {
                panelTimer.add(tempsRestantCompteur);
            }
        }
        
        temps();
        if (fileExiste != 2) {
            MainFrame.class.getResource("/cavalierNoir.jpg");
            labels[0][0]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourNoire.png")));
            squares[0][0].add(labels[0][0]);

            labels[0][1]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierNoir.png")));
            squares[0][1].add(labels[0][1]);
    
            labels[0][2]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouNoir.png")));
            squares[0][2].add(labels[0][2]);
    
            labels[0][3]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/reineNoire.png")));
            squares[0][3].add(labels[0][3]);
    
            labels[0][4]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/roiNoir.png")));
            squares[0][4].add(labels[0][4]);
    
            labels[0][5]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouNoir.png")));
            squares[0][5].add(labels[0][5]);
    
            labels[0][6]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierNoir.png")));
            squares[0][6].add(labels[0][6]);
    
            labels[0][7]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourNoire.png")));
            squares[0][7].add(labels[0][7]);
    
            for (int j = 0; j  < 8; j++){
                labels[1][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/pionNoir.png")));
                squares[1][j].add(labels[1][j]);
            }
    
            labels[6][0]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourBlanche.png")));
            squares[6][0].add(labels[6][0]);
    
            labels[6][1]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierBlanc.png")));
            squares[6][1].add(labels[6][1]);
    
            labels[6][2]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouBlanc.png")));
            squares[6][2].add(labels[6][2]);
    
            labels[6][3]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/reineBlanche.png")));
            squares[6][3].add(labels[6][3]);
    
            labels[6][4]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/roiBlanc.png")));
            squares[6][4].add(labels[6][4]);
    
            labels[6][5]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouBlanc.png")));
            squares[6][5].add(labels[6][5]);
    
            labels[6][6]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierBlanc.png")));
            squares[6][6].add(labels[6][6]);
    
            labels[6][7]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourBlanche.png")));
            squares[6][7].add(labels[6][7]);
    
            for (int j = 0; j  < 8; j++){
                labels[5][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/pionBlanc.png")));
                squares[5][j].add(labels[5][j]);
            }
    
            for (int i = 2; i  < 5; i++){
                for (int j = 0; j  < 8; j++){
                    labels[i][j]= new JLabel(new ImageIcon(""));
                    squares[i][j].add(labels[i][j]);
                }
            }
        }
        else {
            for (int i  =0;i < 7;i++) {
                for (int j = 0; j < 8; j++){
                    if (leControleur.getIdPiece(i, j) == 0) {
                        labels[i][j]= new JLabel(new ImageIcon(""));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 1) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/pionBlanc.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 2) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/pionNoir.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 3) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourBlanche.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 4) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/tourNoire.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 5) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierBlanc.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 6) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/cavalierNoir.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 7) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouBlanc.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 8) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/fouNoir.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 9) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/reineBlanche.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 10) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/reineNoire.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 11) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/roiBlanc.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                    if (leControleur.getIdPiece(i, j) == 12) {
                        labels[i][j]= new JLabel(new ImageIcon(MainFrame.class.getResource("../images/roiNoir.png")));
                        squares[i][j].add(labels[i][j]);
                    }
                }
            }
        }
     
        

        setVisible(true);
    }
    private class PanelListener implements MouseListener {
       

        public void initVictoire(String text, JFrame fenetre)throws IOException  {
            vueVictoire.init(text, fenetre);
        }

        public void initPromotion()throws IOException  {
            vuePromotion.initPromotion();
        }

        

        @Override
        public void mouseClicked(MouseEvent event) {
            int victoire;
            Object source = event.getSource();
            JPanel panelPressed = (JPanel) source;
            if(source instanceof JPanel){
                for ( int i = 0; i < 7;i++) {
                    for (int j = 0; j  < 8; j++){
                        if (panelPressed == squares[i][j]){
                            if (res == false) {
                                xOrigine = i;
                                yOrigine = j;
                                squares[i][j].setBackground(Color.blue);
                            }
                            else {
                                xArrive = i;
                                yArrive = j;
                                if ((xOrigine + yOrigine) % 2 == 0) {
                                    squares[xOrigine][yOrigine].setBackground(Color.gray);
                                }
                                else {
                                    squares[xOrigine][yOrigine].setBackground(Color.white);
                                }
                            }
                        }
                    }
                }
                if ( res == false) {
                    iconeSelec = labels[xOrigine][yOrigine].getIcon();
                    pieceSelec = labels[xOrigine][yOrigine];
                    res = true;
                }
                else {
                    if (leControleur.deplacerPiece(xOrigine,yOrigine,xArrive,yArrive) == 1) {
                        temps();
                        labels[xArrive][yArrive].setIcon(iconeSelec);
                        pieceSelec.setIcon((new ImageIcon("")));
                        victoire = leControleur.verificationVictoireOuDefaite();
                        if (victoire == 2){
                            try {
                                laFenetre.dispose();
                                initVictoire("Partie gagnée",laFenetre);
                             }
                             catch (IOException ioe)
                             {
                                throw new RuntimeException(ioe);
                             }
                        }
                        boolean promo = false;
                        promo = leControleur.promotionPion(xArrive, yArrive);
                        if (promo == true) {
                            /*try {
                                initPromotion();
                             }
                             catch (IOException ioe)
                             {
                                throw new RuntimeException(ioe);
                             }*/
                             Random rand = new Random();
                            int laPromotion = 1+rand.nextInt(4);
                            leControleur.promotion(xArrive, yArrive, laPromotion);
                            if (laPromotion == 1) {
                                labels[xArrive][yArrive].setIcon((new ImageIcon(MainFrame.class.getResource("../images/reineBlanche.png"))));
                            }
                            if (laPromotion == 2) {
                                labels[xArrive][yArrive].setIcon((new ImageIcon(MainFrame.class.getResource("../images/tourBlanche.png"))));
                            }
                            if (laPromotion == 3) {
                                labels[xArrive][yArrive].setIcon((new ImageIcon(MainFrame.class.getResource("../images/cavalierBlanc.png"))));
                            }
                            if (laPromotion == 4) {
                                labels[xArrive][yArrive].setIcon((new ImageIcon(MainFrame.class.getResource("../images/fouBlanc.png"))));
                            }
                        }
                        List<Integer> listeDestination = leControleur.deplacementOrdinateur();
                        leControleur.deplacerPiece(listeDestination.get(0),listeDestination.get(1),listeDestination.get(2),listeDestination.get(3));
                        iconeSelec = labels[listeDestination.get(0)][listeDestination.get(1)].getIcon();
                        pieceSelec = labels[listeDestination.get(0)][listeDestination.get(1)];
                        labels[listeDestination.get(2)][listeDestination.get(3)].setIcon(iconeSelec);
                        pieceSelec.setIcon((new ImageIcon("")));
                        victoire = leControleur.verificationVictoireOuDefaite();
                        if (victoire == 1){
                            try {
                                laFenetre.dispose();
                                initVictoire("Partie perdue",laFenetre);
                             }
                             catch (IOException ioe)
                             {
                                throw new RuntimeException(ioe);
                             }
                        } 
                        boolean promoNoire = false;
                        promoNoire = leControleur.promotionPion(listeDestination.get(2), listeDestination.get(3));
                            if (promoNoire == true) {
                               

                                Random rand = new Random();
                                
                                int laPromotion = 1+rand.nextInt(4);
                                leControleur.promotionNoire(listeDestination.get(2), listeDestination.get(3), laPromotion);
                                if (laPromotion == 1) {
                                    labels[listeDestination.get(2)][listeDestination.get(3)].setIcon((new ImageIcon(MainFrame.class.getResource("../images/reineNoire.png"))));
                                }
                                if (laPromotion == 2) {
                                    labels[listeDestination.get(2)][listeDestination.get(3)].setIcon((new ImageIcon(MainFrame.class.getResource("../images/tourNoire.png"))));
                                }
                                if (laPromotion == 3) {
                                    labels[listeDestination.get(2)][listeDestination.get(3)].setIcon((new ImageIcon(MainFrame.class.getResource("../images/cavalierNoir.png"))));
                                }
                                if (laPromotion == 4) {
                                    labels[listeDestination.get(2)][listeDestination.get(3)].setIcon((new ImageIcon(MainFrame.class.getResource("../images/fouNoir.png"))));
                                }
                            }
                    }
                  
                    res = false;
                }
            }
        }

        



        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent event) {
        }

        @Override
        public void mouseReleased(MouseEvent event) {
        }




    }

    

}

