package lk.linex.restuend.system.repo;

import lk.linex.restuend.system.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
