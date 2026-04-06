class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b)->Integer.compare(b.count, a.count));
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            que.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            if(!que.isEmpty()){
                Pair p = que.poll();
                res[i]=p.num;
            }
        }
        return res;
    }
}
class Pair{
    int num;
    int count;
    Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
}
