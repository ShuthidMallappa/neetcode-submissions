class Solution {
    public static String[] keyPad= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null || digits.length()<1){
            return res;
        }
        
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

   public static void backtrack(List<String> res, StringBuilder current, String digits,int index){
        if(index == digits.length()){
            res.add(current.toString());
            return;
        }

        String letter = keyPad[digits.charAt(index) - '0'];
        for (int i =0; i<letter.length(); i++){
            char ch = letter.charAt(i);
            current.append(ch);
            backtrack(res, current, digits, index+1);
            current.deleteCharAt(current.length() - 1);
        }

    }
}
