import java.util.Deque;

public interface ILoadable<T extends Car> {


    RampPosition getRampPos();

    void setRampPos(RampPosition rampPos);

    boolean isLoadable(T car);


    boolean isUnloadable();

    void load(T car);

    void unload();

    Deque<T> getCargo();



}
