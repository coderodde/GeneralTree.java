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
final class GeneralTreeStringBuilder<E extends Comparable<? super E>> {
    
    private final int verticalSpaces;
    private final int horizontalSpaces;
    
    GeneralTreeStringBuilder(final int verticalSpaces,
                             final int horizontalSpaces) {
        this.verticalSpaces   = checkIsZeroOrLarger(verticalSpaces);
        this.horizontalSpaces = checkIsZeroOrLarger(horizontalSpaces);
    }
    
    private final Deque<GeneralTreeNode<E>> stack = new ArrayDeque<>();
    private final Map<GeneralTreeNode<E>, Integer> counterMap = new HashMap<>();
    private final StringBuilder stringBuilder = new StringBuilder();
    
    String buildTreeString(final GeneralTree<E> tree) {
        
        
        
        return stringBuilder.toString();
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
