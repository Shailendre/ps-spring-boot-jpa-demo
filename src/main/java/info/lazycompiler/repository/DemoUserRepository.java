package info.lazycompiler.repository;

import info.lazycompiler.model.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoUserRepository extends JpaRepository<DemoUser, Long> {
}
