package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class User {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
