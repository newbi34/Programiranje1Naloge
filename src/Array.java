import java.util.Arrays;
import java.lang.Math;

public class Array {

	public static void printarr(int[][] array) {
		System.out.println(
				Arrays.deepToString(array)
						.replace("], ", "]\n"));
	}

	public static int[][] randomize2DArray(int[][] array) {
		// Iterate through Array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {

				// Get a random double from 0 to 1
				// multiply it by 100 (0.5135 > 513.5)
				// cast as int (513.5 > 513)
				array[i][j] = (int) (Math.random() * 10);
			}
		}
		return array;
	}

	public static int[][] SortToSpiral(int[][] array) {
        int m = array.length;
        int k = array[0].length;
		
		int counter = 0;
		int[] array1D = new int[m*k];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<k; j++) {
				 array1D[counter] =  array[i][j];
				counter++;
			}
		}

		//sorts 1D array from lowest to higest
		for (int i = 1;  i < array1D.length;  i++) {
            int element = array1D[i];
            int j = i - 1;
            while (j >= 0 && array1D[j] > element) {
                array1D[j + 1] = array1D[j];
                j--;
            }
            array1D[j + 1] = element;
		}

		int smaller = 0;
		smaller = (m > k) ? k : m;

		counter = 0;
		int spiralCount = smaller / 2 + smaller % 2;
		for (int currentSpiral = 0; currentSpiral < spiralCount; currentSpiral++) {

			//number of movements is depanded on the current ring we are in (spiralCount) 
			//and a constant 1 or 2, so we arent changing the same index twice(corners)
			//loop describing every down movement in the array
			for (int movement = 0; movement < m - (2 * currentSpiral); movement++) {
				array[movement + currentSpiral][currentSpiral] = array1D[counter];
				counter++;
			}

			//loop describing every right movement in the array
			for (int movement = 0; movement < k - (2 * currentSpiral) - 1; movement++) {
				array[m - 1 - currentSpiral][movement + 1 + currentSpiral] = array1D[counter];
				counter++;
			}

			//loop describing every up movement in the array
			for (int movement = 0; movement < m - (2 * currentSpiral) - 1; movement++) {
				array[m - movement - 2 - currentSpiral][k - 1 - currentSpiral] = array1D[counter];
				counter++;
			}

			//loop describing every left movement in the array
			for (int movement = 0; movement < k - (2 * currentSpiral) - 2; movement++) {
				array[currentSpiral][k - movement - 2 - currentSpiral] = array1D[counter];
				counter++;
			}
		}

        return array;
    }

	public static void main(String[] args) throws Exception {

		int x = 3;
		int y = 3;

		int array[][] = new int[y][x];

		randomize2DArray(array);
		SortToSpiral(array);
		printarr(array);
	}
}