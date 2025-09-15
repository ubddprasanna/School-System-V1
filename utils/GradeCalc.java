package utils;
public class GradeCalc {
    public static double main(int[] marks, double[] weight, int length) {
        length--;
        if (length >= 0) {
           return  marks[length] * weight[length] + main (marks, weight,length);
       } else{
           return 0;
       }
    }
}
