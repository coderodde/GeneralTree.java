package com.github.coderodde.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
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
public final class GeneralTree<E extends Comparable<? super E>> {

    private final Set<GeneralTreeNode<E>> roots = new TreeSet<>();
    
    public void addRoot(final GeneralTreeNode<E> root) {
        this.roots.add(
                Objects.requireNonNull(
                        root, 
                        "The input root node is null."));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (final GeneralTreeNode<E> root : roots) {
//            toStringTreeImpl(sb, root);
        }
        
        return sb.toString();
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
