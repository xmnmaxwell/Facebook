49. group anagram 给一组单词然后把是anagram的放在同一组
mnlog(n)
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // create key anagram and value is the new list of strings
        for (int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);// sort chars to make every anagram look the sam
            if(!map.containsKey(String.valueOf(chars))) 
            // if does not contain in the map, create a new list
            	map.put(String.valueOf(chars), new ArrayList<String>());
            map.get(String.valueOf(chars)).add(strs[i]);// add the string in the list
        }
        return new ArrayList<List<String>>(map.values());
    }
/* alternative
O(mn)
public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			String key = charFreq(strs[i]);
			List<String> values = map.get(key);
			if(values != null) values.add(strs[i]);
			else {
				values = new ArrayList<>();
				values.add(strs[i]);
				map.put(key, values);
			}
		}
		for(String key : map.keySet()) {
			results.add(map.get(key));
		}
		return results;
    }

	    private static String charFreq(String str) {
		int[] freqs = new int[26];
		StringBuilder key = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			freqs[str.charAt(i) - 'a']++;
		}
		for(int i = 0; i < freqs.length; i++) {
			key.append(Integer.toString(freqs[i]));
		}
		return key.toString();
	}
