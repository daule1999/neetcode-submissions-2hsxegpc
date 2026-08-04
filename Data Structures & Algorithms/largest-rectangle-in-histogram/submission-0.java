class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> inSt =new Stack<>();
        int maxRectangleArea = 0;
        for(int i=0;i<=n;i++){
            int currentHeight = (i == n) ? 0 : arr[i];
            while(!inSt.isEmpty() && arr[inSt.peek()] > currentHeight){
                int lastHeight = arr[inSt.pop()];
                int lastRight = i-1;
                int lastLeft = inSt.isEmpty()?0:(inSt.peek()+1);
                int area= lastHeight * (lastRight-lastLeft+1);
                maxRectangleArea=Math.max(maxRectangleArea, area);
            }
            inSt.push(i);
        }
        return maxRectangleArea;
    }
}
