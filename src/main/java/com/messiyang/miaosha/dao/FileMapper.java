package com.messiyang.miaosha.dao;

import com.messiyang.miaosha.model.FileInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper {

    int deleteByPrimaryKey(String id);

    int insert(FileInfo record);

    FileInfo getById(String id);

    List<FileInfo> selectByIds(@Param("ids") String[] ids);

    int updateByPrimaryKey(FileInfo record);

}