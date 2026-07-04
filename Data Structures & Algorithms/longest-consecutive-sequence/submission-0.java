class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            min= Math.min(min, nums[i]);
            max= Math.max(max, nums[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(map.containsKey(curr)) continue;
            if(!set.contains(curr)) continue;
            int start = curr; int end = curr;
            set.remove(curr);
            while(start > min && set.contains(start-1)){
                if(set.contains(start-1)){
                    set.remove(start-1);
                    start=start-1;
                }
            }
            while(end<max && set.contains(end+1)){
                if(set.contains(end+1)){
                    set.remove(end+1);
                    end=end+1;
                }
            }
            map.put(start, end);
        }
        int maxRes =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int currLen=entry.getValue()-entry.getKey()+1;
            maxRes = Math.max(maxRes, currLen);
        }
        return maxRes;
        
    }
}
