package userapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // https://jsonplaceholder.typicode.com/users
        Geo geo = new Geo("43.0000","40.0000");

        String geoOneInfo = geo.toString();
        System.out.println(geoOneInfo);


    }

    private static void GetRemoteJsonData() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        String sUrl = "https://jsonplaceholder.typicode.com/users";
        URL url = new URL(sUrl);
        HttpsURLConnection request = (HttpsURLConnection)url.openConnection();
        request.connect();
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(new InputStreamReader((InputStream)request.getContent()));
        JsonArray jsArray = root.getAsJsonArray();
        for (int i = 0; i < jsArray.size(); i++) {
            users.add(CreateUser(jsArray.get(i).getAsJsonObject()));
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }

    }

    private static User CreateUser(JsonObject jsonObject){
        int id = jsonObject.get("id").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String username = jsonObject.get("username").getAsString();
        String email = jsonObject.get("email").getAsString();
        Address address = new Address(
                        jsonObject.get("address").getAsJsonObject().get("street").getAsString(),
                        jsonObject.get("address").getAsJsonObject().get("suite").getAsString(),
                        jsonObject.get("address").getAsJsonObject().get("city").getAsString(),
                        jsonObject.get("address").getAsJsonObject().get("zipcode").getAsString(),
                        new Geo(
                                jsonObject.get("address").getAsJsonObject().get("geo").getAsJsonObject().get("lat").getAsString(),
                                jsonObject.get("address").getAsJsonObject().get("geo").getAsJsonObject().get("lng").getAsString()
                        )
                );


        String phone = jsonObject.get("phone").getAsString();
        String website = jsonObject.get("website").getAsString();
        Company company = new Company(
                jsonObject.get("company").getAsJsonObject().get("name").getAsString(),
                jsonObject.get("company").getAsJsonObject().get("catchPhrase").getAsString(),
                jsonObject.get("company").getAsJsonObject().get("bs").getAsString()
        );

        User user = new User(id,name,username,email,address,phone,website,company);

        return user;
    }

}
