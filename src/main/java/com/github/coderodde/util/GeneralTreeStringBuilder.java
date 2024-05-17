package com.github.coderodde.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @version 1.0.0 (May 16, 2024)
 * @since 1.0.0 (May 16, 2024)
 */
public final class GeneralTreeStringBuilder<E> {
    
    private static final int DEFAUT_VERTICAL_SPACES   = 0;
    private static final int DEFAUT_HORIZONTAL_SPACES = 0;
    
    private final int verticalSpaces;
    private final int horizontalSpaces;
    
    public GeneralTreeStringBuilder(final int verticalSpaces,
                                    final int horizontalSpaces) {
        this.verticalSpaces   = checkIsZeroOrLarger(verticalSpaces);
        this.horizontalSpaces = checkIsZeroOrLarger(horizontalSpaces);
    }
    
    public GeneralTreeStringBuilder() {
        this(DEFAUT_VERTICAL_SPACES, DEFAUT_HORIZONTAL_SPACES);
    }
    
    /**
     * This class impements the conversion state.
     * 
     * @param <E> the satellite data type. 
     */
    private static final class ToStringState<E> {
        
        /**
         * The depth-first search stack.
         */
        private final Deque<GeneralTreeNode<E>> stack = new ArrayDeque<>();
        
        /**
         * Counts how many children of the key tree node where processed.
         */
        private final Map<GeneralTreeNode<E>, Integer> 
                childrenIterationCountMap = new HashMap<>();
        
        /**
         * The actual string builder.
         */
        private final StringBuilder stringBuilder = new StringBuilder();
        
        private String buildTreeStringImpl(final GeneralTree<E> tree) {
            for (final GeneralTreeNode<E> root : tree.getRoots()) {
                childrenIterationCountMap.put(root, 0);
                depthFirstSearch(root);
                childrenIterationCountMap.clear();
            }

            return stringBuilder.toString();
        }
        
        private void depthFirstSearch(final GeneralTreeNode<E> root) {
            stack.addLast(root);
            
            for (final GeneralTreeNode<E> node : stack) {
                if (node.equals(root)) {
                    break;
                }
                
                if (childrenIterationCountMap.get(node) < 
                        node.getChildren().size()) {
                    
                    stringBuilder.append("|");
                } else if (childrenIterationCountMap.get(node)
                        == node.getChildren().size()) {
                    
                    stringBuilder.append(" ");
                } else {
                    throw RuntimeException("Eyeah");
                }
            }
            
            stringBuilder.append(root.getData());
            childrenIterationCountMap.put(root, childrenIterationCountMap.get(root) + 1);
            stringBuilder.append("\n");
            
            for (final GeneralTreeNode<E> child : root.getChildren()) {
                childrenIterationCountMap.put(child, 0);
                depthFirstSearch(child);
            }
            
            // Remove the root:
            stack.removeLast();
        }
    }
    
    public String buildTreeString(final GeneralTree<E> tree) {
        return new ToStringState<E>().buildTreeStringImpl(tree);
    }
    
    private static int checkIsZeroOrLarger(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "Input integer is too small: %d. " + 
                            "Must be at least zero (0).", i));
        }
        
        return i;
    }
}
