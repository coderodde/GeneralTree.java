package com.github.coderodde.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements a simple generic tree node.
 * 
 * @param <E> the satellite data type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Sep 7, 2023)
 * @since 1.6 (Sep 7, 2023)
 */
public final class GeneralTreeNode<E> implements Iterable<GeneralTreeNode<E>> {
    
    private final E value;
    private final Set<GeneralTreeNode<E>> children;

    public GeneralTreeNode(final E value, 
                           final Comparator<? super GeneralTreeNode<E>> cmp) {
        
        Objects.requireNonNull(cmp, "The input comparator is null.");
        this.value = value;
        this.children = new TreeSet<>(cmp);
    }
    
    public E getData() {
        return value;
    }
    
    public void addChild(final GeneralTreeNode<E> child) {
        children.add(child);
    }
    
    public Collection<GeneralTreeNode<E>> getChildren() {
        return children;
    }
    
    public int size() {
        return children.size();
    }
    
    @Override
    public String toString() {
        return Objects.toString(value, "[null]");
    }

    @Override
    public Iterator<GeneralTreeNode<E>> iterator() {
        return children.iterator();
    }
}
