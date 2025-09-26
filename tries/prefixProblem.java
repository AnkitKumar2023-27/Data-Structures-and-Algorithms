public class prefixProblem {

    public static  class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;
        Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            };
            freq=1;

        }
 }
        public static Node root=new Node();
        


         
        public static void insert(String word){
             Node curr=root;
         for (int i=0;i<word.length();i++){
             int idx=word.charAt(i)-'a';
             if(curr.children[idx]==null){
                curr.children[idx]=new Node();
             }else{
                curr.children[idx].freq++;
             }

             curr=curr.children[idx];
         }
        curr. eow=true;


        }
   public static void prefix(String word){
             Node curr=root;
         for (int i=0;i<word.length();i++){
             int idx=word.charAt(i)-'a';
             if(curr.children[idx]==null){
                return;
             } 
                if(curr.children[idx].freq==1){
                    System.out.println(word.substring(0, i+1));
                    return;
                    
                
             }

             curr=curr.children[idx];
         }
    }


       

    public static void main(String[] args) {
     String word[]={"zebra","dog","duck","dove"  };
     for(int i=0;i<word.length;i++){
        insert(word[i]); 
        prefix(word[i]);
     }
  
}
}