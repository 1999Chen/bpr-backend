package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.ItemMapper;
import com.shaoyu.backend.mapper.OrderMapper;
import com.shaoyu.backend.mapper.UserMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.User;
import com.shaoyu.backend.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.checkerframework.checker.units.qual.A;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import okhttp3.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    UserMapper userMapper;
    ItemMapper itemMapper;
    private static Gson gson = new Gson();
    private static OkHttpClient sslClient = new OkHttpClient();
    public UserServiceImpl()  {
        SqlSession ss = MyBatisConnection.getConnection();
        userMapper = ss.getMapper(UserMapper.class);
        itemMapper=  ss.getMapper(ItemMapper.class);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public void registerUser(User user){
        System.out.println("user gender is "+user.getGender());
//        int gender;
//        if (Objects.equals(user.getGender(), "male")){
//                gender = 1;
//        }
//        else {
//                gender = 0;
//        }
        userMapper.insertUser
                (user.getUsername(),user.getPassword(),user.getRegion(),user.getEmail(),user.getAddress(),user.getGender(),user.getAge(),user.getPhoneNumber());
    }

    @Override
    public int validateLogin(String username, String password) {
        int a = userMapper.validateUserInfo(username,password);
        System.out.println("user login a "+a);
        //1  means validate passed
        //0  means failed validation
        return a;
    }

    @Override
    public int  validateSignUp(String username){
        int a = userMapper.validateSignUp(username);
        System.out.println("user register a "+a);
        return a;
    };

    @Override
    public String getUserRole(String username) {
        return  userMapper.selectUserRole(username);
    }
    @Override
    public void updateUserInfo(User user) {
         userMapper.updateUserInfo(user);
    }

    @Override
    public List<Item> getPrediction(int age,int gender,String region) throws JSONException, IOException {
        List<Integer> list = getPredict(age,gender,region);
        System.out.println("get predict");
        List<Item> result=itemMapper.selectItemsById(list);
        System.out.println(result);
        return result;
    }

    public static synchronized List<Integer> getPredict(int age,int gender,String region) throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url("http://localhost:5000/get?age="+age+"&gender="+gender+"&region="+region)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = sslClient.newCall(request).execute();
        int ResponseCode = response.code();
        String result = response.body().string();
        System.out.println(ResponseCode);
        if (ResponseCode != 200) {
            JSONObject JSONResult = new JSONObject("{\"ResponseCode\": \"" + ResponseCode + "\"}");
            System.out.println("JSONResult is "+JSONResult);
            return null;
        } else {
            JSONArray data = new JSONArray(result);
            int l = data.length();
            ArrayList<Integer> list = new ArrayList<Integer>() ;
            for(int i = 0; i <l; i++){
                int a = Integer.parseInt((String)data.get(i));
                list.add(a);
            }
            System.out.println(list);

            return list;
        }
    }

}
