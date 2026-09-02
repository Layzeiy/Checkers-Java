/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layzeiy.game.checkersapp;

/**
 *
 * @author Lesly Mabuda
 */
public class CheckersGrid 
{
    private int width;
    private int height;
    private int positionX;
    private int positionY;
    private boolean occupied;
    private boolean showMove;
    private boolean isTake;
    private boolean promotion;
    private char peice;
    private int peiceNum;

    public CheckersGrid(int width, int height, int positionX, int positionY, boolean occupied, char peice) {
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
        this.occupied = occupied;
        showMove = false;
        isTake = false;
        promotion = false;
        this.peice = peice;
        peiceNum = -1;
    }

    public int getWidth() 
    {
        return width;
    }

    public void setWidth(int width) 
    {
        this.width = width;
    }

    public int getHeight() 
    {
        return height;
    }

    public void setHeight(int height) 
    {
        this.height = height;
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

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) 
    {
        this.occupied = occupied;
    }

    public boolean isShowMove() {
        return showMove;
    }

    public void setShowMove(boolean showMove) 
    {
        this.showMove = showMove;
    }

    public boolean isIsTake() {
        return isTake;
    }

    public void setIsTake(boolean isTake) {
        this.isTake = isTake;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
    
    public char getPeice() 
    {
        return peice;
    }

    public void setPeice(char peice) 
    {
        this.peice = peice;
    }

    public int getPeiceNum() 
    {
        return peiceNum;
    }

    public void setPeiceNum(int peiceNum) 
    {
        this.peiceNum = peiceNum;
    }
    
}
