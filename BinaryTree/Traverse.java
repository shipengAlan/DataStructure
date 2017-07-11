package BinaryTree;

public class Traverse {
	
	public void traverseVLR(TreeNode root){
		if(root!=null){
			System.out.println("visit Node:"+(char)(root.value+'0'));
			traverseVLR(root.left);
			traverseVLR(root.right);
		}
	}
	public void traverseLVR(TreeNode root){
		if(root!=null){
			traverseLVR(root.left);
			System.out.println("visit Node:"+(char)(root.value+'0'));
			traverseLVR(root.right);
		}
	}
	public void traverseLRV(TreeNode root){
		if(root!=null){
			traverseLRV(root.left);
			traverseLRV(root.right);
			System.out.println("visit Node:"+(char)(root.value+'0'));
		}
	}
	public static void main(String[] args) {
		Application app = new Application();
		TreeNode node = app.createTree("ABC##DE#G##F###");
		app.printTree(node);
		System.out.println(app.result);
		app.serilizedTree(node);
		System.out.println(app.output);
		Traverse t = new Traverse();
		System.out.println("VLR");
		t.traverseVLR(node);
		System.out.println("LVR");
		t.traverseLVR(node);
		System.out.println("LRV");
		t.traverseLRV(node);
	}

}
