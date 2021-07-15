package org.example.lc.primary;

public class test013 {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        new test013().rotate1(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix){
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length/2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i -1];
            matrix[length -i -1] = temp;
        }
        //再按对角线交换
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate1(int[][] matrix){
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length-i-1; j++) {
                int temp = matrix[i][j];
                int m = length -j -1;
                int n = length -i -1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
}
