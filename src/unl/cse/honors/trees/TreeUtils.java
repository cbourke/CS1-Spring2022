package unl.cse.honors.trees;

public class TreeUtils {


	public static BinaryTree<String> largeTree() {
		TreeNode<String> a = new TreeNode<>("a");
		TreeNode<String> b = new TreeNode<>("b");
		TreeNode<String> c = new TreeNode<>("c");
		TreeNode<String> d = new TreeNode<>("d");
		TreeNode<String> e = new TreeNode<>("e");
		TreeNode<String> f = new TreeNode<>("f");
		TreeNode<String> g = new TreeNode<>("g");
		TreeNode<String> h = new TreeNode<>("h");
		TreeNode<String> i = new TreeNode<>("i");
		TreeNode<String> j = new TreeNode<>("j");
		TreeNode<String> k = new TreeNode<>("k");
		TreeNode<String> l = new TreeNode<>("l");
		TreeNode<String> m = new TreeNode<>("m");
		TreeNode<String> n = new TreeNode<>("n");
		TreeNode<String> o = new TreeNode<>("o");
		TreeNode<String> p = new TreeNode<>("p");
		TreeNode<String> q = new TreeNode<>("q");
		TreeNode<String> r = new TreeNode<>("r");
		
		a.setLeftChild(b);
		a.setRightChild(c);
		
		b.setParent(a);
		b.setLeftChild(d);
		b.setRightChild(e);
		
		c.setParent(a);
		c.setRightChild(f);
		
		d.setParent(b);
		d.setLeftChild(g);
		d.setRightChild(h);

		e.setParent(b);
		e.setRightChild(i);
		
		f.setParent(c);
		f.setLeftChild(j);
		f.setRightChild(k);
		
		g.setParent(d);
		g.setLeftChild(l);
		g.setRightChild(m);
		
		h.setParent(d);
		h.setRightChild(n);
		
		i.setParent(e);
		i.setLeftChild(o);
		
		j.setParent(f);
		j.setLeftChild(p);
		j.setRightChild(q);
		
		k.setParent(f);
		
		l.setParent(g);
		
		m.setParent(g);
		m.setLeftChild(r);
		
		n.setParent(h);
		
		o.setParent(i);
		
		p.setParent(j);
		
		q.setParent(j);
		
		r.setParent(m);
		
		return new BinaryTree<>(a);
	}

	public static BinaryTree<String> smallTree() {
		TreeNode<String> a = new TreeNode<>("a");
		TreeNode<String> b = new TreeNode<>("b");
		TreeNode<String> c = new TreeNode<>("c");
		TreeNode<String> d = new TreeNode<>("d");
		TreeNode<String> e = new TreeNode<>("e");
		TreeNode<String> f = new TreeNode<>("f");
		
		a.setLeftChild(b);
		a.setRightChild(c);
		
		b.setParent(a);
		b.setLeftChild(d);
		b.setRightChild(e);
		
		c.setParent(a);
		c.setRightChild(f);
		
		d.setParent(b);

		e.setParent(b);
		
		f.setParent(c);
		
		return new BinaryTree<>(a);
	}

}
