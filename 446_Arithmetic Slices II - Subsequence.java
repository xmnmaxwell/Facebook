446. Arithmetic Slices II - Subsequence 找所有等差数列全排列的数量,序列个数最小为3
O(n^2) DP
Input: [2, 4, 6, 8, 10]
Output: 7
/*
1. res is the final count of all valid arithmetic subsequence slices; map will store the intermediate results T(i, d), 
with i indexed into the array and d as the key of the corresponding HashMap.
2. For each index i, we find the total number of "generalized" arithmetic subsequence slices ending at it with all possible differences. 
This is done by attaching A[i] to all slices of T(j, d) with j less than i.
3. Within the inner loop, we first use a long variable diff to filter out invalid cases, 
then get the counts of all valid slices (with element >= 3) as c2 and add it to the final count. 
At last we update the count of all "generalized" slices for T(i, d) by adding the three parts together: 
the original value of T(i, d), which is c1 here, the counts from T(j, d), which is c2 and lastly the 1 count of the "two-element" slice (A[j], A[i]).
*/
public int numberOfArithmeticSlices(int[] A) {
    int res = 0;
    Map<Integer, Integer>[] map = new Map[A.length];
	// key is the index of a certain element
    for (int i = 0; i < A.length; i++) {
        map[i] = new HashMap<>(i);
        	
        for (int j = 0; j < i; j++) {
            long diff = (long)A[i] - A[j];
            if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
        		
            int d = (int)diff;
            int c1 = map[i].getOrDefault(d, 0);
            int c2 = map[j].getOrDefault(d, 0);
            res += c2;
            map[i].put(d, c1 + c2 + 1);
        }
    }
		
    return res;
}
