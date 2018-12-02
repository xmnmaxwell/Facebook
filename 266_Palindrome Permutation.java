266. Palindrome Permutation 给一个单词判断他的某一个组合是回文串
O(n)
Input: "aab" 的某一个组合aba是回文串
Output: true
 public boolean canPermutePalindrome(String s) {
       Set<Character> set = new HashSet<>();// create a set
        for (char c : s.toCharArray()){
            if (!set.contains(c)){// if it did not contain c add it
                set.add(c);
            } else {
                set.remove(c);// if it contains remove it
            }
        }
        
        return set.size() == 0 || set.size() == 1;
    }
