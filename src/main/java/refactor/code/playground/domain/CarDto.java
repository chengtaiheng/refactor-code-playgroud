package refactor.code.playground.domain;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto implements Serializable {
    private static final long serialVersionUID = 2769013380263331935L;

    private String make;

    private int seatCount;

    private String carType;

}
