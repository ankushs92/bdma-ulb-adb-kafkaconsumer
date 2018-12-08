package bdma.ulb.adb.kcclickspersistence.util

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic

/**
 * Created by Ankush on 11/04/17.
 */
@CompileStatic
class Json {

    private static final ObjectMapper objectMapper = new ObjectMapper()

    static <T> T toObject(String json, Class<T> clazz) throws Exception{
        Assert.notNull(json,"json cannot be null");
        Assert.notNull(clazz,"clazz cannot be null");

        objectMapper.readValue(json,clazz)
    }

}
