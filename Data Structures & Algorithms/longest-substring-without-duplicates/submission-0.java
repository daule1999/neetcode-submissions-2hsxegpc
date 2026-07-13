class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0; // Left pointer
        int j = 0; // Right pointer
        
        // Use a HashSet since we only care about tracking unique characters
        HashSet<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // If character is unique, expand the window to the right
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                // If it's a duplicate, shrink the window from the left 
                // until the duplicate character is removed
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
