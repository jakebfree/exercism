package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameBoard {

    private List<Cell> cells = new ArrayList<Cell>();
    private int width;
    private int height;

    // TODO: pass in initializer function
    public GameBoard(int width, int height){
        // TODO: check size args

        this.width = width;
        this.height = height;
        Cell[][] boardLayout = new Cell[this.width][this.height];

        // Create new cell for each location and place in layout
        for( int j=0; j<this.height; j++ ){
            for( int i=0; i<this.width; i++ ){
                cells.add( new Cell(i, j));
                boardLayout[i][j] = cells.get( cells.size() - 1 );
            }
        }

        // Teach cells who their neighbors are
        for( int j=0; j<this.height; j++ ){
            for( int i=0; i<this.width; i++ ){

                // Walk through indices around cell
                for( int y=j-1; y<=j+1; y++ ){
                    if( y<0 || y >= height) continue;  // skip indices outside matrix

                    for( int x=i-1; x<=i+1; x++){
                        if( x<0 || x >= width) continue;   // skip indices outside matrix
                        if( x==0 && y==0 ) continue;    // skip self
                        boardLayout[i][j].addNeighbor( boardLayout[x][y] );   // Add neighbor
                    }
                }
            }
        }

        randomlyInitializeCellStates((float) (0.3));
    }

    public void randomlyInitializeCellStates(float avgOnness){
        Random generator = new Random(System.currentTimeMillis());
        for( Cell cell : this.cells )
            cell.setLiving(generator.nextFloat() < avgOnness);
    }

    public void print(){
        Cell[][] boardLayout = new Cell[this.width][this.height];

        // populate board layout for printing
        for( Cell cell : this.cells ){
            boardLayout[cell.getXLoc()][cell.getYLoc()] = cell;
        }

        System.out.println("-----------------------------------");
        for( int j=0; j<this.height; j++ ){
            for( int i=0; i<this.width; i++ ){
                if(boardLayout[i][j].getLiving())
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }

}
