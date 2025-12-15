class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();
       for(String token: tokens){
          if(token.equals("+") || token.equals("-") ||
          token.equals("*") || token.equals("/")){
            int b = stack.pop();//second operand
            int a = stack.pop();//first operand
            switch(token){
            case "+":
              stack.push(a + b);
              break;
              case "-":
              stack.push(a - b);
              break;
              case "*":
              stack.push(a * b);
              break;
              case "/":
              stack.push(a / b);
              break;
          }
       } else{
          stack.push(Integer.parseInt(token));
        }
       }
       return stack.pop();
    }
}