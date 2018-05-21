package com.chrisleung.other.solutions;

/*
 * Twitch technical screen Codility test question #2
 */
public class BattleShip {
    class Ship {
        int totalLife;
        int currentLife;
        Ship(int l) {
            totalLife = l;
            currentLife = l;
        }
        boolean isDead() {
            return currentLife == 0;
        }
        boolean wasHitOnce() {
            return currentLife == (totalLife-1);
        }
    }
    
    class Coordinate {
        int row;
        int col;
        Coordinate(int i, int j) {
            row = i;
            col = j;
        }
    }
    
    /*
     * Plays the game
     */
    public String solution(int N, String S, String T) {
        if(S == null || S.isEmpty() || T == null || T.isEmpty()) return "0,0";
        Ship[][] map = new Ship[N][N];
        int shipsHit = 0;
        int shipsSunk = 0;
        generateMap(map,S);
        String[] hitStrings = T.split(" ");
        for(String hitString : hitStrings) {
            Coordinate hit = stringToCoordinates(hitString);
            // See if it hit a ship
            Ship ship = map[hit.row][hit.col];
            if(ship != null) {
                ship.currentLife--;
                if(ship.isDead()) {
                    // Special case: If ship only has 1 life, it was never marked as hit before
                    if(ship.totalLife > 1) {
                        shipsHit--;
                    }
                    shipsSunk++;
                } else if(ship.wasHitOnce()) {
                    shipsHit++;
                }
            }
        }
        return String.format("%d,%d", shipsSunk, shipsHit);
    }
    
    /*
     * Create and place each ship on its map cells
     */
    private void generateMap(Ship[][] map, String S) {
        String[] shipOriginDests = S.split(",");
        for(String shipOriginDest : shipOriginDests) {
            String[] shipCoordinates = shipOriginDest.split(" ");
            Coordinate origin = stringToCoordinates(shipCoordinates[0]);
            Coordinate dest = stringToCoordinates(shipCoordinates[1]);
            Ship ship = new Ship(calculateLife(origin,dest));
            for(int i=origin.row; i<=dest.row; i++) {
                for(int j=origin.col; j<=dest.col; j++) {
                    map[i][j] = ship; 
                }
            }
        }
    }
    
    private Coordinate stringToCoordinates(String s) {
        int row = 0;
        int col = 0;
        
        if(s.length() == 3) {
            row = Integer.parseInt(s.substring(0, 2))-1; // Two-character row number
            col = s.charAt(2) - 'A';
        } else {
            row = s.charAt(0) - '1';
            col = s.charAt(1) - 'A';
        }
        return new Coordinate(row,col);
    }

    /*
     * Calculates "life" or number of hits the ship can take, based on the size of the ship
     */
    private int calculateLife(Coordinate topLeft, Coordinate bottomRight) {
        int width = bottomRight.col-topLeft.col+1;
        int height = bottomRight.row-topLeft.row+1;
        return width * height;
    }
}
