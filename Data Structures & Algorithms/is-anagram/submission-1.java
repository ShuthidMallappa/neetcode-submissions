class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tArr = new int[26];

        for (char c : s.toCharArray()){
            tArr[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            tArr[c - 'a']--;
        }
        for (int c : tArr){
            if( c != 0){
                return false;
            }
        }

        return true;
    }
}
