class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int supp = target - nums[i];
            if(map.containsKey(supp)){
                int[] res = new int[2];
                res[0]=map.get(supp);
                res[1]=i;
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
