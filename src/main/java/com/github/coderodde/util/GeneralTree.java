package com.github.coderodde.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class implements a generic tree.
 * 
 * @param <E> the satellite data type.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Sep 7, 2023)
 * @since 1.6 (Sep 7, 2023)
 */
public final class GeneralTree<E> {

    private final SortedSet<GeneralTreeNode<E>> roots;
    
    public GeneralTree(final Comparator<GeneralTreeNode<E>> cmp) {
        Objects.requireNonNull(cmp, "The input node comparator is null.");
        this.roots = new TreeSet<>(cmp);
    }
    
    public void addRoot(final GeneralTreeNode<E> root) {
        this.roots.add(
                Objects.requireNonNull(
                        root, 
                        "The input root node is null."));
    }
    
    public Collection<GeneralTreeNode<E>> getRoots() {
        return roots;
    }
    
    /*
        B
        +-1
        +-2
        +-3-Alice
        | +-Bob
        | | +-1
        | | +-2
        | | +-3
        | +-Hi  
        | +-Clarice
        | | +-A
        | +- B
        |    +- C
        |    +- D
        |    +- E
        +-5
        +-10
        | +-Hello
        |    +-World
        +-Damnit
        C-+-1
          +-2
    */
}
