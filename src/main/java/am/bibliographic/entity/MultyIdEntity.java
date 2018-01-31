package am.bibliographic.entity;

public interface MultyIdEntity extends Entity {
    default int getId(){
        return -1;
    }
}
