class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key = getKey(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public String getKey(String str){
        int n=27;
        int[] map = new int[n];
        for(int i=0;i<str.length();i++){
            map[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(Character.toString((char)(i+'a'))).append(map[i]);
        }
        return sb.toString();
    }
}
