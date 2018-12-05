class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }    
}
************************************************************************************
String permutation
public class StringPermutation {

    public List<String> permutation(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        List<String> ans = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        helper(0, new StringBuilder(), letters, used, ans);
        return ans;
    }

    private void helper(int index, StringBuilder sb, char[] letters, Set<Integer> used, List<String> ans) {
        if (index == letters.length) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < letters.length; i ++) {
            if (used.contains(i)) continue;
            if (i > 0 && letters[i] == letters[i - 1] & !used.contains(i - 1)) continue;

            used.add(i);    sb.append(letters[i]);
            helper(index + 1, sb, letters, used, ans);
            used.remove(i); sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        StringPermutation sol = new StringPermutation();
        String input = "cbaa";
        List<String> ans = sol.permutation(input);
        for (String s : ans)
            System.out.println(s);
    }
}
