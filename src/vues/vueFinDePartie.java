package vues;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.io.IOException;
import javax.swing.JLabel;
import java.io.File;

public class vueFinDePartie  extends JFrame {
    JFrame laFenetreFin = this;
    JLabel message;
    JButton rejouerBouton;
    public void init(String text, JFrame fenetre)throws IOException  {
      
        dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
        message = new JLabel(text,SwingConstants.CENTER);
        message.setBounds(50,50, 180,20);
    
        JButton rejouer = new JButton("Rejouer");
        rejouer.setBounds(90,100,100,40);
        rejouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                laFenetreFin.dispose();
                try {
                    File file = new File("plateauSauve");
                    file.delete();
                    MainFrame myFrame = new MainFrame();
                    myFrame.init(3);
                  
                 }
                 catch (IOException ioe)
                 {
                    throw new RuntimeException(ioe);
                 }

              
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(rejouer);
        add(message);
        setSize(300,300);
        setLayout(null);
        setVisible(true);    
    }


   
}
