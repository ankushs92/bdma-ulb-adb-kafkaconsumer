package bdma.ulb.adb.kcclickspersistence.util

import groovy.transform.CompileStatic

/**
 * Created by Ankush on 11/04/17.
 */
@CompileStatic
class Strings {

    static boolean hasText(String str) {
        if(!str){
            return false
        }
        def length = str.length()
        for(int i = 0 ; i < length ; i++) {
            if(!Character.isWhitespace(str.charAt(i))) {
                return true
            }
        }
        return false
    }

}
