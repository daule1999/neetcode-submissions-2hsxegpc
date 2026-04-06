class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result= new ArrayList<>();
        for(String str: strs){
            String key = getKey(str);
            if(map.containsKey(key)){
                List<String> list=map.get(key);
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public String getKey(String str){
        char[] charList = new char[128];
        for(char ch: str.toCharArray()){
            charList[ch]++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:charList){
            sb.append(Character.toString(ch));
        }
        return sb.toString();
    }
}
