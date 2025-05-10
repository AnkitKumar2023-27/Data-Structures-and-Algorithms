public  class TriesBasic {

     static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

         Node(){
            for(int i=0  ;i<26;i++){
                children[i]=null;

            }
         }


    }
     public static Node root=new Node();
     public static void insert(String word){
        Node Curr=root;
        for(int lavel=0;lavel<word.length();lavel++){
            int idx=word.charAt(lavel)-'a';
            if(Curr.children[idx]==null){
            Curr.children[idx]=new Node();

            }

            Curr=Curr.children[idx];
            
            }

        Curr.eow=true;
        
     }


     public static boolean Search(String word){
        Node Curr=root;
        for(int lavel=0;lavel<word.length();lavel++){
            int idx=word.charAt(lavel)-'a';
            if(Curr.children[idx]==null){
            return false;

            }

            Curr=Curr.children[idx];
            
            }

            return Curr.eow;
        
     }

    public static void main(String[] args) {
        String word[]={"the","a","thee","their","and","there"};
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }

        System.out.println(Search("thee"));
        System.out.println(Search("thor"));
    }
}