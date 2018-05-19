package com.lingxi.generate.java;

import com.lingxi.util.Constants;
import com.lingxi.generate.Generate;
import freemarker.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GenerateJava extends Generate {

    public GenerateJava(String module, String name) {
        super(module,name);
    }

    @Override
    public void push(){
        //获取模版
        Template template = getTemplate(this.getTemplateName(), Constants.JAVA_TEMPLATE_PATH);
        //输出文件
        String outFile = Constants.JAVA_OUT_ROOT_PATH + "/" + this.getModule().replace(".","/") + "/" + this.getSubModule() + "/" + this.getFileName()+ ".java";
        //写入
        super.write(template,outFile,getData());
    }

    public Map<String,Object> getData(){
        Map<String,Object> data = new HashMap<>();
        data.put("dao_name", capitalize(this.getName()) + capitalize(Constants.JAVA_DAO_NAME));
        data.put("service_name", capitalize(this.getName()) + capitalize(Constants.JAVA_SERVICE_NAME));
        data.put("controller_name", capitalize(this.getName()) + capitalize(Constants.JAVA_CONTROLLER_NAME) );
        data.put("var_controller_name",this.getName() + capitalize(Constants.JAVA_CONTROLLER_NAME) );
        data.put("var_service_name", this.getName() + capitalize(Constants.JAVA_SERVICE_NAME) );
        data.put("var_dao_name", this.getName() + capitalize(Constants.JAVA_DAO_NAME) );
        data.put("ENTITY_NAME", Constants.JAVA_ENTITY_NAME);
        data.put("DAO_NAME", Constants.JAVA_DAO_NAME);
        data.put("SERVICE_NAME", Constants.JAVA_SERVICE_NAME);
        data.put("CONTROLLER_NAME", Constants.JAVA_CONTROLLER_NAME);
        return  data;
    }
}
