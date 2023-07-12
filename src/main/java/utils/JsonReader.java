package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static Object[][] getJSONData(String JSON_Path, String Json_Data, int JSON_Attributes) throws IOException, ParseException {
        Object object = new JSONParser().parse(new FileReader(JSON_Path));
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(Json_Data);

        Object[][] arr = new String[jsonArray.size()][JSON_Attributes];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object1 = (JSONObject) jsonArray.get(i);
            arr[i][0] = String.valueOf(object1.get("TaskName"));
            arr[i][1] = String.valueOf(object1.get("TaskDesc"));
        }

        return arr;
    }
}
