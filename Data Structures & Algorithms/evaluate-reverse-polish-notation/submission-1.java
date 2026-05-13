class Solution {
    public int evalRPN(String[] tokens) {
    
        Stack<Integer> ans= new Stack<>();
       
        for(String token : tokens){
            if(checkOperator(token)){
                int num2 = ans.pop();
                int num1 = ans.pop();
                 int result=0;
                switch(token){
                    case "+" :
                    result = num1 + num2;
                    break;
                    case "-" :
                    result = num1 - num2;
                    break;
                    case "*" :
                    result = num1 * num2;
                    break;
                    case "/":
                    result = num1 / num2;
                    break;
                }
                ans.push(result);
            } else {
                ans.push(Integer.parseInt(token));
                
            }

        }
        return ans.pop();
    }
    public static boolean checkOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
            
             return false;
        }
       
    }

