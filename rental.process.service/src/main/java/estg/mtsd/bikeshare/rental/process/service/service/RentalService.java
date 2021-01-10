package estg.mtsd.bikeshare.rental.process.service.service;

import estg.mtsd.bikeshare.shared.library.vo.RentalVo;

import java.util.List;


public interface RentalService {

    void update(RentalVo rentalVo);

    void delete(Integer id);

    RentalVo get(Integer id);

    List<RentalVo> getAll();

}
