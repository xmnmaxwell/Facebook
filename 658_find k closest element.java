f658. Find K Closest elements 找k个距离target更近的数(sorted array)
O(logn) + O(k)
Input: [1,2,3,4,5], k=4, x=3  12456
Output: [1,2,3,4]

 public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) return res;
        
        // find target position
        int start = 0, end = arr.length - 1;
        while (start  < end){
            int mid = start + (end - start)/2;
            if (x == arr[mid]){
                end = mid; 
                break;
            } else if (x < arr[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
         }    
        
         // get k numbers
        start = end;
        end++;
            while (k > 0){
                if ( end >= arr.length || (start >=0 && x-arr[start] <= arr[end] - x)){
                    start--;// end 超界， start距离x距离较小
                } else {
                    end++;
                }
                k--;//找k个这样的数
            }
            
            for (int i = start + 1; i < end; i++){
                res.add(arr[i]);
            }
            
         return res;    
       
    }   
