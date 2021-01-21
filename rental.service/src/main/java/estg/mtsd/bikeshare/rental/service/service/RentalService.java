package estg.mtsd.bikeshare.rental.service.service;

import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RentalService {

    RentalVo rental(RentalVo rentalVo) throws Exception;

    void update(RentalVo rentalVo);

    void delete(Integer id);

    RentalVo get(Integer id);

    Page<RentalVo> getAll(Pageable pageable, String email);

}
