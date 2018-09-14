package com.jzfq.house.serializable;

import org.springframework.stereotype.Component;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * test
 *
 * @author Garen Gosling
 * @create 2018-04-28 00:48
 * @since 1.0
 */
@Component
public class BaseHandler
{
    /**
     * 持久化为XML对象
     *
     * @param obj
     * @param out
     */
    public void storeXML(Object obj, OutputStream out)
    {
        XMLEncoder encoder = new XMLEncoder(out);
        encoder.writeObject(obj);
        encoder.flush();
        encoder.close();
    }

    /**
     * 从XML中加载对象
     *
     * @param in
     * @return
     */
    public Object loadXML(InputStream in)
    {
        XMLDecoder decoder = new XMLDecoder(in);
        Object obj = decoder.readObject();
        decoder.close();
        return obj;
    }

    /**
     * 持久化对象
     *
     * @param obj
     * @param out
     * @throws IOException
     */
    public void store(Object obj, OutputStream out) throws IOException
    {
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(obj);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 加载对象
     *
     * @param in
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object load(InputStream in) throws IOException,
            ClassNotFoundException
    {
        ObjectInputStream inputStream = new ObjectInputStream(in);
        Object obj = inputStream.readObject();
        inputStream.close();
        return obj;
    }

//    public static void main(String[] args) throws Exception
//    {
//        String storeName = "java object 123";
//        File xmlFile = new File("xmlFile.data");
//        JavaSerializable serializable = new JavaSerializable();
//        serializable.storeXML(storeName, new FileOutputStream(xmlFile));
//        System.out.println(serializable.loadXML(new FileInputStream(xmlFile)));
//        File file = new File("file.data");
//        serializable.store(storeName, new FileOutputStream(file));
//        System.out.println(serializable.load(new FileInputStream(file)));
//    }
}