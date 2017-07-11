package UFsets;

public class UFset {
	//find father
	int [] a;
	int size;
	public UFset(int n){
		a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = -1;
		}
		size = n;
	}
	public int find(int x){
		int key = x;
		if(key>=0&&key<size){
			while(a[key]>=0){
				key = a[key];
			}
			return key;
		}
		else{
			System.out.println("cannot find");
			return -1;
		}
	}
	public void union(int root1, int root2){
		int f1 = find(root1);
		int f2 = find(root2);
		if(f1!=f2){
			a[f1] += a[f2];
			a[f2] = f1;
		}
	}
	public static void main(String[] args) {
		UFset uf = new UFset(10);
		System.out.println(uf.find(-1));
		System.out.println(uf.find(1));
		uf.union(0, 6);
		
		uf.union(6, 7);
		uf.union(0, 8);
		uf.union(1, 9);
		uf.union(4, 9);
		uf.union(1, 8);
		/**/
		System.out.println(uf.find(9));
		for(int i=0;i<uf.size;i++){
			System.out.print(i+",");
		}
		System.out.println();
		for(int i=0;i<uf.size;i++){
			System.out.print(uf.a[i]+",");
		}
		

	}

}
