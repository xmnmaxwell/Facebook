LC.211 add and search word- Trie data structure

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true

addWord - O(m) - m is the length of the new word
search - O(n) - n is the total number of characters in all words

class WordDictionary {
    class TrieNode {
        TrieNode[] children;// define children 26 possiblities, children也是node
        boolean isWord; // if this word is a word
        public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
        }
    }
    TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;// define a pointer
        for (int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null){
                node.children[c] = new TrieNode();//a 的字母一个个添加，如果children[c]不存在新建一个
            }
            node = node.children[c];//如果存在了，move node to its childern
        }
        node.isWord = true;//after 完成添加后，trie里是否有单词了标记为yes.
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {  //DFS search
        TrieNode node = root;
        return search(node, word);
    }
    private boolean search (TrieNode node, String word){
        if (node == null) return false;
        if (word.length() == 0) return node.isWord;
        // here we have two situations: first one if we meet "."
        if (word.charAt(0) == '.'){
            for (TrieNode child : node.children){// if it is a ., means it needs to seach all children and their subchildren
                if (search(child, word.substring(1))) return true;
            }
        } else {
            int c = word.charAt(0) - 'a'; //if it is not a ., we only search the certain char and its children.
            return search(node.children[c], word.substring(1));
        }
         return false;
    }
}
