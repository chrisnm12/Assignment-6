public interface IList<T> {
  boolean classmatesHelper(IList<T> c);
  T getFirst();
  IList<T> getRest();
  boolean isEmpty();
  boolean contains(T t);
}

class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;
  ConsList(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }
  public T getFirst() {
    return this.first;
  }
  public IList<T> getRest() {
    return this.rest;
  }
  public boolean classmatesHelper(IList<T> c) {
    if (c.contains(this.first)) {
      return true;
    } else {
      return this.rest.classmatesHelper(c);
    }
  }
  public boolean contains(T t) {
    if (this.first.equals(t)) {
      return true;
    } else {
      return this.rest.contains(t);
    }
  }
  public boolean isEmpty() {
    return false;
  }
}

class MtList<T> implements IList<T> {
  public T getFirst() {
    return null;
  }
  public IList<T> getRest() {
    return null;
  }
  public boolean classmatesHelper(IList<T> c) {
    return false;
  }
  public boolean contains(T item) {
    return false;
  }
  public boolean isEmpty() {
    return true;
  }
}