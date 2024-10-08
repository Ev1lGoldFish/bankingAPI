package dev.harsha.bankingApp.repository;

import dev.harsha.bankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
