package _04_MaxMin;

public class TwoLoop {

    // Complexity: O(2n-2)
    public static int twoLoops(int[] arr){
        int comparisons = 0;
        int max = arr[0];
        int indexMax = 0;
        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] > max) {
                indexMax = i;
                max = arr[i];
            }
        }

        int min = arr[0];
        int indexMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
                indexMin = i;
            }
            comparisons++;
        }
        System.out.println("max = " + max + " indexMax = " + indexMax + " min = " + min +
                " indexMin = " + indexMin);
        return comparisons;
    }

    public static void main(String[] args) {
        int[] a = BuildArray.buildRandomArray();
        int[] aInc = BuildArray.buildSortIncreasingArray();
        int[] aDec = BuildArray.buildSortDecreasingArray();
        System.out.println("\n********** Two loops Random Array **********");
        int comp1 = twoLoops(a);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*a.length - 2));
        System.out.println("\n********** Two loops Increasing Array **********");
        comp1 = twoLoops(aInc);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*aInc.length - 2));
        System.out.println("\n********** Two loops Decreasing Array **********");
        comp1 = twoLoops(aDec);
        System.out.println("comp1 = " + comp1 + ", 2n-2 = " + (2*aDec.length - 2));
    }
}
