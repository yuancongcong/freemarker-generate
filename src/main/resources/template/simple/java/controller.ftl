package ${module}.controller;

import com.lingxi.framework.domain.ResultMsg;
import com.lingxi.framework.utils.ResultUtil;
import ${module}.${ENTITY_NAME}.${entity_name};
import ${module}.${SERVICE_NAME}.${service_name};
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/${module_name}/${name}")
public class ${controller_name} {

	@Autowired
	private ${service_name} ${var_service_name};


	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.POST)
	public ResultMsg listPage(${entity_name} ${name}, @PageableDefault Pageable pageable){
		return ResultUtil.success(${var_service_name}.findAll(${name},pageable));
	}
}
