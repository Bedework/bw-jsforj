/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.collections.JSMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public abstract class JSMapImpl<K, E extends JSValue>
        extends JSValueImpl
        implements JSMap<K, E> {
  public JSMapImpl(final String type,
                   final JsonNode node) {
    super(type, node);
  }

  protected JSMapImpl() {
    super();
  }

  protected abstract String getPropertyType();

  /**
   *
   * @param key external form
   * @return String
   */
  protected abstract String convertKey(K key);

  protected abstract K convertFieldName(String fieldName);

  protected JSProperty<E> postCreate(final JSProperty<E> entry) {
    return entry;
  }

  @Override
  public int size() {
    assertObject("size");

    return getNode().size();
  }

  @Override
  public List<K> getKeys() {
    assertObject("get");

    final var res = new ArrayList<K>(getNode().size());
    final var node = (ObjectNode)getNode();

    for (final var it = node.fieldNames(); it.hasNext(); ) {
      res.add(convertFieldName(it.next()));
    }

    return res;
  }

  @Override
  public List<JSProperty<E>> get() {
    assertObject("get");

    final var res = new ArrayList<JSProperty<E>>(getNode().size());
    final var node = (ObjectNode)getNode();

    for (final var it = node.fieldNames(); it.hasNext(); ) {
      final var name = it.next();
      res.add(postCreate((JSProperty<E>)getProperty(name)));
//              getFactory().makeProperty(name,
  //                                      getPropertyType(),
    //                                    node.get(name))));
    }

    return Collections.unmodifiableList(res);
  }

  @Override
  public JSProperty<E> get(final K key) {
    assertObject("get(i)");

    final String name = convertKey(key);
/*    final var node = (ObjectNode)getNode();
    final var elNode = node.get(name);

    if (elNode == null) {
      return null;
    }

    return postCreate(
            getFactory().makeProperty(name,
                                     getPropertyType(),
                                     node.get(name)));
                                     */
    return postCreate((JSProperty<E>)getProperty(name));
  }

  @Override
  public JSProperty<E> put(final K key, final E val) {
    assertObject("add");

    final String name = convertKey(key);
    return postCreate(
            (JSProperty<E>)getFactory()
                    .makeProperty(name,
                                  val));
  }

  @Override
  public void put(final JSProperty<E> entry) {
    assertObject("add");

    setProperty(entry);
  }

  @Override
  public void remove(final K key) {
    assertObject("remove");

//    final var node = (ObjectNode)getNode();
//    node.remove(convertKey(key));
    removeProperty(convertKey(key));
  }

  @Override
  public void remove(final JSProperty<E> entry) {
    assertObject("remove");

//    final var node = (ObjectNode)getNode();
 //   node.remove(entry.getName());
    removeProperty(entry.getName());
  }

  @Override
  public JSProperty<E> makeEntry(final K key) {
    final JSProperty<E> p =
            postCreate(
                    getFactory().makeProperty(convertKey(key),
                                              getPropertyType(),
                                              null));
    put(p);
    return p;
  }
}
