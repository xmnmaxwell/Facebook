DFS//
O(V+E) O(V+E)
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();//key是老图，value是新图
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);// 说明该点已经扫过，返回new node.
        
        map.put(node, new UndirectedGraphNode(node.label));//if it does not contain node.将label放在新图里
        List<UndirectedGraphNode> list = node.neighbors;// 建一个新的list存放图的neighbour
        for (UndirectedGraphNode nb : list)//遍历neighbour
            map.get(node).neighbors.add(cloneGraph(nb));//map.get(node).neighbors是指新图的neigbour指针
        return map.get(node);
    }
}
******************************************************************************
