class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero=0; int n = nums.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0) zero++;
        }
        if(zero == 0){
            int product =1;
            for(int i=0;i<n;i++){
                product*=nums[i];
            }
            for(int i=0;i<n;i++){
                res[i]=product/nums[i];
            }
        }else if(zero == 1){
            int product =1; int zeroIndex=-1;
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    zeroIndex=i;
                }else{
                    product*=nums[i];
                }
            }
            for(int i=0;i<n;i++){
                res[i]=0;
            }
            res[zeroIndex] = product;
        }else{
            for(int i=0;i<n;i++){
                res[i]=0;
            }
        }
        return res;
    }
}  
