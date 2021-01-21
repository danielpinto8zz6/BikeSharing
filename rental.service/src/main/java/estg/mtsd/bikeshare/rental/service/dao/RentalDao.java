package estg.mtsd.bikeshare.rental.service.dao;

import estg.mtsd.bikeshare.rental.service.entity.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer> {

    Page<Rental> findAllByUserEmail(Pageable pageable, String email);

}