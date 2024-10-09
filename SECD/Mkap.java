import java.util.Deque;

public class Mkap {
    Func f;
    int args;
    Deque<Object> controlStack;

    public Mkap(Func f, int args, Deque<Object> stack) {
        this.f = f;
        this.args = args;
        this.controlStack = stack;
    }

}
