package com.jzfq.house.code;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.exception.BusinessException;
import com.jzfq.house.serializable.SerializedObjHandler;
import com.jzfq.house.service.CommonMethods;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自增编码生成器
 *
 * @author Garen Gosling
 * @create 2018-04-28 03:14
 * @since v1.0
 */
@Log
@Component
public class IncrementHandler extends CommonMethods {

    @Autowired
    SerializedObjHandler<Increment> serializedObjHandler;

    /**
     * 新增
     * @param increment
     */
    public void save(Increment increment, String path) {

        Increment load = serializedObjHandler.load(increment.getName(), path);
        if(load != null){
            throw new BadRequestException("名称已存在");
        }
        int lackSize = increment.getSize() - increment.getId().toString().length();
        String code = increment.getId().toString();
        if(lackSize > 0){
            for(int i=0;i<lackSize;i++){
                code = "0" + code;
            }
        }
        increment.setCode(code);
        try {
            serializedObjHandler.store(increment, path);
        } catch (IOException e) {
            log.throwing(this.getClass().getName(), "delete", e);
            throw new BusinessException("系统异常： URISyntaxException");
        }

    }

    /**
     * 修改
     * @param increment
     */
    public void update(Increment increment, String path) {
        Increment load = serializedObjHandler.load(increment.getName(), path);
        if(load == null){
            throw new BadRequestException("名称不存在");
        }
        int lackSize = increment.getSize() - increment.getId().toString().length();
        String code = increment.getId().toString();
        if(lackSize > 0){
            for(int i=0;i<lackSize;i++){
                code = "0" + code;
            }
        }
        increment.setCode(code);
        try {
            serializedObjHandler.store(increment, path);
        } catch (IOException e) {
            log.throwing(this.getClass().getName(), "delete", e);
            throw new BusinessException("系统异常： URISyntaxException");
        }

    }


    /**
     * 删除
     * @param name
     */
    public void delete(String name, String path) {
        try {
            serializedObjHandler.destroy(name, path);
        } catch (URISyntaxException e) {
            log.throwing(this.getClass().getName(), "delete", e);
            throw new BusinessException("系统异常： URISyntaxException");
        }
    }

    /**
     * 批量删除
     * @param names
     * @return
     */
    public String batchRemove(String names, String path){
        int count = 0;
        List<String> failList = new ArrayList<>();
        for(String name : names.split(",")){
            try {
                delete(name, path);
                count ++;
            }catch (Exception e) {
                failList.add(name);
            }
        }
        return failMsg(count, names, failList);
    }

    /**
     * 查询
     * @param name
     * @return
     */
    public Increment get(String name, String path) {
        return serializedObjHandler.load(name, path);
    }

    /**
     * 分页查询
     * @param incrementSearch
     * @return
     */
    public List<Increment> getByPage(IncrementSearch incrementSearch, String path){
        if(incrementSearch.getStart() == null){
            incrementSearch.setStart(0);
        }
        if(incrementSearch.getLength() == null){
            incrementSearch.setLength(5);
        }
        List<Increment> increments = getAll(path);
        if(incrementSearch.getStart() >= increments.size()){
            return null;
        }
        if(incrementSearch.getLength() >= increments.size()){
            incrementSearch.setLength(increments.size());
        }

        List<Increment> incrementList = new ArrayList<>();
        for(int i=incrementSearch.getStart();i<increments.size();i++){
            boolean tag = true;
            Increment increment = increments.get(i);
            // 英文名称
            if(StringUtils.isNotBlank(incrementSearch.getName())){
                if(!increment.getName().equals(incrementSearch.getName())){
                    tag = false;
                }
            }
            // 中文名称
            if(StringUtils.isNotBlank(incrementSearch.getLabel())){
                if(increment.getLabel().indexOf(incrementSearch.getLabel()) < 0){
                    tag = false;
                }
            }
            if(tag){
                incrementList.add(increment);
            }
            if(incrementList.size() == incrementSearch.getLength()){
                break;
            }
        }
        return incrementList;
    }

    /**
     * 分页总数
     * @param incrementSearch
     * @return
     */
    public Integer getPageCount(IncrementSearch incrementSearch, String path){
        List<Increment> increments = getAll(path);
        List<Increment> incrementList = new ArrayList<>();
        for(int i=0;i<increments.size();i++){
            boolean tag = true;
            Increment increment = increments.get(i);
            if(StringUtils.isNotBlank(incrementSearch.getName())){
                if(!increment.getName().equals(incrementSearch.getName())){
                    tag = false;
                }
            }
            if(StringUtils.isNotBlank(incrementSearch.getLabel())){
                if(increment.getLabel().indexOf(incrementSearch.getLabel()) < 0){
                    tag = false;
                }
            }
            if(tag){
                incrementList.add(increment);
            }
        }
        return incrementList.size();
    }

    /**
     * 查询全部
     * @return
     */
    private List<Increment> getAll(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            if(dir.mkdir()){
                return null;
            }else{
                throw new BadRequestException("目录不存在，切创建目录失败");
            }
        }
        File[] files = dir.listFiles();
        List<Increment> increments = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                continue;
            } else {
                String name = file.getName();
                name = name.split("[.]")[0];
                Increment increment = get(name, path);
                increments.add(increment);
            }
        }
        return increments;
    }

    /**
     * 消费
     * @param name
     * @throws Exception
     */
    public void consume(String name, String path){
        Increment increment = get(name, path);
        Integer id = increment.getId();
        id ++;
        increment.setId(id);
        int lackSize = increment.getSize() - id.toString().length();
        String code = id.toString();
        if(lackSize > 0){
            for(int i=0;i<lackSize;i++){
                code = "0" + code;
            }
        }
        increment.setCode(code);
        try {
            serializedObjHandler.store(increment, path);
        } catch (IOException e) {
            log.throwing(this.getClass().getName(), "consume", e);
            throw new BusinessException("系统异常： IOException");
        }
    }

    /**
     * 解锁
     * @param name
     */
    public void unLock(String name, String path) {
        Increment increment = get(name, path);
        try {
            serializedObjHandler.store(increment, path);
        } catch (IOException e) {
            log.throwing(this.getClass().getName(), "unLock", e);
            throw new BusinessException("系统异常： IOException");
        }
    }

}
