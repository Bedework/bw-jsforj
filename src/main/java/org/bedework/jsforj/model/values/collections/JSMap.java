package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;

import java.util.List;

/** Have type K[E]
 * where K is the key type, E is the element type.
 *
 * Each entry is represented as a JSProperty with
 * the name being the key.
 *
 * All elements may be fetched as their values or as
 * properties.Fetching as properties associates the key
 * with a value.
 *
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSMap<K, E extends JSValue>
        extends JSValue {
  /**
   * Returns the number of entries in this map. If this list contains
   * more than {@code Integer.MAX_VALUE} elements, returns
   * {@code Integer.MAX_VALUE}.
   *
   * @return the number of entries in this map
   */
  int size();

  /**
   *
   * @return all the keys or empty list
   */
  List<K> getKeys();

  /**
   *
   * @return all the entries as properties or empty list
   */
  List<JSProperty<E>> get();

  /**
   *
   * @param key for entry
   * @return the property or null
   */
  JSProperty<E> get(K key);

  /**
   *
   * @param key for value to be added to map
   * @param val to be added to map
   * @return the new property
   */
  JSProperty<E> put(K key, E val);

  /**
   *
   * @param entry to be added to map
   */
  void put(JSProperty<E> entry);

  /**
   *
   * @param key to remove
   */
  void remove(K key);

  /**
   *
   * @param entry to remove
   */
  void remove(JSProperty<E> entry);

  /** Create and add a new empty entry
   *
   * @param key - the entry key
   */
  JSProperty<E> makeEntry(K key);
}
