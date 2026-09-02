/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layzeiy.game.checkersapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lesly Mabuda
 */
public class CheckersBoard extends JPanel
{
    protected static CheckersGrid[][] chGrids;
    protected static CheckersPeice[] chPeices;
    private GameManager gManager;
    
    public CheckersBoard() 
    {
        chGrids = new CheckersGrid[8][8];
        chPeices = new CheckersPeice[24];
        gManager = new GameManager(this);
        
        this.setSize(800, 800);
        
        //Occupy Arrays
        int height = this.getHeight() / 8;
        int width = this.getWidth() / 8;
        int positionX = 0 , positionY = 0;
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
               if((i + j) % 2 == 0)
                {
                    chGrids[i][j] = new CheckersGrid(width, height, positionX, positionY, false, 'n');
                }
               else
               {
                   chGrids[i][j] = new CheckersGrid(width, height, positionX, positionY, false, 'n');
               }
               
               positionX += width;
            }
            positionX = 0;
            positionY += width;
        }
        
        positionX = 5;
        positionY = 5;
        int pHeight = height - 10, pWidth = width - 10;
        int peiceNum = 0;
        
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
               if(((i + j) % 2 != 0) && (i <= 2 && j <= 7))
                {
                    chPeices[peiceNum] = new CheckersPeice(peiceNum, pWidth, positionX, positionY, false, 'r');
                    
                    
                    chGrids[i][j].setOccupied(true);
                    chGrids[i][j].setPeiceNum(peiceNum);
                    chGrids[i][j].setPeice('r');
                    
                    peiceNum++;
                }
               else if(((i + j) % 2 != 0) && (i >= 5) )
               {
                   chPeices[peiceNum] = new CheckersPeice(peiceNum, pWidth, positionX, positionY, false, 'b');
                   
                   
                   chGrids[i][j].setOccupied(true);
                   chGrids[i][j].setPeiceNum(peiceNum);
                   chGrids[i][j].setPeice('b');
                   
                   peiceNum++;
               }
               positionX += width;
            }
            positionX = 5;
            positionY += width;
        }
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        CheckersGrid tempGrid = chGrids[0][0];
        int height = tempGrid.getHeight();
        int width = tempGrid.getWidth();
        int positionX = 0, positionY = 0;
        
        
        
        //Generate the board
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
               if((i + j) % 2 == 0)
                {
                    tempGrid = chGrids[i][j];
                    positionX = tempGrid.getPositionX();
                    positionY = tempGrid.getPositionY();
                    
                    g.setColor(Color.white);
                    g.fillRect(positionX, positionY, width, height);
                }
               else
               {
                   tempGrid = chGrids[i][j];
                   positionX = tempGrid.getPositionX();
                   positionY = tempGrid.getPositionY();
                    
                   g.setColor(Color.black);
                   g.fillRect(positionX, positionY, width, height);
               }
               
               if(tempGrid.isShowMove())
                {
                    positionX += 25;
                    positionY += 25;
                    g.setColor(Color.green);
                    g.fillOval(positionX, positionY, width - 50, height - 50);
                }
               
               positionX += width;
            }
            positionX = 0;
            positionY += width;
        }
        
        //Generate the peices
        int  radius;
        char color;
        
        CheckersPeice tempPeice;
        
        
        for(int i = 0; i < chPeices.length; i++)
        {
            if(chPeices[i] != null){
                tempPeice = chPeices[i];

                positionX = chPeices[i].getPositionX();
                positionY = chPeices[i].getPositionY();
                radius = chPeices[i].getRadius();
                color = chPeices[i].getColor();

                if(color == 'r')
                {
                    g.setColor(Color.red);
                    g.fillOval(positionX, positionY, radius, radius);
                }
                else
                {
                    g.setColor(Color.blue);
                    g.fillOval(positionX, positionY, radius, radius);
                }  
            }
            
        }
    }
    
    public void play()
    {
        
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                
                int row = y / chGrids[0][0].getWidth();
                int col = x / chGrids[0][0].getWidth();
                
                System.out.println("Clicked at X: " + x + " Y: " + y);
                System.out.println("Col: " + col + " row: " + row);
                
                gManager.calculateMoves(col, row);
            }
        });
    }
}
