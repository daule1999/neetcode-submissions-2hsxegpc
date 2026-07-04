class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int first = 0; int last = numbers.length-1;
        while(first<last){
            int currSum = numbers[first]+numbers[last];
            if(currSum == target){
                res[0]=first+1;res[1]=last+1; return res;
            }else if(currSum > target){
                last--;
            }else{
                first++;
            }
        }
        return res;
    }
}
