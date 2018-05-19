package ${module}.${ENTITY_NAME};

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="${table_name}")
public class ${entity_name} implements Serializable {


}
