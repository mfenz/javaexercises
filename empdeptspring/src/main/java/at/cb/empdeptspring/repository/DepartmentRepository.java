package at.cb.empdeptspring.repository;

import at.cb.empdeptspring.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> // JpaRepository<Klasse, DatentypPK>
{
}
