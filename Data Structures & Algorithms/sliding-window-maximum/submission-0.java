
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // Index for result array
        
        // Store indices of elements
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window bounds
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            
            // 2. Remove elements from the back that are smaller than the current element
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            
            // Add current element's index to the back of the queue
            q.offerLast(i);
            
            // 3. If the window has reached size k, append the max to the result
            if (i >= k - 1) {
                result[ri++] = nums[q.peekFirst()];
            }
        }
        
        return result;
    }
}