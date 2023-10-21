package graph;

//  G-9. Flood Fill Algorithm | C++ | Java
public class FloodFill {
    public int[][] floodFill(int[][] image, int x, int y, int p) {
        int c = image[x][y];
        int[][] ans = copyArray(image);
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        dfs(x, y, image, ans, delRow, delCol, p, c);
        return ans;
    }
    public static void dfs(int row, int col, int[][] image, int[][] ans, int[] delRow, int[] delCol, int p, int c){
        ans[row][col] = p;
        int m = image.length;
        int n = image[0].length;
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == c && ans[nRow][nCol] != p){
                dfs(nRow, nCol, image, ans, delRow, delCol, p, c);
            }
        }
    }
    public static int[][] copyArray(int[][] image){
        int[][] ans = new int[image.length][image[0].length];
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                ans[i][j] = image[i][j];
            }
        }
        return ans;
    }
}

//  733. Flood Fill

//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//Return the modified image after performing the flood fill.

//Example 1:
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

//Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

//Example 2:
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made to the image.

//Constraints:
//m == image.length
//n == image[i].length
//1 <= m, n <= 50
//0 <= image[i][j], color < 216
//0 <= sr < m
//0 <= sc < n