package estg.mtsd.bikeshare.dockmanagement.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.dockmanagement.service.entity.Dock;

@Repository
public interface DockDao extends JpaRepository<Dock, Integer>{

}