package by.starodubtsev.Model;

import java.io.Serializable;

public interface BaseEntity<KEY extends Serializable>{
    public KEY getId();
}
