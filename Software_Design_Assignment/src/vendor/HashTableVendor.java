package vendor;

import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

interface Iterator {
	boolean hasNext();

	Object next();
}

interface Container {
	Iterator iterator();
}

public class HashTableVendor implements Container, Iterator {

	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
	int index = 1;

	public void insertCustomer(int key, String value) {
		ht.put(key, value);
	}

	public boolean searchVendorbyName(String name) {

		Iterator i = iterator();
		boolean res = false;
		while (i.hasNext()) {
			Object element = i.next();
			if (element.equals(name)) {
				res = true;
			}
		}
		return res;

	}

	public DefaultTableModel printReport() {
		Iterator i = iterator();
		String[] heading = { "Vendor ID", "Vendor Name" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(heading);
		while (i.hasNext()) {
			model.addRow(new Object[] { index, i.next() });
		}
		return model;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index <= ht.size();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return ht.get(index++);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		index = 1;
		return HashTableVendor.this;
	}

}
