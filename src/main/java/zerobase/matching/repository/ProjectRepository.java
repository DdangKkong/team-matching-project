package zerobase.matching.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.matching.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, BigInteger> {
  List<Project> findAllByDueDateBefore(LocalDate date);
}
