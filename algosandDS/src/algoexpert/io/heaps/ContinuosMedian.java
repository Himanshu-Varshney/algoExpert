package algoexpert.io.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuosMedian {

    static class ContinuousMedianHandler{

        Heap lowers = new Heap(new ArrayList<Integer>(),Heap::MAX_HEAP_FUNC);
        Heap greaters = new Heap(new ArrayList<Integer>(),Heap::MIN_HEAP_FUNC);
        double median = 0;

        public void insert(int number) {
            if(lowers.length == 0 || number<lowers.peek()){
                lowers.insert(number);
            }else{
                greaters.insert(number);
            }
            rebalanceHeaps();
            updateMedian();
        }

        private void updateMedian() {
            if(lowers.length== greaters.length){
                median = ((double)lowers.peek()+ (double)greaters.peek())/2;
            }else if (lowers.length> greaters.length){
                median=lowers.peek();
            }else{
                median=greaters.peek();
            }

        }

        private void rebalanceHeaps() {

            if(lowers.length- greaters.length==2){
                greaters.insert(lowers.remove());
            }else if(greaters.length-lowers.length==2){
                lowers.insert(greaters.remove());
            }
        }

        public double getMedian() {
            return median;
        }
    }

     static class Heap{
        List<Integer> heap = new ArrayList<Integer>();
        BiFunction<Integer,Integer,Boolean> comparisonFunction;
        int length;

        public Heap(List<Integer> array, BiFunction<Integer, Integer, Boolean> comparisonFunction) {
            this.heap = buildHeap(array);
            this.comparisonFunction = comparisonFunction;
            this.length = heap.size();
        }

     

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap){
           int childOneIdx = currentIdx*2+1;
           while (childOneIdx <=endIdx){
               int childTwoIdx = currentIdx*2+2 <=endIdx ?currentIdx*2+2 :-1;
               int idxToSwap=-1;
               if(childTwoIdx !=-1){
                   if(comparisonFunction.apply(heap.get(childTwoIdx), heap.get(childOneIdx))){
                       idxToSwap=childTwoIdx;
                   }else{
                       idxToSwap=childOneIdx;
                   }
               }else{
                   idxToSwap=childOneIdx;
               }
               if(comparisonFunction.apply(heap.get(idxToSwap), heap.get(currentIdx))){
                   swap(currentIdx,idxToSwap,heap);
                   currentIdx=idxToSwap;
                   childOneIdx=currentIdx*2+1;
               }else{
                   return;
               }
           }
        }


        public void siftUp(int currentIndx, List<Integer> heap){
            int parentIndx = (currentIndx-1)/2;
            while (currentIndx>0){
                if(comparisonFunction.apply(heap.get(currentIndx),heap.get(parentIndx))){
                    swap(currentIndx,parentIndx,heap);
                    currentIndx=parentIndx;
                    parentIndx=(currentIndx-1)/2;
                }else{
                    return;
                }
            }
        }

        public void insert(int value){
            heap.add(value);
            length++;
            siftUp(heap.size()-1,heap);
        }


        public int remove(){
            swap(0,heap.size()-1,heap);
            int valueToRemove = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            length--;
            siftDown(0,heap.size()-1,heap);
            return valueToRemove;
        }
        private void swap(int currentIdx, int indxToSwap, List<Integer> heap) {
            Integer temp = heap.get(indxToSwap);
            heap.set(indxToSwap, heap.get(currentIdx));
            heap.set(currentIdx, temp);
        }
        public int peek(){
            return heap.get(0);
        }

        public static Boolean MAX_HEAP_FUNC(int a, int b){
            return a>b;
        }
        public static Boolean MIN_HEAP_FUNC(int a, int b){
            return a<b;
        }

        public   List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size()-2)/2;
            for(int curIdx = firstParentIdx ;curIdx>=0;curIdx--){
                siftDown(curIdx,array.size()-1,array);
            }
            return array;
        }
    }


}
