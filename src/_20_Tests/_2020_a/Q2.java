package _20_Tests._2020_a;

import _10_AirPlane.InitMatrixOfPrices;
import _10_AirPlane.Node;

public class Q2 {

    // 1.a
    public static int plane(Node[][] mat) {
        return plane(mat, 0, 0, mat.length, mat[0].length);
    }

    public static int plane(Node[][] mat, int nBegin, int mBegin, int nEnd, int mEnd) {
        for (int i = nBegin+1; i < mat.length; i++) {
            int t = mat[i-1][mBegin].getY() + mat[i-1][mBegin].getPrice();
            mat[i][mBegin].setPrice(t);
        }
        for (int i = mBegin+1; i < mat[0].length; i++) {
            mat[nBegin][i].setPrice(mat[nBegin][i-1].getX() + mat[nBegin][i-1].getPrice());
        }
        for (int k = nBegin+1; k < nEnd; k++) {
            for (int l = mBegin+1; l < mEnd; l++) {
                int xMin = mat[k][l - 1].getPrice() + mat[k][l - 1].getX();
                int yMin = mat[k - 1][l].getPrice() + mat[k - 1][l].getY();
                mat[k][l].setPrice(Math.min(yMin, xMin));
            }
        }
        return mat[nEnd-1][mEnd-1].getPrice();
    }

    //1.b
    public static boolean pointOnPath(Node[][] mat, int[] point1, int[] point2) {
        int n = mat.length, m = mat[0].length;
        int lis = plane(mat);
        int i = plane(mat, 0, 0, point1[0], point1[1]);
        int j = plane(mat, point1[0], point1[1], n, m);
        int lis1 = i + j;
        if (lis1 == lis) return true;
        if (point1[0] == point2[0] && point1[1] == point2[1]) return false;
        int lis2 = plane(mat, 0, 0, point2[0], point2[1]) + plane(mat, point2[0], point2[1], n, m);
        return lis2 == lis;
    }

    public static void main(String[] args) {
        Node[][] mat = InitMatrixOfPrices.initMatOfNodes1();
        int[] point1 = {1, 2}, point2 = {2, 1};
        System.out.println(plane(mat));
        mat = InitMatrixOfPrices.initMatOfNodes1();
        System.out.println(pointOnPath(mat, point1, point2));
    }
}

