package my.test.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 256)
    private String userName;

    @Column(name = "password", nullable = false, length = 2048)
    private String password;

    @Column(name = "role", nullable=false, length = 256)
    private String role;
}
