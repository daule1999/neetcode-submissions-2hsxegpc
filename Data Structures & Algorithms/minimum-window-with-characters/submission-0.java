
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i); 
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0; // Track start index instead of slicing strings repeatedly
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) count--;
            }

            // Shrink the window as long as it contains all characters of t
            while (count == 0 && left <= right) {
                // Update minimum details efficiently
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char lch = s.charAt(left);
                
                if (map.containsKey(lch)) {
                    // Put it back into the map because it's leaving the window
                    map.put(lch, map.get(lch) + 1);
                    // If it goes above 0, it means we no longer have enough of this character
                    if (map.get(lch) > 0) {
                        count++;
                    }
                }
                left++; // Move left pointer
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}