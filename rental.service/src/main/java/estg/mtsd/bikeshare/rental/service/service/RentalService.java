package estg.mtsd.bikeshare.rental.service.service;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.vo.RentalVo;


public interface RentalService {

    RentalVo rental(RentalVo rentalVo) throws Exception;

    void update(RentalVo rentalVo);

    void delete(Integer id);

    RentalVo get(Integer id);

    List<RentalVo> getAll();

}
