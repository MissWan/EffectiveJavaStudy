package ds.heap.guava_based;

import com.google.common.collect.MinMaxPriorityQueue;

import ds.heap.Heap;

public class HeapGuavaBasedImpl<T extends Comparable<T>> implements Heap<T>{
    private final MinMaxPriorityQueue<T> heap;
    
    public static <T extends Comparable<T>> HeapGuavaBasedImpl<T> createMinHeap(){
      return new HeapGuavaBasedImpl<>(HeapType.MIN_HEAP);
    }
    
    public static <T extends Comparable<T>> HeapGuavaBasedImpl<T> createMaxHeap(){
      return new HeapGuavaBasedImpl<>(HeapType.MAX_HEAP);
    }
    
    private HeapGuavaBasedImpl(final HeapType heapType){
      switch(heapType){
        case MAX_HEAP:
          // only 1 line lambda implementation could omit the return key word.
          heap = MinMaxPriorityQueue.orderedBy((T t1, T t2) -> { return t2.compareTo(t1);}).expectedSize(1000).create();
          break;
        case MIN_HEAP:
        default:
          heap = MinMaxPriorityQueue.orderedBy((T t1, T t2) -> t1.compareTo(t2)).expectedSize(1000).create();
          break;
      }
    }
    
    public T peek(){
      return heap.peek();
    }
    
    @Override
    public void insert(T t) {
      heap.offer(t);
    }

    @Override
    public T pop() {
      return heap.poll();
    }

    @Override
    public int size() {
      return heap.size();
    }
}
