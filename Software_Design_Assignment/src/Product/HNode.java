package Product;

class HNode {
	int key;
	String m_name;
	int m_quantity;
	int m_price;

	HNode next;

	HNode(int k, String nm, int qt, int pr) {
		key = k;
		m_name = nm;
		m_quantity = qt;
		m_price = pr;
		next = null;
	}

	public int readKey() {
		return key;
	}

	public String readProductName() {
		return m_name;
	}

	public int readQuantity() {
		return m_quantity;
	}

	public int readPrice() {
		return m_price;
	}

	public void print() {
		System.out.print("[" + key + ":" + m_name + ":" + m_quantity + ":" + m_price + "]-->");
	}
}