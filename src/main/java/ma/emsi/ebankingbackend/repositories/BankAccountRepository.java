package ma.emsi.ebankingbackend.repositories;

import ma.emsi.ebankingbackend.entites.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
