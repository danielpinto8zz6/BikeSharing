package estg.mtsd.bikeshare.shared.library.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }
}
