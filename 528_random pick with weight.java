Given an array w of positive integers, where w[i] describes the weight of index i, 
write a function pickIndex which randomly picks an index in proportion to its weight.

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
************************************************************************************
class Solution {

    TreeMap<Integer, Integer> map;
    Random rand;
    
    public Solution(int[] w) {
        map = new TreeMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < w.length; i ++) {
            sum += w[i];
            map.put(sum, i);
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(map.lastKey());
        return map.higherEntry(target).getValue();
    }
}
