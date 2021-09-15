package algoexpert.io.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeapBasicStructure {

    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        //O(log(n) time | O(1) space
        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdxFromLast = (array.size()-2)/2;
            for(int currentIdx = firstParentIdxFromLast ; currentIdx>=0;currentIdx--){
                siftDown(currentIdx,array.size()-1,array);
            }
            return array;
        }

        //O(log(n) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIndx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int indxToSwap = -1;
                if (childTwoIndx != -1 && heap.get(childTwoIndx) < heap.get(childOneIdx)) {
                    indxToSwap = childTwoIndx;
                } else {
                    indxToSwap = childOneIdx;
                }
                if (heap.get(indxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, indxToSwap, heap);
                    currentIdx = indxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }

            }

        }

        //O(log(n) | O(1)
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }


        public void insert(int value){
            heap.add(value);
            siftUp(heap.size()-1,heap);
        }
        public int remove() {
            //replace the first element with last
            swap(0, heap.size() - 1, heap);
            //now remove last element which is basically first element because of first step
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size()-1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        private void swap(int currentIdx, int indxToSwap, List<Integer> heap) {
            Integer temp = heap.get(indxToSwap);
            heap.set(indxToSwap, heap.get(currentIdx));
            heap.set(currentIdx, temp);
        }

    }

}
