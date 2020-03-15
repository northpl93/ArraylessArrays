package pl.north93.arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ArrayType
{
    OBJECT("Ljava/lang/Object;"),
    BOOLEAN("Z"),
    BYTE("B"),
    CHAR("C"),
    SHORT("S"),
    INTEGER("I"),
    FLOAT("F"),
    LONG("J"),
    DOUBLE("D");

    private final String fieldDescriptor;
}
