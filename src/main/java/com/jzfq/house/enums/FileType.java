package com.jzfq.house.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件类型枚举
 *
 * @author Garen Gosling
 * @create 2018-04-22 15:14
 * @since v1.0
 */
public enum FileType {

    XLSX("xlsx", "504b0304"),
    JPG("jpg", "ffd8ffe0");
    private String suffix;
    private String code;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    FileType(String suffix, String code) {
        this.suffix = suffix;
        this.code = code;
    }

    public static String getSuffix(String code){
        FileType fileTypeEnum = FileType.valueOf(code);
        if (fileTypeEnum == null) {
            return null;
        }
        return fileTypeEnum.getSuffix();
    }

    public static FileType getFileType(String code){
        FileType[] fileTypes = FileType.values();
        if(StringUtils.isEmpty(code)){
            return null;
        }
        for(FileType fileType : fileTypes){
            if(fileType.code.equals(code)){
                return fileType;
            }
        }
        return null;
    }

}
