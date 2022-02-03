import java.util.Deque;

public interface ILoadable {


    RampPosition getRampPos();

    void setRampPos(RampPosition rampPos);

    boolean isLoadable();

    boolean isUnloadable();

    void load();


    void unload();

    Deque<Car> getCargo();



}
