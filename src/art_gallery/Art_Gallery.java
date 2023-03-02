package art_gallery;

import art_gallery.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Art_Gallery extends JFrame {
    Timer timer;
    //    JFrame frame = new JFrame();

    JPanel loginOption;
    private void displayWelcomeScreen() {
        JWindow window = new JWindow(this);
        window.setSize(1600, 900);
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        JPanel panel = new JPanel();
        window.add(panel);
        String imagePath = "C:\\Users\\fdipt\\IdeaProjects\\Art_Gallery\\Art_Gallery\\src\\images\\Art Vending Management Studio - Background.png";
        JLabel label = new JLabel(new ImageIcon(imagePath));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, false));


        JProgressBar progressBar = new JProgressBar(0, 100);
//        progressBar.setForeground(Color.ORANGE);
        window.add(BorderLayout.PAGE_END, progressBar);
        window.revalidate();
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = progressBar.getValue();
                if (x == 100) {
                    window.dispose();
                    Art_Gallery.this.setVisible(true);
                    timer.stop();
                    new Login().setVisible(true);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                } else {
                    progressBar.setValue(x + 1);
                }
            }
        });
        timer.start();
    }


    public Art_Gallery() {

        displayWelcomeScreen();
        setVisible(true);
        setSize(1600, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        JPanel panel2 = new JPanel();
//        panel2.setSize(1600, 900);
//        add(panel2);
//        panel2.setVisible(true);


//        JLabel label = new JLabel("Do you want to login as Admin or Outlet manager?");
//        label.setFont(new Font("Arial", Font.PLAIN, 30));
//        label.setBounds(300, 500, 100, 50);
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//        label.setVerticalAlignment(SwingConstants.CENTER);
//        panel2.add(label);


    }



    public static void main(String[] args) {
        new Art_Gallery();
    }
}







///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package art_gallery;
//
///**
// *
// * @author This Pc
// */
//public class Art_Gallery {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//
//}
