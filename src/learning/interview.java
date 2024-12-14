package learning;

public class interview {
/*
Given an m x n 2D binary grid grid which represents a map of '1's
(land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting
adjacent lands horizontally or vertically. You may assume all four
edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

//Check is r/c if it is inbounds, then check if it is land, and if it'sland continue if not stop.

Example 2:
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

[execution time limit] 4 seconds (py3)
[memory limit] 1 GB
[input] array.array.string grid
mxn Grid for islands and water
[output] integer
Number of islands found
 */

  public static void island(String[][] grid, int rowF, int colF) {

    // If there is land connected
//    boolean inBoundsRight = rowF;
    if (grid[rowF][colF].equals("1")) {

    }


  }
  public static void solution(String[][] grid) {
  //counter islands
    //An island happens when we have 0s left
    int islandCount = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        //first find land
        if (grid[r][c].equals("1")) {
          //Check whats next to it


        }


      }
    }
  }


  public static void main(String[] args) {
//    int solu = solution();
  }
}
