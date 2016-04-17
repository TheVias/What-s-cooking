package com.application.vias.what_s_cooking;

import android.content.Context;
import android.os.Handler;

import com.application.vias.what_s_cooking.entity.Ingredient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
public class SocketManager {

    Context context;
    Socket socket;
    InputStream in;
    OutputStream out;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    Handler handler;

    public SocketManager(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
        socket = null;
        in = null;
        out = null;
        objectInputStream = null;
        objectOutputStream = null;
    }

    public void updateDB() {
        ApplicationState state = ApplicationState.getInstance();
        DBSnapshot snapshot = state.getHelper().getDBSnapshot();
        DBSnapshot update = null;

        try {
            socket = new Socket(state.getServerIp(),state.getServerPort());
            in = socket.getInputStream();
            out = socket.getOutputStream();
            objectInputStream = new ObjectInputStream(in);
            objectOutputStream = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            objectOutputStream.writeObject("updateDB");
            objectOutputStream.writeObject(snapshot);
            update = (DBSnapshot)objectInputStream.readObject();
            state.setName(String.valueOf(update.getIngredient().length));
            handler.sendEmptyMessage(4);
            //...скачиваем нужное количество нужных файлов (обрабатываем каждый массив в snapshot-е)
            //...сервер пока не готов еще ничего читать
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            if (objectInputStream != null) objectInputStream.close();
            if (objectOutputStream != null) objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ingredient> getNewIngredients() {

        ApplicationState state = ApplicationState.getInstance();
        List<Ingredient> list = null;
        try {
            socket = new Socket(state.getServerIp(),state.getServerPort());
            in = socket.getInputStream();
            out = socket.getOutputStream();
            objectInputStream = new ObjectInputStream(in);
            handler.sendEmptyMessage(2);
        } catch (IOException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(3);
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendEmptyMessage(3);
        }

        try {
            objectOutputStream.writeObject("getNewIngredients");
            list = (List<Ingredient>) objectInputStream.readObject();
            handler.sendEmptyMessage(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(1);
        } catch (IOException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(1);
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendEmptyMessage(1);
        }

        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            if (objectInputStream != null) objectInputStream.close();
            if (objectOutputStream != null) objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
