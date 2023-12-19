package utiles;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils<T> {

    private T data;

    private JsonUtils() {
    }

    public static <T> JsonUtils<T> initializeData(String filePath, Class<T> clazz) {
        JsonUtils<T> jsonUtils = new JsonUtils<>();
        try {
            jsonUtils.data = new ObjectMapper().readValue(new File(filePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonUtils;
    }

    public T getData() {
        if (data == null) {
            throw new IllegalStateException("Data is not initialized. Call initializeData() first.");
        }
        return data;
    }
}
