
public class QuickSort<E> {
	E[] arr;
	public E[] sort(E[] arr) {
		this.arr = arr;
		quicksort(0, arr.length-1);
		return arr;
	}
	public void swap(int from, int to) {
		E temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	public void quicksort(int from, int to) {
		if (from == to) return;
		E v = arr[to]; //pivot
		int counter = from; //pointer for the first element that is larger than the pivot
		for (int i = from; i < to; i++) {
			if (((Comparable<E>) arr[i]).compareTo(v) <= 0) {
				swap(i, counter);
				counter++;
			}
		}
		swap(counter, to); //bringing the pivot to its right place
		quicksort(from, counter-1);
		quicksort(counter, to);
	}
	public static void main(String[] args) {
		String[] arr = {"understand", "before", "car", "chicas", "hola", "aesthetics"};
		System.out.print("Original array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Original array: understand before car chicas hola aesthetics 
		
		System.out.println();
		InsertionSort sort = new InsertionSort();
		sort.insertSort(arr);
		System.out.print("Sorted array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Sorted array: aesthetics before car chicas hola understand 
	}
}
