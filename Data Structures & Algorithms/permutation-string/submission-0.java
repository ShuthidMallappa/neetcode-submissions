class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq= new int[26];
        int[] freq2 = new int[26];
        for (int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int windowSize = s1.length();

        for (int i =0; i<s2.length(); i++){
            freq2[s2.charAt(i) - 'a']++;

            if(i>=windowSize){
                freq2[s2.charAt(i - windowSize) - 'a']--;
            }

            if(matches(freq, freq2)){
                return true;
            }
        }
        return false;
    }

    public static boolean matches(int[] arr1, int[] arr2){
        for (int i =0; i<26; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
