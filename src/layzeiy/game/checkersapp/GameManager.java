/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layzeiy.game.checkersapp;

import java.util.ArrayList;

/**
 *
 * @author Lesly Mabuda
 */
public class GameManager 
{
    private char playerTurn;
    private CheckersBoard chBoard;
    private int[] prevMoves;
    private int[] prevPeicePosition;
    private int peiceNum;
    private int peiceTaken;
    private int[] peiceTakenPosition;
    private boolean moveAvailabe;
    private boolean forcedTake;

    public GameManager(CheckersBoard chBoard) 
    {
        this.chBoard = chBoard;
        playerTurn = 'b';
        prevMoves = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        prevPeicePosition = new int[]{0, 0};
        peiceTakenPosition = new int[]{0, 0};
        moveAvailabe = false;
        forcedTake = false;
    }
    
    public void calculateMoves(int x, int y)
    {
        char peiceColor = chBoard.chGrids[y][x].getPeice();
        
        if (peiceColor == playerTurn)
        {
            //Show moves
            if(chBoard.chGrids[y][x].isOccupied())
            {
                if(chBoard.chPeices[chBoard.chGrids[y][x].getPeiceNum()].isIsKing()) showKingMoves(x, y);
                else showValidMoves(x, y);
            }
        }
        else if(peiceColor == 'n')
        {
            //Make Move
            if(chBoard.chGrids[y][x].isShowMove())
            {
                makeValidMoves(x, y);
                
                if(playerTurn == 'r') playerTurn = 'b';
                else playerTurn = 'r';
            }
        }
        
        chBoard.repaint();
    }
    
    public void showValidMoves(int x, int y)
    {
        peiceNum = chBoard.chGrids[y][x].getPeiceNum();
        
        chBoard.chGrids[prevMoves[0]][prevMoves[1]].setShowMove(false);
        chBoard.chGrids[prevMoves[2]][prevMoves[3]].setShowMove(false);
        chBoard.chGrids[prevMoves[4]][prevMoves[5]].setShowMove(false);
        chBoard.chGrids[prevMoves[6]][prevMoves[7]].setShowMove(false);
        
        
        
        prevPeicePosition[0] = x;
        prevPeicePosition[1] = y;
        
        switch(playerTurn)
        {
            case'r':
                try{
                    if(chBoard.chGrids[y + 1][x - 1].isOccupied() == false) 
                    {
                        chBoard.chGrids[y + 1][x - 1].setShowMove(true);
                        prevMoves[0] = y + 1;
                        prevMoves[1] = x - 1;

                        if (checkForPromotions(y + 1)) chBoard.chGrids[y + 1][x - 1].setPromotion(true);
                    }
                    else if(chBoard.chGrids[y + 2][x - 2].isOccupied() == false && chBoard.chGrids[y + 1][x - 1].getPeice() != playerTurn)
                    {
                        chBoard.chGrids[y + 2][x - 2].setShowMove(true);
                        chBoard.chGrids[y + 2][x - 2].setIsTake(true);

                        prevMoves[0] = y + 2;
                        prevMoves[1] = x - 2;

                        peiceTaken = chBoard.chGrids[y + 1][x - 1].getPeiceNum();
                        peiceTakenPosition[0] = x - 1;
                        peiceTakenPosition[1] = y + 1;

                        if (checkForPromotions(y + 2)) chBoard.chGrids[y + 2][x - 2].setPromotion(true);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("cant go there");
                }

                try{
                    if(chBoard.chGrids[y + 1][x + 1].isOccupied() == false) 
                    {
                        chBoard.chGrids[y + 1][x + 1].setShowMove(true);
                        prevMoves[2] = y + 1;
                        prevMoves[3] = x + 1;

                        if (checkForPromotions(y + 1)) chBoard.chGrids[y + 1][x + 1].setPromotion(true);
                    }
                    else if(chBoard.chGrids[y + 2][x + 2].isOccupied() == false && chBoard.chGrids[y + 1][x + 1].getPeice() != playerTurn)
                    {
                        chBoard.chGrids[y + 2][x + 2].setShowMove(true);
                        chBoard.chGrids[y + 2][x + 2].setIsTake(true);

                        prevMoves[2] = y + 2;
                        prevMoves[3] = x + 2;

                        peiceTaken = chBoard.chGrids[y + 1][x + 1].getPeiceNum();
                        peiceTakenPosition[0] = x + 1;
                        peiceTakenPosition[1] = y + 1;

                        if (checkForPromotions(y + 2)) chBoard.chGrids[y + 2][x + 2].setPromotion(true);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("cant go there");
                }

                break;
            case'b':
                try{
                    if(chBoard.chGrids[y - 1][x - 1].isOccupied() == false) 
                    {
                        chBoard.chGrids[y - 1][x - 1].setShowMove(true);
                        prevMoves[0] = y - 1;
                        prevMoves[1] = x - 1;

                        if (checkForPromotions(y - 1)) chBoard.chGrids[y - 1][x - 1].setPromotion(true);
                    }
                    else if(chBoard.chGrids[y - 2][x - 2].isOccupied() == false && chBoard.chGrids[y - 1][x - 1].getPeice() != playerTurn)
                    {
                        chBoard.chGrids[y - 2][x - 2].setShowMove(true);
                        chBoard.chGrids[y - 2][x - 2].setIsTake(true);

                        prevMoves[0] = y - 2;
                        prevMoves[1] = x - 2;

                        peiceTaken = chBoard.chGrids[y - 1][x - 1].getPeiceNum();
                        peiceTakenPosition[0] = x - 1;
                        peiceTakenPosition[1] = y - 1;

                        if (checkForPromotions(y - 2)) chBoard.chGrids[y - 2][x - 2].setPromotion(true);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("cant go there");
                }


                try{
                  if(chBoard.chGrids[y - 1][x + 1].isOccupied() == false) 
                    {
                        chBoard.chGrids[y - 1][x + 1].setShowMove(true);
                        prevMoves[2] = y - 1;
                        prevMoves[3] = x + 1;

                        if (checkForPromotions(y - 1)) chBoard.chGrids[y - 1][x + 1].setPromotion(true);
                    }  
                  else if(chBoard.chGrids[y - 2][x + 2].isOccupied() == false && chBoard.chGrids[y - 1][x + 1].getPeice() != playerTurn)
                    {
                        chBoard.chGrids[y - 2][x + 2].setShowMove(true);
                        chBoard.chGrids[y - 2][x + 2].setIsTake(true);

                        prevMoves[2] = y - 2;
                        prevMoves[3] = x + 2;

                        peiceTaken = chBoard.chGrids[y - 1][x + 1].getPeiceNum();
                        peiceTakenPosition[0] = x + 1;
                        peiceTakenPosition[1] = y - 1;

                        if (checkForPromotions(y - 2)) chBoard.chGrids[y - 2][x + 2].setPromotion(true);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("cant go there");
                }
        }
    }
    
    public void makeValidMoves(int x, int y)
    {
        chBoard.chGrids[prevMoves[0]][prevMoves[1]].setShowMove(false);
        chBoard.chGrids[prevMoves[2]][prevMoves[3]].setShowMove(false);
        chBoard.chGrids[prevMoves[4]][prevMoves[5]].setShowMove(false);
        chBoard.chGrids[prevMoves[6]][prevMoves[7]].setShowMove(false);
        
        int positionX = 5 + chBoard.chGrids[y][x].getPositionX();
        int positionY = 5 + chBoard.chGrids[y][x].getPositionY();
        
        if(chBoard.chGrids[y][x].isIsTake()){
            chBoard.chGrids[peiceTakenPosition[1]][peiceTakenPosition[0]].setIsTake(false);
            chBoard.chGrids[peiceTakenPosition[1]][peiceTakenPosition[0]].setOccupied(false);
            chBoard.chGrids[peiceTakenPosition[1]][peiceTakenPosition[0]].setPeiceNum(-1);
            chBoard.chGrids[peiceTakenPosition[1]][peiceTakenPosition[0]].setPeice('n');
            
            chBoard.chPeices[peiceTaken] = null;
        }
        
        if(chBoard.chGrids[y][x].isPromotion()){
            chBoard.chPeices[peiceNum].setIsKing(true);
            chBoard.chGrids[y][x].setPromotion(false);
        }
        
        chBoard.chGrids[prevPeicePosition[1]][prevPeicePosition[0]].setOccupied(false);
        chBoard.chGrids[prevPeicePosition[1]][prevPeicePosition[0]].setPeiceNum(-1);
        chBoard.chGrids[prevPeicePosition[1]][prevPeicePosition[0]].setPeice('n');
        
        chBoard.chPeices[peiceNum].setPositionX(positionX);
        chBoard.chPeices[peiceNum].setPositionY(positionY);
        

        chBoard.chGrids[y][x].setOccupied(true);
        chBoard.chGrids[y][x].setPeiceNum(peiceNum);
        chBoard.chGrids[y][x].setPeice(playerTurn);

        boolean p = chBoard.chGrids[y][x].isOccupied();
        boolean q = chBoard.chPeices[peiceNum].isIsKing();
    }
    
    public boolean checkForPromotions(int y)
    {
        boolean promote = false;
        
        switch(playerTurn)
        {
            case'r':
                if(y == 7) promote = true;
                break;
            case'b':
                if(y == 0) promote = true;
        }
        
        return promote;
    }
    
    public void showKingMoves(int x, int y)
    {
        peiceNum = chBoard.chGrids[y][x].getPeiceNum();
            
        chBoard.chGrids[prevMoves[0]][prevMoves[1]].setShowMove(false);
        chBoard.chGrids[prevMoves[2]][prevMoves[3]].setShowMove(false);
        chBoard.chGrids[prevMoves[4]][prevMoves[5]].setShowMove(false);
        chBoard.chGrids[prevMoves[6]][prevMoves[7]].setShowMove(false);
        
        prevPeicePosition[0] = x;
        prevPeicePosition[1] = y;
        
        try
        {
            if(chBoard.chGrids[y - 1][x - 1].isOccupied() == false)
            {
                chBoard.chGrids[y - 1][x - 1].setShowMove(true);
                prevMoves[0] = y - 1;
                prevMoves[1] = x - 1;
            }
            else if(chBoard.chGrids[y - 2][x - 2].isOccupied() == false && chBoard.chGrids[y - 1][x - 1].getPeice() != playerTurn)
            {
                chBoard.chGrids[y - 2][x - 2].setShowMove(true);
                chBoard.chGrids[y - 2][x - 2].setIsTake(true);
                prevMoves[0] = y - 2;
                prevMoves[1] = x - 2;
                peiceTaken = chBoard.chGrids[y - 1][x - 1].getPeiceNum();
                peiceTakenPosition[0] = x - 1;
                peiceTakenPosition[1] = y - 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("cant go there");
        }
        
        try
        {
            if(chBoard.chGrids[y - 1][x + 1].isOccupied() == false)
            {
                chBoard.chGrids[y - 1][x + 1].setShowMove(true);
                prevMoves[2] = y - 1;
                prevMoves[3] = x + 1;
            }
            else if(chBoard.chGrids[y - 2][x + 2].isOccupied() == false && chBoard.chGrids[y - 1][x + 1].getPeice() != playerTurn)
            {
                chBoard.chGrids[y - 2][x + 2].setShowMove(true);
                chBoard.chGrids[y - 2][x + 2].setIsTake(true);
                prevMoves[2] = y - 2;
                prevMoves[3] = x + 2;
                peiceTaken = chBoard.chGrids[y - 1][x + 1].getPeiceNum();
                peiceTakenPosition[0] = x + 1;
                peiceTakenPosition[1] = y - 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("cant go there");
        }
        
        try
        {
            if(chBoard.chGrids[y + 1][x - 1].isOccupied() == false)
            {
                chBoard.chGrids[y + 1][x - 1].setShowMove(true);
                prevMoves[4] = y + 1;
                prevMoves[5] = x - 1;
            }
            else if(chBoard.chGrids[y + 2][x - 2].isOccupied() == false && chBoard.chGrids[y + 1][x - 1].getPeice() != playerTurn)
            {
                chBoard.chGrids[y + 2][x - 2].setShowMove(true);
                chBoard.chGrids[y + 2][x - 2].setIsTake(true);
                prevMoves[4] = y + 2;
                prevMoves[5] = x - 2;
                peiceTaken = chBoard.chGrids[y + 1][x - 1].getPeiceNum();
                peiceTakenPosition[0] = x - 1;
                peiceTakenPosition[1] = y + 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("cant go there");
        }
        
        try
        {
            if(chBoard.chGrids[y + 1][x + 1].isOccupied() == false)
            {
                chBoard.chGrids[y + 1][x + 1].setShowMove(true);
                prevMoves[6] = y + 1;
                prevMoves[7] = x + 1;
            }
            else if(chBoard.chGrids[y + 2][x + 2].isOccupied() == false && chBoard.chGrids[y + 1][x + 1].getPeice() != playerTurn)
            {
                chBoard.chGrids[y + 2][x + 2].setShowMove(true);
                chBoard.chGrids[y + 2][x + 2].setIsTake(true);
                prevMoves[6] = y + 2;
                prevMoves[7] = x + 2;
                peiceTaken = chBoard.chGrids[y + 1][x + 1].getPeiceNum();
                peiceTakenPosition[0] = x + 1;
                peiceTakenPosition[1] = y + 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("cant go there");
        }
        
    }
}
