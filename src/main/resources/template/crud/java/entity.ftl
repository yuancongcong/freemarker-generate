package ${module}.${ENTITY_NAME};

import com.lingxi.framework.base.IdEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="${table_name}")
public class ${entity_name} extends IdEntity {

    /** 名称 */
    private String name;

}
