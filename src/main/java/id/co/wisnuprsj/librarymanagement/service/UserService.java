package id.co.wisnuprsj.librarymanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.wisnuprsj.librarymanagement.model.response.UserRs;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;
    private final ObjectMapper mapper;

    public UserService(WebClient.Builder webClientBuilder, ObjectMapper mapper) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
        this.mapper = mapper;
    }

    public List<UserRs> getAllUsers() {
        return this.webClient.get().uri("/users")
                .retrieve()
                .bodyToFlux(UserRs.class)
                .collectList()
                .block();
    }

}
