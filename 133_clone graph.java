DFS//

public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();//key是老图，value是新图
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);// 说明node的信息和老图一模一样就返回node
        
        map.put(node, new UndirectedGraphNode(node.label));//将label放在新图里
        List<UndirectedGraphNode> list = node.neighbors;// 建一个新的list存放图的neighbour
        for (UndirectedGraphNode nb : list)
            map.get(node).neighbors.add(cloneGraph(nb));//将neighbour放进value里
        return map.get(node);
    }
}
******************************************************************************