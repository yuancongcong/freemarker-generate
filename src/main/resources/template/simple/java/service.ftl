package ${module}.${SERVICE_NAME};

import com.lingxi.framework.base.BaseDao;
import com.lingxi.framework.base.CRUDService;
import com.lingxi.framework.domain.jpa.Query;
import ${module}.${DAO_NAME}.${dao_name};
import ${module}.${ENTITY_NAME}.${entity_name};
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
@Slf4j
public class ${service_name} {

    @Autowired
    private ${dao_name} ${var_dao_name};

    public Page<${entity_name}> findAll(${entity_name} ${ENTITY_NAME},Pageable pageable) {
        return ${var_dao_name}.findAll((Root<${entity_name}> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb)->
            new Query(cb,root)
               // .like("name",${ENTITY_NAME}.getName()) //name like '%:value%
                .toPredicate()
            ,pageable);
    }
}
