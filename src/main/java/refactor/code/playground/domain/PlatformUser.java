package refactor.code.playground.domain;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "refactor_user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlatformUser implements Serializable {

    private static final long serialVersionUID = -4981045458028750134L;

    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 别名
     */
    @Column(name = "alias")
    private String alias;

    /**
     * 年龄
     */
    @Column(name = "age")
    private int age;

    /**
     * 嵌套属性
     */
    private Address address;

}
