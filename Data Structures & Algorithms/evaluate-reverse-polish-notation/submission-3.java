class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operator = "+-*/";
        for(String str : tokens){
            if(operator.indexOf(str) != -1){
                int d2 = stack.pop();
                int d1 = stack.pop();
                int res = 0;
                if(str.equals("+")){
                    res = d2+d1;
                } else if(str.equals("-")){
                    res = d1 - d2;
                } else if(str.equals("*")){
                    res = d2 * d1;
                } else if(str.equals("/")){
                    res = d1/d2;
                }

                stack.push(res);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
