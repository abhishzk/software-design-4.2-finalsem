package Product;

import javax.swing.table.DefaultTableModel;

import Employee.binarySearch;
import MainMenu.MainMenu;
import Misc.DialogMessage;

interface Iterator {
	boolean hasNext();

	HNode next();
}

interface Container {
	Iterator iterator();
}

public class HashTable implements Iterator, Container {
	public int hash(int id) {
		return id % 20;
	}

	private final static int TABLE_SIZE = 128;
	HNode[] head = new HNode[TABLE_SIZE];
	private static boolean created = false;
	private static HashTable single;
	int ind = 1;

	public HashTable() {
		created = true;
		for (int i = 1; i < TABLE_SIZE; i++)
			head[i] = null;
	}

	public void insert(int k, String name, int quantity, int price) {
		HNode temp = new HNode(k, name, quantity, price);
		int index = hash(k);
		temp.next = head[index];
		head[index] = temp;
	}

	public HNode searchbyName(String name) {
		Iterator i = iterator();
		HNode temp = null;
		// boolean res = false;
		while (i.hasNext()) {
			temp = i.next();
			if (temp.m_name.equals(name)) {
				return temp;
			} else {
				temp = null;
			}

		}
		return temp;

	}


	public DefaultTableModel printReport() {
		Iterator i = iterator();
		String[] heading = { "Key", " Name", " Quantity", " Price" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(heading);
		while (i.hasNext()) {
			HNode temp = i.next();
			model.addRow(
					new Object[] { temp.readKey(), temp.readProductName(), temp.readQuantity(), temp.readPrice() });
		}
		return model;
	}

	public HNode searchbyIterator(int k) {
		Iterator i = iterator();
		HNode temp = null;
		// boolean res = false;
		while (i.hasNext()) {
			temp = i.next();
			if (temp.key == k) {
				return temp;
			} else {
				temp = null;
			}

		}
		return temp;

	}

	public int getSize() {

		int flag = 0;
		for (int k = 0; k < TABLE_SIZE; k++) {
			int hash = (k % TABLE_SIZE);
			if (head[hash] != null) {
				flag++;
			}
		}
		return flag;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		ind = 1;
		return HashTable.this;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return ind <= getSize();
	}

	@Override
	public HNode next() {
		// TODO Auto-generated method stub

		return head[ind++];
	}

	public static HashTable getInstance() {
		if (!created) {
			single = new HashTable();
		}
		return single;
	}

}
