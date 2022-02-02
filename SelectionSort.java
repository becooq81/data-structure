
public class SelectionSort<E> {
	E[] arr;
	public void selectsort(E[] arr) {
		this.arr = arr;
		int min;
		for (int i = 0; i< arr.length; i++) {
			min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (((Comparable<E>) arr[j]).compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			swap(i, min);
		}
	}
	public void swap(int from, int to) {
		E temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	public static void main(String[] args) {
		Integer[] arr = {3, 1, 5, 2, 7, 10, 6};
		System.out.print("Original array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Original array: 3 1 5 2 7 10 6 
		System.out.println();
		SelectionSort sort = new SelectionSort();
		sort.selectsort(arr);
		System.out.print("Sorted array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Sorted array: 1 2 3 5 6 7 10 
	}
}
