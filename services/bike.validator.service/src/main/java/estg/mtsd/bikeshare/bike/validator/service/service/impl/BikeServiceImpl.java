package estg.mtsd.bikeshare.bike.validator.service.service.impl;

import estg.mtsd.bikeshare.bike.validator.service.dao.BikeDao;
import estg.mtsd.bikeshare.bike.validator.service.entity.Bike;
import estg.mtsd.bikeshare.bike.validator.service.service.BikeService;
import estg.mtsd.bikeshare.shared.library.vo.BikeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    BikeDao bikeDao;

    @Override
    @Transactional
    public BikeVo get(Integer id) {
        Optional<Bike> bikeOptional = bikeDao.findById(id);
        BikeVo bikeVo;
        if (bikeOptional.isPresent()) {
            bikeVo = new BikeVo();
            BeanUtils.copyProperties(bikeOptional.get(), bikeVo);
        } else {
            throw new EntityNotFoundException();
        }

        return bikeVo;
    }
}

