import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set<E> {

	private int size = 10;
	private Object[] aaa;
	private int index = 0;

	private class MyIterator<E> implements Iterator {
		private int pointer = 0;

		@Override
		public boolean hasNext() {
			return (pointer < index);
		}

		@Override
		public E next() {
			return (E) aaa[pointer++];
		}

		@Override
		public void remove() {
			aaa[pointer - 1] = null;
		}
		
		public void backOnePointer(){
			pointer--;
		}
	}

	public MySet() {
		super();
		aaa = new Object[size];
	}

	@Override
	public boolean add(E arg0) {
		if (contains(arg0)) {
			return false;
		}
		if (index >= size) {
			Object[] temp = aaa.clone();
			size = size * 2;
			aaa = new Object[size];
			for (int i = 0; i < index; i++) {
				aaa[i] = temp[i];
			}
		}
		aaa[index++] = arg0;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < index; i++) {
			aaa[i] = null;
		}
		size = 0;
		index = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		for (int i = 0; i < index; i++) {
			if (aaa[i].equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		boolean isContain = true;
		Iterator<?> target = arg0.iterator();
		while (target.hasNext()) {
			Object ob = target.next();
			if (!this.contains(ob)) {
				isContain = false;
			}
		}
		return isContain;
	}

	@Override
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}

	@Override
	public boolean remove(Object arg0) {
		for (int i = 0; i < index; i++) {
			if (aaa[i].equals(arg0)) {
				for (int j = i; j < index - 1; j++) {
					aaa[j] = aaa[j + 1];
				}
				index--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean isRemove = false;
		Iterator<?> target = arg0.iterator();
		while (target.hasNext()) {
			Object ob = target.next();
			if (this.contains(ob)) {
				this.remove(ob);
				isRemove = true;
			}
		}
		return isRemove;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		boolean isRetain = false;
		Iterator<?> target = this.iterator();
		while (target.hasNext()) {
			Object ob = target.next();
			if (!arg0.contains(ob)) {
				this.remove(ob);
				((MyIterator<E>) target).backOnePointer();
				isRetain = true;
			}
		}
		return isRetain;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public Object[] toArray() {
		return aaa.clone();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
