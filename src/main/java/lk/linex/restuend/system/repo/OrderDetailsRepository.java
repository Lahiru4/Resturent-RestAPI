package lk.linex.restuend.system.repo;

import lk.linex.restuend.system.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
