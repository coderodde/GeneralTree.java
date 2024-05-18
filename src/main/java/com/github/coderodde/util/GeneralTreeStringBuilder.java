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
                stack.addLast(root);
                stringBuilder.append(root.getData());

                if (!root.getChildren().isEmpty()) {
                    stringBuilder.append("+");
                }
                
                stringBuilder.append("\n");
                
                for (final GeneralTreeNode<E> node : root.getChildren()) {
                    
                    stack.addLast(root);
                    childrenIterationCountMap.put(root, 0);
                    depthFirstSearch(node, root);
                    childrenIterationCountMap.clear();
                    stack.removeLast();
                }
                
                stack.removeLast();
            }

            return stringBuilder.toString();
        }
        
        private void depthFirstSearch(final GeneralTreeNode<E> root,
                                      GeneralTreeNode<E> parent) {
            stack.addLast(root);
            
            for (final GeneralTreeNode<E> node : stack) {
                
                if (childrenIterationCountMap.get(parent) < 
                        root.getChildren().size()) {
                    
                    stringBuilder.append("|");
                    
                    childrenIterationCountMap.put(
                            parent, 
                            childrenIterationCountMap.get(parent) + 1);
                    
                } else if (childrenIterationCountMap.get(parent)
                        == root.getChildren().size()) {
                    
                    stringBuilder.append(" ");
                } else {
                    throw new RuntimeException("Eyeah");
                }
            }
            
            stringBuilder.append(root.getData());
            
            if (!root.getChildren().isEmpty()) {
                stringBuilder.append("+");
            }
            
            stringBuilder.append("\n");
            
            for (final GeneralTreeNode<E> child : root.getChildren()) {
                childrenIterationCountMap.put(root, 0);
                depthFirstSearch(child, root);
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
