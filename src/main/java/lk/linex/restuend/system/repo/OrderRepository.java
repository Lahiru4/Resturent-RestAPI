package lk.linex.restuend.system.repo;


import lk.linex.restuend.system.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
