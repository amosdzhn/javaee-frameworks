package solution;

/**
 * 问题描述：
 *      给定一个 n*n的棋盘，棋盘中填满了棋子0/1
 *      先给定一个坐标x,y 将该坐标的上下左右棋子变为另外一种
 */
public class Solution_棋盘反转 {
    public static void main(String[] args) {
        //数据准备
        // table
        int[][] t = {
                {1,0,1,0},
                {1,0,1,1},
                {1,0,1,0},
                {0,1,0,1},
        };
        //  operation_location
        int[][] op = {
                {1,1},
                {4,4},
        };

        int[][] res = solution(t, op);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] table,int[][] location){
        int left = 0;
        int right = table[0].length-1;
        int top = 0;
        int down = table.length-1;

        for (int i = 0; i < location.length; i++) {
            int x = location[i][0] -1;
            int y = location[i][1] -1;
            if( x-1 >= left){
                table[y][x-1] = table[y][x-1]==0? 1:0;
            }
            if( x+1 <= right){
                table[y][x+1] = table[y][x+1]==0? 1:0;
            }
            if( y-1 >= top){
                table[y-1][x] = table[y-1][x]==0? 1:0;
            }
            if( y+1 <= down){
                table[y+1][x] = table[y+1][x]==0? 1:0;
            }
        }
        return table;
    }
}
