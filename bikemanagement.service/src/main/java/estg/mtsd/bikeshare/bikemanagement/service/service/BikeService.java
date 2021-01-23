package estg.mtsd.bikeshare.bikemanagement.service.service;

import estg.mtsd.bikeshare.shared.library.vo.BikeVo;

import java.util.List;

public interface BikeService {

    void save(BikeVo bikeVo);

    void update(BikeVo bikeVo);

    void delete(Integer id);

    BikeVo get(Integer id);

    List<BikeVo> getAll();

}

