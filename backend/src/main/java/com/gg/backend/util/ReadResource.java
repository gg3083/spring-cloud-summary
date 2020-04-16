package com.gg.backend.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/10 10:54
 */
@Component
public class ReadResource {

    @Autowired
    ApplicationContext context;

    /**
     * 参数格式
     * file://C:\Users\gimi\Desktop\项目成本sit问题记录.txt
     * classpath:lib/01-sql.sql
     *
     * 支持通配符
     * @param path
     * @return
     */
    public String readFile(String path){
       Resource temp = context.getResource(path);
        try {
            List mPaths = new ArrayList<>();
            BufferedReader br = new BufferedReader (new InputStreamReader(temp.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                mPaths.add(line);
            }
            br.close();
            return JSONObject.toJSONString(mPaths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
