package BinaryTree;

public class Application {
	public int index = -1;
	public String result = "";
	public String output = "";
	public Application(){
		index = -1;
		result = "";
		output = "";
	}
	//using VLR to create tree
	public TreeNode createTree(String str){
		index++;
		if(str.charAt(index)!='#'){
			TreeNode node = new TreeNode();
			node.value = str.charAt(index) - '0';
			node.left = createTree(str);
			node.right = createTree(str);
			return node;
		}
		return null;
	}
	//using tree to create VLR
	public void serilizedTree(TreeNode node){
		if(node==null){
			output += "#";
		}
		else{
			output += (char)(node.value + '0');
			serilizedTree(node.left);
			serilizedTree(node.right);
		}
	}
	// print the tree in VLR
	public void printTree(TreeNode node){
		if(node!=null){
			result += (char)(node.value + '0') + "";
			if(node.left!=null||node.right!=null){
				result += "(";
				printTree(node.left);
				result += ",";
				printTree(node.right);
				result += ")";
			}
		}
	}
	// using VLR to copy the tree
	public TreeNode copyOfTree(TreeNode node){
		if(node==null) 
			return null;
		else{
			TreeNode n = new TreeNode();
			n.value = node.value;
			n.left = copyOfTree(node.left);
			n.right = copyOfTree(node.right);
			return n;
		}
	}
	// using LRV to get the height
	public int getHeight(TreeNode node){
		if(node==null)
			return 0;
		else{
			int left = getHeight(node.left);
			int right = getHeight(node.right);
			return Math.max(left, right) + 1;
		}
	}
	public static void main(String[] args) {
		Application app = new Application();
		TreeNode node = app.createTree("ABC##DE#G##F###");
		app.printTree(node);
		System.out.println(app.result);
		app.serilizedTree(node);
		TreeNode tmp = app.copyOfTree(node);
		System.out.println(app.output);
		System.out.println(app.getHeight(tmp));
	}

}
