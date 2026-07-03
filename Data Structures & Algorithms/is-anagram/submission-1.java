class Solution {
    public boolean isAnagram(String s, String t) {
        int n = 27;
        int[] charSet = new int[n];
        for(int i=0;i<s.length();i++){
            charSet[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            charSet[t.charAt(i)-'a']--;
        }
        for(int i=0;i<n;i++){
            if(charSet[i]!=0){
                return false;
            }
        }
        return true;
    }
}
