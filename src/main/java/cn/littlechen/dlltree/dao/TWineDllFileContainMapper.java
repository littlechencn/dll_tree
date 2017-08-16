package cn.littlechen.dlltree.dao;

import cn.littlechen.dlltree.model.TWineDllFileContain;
import cn.littlechen.dlltree.model.TWineDllFileContainExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TWineDllFileContainMapper {

    List<String> selectDistinctDll();

    int countByExample(TWineDllFileContainExample example);

    int deleteByExample(TWineDllFileContainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWineDllFileContain record);

    int insertSelective(TWineDllFileContain record);

    List<TWineDllFileContain> selectByExample(TWineDllFileContainExample example);

    TWineDllFileContain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWineDllFileContain record, @Param("example") TWineDllFileContainExample example);

    int updateByExample(@Param("record") TWineDllFileContain record, @Param("example") TWineDllFileContainExample example);

    int updateByPrimaryKeySelective(TWineDllFileContain record);

    int updateByPrimaryKey(TWineDllFileContain record);
}