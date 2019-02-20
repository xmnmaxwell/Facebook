380/f381. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

import java.util.Random;
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> num2index;
    Random rand;

    public RandomizedSet() {
        // do initialize if necessary 
        nums = new ArrayList<Integer>();
        num2index = new HashMap<Integer, Integer>();  
        rand = new Random();
    }    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        if (num2index.containsKey(val)) {
            return false;
        }     
        num2index.put(val, nums.size());
        nums.add(val);
        return true;
    }
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        if (!num2index.containsKey(val)) {
            return false; 
        } 
        int index = num2index.get(val);
        if (index < nums.size() - 1) { // not the last one than swap the last one with this val
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            num2index.put(last, index);
        }
        num2index.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    // Get a random element from the set
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

duplicate
class NumberAndIndex {
    public int number, index;
    public NumberAndIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

public class RandomizedCollection {
    // pair.number is the number, pair.index is the index in map value
    private List<NumberAndIndex> nums;
    // key is the number, value if the indices list in nums;
    private Map<Integer, List<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);
        
        if (!existed) {
            map.put(val, new ArrayList<Integer>());
        }
        List<Integer> indices = map.get(val);
        indices.add(nums.size());
        nums.add(new NumberAndIndex(val, indices.size() - 1));

        return !existed;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
    
        List<Integer> indices = map.get(val);
        int index = indices.get(indices.size() - 1);
        
        NumberAndIndex numIndex = nums.get(nums.size() - 1);
        nums.set(index, numIndex);
        nums.remove(nums.size() - 1);
        map.get(numIndex.number).set(numIndex.index, index);
        
        indices.remove(indices.size() - 1);
        if (indices.size() == 0) {
            map.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index).number;
    }
}
