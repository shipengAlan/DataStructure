package Graph;

public class Graph2 {
	public int A[][];
	char [] ch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'R'};
	public int dist[];
	public int path[];
	public Graph2(int[][] a2) {
		this.A = a2;
	}
	public Graph2(int n){
		A = new int[n][n];
	}
	public void minpath(int s){
		dist = new int[A.length];
		path = new int[A.length];
		boolean S[] = new boolean[A.length];
		for(int i=0;i<S.length;i++){
			S[i] = false;
			dist[i] = A[s][i];
			path[i] = s;
		}
		S[s] = true;
		dist[s] = 0;
		path[s] = -1;
		int k = 1;
		while(k<A.length){
			int min =Integer.MAX_VALUE;
			int j = -1;
			for(int i=0;i<S.length;i++){
				if(S[i]==false&&dist[i]<min){
					min = dist[i];
					j = i;
				}
			}
			S[j] = true;
			k++;
			for(int i=0;i<S.length;i++){
				if(S[i]==false&&A[j][i]!=Integer.MAX_VALUE&&dist[j]+A[j][i]<dist[i]){
					dist[i] = dist[j]+A[j][i];
					path[i] = j;
				}
			}
		}
	}
	public void printFather(int s){
		for(int i=0;i<A.length;i++){
			System.out.println(i+","+dist[i]);
		}
		for(int i=0;i<A.length;i++){
			if(i!=s)
				System.out.print(path[i]+"->"+i+",");
			else
				System.out.print("null->"+i+",");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int MAX = Integer.MAX_VALUE;
		// Integer.MAX_VALUE is un-reachable
		int A[][] = {{0,10,MAX,30,100},
					{MAX,0,50,MAX,MAX},
					{MAX,MAX,0,MAX,10},
					{MAX,MAX,20,0,60},
					{MAX,MAX,MAX,MAX,0}};
		Graph2 g = new Graph2(A);
		g.minpath(0);
		g.printFather(0);
	}

}
