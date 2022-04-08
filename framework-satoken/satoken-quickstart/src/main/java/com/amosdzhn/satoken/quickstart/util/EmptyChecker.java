package com.amosdzhn.satoken.quickstart.util;

import java.util.Collection;
import java.util.Map;

/**
 * 空检查器
 */
public abstract class EmptyChecker {

    public static boolean isEmpty(Object o) {
        if( o==null ){
            return true;
        }else if ( o instanceof String){
            return ((String) o).trim().length() == 0;
        }else if ( o instanceof Collection ) {
            return ((Collection) o).isEmpty();
        }else {
            return o instanceof Map && ((Map<?, ?>) o).isEmpty();
        }
    }

    public static boolean isEmpty(Object[] arr) {
        return arr==null || arr.length == 0;
    }
}
