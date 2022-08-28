import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"127.0.0.1", "172.0.32.11", "96.44.183.149", "172.0.00.00"})
    void test_byIp(String ip){
        GeoService geoService = new GeoServiceImpl();
        Country result = geoService.byIp(ip).getCountry();
        if (ip == "127.0.0.1") {
            Assertions.assertEquals(null, result);
            if (ip == "172.0.32.11") {
                Assertions.assertEquals(Country.RUSSIA, result);
                if (ip == "96.44.183.149") {
                    Assertions.assertEquals(Country.USA, result);
                }
            }
            else Assertions.assertEquals(Country.RUSSIA, result);
        }
    }
}
