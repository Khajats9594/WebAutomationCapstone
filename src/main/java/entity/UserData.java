package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class UserData {
    @JsonProperty("validUserData")
    private User validUser;

    @JsonProperty("invalidUserData")
    private User invalidUser;

}
