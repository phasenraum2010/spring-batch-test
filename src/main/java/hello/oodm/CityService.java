package hello.oodm;

import java.util.List;

/**
 * Created by tw on 28.03.17.
 */
public interface CityService {

    List<City> findAll();

    void create(City city);

    int deleteAll();

}
