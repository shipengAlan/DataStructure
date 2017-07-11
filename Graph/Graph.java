package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	public int A[][];
	public int visit[];
	public int pi[];
	char [] ch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'R'};
	public int dist[];
	public int path[];
	public Graph(int[][] a2) {
		this.A = a2;
		visit = new int[A.length];
		pi = new int[A.length];
	}
	public Graph(int n){
		A = new int[n][n];
		visit = new int[n];
		pi = new int[n];
	}
	public void reset(){
		for(int i=0;i<visit.length;i++){
			visit[i] = 0;
			pi[i] = 0;
		}
	}
	public void visit(int i){
		
		System.out.println("visit "+ i +","+ch[i]);
	}
	public void DFS(int s){
		visit(s);
		visit[s] = 1;
		for(int i=0;i<A.length;i++){
			if(A[s][i]==1&&visit[i]==0){
				DFS(i);
				pi[i] = s;
			}
		}
	}
	public void BFS(int s){
		reset();
		visit(s);
		visit[s] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()){
			int r = queue.poll();
			for(int i=0;i<A.length;i++){
				if(A[r][i]==1&&visit[i]==0){
					visit(i);
					visit[i] = 1;
					pi[i] = r;
					queue.add(i);
					
				}
			}
		}
	}
	public void printFather(int s){
		pi[s] = A.length;
		for(int i=0;i<A.length;i++){
			System.out.print(ch[pi[i]]+"->"+ch[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int A[][] = {	{0,1,1,1,0,0,0,0,0},
				{1,0,1,0,1,0,0,0,0},
				{1,1,0,0,0,1,0,0,0},
				{1,0,0,0,0,1,0,0,0},
				{0,1,0,0,0,0,1,0,0},
				{0,0,1,1,0,0,0,1,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,0,1,0,0,1},
				{0,0,0,0,0,0,0,1,0}};
		Graph g = new Graph(A);
		g.reset();
		g.DFS(0);
		g.printFather(0);
		g.BFS(0);
		g.printFather(0);
	}

}
