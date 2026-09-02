/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layzeiy.game.checkersapp;

/**
 *
 * @author Lesly Mabuda
 */
public class CheckersPeice 
{
    private int peiceNum;
    private int radius;
    private int positionX;
    private int positionY;
    private boolean isKing;
    private char color;

    public CheckersPeice(int peiceNum, int radius, int positionX, int positionY, boolean isKing, char color) 
    {
        this.peiceNum = peiceNum;
        this.radius = radius;
        this.positionX = positionX;
        this.positionY = positionY;
        this.isKing = isKing;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }
    
    

    public char getColor() 
    {
        return color;
    }

    public int getPositionX() 
    {
        return positionX;
    }

    public void setPositionX(int positionX) 
    {
        this.positionX = positionX;
    }

    public int getPositionY() 
    {
        return positionY;
    }

    public void setPositionY(int positionY) 
    {
        this.positionY = positionY;
    }

    public boolean isIsKing() 
    {
        return isKing;
    }

    public void setIsKing(boolean isKing) 
    {
        this.isKing = isKing;
    }
    
}
