import java.util.Deque;

public class Construct {
    int tag;
    int arity;
    Deque<Object> stack;
    public Construct(int tag, int arity, Deque<Object> stack) {
        this.tag = tag;
        this.arity = arity;
        this.stack = stack;
    }

}
