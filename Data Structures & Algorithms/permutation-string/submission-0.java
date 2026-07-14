class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int s1count[] = new int[26];
        int s2count[] = new int[26];
        
        // Only count s1 frequencies
        for(int i = 0; i < s1.length(); i++){
            s1count[s1.charAt(i) - 'a']++;
        }
        
        int left = 0;
        // Let the loop handle incrementing 'right' naturally
        for(int right = 0; right < s2.length(); right++){
            // 1. Add the incoming right character
            s2count[s2.charAt(right) - 'a']++;
            
            // 2. If the window size exceeds s1's length, shrink it from the left
            if (right - left + 1 > s1.length()) {
                s2count[s2.charAt(left) - 'a']--;
                left++;
            }
            
            // 3. Check for a match only when the window is exactly the right size
            if (right - left + 1 == s1.length()) {
                if(matches(s1count, s2count)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}