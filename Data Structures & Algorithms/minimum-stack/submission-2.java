class MinStack {

Stack<Integer> mainstack ;
Stack<Integer> minStack;
    public MinStack() {
       mainstack= new Stack<>();
       minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainstack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
       int removed = mainstack.pop();
       if(removed==minStack.peek()){
        minStack.pop();
       }
    }
    
    public int top() {
       return mainstack.peek();
    }
    
    public int getMin() {
       
        return minStack.peek();
    }
}
