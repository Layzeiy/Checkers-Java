/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package layzeiy.game.checkersapp;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Lesly Mabuda
 */
public class CheckersApp 
{
    public static void main(String[] args) 
    {
        JFrame jf = new JFrame("Checkers App");
        CheckersBoard ch = new CheckersBoard();
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(900, 1000);
        jf.setResizable(false);
        jf.setLayout(new BorderLayout());
        
        jf.add(ch, BorderLayout.CENTER);
        ch.play();
        jf.setVisible(true);
    }
    
}
