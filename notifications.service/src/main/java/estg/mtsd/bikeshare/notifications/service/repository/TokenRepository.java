package estg.mtsd.bikeshare.notifications.service.repository;

public interface TokenRepository {

    String findById(String email);

}
