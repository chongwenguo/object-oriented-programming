/**
 * cs1331 hw07
 * MySet class implement Set<E>
 *
 * @author chongwen guo
 * @version 1.0
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;



public class MySet<E> implements Set<E> {
    private int size;
    private int index;
    private Object[] array;

/**
 * default constructor, sets size to 10, index to 0
 * and initialize a object array
 */
    public MySet() {
        size = 10;
        index = 0;
        array = new Object[size];
    }
/**
 * method to return the used size of the array
 * @return index - the used size of the array
 */
    public int size() {
          return index;
    }
/**
 * method to check if the array is empty
 * @return true if index == 0
 *         false if index != 0
 */
    public boolean isEmpty() {
        return index == 0;

    }
/**
 * method to check if this set contains a specified object o
 * @return true if contains
 *         false if not contain
 */
    public boolean contains(Object o) {
        boolean isContain = false;
        for (int i = 0; i < index; i++) {
            if (array[i].equals(o)) {
                isContain = true;
            }
        }
        return isContain;
    }
/**
 * inner MySetIterator class
 *
 * @author chongwen guo
 * @version 1.0
 *
 *
 */
    private class MySetIterator<E> implements Iterator<E> {
        private int currentIndex = 0;
/**
 * method to check next object is available
 * @return true if there is next object
 *         false if there is no next object
 */
        public boolean hasNext() {
            return (index - currentIndex) > 0;
        }
/**
 * method to return the next object
 * @return the current index object of this array
 */
        public E next() {
            return (E) array[currentIndex++];
        }
/**
 * method to remove current index object of this array
 * by replacing it by its next element and shift all
 * its next elements forward one index
 *
 */
        public void remove() {
             for (int i = this.currentIndex; i <= index; i++) {
                  array[i] = array[i + 1];
             }
             index--;
        }
/**
 * method to set currentIndex back one position
 */
        public void back() {
            currentIndex--;
        }
    }
/**
 * method to create a MySetIterator
 * @return MySetIterator
 */
    public Iterator<E> iterator() {

        return  new MySetIterator<E>();
    }
/**
 * add a element to this set, if not enough size, double the size
 * @param the element wanted add
 * @return true if added
 *         false if already contains that element
 */
    public boolean add(E e) {
         if (contains(e)) {
            return false;
         }
         if (index >= size) {
              Object[] temp = array.clone();
              size *= 2;
              array = new Object[size];
              for (int i = 0; i < index; i++) {
                  array[i] = temp[i];
              }
          }
        array[index++] = e;
        return true;
    }

/**
 * Removes the specified element from this set if it is present
 * by replacing it by its next element and shift all its next elements
 * forward one index
 * @param o - the element wanted to remove
 * @return true if removed
 *         false if not removed
 */
    public boolean remove(Object o) {
        for (int i = 0; i < index; i++) {
                if (array[i].equals(o)) {
                   for (int j = i; j < index; j++) {
                       array[j] = array[j + 1];
                   }
                   index--;
                   return true;
                }
        }
        return false;
    }

/**
 * Returns true if this set contains all
 * of the elements of the specified collection.
 * @param c - the special collection
 * @retuen true if contains all elements of c
 *         false if not contain all elements of c
 */
    public boolean containsAll(Collection<?> c) {
        boolean isContainsAll = true;
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (!contains(o)) {
                 isContainsAll = false;
            }
        }
        return isContainsAll;
    }
/**
 * Adds all of the elements in the specified collection
 * to this set if they're not already present
 * @param c - the specified collection
 * @return true if added
 *         false if not added anything
 */
    public boolean addAll(Collection<? extends E> c) {
           boolean added = false;
           Iterator<? extends E> it = c.iterator();
           while (it.hasNext()) {
           E o = it.next();
             if (!contains(o)) {
                add(o);
                added = true;
             }
         }
        return added;
    }
/**
 * Retains only the elements in this set that are
 * contained in the specified collection
 *  @param c - the specified collection
 *  @return true if modified
 *          false if not modified
 */
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        MySetIterator<E> it = new MySetIterator<E>();
        while (it.hasNext()) {
               Object o = it.next();
               if (!c.contains(o)) {
                    remove(o);
                    it.back();
                    modified = true;
                }
             }
         return modified;
    }

/**
 * Removes from this set all of its elements that
 * are contained in the specified collection
 * @param c the specified collection
 * @return true if modified
 *         false if not modified
 */
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
               Object o = it.next();
               if (contains(o)) {
                   this.remove(o);
                   modified = true;
                }
             }
         return modified;
    }

/**
 * Returns an array containing all of the elements in this set
 * @return an array containing all of the elements in this set
 */
    public Object[] toArray() {
          return array.clone();
    }
/**
 * Returns an array containing all of the elements in this set
 * @param a the array into which the elements of this set are to be stored,
 * if it is big enough; otherwise, a new array of the same runtime type is
 * allocated for this purpose.
 * @return an array containing all the elements in this set
 */
    public <T> T[] toArray(T[] a) {
        T[] b = (T[]) new Object[a.length];
        for (int i = 0; i < a.length; i++) {
        b[i] = a[i];
        }
        return  b;
    }

/**
 * Removes all of the elements from this set
 */
    public void clear() {
         for (int i = 0; i < index; i++) {
                array[i] = null;
             }
         size = 0;
         index = 0;
       }
}
