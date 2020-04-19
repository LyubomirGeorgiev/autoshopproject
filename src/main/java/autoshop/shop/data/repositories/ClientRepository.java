package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByEmail(String email);
}
