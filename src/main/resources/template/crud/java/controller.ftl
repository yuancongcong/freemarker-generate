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
	 * 根据ID获取数据
	 * @param id
	 */
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public ResultMsg get(Long id) {
		return ResultUtil.success(${var_service_name}.get(id));
	}

	/**
	 * 保存数据
	 * @RequestBody 注解为入参实（将传入参数自动注入实体类中）
	 * @param ${name}
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
    public ResultMsg save(${entity_name} ${name}) {
		return ResultUtil.success(${var_service_name}.save(${name}));
    }

	/**
	 * 删除数据，支持多删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteByIds",method=RequestMethod.POST)
	public ResultMsg deleteByIds(Long[] ids) {
        ${var_service_name}.deleteByIds(ids);
		return ResultUtil.success("删除成功");
	}

	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.POST)
	public ResultMsg listPage(${entity_name} ${name}, @PageableDefault Pageable pageable){
		return ResultUtil.success(${var_service_name}.findAll(${name},pageable));
	}
}
