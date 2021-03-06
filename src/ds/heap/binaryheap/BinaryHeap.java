package ds.heap.binaryheap;

import java.util.ArrayList;
import java.util.List;

import ds.heap.Heap;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {
  private List<T> items;
  private final int minMaxInd;

  public static <T extends Comparable<T>> BinaryHeap<T> create() {
    return new BinaryHeap<>(1);
  }

  public static <T extends Comparable<T>> BinaryHeap<T> minHeap() {
    return create();
  }

  public static <T extends Comparable<T>> BinaryHeap<T> maxHeap() {
    return new BinaryHeap<>(-1);
  }

  private BinaryHeap(int minMaxInd) {
    items = new ArrayList<>(1000);
    this.minMaxInd = minMaxInd;
  }

  @Override
  public T peek() {
    if (items.isEmpty())
      return null;
    return items.get(0);
  }

  @Override
  public void insert(T t) {
    items.add(t);
    swapUp(items.size() - 1);
  }

  private void swapUp(int index) {
    if (index == 0)
      return;
    T child = items.get(index);
    final int parentIndex = (index - 1) / 2;
    T parent = items.get(parentIndex);
    if (minMaxInd * parent.compareTo(child) > 0) {
      items.set(parentIndex, child);
      items.set(index, parent);
      swapUp(parentIndex);
    }
  }

  @Override
  public T pop() {
    if (items.isEmpty())
      return null;
    T item = items.get(0);
    items.set(0, items.get(items.size() - 1));
    items.remove(items.size() - 1);
    swapDown(0);
    return item;
  }

  private void swapDown(int index) {
    final int leftChildIndex = index * 2 + 1;
    if (leftChildIndex >= items.size())
      return;
    final int rightChildIndex = leftChildIndex + 1;
    T parent = items.get(index);
    T leftChild = items.get(leftChildIndex);
    if (rightChildIndex >= items.size()) {
      if (minMaxInd * parent.compareTo(leftChild) > 0) {
        items.set(index, leftChild);
        items.set(leftChildIndex, parent);
      }
      return;
    }
    T rightChild = items.get(rightChildIndex);
    T childToSwap = leftChild;
    if (minMaxInd * leftChild.compareTo(rightChild) > 0)
      childToSwap = rightChild;
    if (minMaxInd * parent.compareTo(childToSwap) > 0) {
      items.set(index, childToSwap);
      final int childIndexToSwap = childToSwap == leftChild ? leftChildIndex : rightChildIndex;
      items.set(childIndexToSwap, parent);
      swapDown(childIndexToSwap);
    }
  }

  @Override
  public int size() {
    return items.size();
  }
}
