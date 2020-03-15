package pl.north93.arrays.impl;

import lombok.Data;
import pl.north93.arrays.ArrayType;

@Data // allArgsConstructor, getters, equals&hashCode
class ClassCacheKey
{
    private final int size;
    private final ArrayType type;
}
