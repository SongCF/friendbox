package com.scys.friendbox.session;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * json/对象互转
 */
public class JsonMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static <T> String toJson(T t) {
        String result = null;
        try {
            result = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> T fromJson(Object value, Class<T> t) {
        T result = null;
        try {
            result = objectMapper.readValue(value.toString(), t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static <T> List<T> fromJson(Object value, Class cls, Class<T> t) {
        List<T> result = null;
        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(cls, t);
            result = objectMapper.readValue(value.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <K,V> Map<K,V> fromJson(Object object, Class cls, Class<K> key, Class<V> value) {
        Map<K,V> result = null;
        try {
            JavaType type = objectMapper.getTypeFactory().constructMapLikeType(cls, key, value);
            result = objectMapper.readValue(object.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}