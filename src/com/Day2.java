package com;

/**
 * @Author: WangGguo
 * @Description:
 * @Date: Created in 7:50 下午 2020/7/12
 * @Modified By:
 */
public class Day2 {

    public static boolean findNum(int[][] matrix,int num){
        //int startR = 0;
        //int startC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        int startR = endR;
        int startC = 0;
        while (startR >= 0 || startC >= endC){
            if (matrix[startR][startC] > num){
                startR --;
            }else if (matrix[startR][startC] == num){
                return true;
            }else {
                startC ++;
            }
        }
        return false;
    }



    private static void rotateEdge(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean flag = false;
        while (aC < endC + 1) {
            printLevel(matrix, aR, aC, bR, bC, flag);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            //bR = bR == endR ? bR : bR + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            flag = !flag;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean f) {
        if (f){
            while (aR != bR + 1){
                System.out.print(m[aR++][aC--] + " ");
            }
        }else {
            while (bR != aR -1){
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean f = findNum(matrix,4);
        System.out.println(f);
    }
}
