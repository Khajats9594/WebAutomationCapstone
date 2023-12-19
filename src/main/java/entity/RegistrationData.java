package entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
public class RegistrationData {

    @JsonProperty("validRegistrationData")
    private Registration validRegistration;

    @JsonProperty("inValidRegistrationData")
    private Registration invalidRegistration;
}
