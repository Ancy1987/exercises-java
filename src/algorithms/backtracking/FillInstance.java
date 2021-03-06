/*
 * Fill two instances of all numbers from 1 to n in a specific way
 * 
 * Given a number n, create an array of size 2n such that the array contains 2 instances of every number from 1 to n, and the number of elements between two instances of a number i is equal to i. If such a configuration is not possible, then print the same.

*/
/*Examples: 
 

Input: n = 3
Output: res[] = {3, 1, 2, 1, 3, 2}

Input: n = 2
Output: Not Possible

Input: n = 4
Output: res[] = {4, 1, 3, 1, 2, 4, 3, 2}
 */

//A backtracking Approach

package algorithms.backtracking;

class FillInstance {

	// A recursive utility function to fill
	// two instances of numbers from 1 to n
	// in res[0..2n-1]. 'curr' is current value of n.
	static boolean fillUtil(int res[], int curr, int n) {
		// If current number becomes 0,
		// then all numbers are filled
		if (curr == 0)
			return true;

		// Try placing two instances of 'curr' at
		// all possible locations till solution is found
		int i;
		for (i = 0; i < 2 * n - curr - 1; i++) {
			// Two 'curr' should be placed at
			// 'curr+1' distance
			if (res[i] == 0 && res[i + curr + 1] == 0) {

				// Plave two instances of 'curr'
				res[i] = res[i + curr + 1] = curr;

				// Recur to check if the above placement
				// leads to a solution
				if (fillUtil(res, curr - 1, n))
					return true;

				// If solution is not possible,
				// then backtrack
				res[i] = res[i + curr + 1] = 0;
			}
		}
		return false;
	}

	// This function prints the result for
	// input number 'n' using fillUtil()
	static void fill(int n) {
		// Create an array of size 2n and
		// initialize all elements in it as 0
		int res[] = new int[2 * n];
		int i;
		for (i = 0; i < 2 * n; i++)
			res[i] = 0;

		// If solution is possible,
		// then print it.
		if (fillUtil(res, n, n)) {
			for (i = 0; i < 2 * n; i++)
				System.out.print(res[i] + " ");
		} else
			System.out.print("Not Possible");
	}

	// Driver Code
	public static void main(String[] args) {
		fill(7);
	}
}

// This code is contributed by ajit