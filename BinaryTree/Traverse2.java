package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traverse2 {

	public void visit(TreeNode node){
		System.out.println("visit node:" + (char)(node.value+'0'));
	}
	public void traverseVLR(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();	
		TreeNode pnode = node;
		stack.add(null);
		while(pnode!=null){
			visit(pnode);
			if(pnode.right!=null)
				stack.add(pnode.right);
			
			if(pnode.left!=null)
				pnode = pnode.left;
			else
				pnode = stack.pop();
		}
	}
	public void traverseLVR(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pnode = node;
		do{
			while(pnode!=null){
				stack.add(pnode);
				pnode = pnode.left;
			}
			if(!stack.isEmpty()){
				pnode = stack.pop();
				visit(pnode);
				pnode = pnode.right;
			}
		}while(pnode!=null||!stack.isEmpty());
	}
	public void traverseLRV(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Character> stackC = new Stack<Character>();
		TreeNode pnode = node;
		do{
			while(pnode!=null){
				stack.add(pnode);
				stackC.add('L');
				pnode = pnode.left;
			}
			int continue1 = 1;
			while(continue1==1&&!stack.isEmpty()){
				pnode = stack.pop();
				char ch = stackC.pop();
				if(ch=='L'){
					stack.add(pnode);
					stackC.add('R');
					pnode = pnode.right;
					continue1 = 0;
				}
				if(ch == 'R'){
					visit(pnode);
				}
			}
		}while(!stack.isEmpty());
	}
	public ArrayList<ArrayList<TreeNode>> traverseLevel(TreeNode node){
		Queue queue = new LinkedList<TreeNode>();
		queue.add(node);
		ArrayList<Integer> levelNum = new ArrayList<Integer>();
		levelNum.add(0);
		int curlevel = 0;
		ArrayList<TreeNode> items = new ArrayList<TreeNode>();
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		while(!queue.isEmpty()){
			TreeNode pnode = (TreeNode)queue.poll();
			int lastLevel = levelNum.get(0);
			levelNum.remove(0);
			visit(pnode);
			if(pnode.left!=null){
				queue.add(pnode.left);
				levelNum.add(lastLevel+1);
			}
			if(pnode.right!=null){
				queue.add(pnode.right);
				levelNum.add(lastLevel+1);
			}
			if(lastLevel==curlevel){
				items.add(pnode);
			}
			else{
				curlevel++;
				result.add(items);
				items = new ArrayList<TreeNode>();
				items.add(pnode);
			}
		}
		if(!items.isEmpty())
			result.add(items);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app = new Application();
		TreeNode node = app.createTree("ABC##DE#G##F###");
		app.printTree(node);
		System.out.println(app.result);
		app.serilizedTree(node);
		System.out.println(app.output);
		Traverse2 t = new Traverse2();
		System.out.println("VLR");
		t.traverseVLR(node);
		System.out.println("LVR");
		t.traverseLVR(node);
		System.out.println("LRV");
		t.traverseLRV(node);
		System.out.println("By level");
		ArrayList<ArrayList<TreeNode>> result = t.traverseLevel(node);
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print((char)(result.get(i).get(j).value+'0')+",");
			}
			System.out.println();
		}
	}

}
