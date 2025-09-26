public class Tries {
    public static class Node{
        Node childern[];
        boolean eow;
        public Node(){
            childern=new Node[26];
            for(int i=0;i<26;i++){
                childern[i]=null;
            }
        }
       
    }
   public static  Node root=new Node();
public static void insert(String word){
     Node curr=root;
     for(int i=0;i<word.length();i++){
         int idx=word.charAt(i)-'a';
         if(curr.childern[idx]==null){
            curr.childern[idx]=new Node();
            }
             curr=curr.childern[idx];
     }
     curr.eow=true;
    

    }
    public static boolean search(String word){
     Node curr=root;
     for(int i=0;i<word.length();i++){
         int idx=word.charAt(i)-'a';
         if(curr.childern[idx]==null){
            return false;
            
           

         }else{
             curr=curr.childern[idx];
         }
     }
        if(curr.eow==true ){
            System.out.println(word +" ");
        }
       return curr.eow==true;
        

    }
   
//   find the word using treis//
public static boolean wordBreak(String Word){
    if(Word.length()==0){
        return true;
    }
    for( int i=0;i<=Word.length();i++){
        if(search(Word.substring(0,i))&&wordBreak(Word.substring(i))){
            return true;
        }
        
 
     }
 return false;
     
   
}

//  ?????????????????????Word break Problem??????????
    public static class Node2{
        Node2 child[];
        boolean eow;
        int freq=0;
        public Node2(){
            Tries.Node2[] child= new Node2[26];
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
       
    }

 public static  Node2 root2=new Node2();
public static void insert2(String word){
     Node2 curr=root2;
     for(int i=0;i<word.length();i++){
         int idx=word.charAt(i)-'a';
         if(curr.child[idx]==null){
            curr.child[idx]=new Node2();
            }else{
                curr.child[idx].freq++; 
            }
            curr=curr.child[idx];
         }
         curr.eow=true;
     
    
    }
//    public static Node2 root=new Node2();
  public static void freq(String word){
    Node2 curr=root2;
    for( int i=0;i<word.length();i++){
        int idx=word.charAt(i)-'a';
        if(curr.child[idx]==null){
            return;

        }
       if(curr.child[idx].freq==1){
        System.out.print(" "+word.substring(0, i+1));
        return;
       }
       curr=curr.child[idx];

    }
     
  }  

// public static class Node3{
//      Node3 child3[]=new Node3[26];
//      int cw;
//      int cp;
//      boolean eow;
//      Node3( ){
//         for(int i =0;i<26;i++){
//             child3[i]=null;

//         }
        
//      }
// }
// public static Node3 root3=new Node3();
// public static void insert3(String  word) {
//     Node3 curr=root3;
//     for( int i=0;i<word.length();i++){
//        int  idx=word.charAt(i)-'a';
//         if(curr.child3[i]==null){
//             curr.child3[idx]=new Node3();
//         }else{
//             curr=curr.child3[idx];
//             curr.cp++;
            
//         }
//      }
//      curr.eow=true;
//      curr.cw++;
      
//     }
// public static int totalword(String word){
//       Node3 curr=root3;
      
//       for(int i=0;i<word.length();i++){
//         int  idx=word.charAt(i)-'a';
        
//         if(curr.cp==)
//       }
    
// }


public static void main(String[] args) {
    String words[]={"the","a","there","their","are"};
     for( int i=0;i<words.length;i++){
        insert(words[i]);
    
     }
      System.out.println(search("there"));
      System.out.println();
         String words2[]={"i","sam","samsung","mobaile","like"};
     for( int i=0;i<words.length;i++){
        insert(words2[i]);
    
     }

     System.out.println();
     System.out.println( "here Is the final result  => " +wordBreak("ilikesamsung"));
     System.out.println();
     
    String words3[]={"zebra","dog","duck","dove","are"};
     for( int i=0;i<words.length;i++){
        insert2(words3[i]);
        
    
     }
       for( int i=0;i<words.length;i++){
        freq(words3[i]);
        
    
     }
}
    
}
