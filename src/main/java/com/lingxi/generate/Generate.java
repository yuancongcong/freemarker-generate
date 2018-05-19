package com.lingxi.generate;

import com.lingxi.util.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class Generate {

    private String module;
    private String name;
    private String subModule;
    private String fileName;
    private String templateName;
    private Map<String,Object> data = new HashMap<>();

    public Generate(String module, String name) {
        this.module = module;
        this.name = name;
        data.put("module",this.module);
        data.put("module_name",this.module.substring(this.module.lastIndexOf(".")+1));
        data.put("name",this.name);
        data.put("entity_name", capitalize(this.name));
    }

    public void dataPush(String key,Object value){
        this.data.put(key,value);
    }

    public abstract void push();

    /**
     * freemark 写入
     * @param template 模版
     * @param fileName 输出文件名
     */
    public void write(Template template,String fileName,Map<String,Object> data){
        try{
            if(template == null){
                System.out.println(template);
                return;
            }
            File outFile = FileUtil.createFile(fileName);
            if(outFile == null) return;
            FileWriter writer = new FileWriter(outFile);
            data.putAll(this.data);
            template.process(data,writer);
            writer.flush();
            writer.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 获取模版
     * @param name
     * @param templatePath
     * @return
     */
    public Template getTemplate(String name,String templatePath){
        try{
            Configuration configuration = new Configuration();
            String tempFile =  this.getClass().getClassLoader().getResource(templatePath).getPath();
            //获取template路径
            configuration.setDirectoryForTemplateLoading(new File(tempFile));
            return  configuration.getTemplate(name,"UTF-8");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 首字母小写
     * @param str
     * @return
     */
    protected String capitalize(String str){
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
