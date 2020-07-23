package refactor.code.playground.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Car implements Serializable {
    private static final long serialVersionUID = 2841676163909722589L;

    private String make;

    private int numberOfSeats;

    private CarType carType;
}
