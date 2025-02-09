import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Queue<T> {
    private List<T> elements;

    public Queue() {
        this.elements = new ArrayList<>();
    }
    
    public void enqueue(T element) {
    	elements.add(element);
    }
    
    public T dequeue(T element) {
    	return elements.removeFirst(); // throws exception if empty
    }
    
    public T getFront() {
		return elements.getFirst(); // throws exception if empty
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    public void clear() {
    	elements.clear();
    }
    
    public void quicksort(Comparator<T> comparator) {
        quicksortHelper(0, elements.size() - 1, comparator);
    }

    private void quicksortHelper(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksortHelper(low, pivotIndex - 1, comparator);
            quicksortHelper(pivotIndex + 1, high, comparator);
        }
    }
    
    private int partition(int low, int high, Comparator<T> comparator) {
    	T pivot = elements.get(high);
    	int leftPointer = low;
    	int rightPointer = high - 1;
    	
    	while (leftPointer <= rightPointer) {
    		while (leftPointer <= rightPointer && comparator.compare(elements.get(leftPointer), pivot) < 0) {
    			leftPointer++;
    		}
    		while (leftPointer <= rightPointer && comparator.compare(elements.get(rightPointer), pivot) > 0) {
    			rightPointer--;
    		}
    		if (leftPointer <= rightPointer) {
    			Collections.swap(elements, leftPointer, rightPointer);
    			leftPointer++;
    			rightPointer--;
    		}
    	}
    	Collections.swap(elements, leftPointer, high);
    	return leftPointer;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}
