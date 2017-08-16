package cn.littlechen.dlltree.service;

import cn.littlechen.dlltree.model.TWineDllFileContain;
import java.util.List;

/**
 * Created by lenovo on 2017/8/16
 */
public interface DllService {
    TWineDllFileContain selectDllById(int dllId);

    List<String> selectDistinctDll();

    List<TWineDllFileContain> selectAllDll(String dll_name);

}
