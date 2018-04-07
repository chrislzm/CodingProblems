package com.chrisleung.other.solutions;

import java.util.Map;

/*
Game of squares
Two players
Turn: Subtracting a perfect square from the current state
State: Always a non-negative integer

50
41
37
21
...


23
 - 16
7
 - 4
 
1, 2, 4, 8, 16, 32...


Us - 2
Them - 1
Us - 1 return 1





I play from the current state

We win when other player has no more moves
Zero is not a valid move
If 0 on my turn i lose

We want to find the best move (with the highest chance of winning)

If we choose a move
 -"Base case"s:
     0
     Any perfect square (will result in 0)
    
 -Otherwise, try all possible moves less than the currentState that are perfect squares
     - See if we win
 
 Find all the possible moves they could make after
 -Play out each of those moves that they make
    -If returns -1 for all moves they can make, we win
    
    
 -Continue this until we win in all cases
 
 
 -- How many times can we win out of the possible moves they make
 
Can we win and if so, WHICH MOVE?

*/
public class GetOptimalMove {
 // Return -1 if no guaranteed way to win
    int getOptimalMove(int currentState, Map<Integer,Integer> memo) {
        if(memo.get(currentState) == null) {
            int result = -1;
            for(int i=1; i*i<=currentState; i++) {
                if(getOptimalMove(currentState - i*i, memo) < 0) {
                    result = i*i;
                    break;
                }
            }
            memo.put(currentState,result);        
        }
        return memo.get(currentState);
    }
}
