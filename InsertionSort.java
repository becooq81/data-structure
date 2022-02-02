
public class InsertionSort<E> {
	E[] arr;
	public void insertSort(E[] arr) {
		this.arr = arr;
		for (int i = 1; i < arr.length; i++) {
			int j;
			E v = arr[i];
			for (j = i-1; j >= 0; j--) {
				if (((Comparable<E>) arr[j]).compareTo(v) < 0) {
					break;
				}
				arr[j+1] = arr[j];
			}
			arr[j+1] = v;
		}
	}
	public static void main(String[] args) {
		String[] arr = {"Apple", "Hello", "I'm", "Bear", "Hi", "Jinny"};
		System.out.print("Original array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Original array: Apple Hello I'm Bear Hi Jinny 
		
		System.out.println();
		InsertionSort sort = new InsertionSort();
		sort.insertSort(arr);
		System.out.print("Sorted array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Sorted array: Apple Bear Hello Hi I'm Jinny 
	}
}
