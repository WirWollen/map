package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class WorkloadService {
    private final Random random = new Random();

    public int calculateWorkload() {
        return random.nextInt(101);
    }
}
