package my.test.database.repository;

import my.test.database.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String userName);
}
