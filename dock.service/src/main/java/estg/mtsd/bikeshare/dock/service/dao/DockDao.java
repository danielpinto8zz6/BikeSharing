package estg.mtsd.bikeshare.dock.service.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.dock.service.entity.Dock;

@Repository
public interface DockDao extends JpaRepository<Dock, Integer>{
    Page<Dock> findAll(Pageable pageable);

    Page<Dock> findByBikeIdNotNull(Pageable pageable);
}