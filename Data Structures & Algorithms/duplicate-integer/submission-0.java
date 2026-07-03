class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j!=i && nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}