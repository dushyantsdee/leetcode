// Solution class: Longest Substring Without Repeating Characters solve karega
class Solution {
    // Method: lengthOfLongestSubstring
    // Input: String s
    // Output: int (length of longest substring without repeating chars)
    public int lengthOfLongestSubstring(String s) {
        // HashMap: character aur uska last seen index store karega
        // Key: character, Value: index
        java.util.HashMap<Character, Integer> charIndex = new java.util.HashMap<>();
        
        // Left pointer: sliding window ka starting point
        int left = 0;
        
        // maxLength: sabse badi substring ka length
        int maxLength = 0;
        
        // Right pointer: sliding window ko expand karne ke liye
        // String ke har character par loop chalao
        for (int right = 0; right < s.length(); right++) {
            // Current character nikalo
            char currentChar = s.charAt(right);
            
            // Check karo ki yeh character pehle se map mein hai ya nahi
            // Aur yeh left se aage hai ya nahi (important!)
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                // Agar repeat character mila:
                // left pointer ko aage badhao (previous occurrence ke aage)
                // Example: "abca" mein 'a' repeat hai, left ko move karo
                left = charIndex.get(currentChar) + 1;
            }
            
            // Current character ka index map mein store karo
            charIndex.put(currentChar, right);
            
            // Current window ka length calculate karo
            // right - left + 1
            // Example: left=0, right=2 = 3 characters (0,1,2)
            int currentLength = right - left + 1;
            
            // Agar current length zyada hai toh maxLength update karo
            maxLength = Math.max(maxLength, currentLength);
        }
        
        // Sabse badi length return karo
        return maxLength;
    }
}

// Main class: test cases run karega
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: "abcabcbb"
        // 'a' -> 'b' -> 'c' -> 'a' repeat (left move karo)
        // Window: "abc" = 3
        String test1 = "abcabcbb";
        int result1 = solution.lengthOfLongestSubstring(test1);
        System.out.println("Example 1: \"" + test1 + "\" -> " + result1);
        
        // Test Case 2: "bbbbb"
        // Sirf 'b' repeat karta hai, max length = 1
        String test2 = "bbbbb";
        int result2 = solution.lengthOfLongestSubstring(test2);
        System.out.println("Example 2: \"" + test2 + "\" -> " + result2);
        
        // Test Case 3: "pwwkew"
        // "pw" -> "wk" -> "wke" = 3
        String test3 = "pwwkew";
        int result3 = solution.lengthOfLongestSubstring(test3);
        System.out.println("Example 3: \"" + test3 + "\" -> " + result3);
        
        // Test Case 4: "au"
        // Koi repeat nahi, pura string "au" = 2
        String test4 = "au";
        int result4 = solution.lengthOfLongestSubstring(test4);
        System.out.println("Example 4: \"" + test4 + "\" -> " + result4);
        
        // Test Case 5: "dvdf"
        // "dv" -> "vdf" (d repeat, left move karo) = 3
        String test5 = "dvdf";
        int result5 = solution.lengthOfLongestSubstring(test5);
        System.out.println("Example 5: \"" + test5 + "\" -> " + result5);
        
        // Test Case 6: "" (empty string)
        String test6 = "";
        int result6 = solution.lengthOfLongestSubstring(test6);
        System.out.println("Example 6: \"" + test6 + "\" -> " + result6);
    }
}