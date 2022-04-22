package unl.cse.honors.trees;


public class Demo {
	

	public static void main(String[] args) {

		BinaryTree<String> t = TreeUtils.largeTree();
		
		System.out.println(t.bfs());

//		t.postorderRecursive();
	}

}
