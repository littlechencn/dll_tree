package cn.littlechen.dlltree.controller;

import cn.littlechen.dlltree.model.DllTree;
import cn.littlechen.dlltree.model.TWineDllFileContain;
import cn.littlechen.dlltree.service.DllService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/16.
 */
@Controller
@RequestMapping("/dlls")
public class DllController {

    private Logger log = Logger.getLogger(DllController.class);

    @Resource
    private DllService dllService;

    /**
     * showDlls页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/showDlls")
    public String showDlls(HttpServletRequest request, Model model) {
        log.info("查询所有Dll信息");
        //查出所有不重复的DLL信息；
        List<String> dllList = dllService.selectDistinctDll();
        model.addAttribute("dllList", dllList);
        return "showDlls";
    }

    /**
     * 根据DLL名称，返回依赖树Json字符串；
     * @param dllName
     * @return
     */
    public String getJsonTree(String dllName) {
        List<TWineDllFileContain> firstDllTree = dllService.selectAllDll(dllName);
        Map<String, List<Map<String, String>>> classMap = new HashMap<String, List<Map<String, String>>>();
        //组装json数据；
        for (TWineDllFileContain dll : firstDllTree) {
            String fatherName = dll.getfClass();
            String childrenName = dll.getfPath();

            if (classMap.get(fatherName) == null) {
                List<Map<String, String>> pathList = new ArrayList<Map<String, String>>();
                Map<String, String> tempMap = new HashMap<String, String>();
                tempMap.put("name", childrenName);
                pathList.add(tempMap);
                classMap.put(fatherName, pathList);
            } else {
                List<Map<String, String>> pathList2 = classMap.get(fatherName);
                Map<String, String> tempMap2 = new HashMap<String, String>();
                tempMap2.put("name", childrenName);
                pathList2.add(tempMap2);
                classMap.put(fatherName, pathList2);
            }
        }
        //构建最终的dllTreeJson
        String finalDllTreeJson = "{}";
        if (classMap.size() >= 1) {
            List<DllTree> dllTreeList = new ArrayList<DllTree>();
            //遍历map
            for (String key : classMap.keySet()) {
                DllTree dllTree = new DllTree();
                dllTree.setName(key);
                dllTree.setChildren(classMap.get(key));
                dllTreeList.add(dllTree);
            }
            //构建最终的dllTree
            DllTree dllTreeFinal = new DllTree();
            dllTreeFinal.setName(dllName);
            dllTreeFinal.setChildren(dllTreeList);
            //对象转换Json
            finalDllTreeJson = new Gson().toJson(dllTreeFinal);
        }
        return finalDllTreeJson;
    }

    /**
     * 创建Json文件流，便于D3加载；
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getJsonTree")
    public ModelAndView creatJsonFile(String dllName, HttpServletResponse response){
        String fileName="data.json";
        response.reset();// 不加这一句的话会出现下载错误
        response.setHeader("Content-disposition", "attachment; filename="+fileName);// 设定输出文件头
        response.setContentType("text/x-plain");// 定义输出类型
        try {
            ServletOutputStream out = response.getOutputStream();
            String path = System.getProperty("java.io.tmpdir") + "\\poem.txt";
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(fos, "utf-8");
            String text=getJsonTree(dllName);
            writer.write(text);
            writer.close();
            fos.close();

            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(4096);

            byte[] cache = new byte[4096];
            for (int offset = fis.read(cache); offset != -1; offset = fis.read(cache)) {
                byteOutputStream.write(cache, 0, offset);
            }

            byte[] bt = null;
            bt = byteOutputStream.toByteArray();

            out.write(bt);
            out.flush();
            out.close();
            fis.close();
            if(file.exists()){
                file.delete();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
