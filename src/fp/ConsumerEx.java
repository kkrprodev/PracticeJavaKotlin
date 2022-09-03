package fp;

@FunctionalInterface
public interface  ConsumerEx<T> {
    void execute(T t) throws Exception;
}
