import java.util.Deque;

public interface ITransporter<T> {

    boolean isLoadable(T t);

    boolean isUnloadable();

    void load(T t);

    void unload();

    Deque<T> getCargo();



}
