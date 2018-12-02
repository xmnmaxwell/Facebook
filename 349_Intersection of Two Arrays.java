Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for (int i = 0; i< nums1.length; i++){
            set.add(nums1[i]);//放入时候去掉重复的
        }
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] res = new int[result.size()];
        //Iterator迭代器
		//1、获取迭代器
		Iterator iter = result.iterator();
        int i = 0;
		//2、通过循环迭代
		//hasNext():判断是否存在下一个元素
		while(iter.hasNext()){
			//如果存在，则调用next实现迭代
			//Object-->Integer-->int
			res[i++] = (int)iter.next();  //把Object型强转成int型
		}

        return res;
    }
