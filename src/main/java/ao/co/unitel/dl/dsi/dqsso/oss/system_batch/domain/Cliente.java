package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private String firstName;
    private String lastName;
    private Long age;

    private String email;

    @Override
    public String toString() {
        return "Cliente{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
