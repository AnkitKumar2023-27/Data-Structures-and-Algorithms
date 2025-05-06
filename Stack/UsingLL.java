import java.util.ArrayList;

public class UsingLL{

    static class Stack{
       static  ArrayList<Integer>list=new ArrayList<Integer>();
        public static boolean isEmpty(){
            return list.size()==0;
            
        }
        public static void push(int data){
            list.add(data);
        };
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
             int top =list.get(list.size()-1);
             list.remove(list.size()-1);
             return top;
        };
       public static int peek(){
        return list.get(list.size()-1);
       } 

    }




public static void main(String[] args) {
    Stack s=new Stack();
    s.push(5);
    s.push(6);
    s.push(7);
    while (!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
        
    }
}

}