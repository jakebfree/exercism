package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jake on 1/5/15.
 */
public class Cell {
    private boolean living = false;
    private boolean willBeLiving = false;

    private int xLoc;
    private int yLoc;

    private List<Cell> neighbors = new ArrayList<Cell>();
    private boolean XLoc;

    public Cell( int x_loc, int y_loc){
        this.xLoc = x_loc;
        this.yLoc = y_loc;
    }
    public void addNeighbor( Cell neighbor ){
        this.neighbors.add( neighbor );
    }

    public void transitionToNextTimeSlice(){
        this.living = this.willBeLiving;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getXLoc() {
        return xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public boolean getLiving(){
        return this.living;
    }
}
