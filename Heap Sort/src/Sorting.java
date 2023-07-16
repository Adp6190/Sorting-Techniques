
public class Sorting {
	public class SortingAlgo {
		private void Merge(int[] arr,
				int startPos1, int endPos1, int startPos2, int endPos2) {
			System.out.println("Merge(" + startPos1 + ", " + endPos1 + ", "
					+ startPos2 + ", " + endPos2 + ")");
			int[] mergedArray = new int[endPos1 - startPos1 + 1 + endPos2 - startPos2 + 1];
			int i1 = startPos1;
			int i2 = startPos2;
			int r = 0;

			while ((i1 <= endPos1) && (i2 <= endPos2)) {
				if (arr[i1] < arr[i2]) {
					mergedArray[r] = arr[i1];
					++i1;
				}
				else {
					mergedArray[r] = arr[i2];
					++i2;
				}
				++r;
			}

			while (i1 <= endPos1) {
				mergedArray[r] = arr[i1];
				++i1;
				++r;
			}
			while (i2 <= endPos2) {
				mergedArray[r] = arr[i2];
				++i2;
				++r;
			}

			int i = startPos1;
			int j = 0;
			while (j < r) {
				arr[i] = mergedArray[j];
				++i;
				++j;
			}
		}
		
		private void MergeSort(int[] arr, int startPos, int endPos) {
			System.out.println("MergeSort(" + startPos + ", " + endPos + ")");

			if ((endPos - startPos + 1) <= 1)
				return;

			int middlePos = (startPos + endPos) / 2;

			MergeSort(arr, startPos, middlePos);
			MergeSort(arr, middlePos + 1, endPos);

			Merge(arr, startPos, middlePos, middlePos + 1, endPos);
		}

		public void MergeSort(int[] arr) {
			MergeSort(arr, 0, arr.length - 1);
		}

		private void MakeMaxHeap(int[] arr, int parent, int n) {
			int maxChildPos = parent * 2 + 1;
			int rightChildPos = parent * 2 + 2;

			if (rightChildPos < n) {
				if (arr[rightChildPos] > arr[maxChildPos])
					maxChildPos = rightChildPos;
			}

			if (arr[parent] > arr[maxChildPos])
				return;

			int t = arr[parent];
			arr[parent] = arr[maxChildPos];
			arr[maxChildPos] = t;

			// Is maxChildPos a leaf node?
			if (!((maxChildPos * 2 + 1) < n))
				return;

			MakeMaxHeap(arr, maxChildPos, n);
		}

		private void ConvertToMaxHeap(int[] arr, int n) {
			int lastParent = (n / 2) - 1;
			while (lastParent  >= 0) {
				MakeMaxHeap(arr, lastParent, n);
				--lastParent;
			}
		}

		public void HeapSort(int[] arr) {
			ConvertToMaxHeap(arr, arr.length);

			int lastChildPos = arr.length - 1;
			while (lastChildPos > 0) {
				// Swap root and lastChildPos values
				int t = arr[0];
				arr[0] = arr[lastChildPos];
				arr[lastChildPos] = t;

				if (lastChildPos > 1)
					MakeMaxHeap(arr, 0, lastChildPos);

				--lastChildPos;
			}
		}
	}

	

}
