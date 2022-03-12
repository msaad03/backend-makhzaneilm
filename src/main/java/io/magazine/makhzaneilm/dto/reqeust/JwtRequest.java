package io.magazine.makhzaneilm.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 2926468589005150707L;

    @NotBlank(message = "Email address is required")
    private String userName;

    @NotBlank(message = "Password is required")
    private String password;

}
