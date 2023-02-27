import com.example.tp_spring.repository.ClientRepository;
import com.example.tp_spring.service.ClientService;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// @RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testDelete() {
        Long clientId = 1L;
        clientService.delete(clientId);
        verify(clientRepository, times(1)).deleteById(clientId);
    }



}