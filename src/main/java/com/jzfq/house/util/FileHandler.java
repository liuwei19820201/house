package com.jzfq.house.util;

import com.jzfq.house.enums.FileType;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件帮助类
 *
 * @author Garen Gosling
 * @create 2018-04-22 15:24
 * @since v1.0
 */
public class FileHandler {
    /**
     * 判断文件类型
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static FileType getType(InputStream is) throws IOException {
        byte[] b = new byte[28];
        is.read(b, 0, 28);
        String fileHead = bytesToHexString(b);
        // 验证
        if(StringUtils.isBlank(fileHead)){
            return null;
        }
        // 业务
        fileHead = fileHead.toLowerCase();
        String code = fileHead.substring(0, 8);
        return FileType.getFileType(code);
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param bytes
     * @return 16进制字符串
     */
    public static String bytesToHexString(byte[] bytes){
        // 验证
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        // 业务
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String s = Integer.toHexString(v);
            if (s.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }



}
