import java.util.ArrayList;

public class TarganAlgo {
    public static class pair {
        int src;
        int des;
        public pair( int s, int d){
            this.src=s;
             this.des=d;

        }
    public static void targen(ArrayList<pair>graph[], int v){
        for(int i=0; i<v;i++){
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new pair(0, 1));
        graph[0].add(new pair(0, 2));
        graph[1].add(new pair(1, 2));
        graph[1].add(new pair(1, 0));
        graph[2].add(new pair(2, 1));
       
        graph[0].add(new pair(0, 3));
        graph[3].add(new pair(3, 4));
        graph[3].add(new pair(3, 0));
        graph[3].add(new pair(3, 5));
        graph[4].add(new pair(4, 3));
        graph[4].add(new pair(4, 5));
        graph[5].add(new pair(5, 4));
        graph[5].add(new pair(5, 3));

       int dt[]=new int[v];
       int low[]=new int[v];
       boolean vis[]=new boolean[v];
       int time=1;
       for(int i=0;i<v;i++){

        if(!vis[i]){
            dfs(graph,i,-1,dt,low,vis,time);
           
        }
       }
    }
public static void dfs(ArrayList<pair>graph[],int curr, int par, int dt[],int low[], boolean vis[], int time){
    vis[curr]=true;
    dt[curr]=low[curr]=++time;

    for( int i=0;i<graph[curr].size();i++){
        pair p=graph[curr].get(i);
        int src=p.src;
        int dest=p.des;
        if(dest==par) continue;
        if(!vis[dest]){
            dfs(graph, dest, src, dt, low, vis, time);
            low[curr]=Math.min(low[curr],low[dest]);
            if(dt[curr]<low[dest]){
                System.out.println(curr+" ------"+dest);

            }
        }else{
             low[curr]=Math.min(low[curr],dt[dest]);
        }

        

    }
}
    
        
    }
    public static void main(String[] args) {
        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<pair>graph[]=new ArrayList[v];
        targen(graph,v);
    
    }
    
}
