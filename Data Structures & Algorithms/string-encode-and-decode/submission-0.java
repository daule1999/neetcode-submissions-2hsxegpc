class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder enc = new StringBuilder();
        for(String str:strs){
            enc.append(str.length()).append('#').append(str);
        }
        System.out.println(enc.toString());
        return enc.toString();
    }//5#Hello5#World

    public List<String> decode(String str) {
        List<String> res= new ArrayList<>();
        if(str.isEmpty()) return res;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int delIndex = str.indexOf('#',i);
            int length = Integer.parseInt(str.substring(i, delIndex));
            i = delIndex + 1;
            res.add(str.substring(i, i + length));
            i += length;
        }
        return res;
    }
}
