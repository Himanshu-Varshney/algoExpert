package algoexpert.io.search;

public class ThreeLargestNumber {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargestNumber = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int num : array){
            updateLargest(threeLargestNumber,num);
        }
        return threeLargestNumber;
    }

    private static void updateLargest(int[] threeLargestNumber, int num) {
        if(num>threeLargestNumber[2]){
            updateAndShift(threeLargestNumber,num,2);
        }else if(num>threeLargestNumber[1]){
            updateAndShift(threeLargestNumber,num,1);
        }else if(num > threeLargestNumber[0]){
            updateAndShift(threeLargestNumber,num,0);
        }

    }

    private static void updateAndShift(int[] threeLargestNumber, int num, int idx) {
        for (int i=0;i<idx+1;i++){
            if(i == idx)
                threeLargestNumber[i]=num;
            else{
                threeLargestNumber[i]=threeLargestNumber[i+1];
            }
        }

    }

}
