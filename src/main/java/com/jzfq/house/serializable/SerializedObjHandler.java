package com.jzfq.house.serializable;

import com.jzfq.house.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class SerializedObjHandler<T extends SerializedObj>{

    @Autowired
    BaseHandler baseHandler;

    public void store(T t, String path) throws IOException {
        File objFile = new File(path + t.getName() + ".obj");
        if(!objFile.exists()){
           objFile.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(objFile);
        baseHandler.store(t, fileOutputStream);
    }

    public T load(String name, String path) {
        File objFile = new File(path + name + ".obj");
        try {
            return (T) baseHandler.load(new FileInputStream(objFile));
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void destroy(String name, String path) throws URISyntaxException {
        File objFile = new File(path + name + ".obj");
        if(!objFile.exists()){
            throw new BadRequestException("名称有误");
        }
        objFile.delete();
    }

}
