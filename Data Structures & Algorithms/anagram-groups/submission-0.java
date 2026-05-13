class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
       for ( String str : strs){
        int[] freq = new int[26];
        char[] chars = str.toCharArray();
        for (int c : chars){
            freq[c - 'a']++;
        }

        StringBuilder key = new StringBuilder();
        for ( int i : freq){
            key.append('#').append(i);
        }
        map.putIfAbsent(key.toString(), new ArrayList<>());
        map.get(key.toString()).add(str);
       }

       return new ArrayList<>(map.values());
    }
}
