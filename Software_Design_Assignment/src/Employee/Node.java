package Employee;

class Node {
	int key;
	String name;
	int age;
	int salary;
	Node left;
	Node right;

	Node(int k, String nm, int a, int salary, Node ll, Node rr) {
		key = k;
		name = nm;
		age = a;
		this.salary = salary;
		left = ll;
		right = rr;
	}

	public int readKey() {
		return key;
	}

	public String readName() {
		return name;
	}

	public int readAge() {
		return age;
	}

	public int readSalary() {
		return salary;
	}
}