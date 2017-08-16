package cn.littlechen.dlltree.service.impl;

import cn.littlechen.dlltree.dao.TWineDllFileContainMapper;
import cn.littlechen.dlltree.model.TWineDllFileContain;
import cn.littlechen.dlltree.model.TWineDllFileContainExample;
import cn.littlechen.dlltree.service.DllService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/8/16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DllServiceImpl implements DllService {

    @Resource
    private TWineDllFileContainMapper dllDao;


    @Override
    public TWineDllFileContain selectDllById(int dllId) {
        return dllDao.selectByPrimaryKey(dllId);
    }

    @Override
    public List<String> selectDistinctDll() {
        return dllDao.selectDistinctDll();
    }

    @Override
    public List<TWineDllFileContain> selectAllDll(String dll_name) {
        TWineDllFileContainExample example = new TWineDllFileContainExample();
        TWineDllFileContainExample.Criteria criteria = example.createCriteria();
        criteria.andDllNameEqualTo(dll_name);
        return dllDao.selectByExample(example);
    }
}
