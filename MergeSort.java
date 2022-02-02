
public class MergeSort {
	int[] arr, temp;
	public void mergesort(int[] arr) {
		this.arr = arr;
		temp = new int[arr.length];
		split(0, arr.length-1);
	}
	public void split(int low, int high) {
		if (low == high)
			return;
		int mid = (low + high)/2;
		split(low, mid);
		split(mid+1, high);
		merge(low, mid, high);
	}
	public void merge(int low, int mid, int high) {
		int i = low, j = mid+1, idx = low;
		while ((i <= mid) && (j <= high)) {
			if (arr[i] > arr[j]) 
				temp[idx++] = arr[j++];
			else
				temp[idx++] = arr[i++]; 
		}
		while (i <= mid) {
			temp[idx++] = arr[i++];
		}
		while (j <= high) {
			temp[idx++] = arr[j++];
		}
		for (idx = low; idx < high; idx++) {
			arr[idx] = temp[idx];
		}
	}
	public static void main(String[] args) {
		int[] arr = {5, 1, 3, 7, 4, 2, 10};
		System.out.print("Original array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Original array: 5 1 3 7 4 2 10
		System.out.println();
		
		MergeSort sort = new MergeSort();
		sort.mergesort(arr);
		System.out.print("Sorted array: ");
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" ");
		//Sorted array: 1 1 2 2 3 7 10 
	}
}
