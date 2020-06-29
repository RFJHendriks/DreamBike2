package dockingBike;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockingRepository extends JpaRepository<Docking, Integer> {

	Docking findByDockingId(int dockingId);

	Set<Docking> getAll();

}
