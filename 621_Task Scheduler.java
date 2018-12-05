621. Task Scheduler
/*
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*/
这道题要求的是相同两个任务必须间隔n个任务
AAABBCC, n = 2
A--A--A,
AB-AB-A,
ABCABCA.  n(A)-1 = 2, 每个模块3个元素，最后在加25-24，因为只有A最多
-----------------------
AAABBBCC, n = 2
AB-AB-AB,
ABCABCAB, n(AB)-1 = 2, 每个模块3个元素，最后再加25-23，因为有AB两个最多
所以公式是=(最多任务的-1)*(n+1) + 25 - 有多少个任务最多的
但是有一种情况就是在这种情况都满足的情况下，还有一些没有分配
比如AAABBCCD，D放哪都可以但最大值并不是上个公式，所以取和整个task的长度的最大值
O(n)
public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (int i = 0; i < tasks.length; i++){
            c[tasks[i]-'A']++; // calculate frequency of every task
        }
        Arrays.sort(c); //sort
        int i = 25; 
        while (i>=0 && c[i] == c[25]){
            i--; //find how many tasks have largest frequency
        }
        return Math.max(tasks.length, (c[25]-1)*(n+1)+25-i);
    }
**************************************************************************************
变种
public class TaskSchedulerFixedOrder {

    // Original: HashMap O(n) O(n)
    private int withHashMap(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            map.put(task, ans);
        }
        return ans;
    }

    private class Task {
        int name, time;
        public Task(int name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    // Follow up: Queue O(kn) O(k)
    private int withQueue(int[] tasks, int cooldown) {
        int ans = 0;
        Queue<Task> queue = new LinkedList<Task>();
        for (int task : tasks) {
            ans ++;
            for (Task rec : queue) 
                if (rec.name == task) {
                    ans = rec.time + cooldown + 1;
                    break;
                }
            while (!queue.isEmpty() && queue.peek().time < ans - cooldown)
                queue.poll();
            queue.add(new Task(task, ans));
        }
        return ans;
    }

    // Follow up: HashMap O(kn) O(k)
    private int withHashMapSizeK(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            List<Integer> garbage = new ArrayList<Integer>();
            for (int key : map.keySet())
                if (map.get(key) < ans - cooldown)
                    garbage.add(key);
            for (int key : garbage)
                map.remove(key);
            map.put(task, ans);
        }
        return ans;
    }

    // Follow up: Queue + HashMap O(n) O(k)
    private int withQueueAndMap(int[] tasks, int cooldown) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            while (!queue.isEmpty() && map.get(queue.peek()) < ans - cooldown)
                map.remove(queue.poll());
            map.put(task, ans);
            queue.add(task);
        }
        return ans;
    }

    public static void main(String[] args) {
        TaskSchedulerFixedOrder sol = new TaskSchedulerFixedOrder();
        // int[] tasks = {1, 1, 2, 3, 3, 1};
        // int[] tasks = {1, 1, 2, 1, 3, 1, 1};
        int[] tasks = {1, 1, 2, 3, 4, 1, 4, 3, 1, 3, 1};
        System.out.println(sol.withQueueAndMap(tasks, 2));
    }
}
