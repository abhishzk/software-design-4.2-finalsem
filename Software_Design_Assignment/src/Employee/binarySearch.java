package Employee;

import javax.swing.table.DefaultTableModel;

public class binarySearch {
	private Node head;
	private Node tail;
	private Node root;
	private static boolean created = false;
	private static binarySearch single;
	DefaultTableModel model = new DefaultTableModel();

	public binarySearch() {
		tail = new Node(0, null, 0, 0, null, null);
		head = new Node(-1, null, 0, 0, null, tail);
		created = true;
	}

	public void insert(int k, String name, int age, int salary) {
		Node p, x;
		p = head;
		x = head.right;
		while (x != tail) {
			p = x;
			x = (k < x.key) ? x.left : x.right;
		}
		x = new Node(k, name, age, salary, tail, tail);
		if (k < p.key)
			p.left = x;
		else
			p.right = x;
	}

	public Node search(int k) {
		Node x = head.right;
		tail.key = k;
		boolean found = false;
		while (x != tail && found == false) {
			if (k == x.key)
				found = true;
			else if (k < x.key)
				x = x.left;
			else
				x = x.right;
		}
		if (x == tail)
			return null;
		else
			return x;
	}

	public DefaultTableModel printReport() {
		Node n = head.right;
		String[] heading = { "Employee ID", "Employee Name", "Employee Salary", "Employee Age" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(heading);
		if (n.left != null) {
			// str += "Account Number: " + t.accountNumber + " Name : " + t.name.toString()+
			// " Address: " + t.address +" Phone Number: "+t.phoneNumber + "\n" ;
			model.addRow(new Object[] { n.readKey(), n.readName(), n.readSalary(), n.readAge() });
			printReport();
		}
		if (n.right != null) {
			model.addRow(new Object[] { n.readKey(), n.readName(), n.readSalary(), n.readAge() });
			printReport();

		}
		return model;
	}

	public void printTree() {
		model = new DefaultTableModel();
		root = head.right;
		if (root != null)
			display(root);
	}

	public void display(Node root) {

		String[] heading = { " Key", " Name", " Age", " Salary" };
		model.setColumnIdentifiers(heading);
		if (root.left != null) {
			display(root.left);
			// System.out.print(" " + root.name);
			model.addRow(new Object[] { root.key, root.name, root.age, root.salary });
		}
		if (root.right != null) {
			display(root.right);
		}
	}

	public static binarySearch getInstance() {
		if (!created) {
			single = new binarySearch();
		}
		return single;
	}

}