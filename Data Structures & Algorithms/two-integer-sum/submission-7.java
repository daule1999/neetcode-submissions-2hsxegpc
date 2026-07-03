class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int aux = target - num;
            if(map.containsKey(aux)){
                return new int[]{map.get(aux), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
