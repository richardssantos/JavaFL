import java.util.Deque;
import java.util.ArrayDeque;
public class Secd {

    private static Deque<Object> stack = new ArrayDeque<>();
    //coloca o objeto no topo da pilha
    public static void pushO(Object obj) {
        stack.push(obj);
    }

    //coloca o objeto com distancia n do topo da pilha no topo da pilha
    public static void push(int n){
        Deque<Object> controlStack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            controlStack.push(stack.pop());
        }
        Object aux = stack.pop();
        stack.push(aux);
        for(int i = 0; i < n; i++){
            stack.push(controlStack.pop());
        }
        stack.push(aux);
    }

    public static Object pop(){
        return stack.pop();
    }

    public static Object getLast(){
        return stack.getLast();
    }

    //Move o valor no topo da pilha n posições para baixo
    public static void drop(int n){
        Object top = stack.pop();
        for(int i = 0; i < n; i++) {
            stack.pop();
        }
        pushO(top);
    }

    public static void call(Func f) {
        f.code();
    }

    public static void add(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 + arg2);
    }

    public static void sub(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 - arg2);
    }

    public static void mult(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 * arg2);
    }
    public static void div(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 / arg2);
    }

    public static void menor(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 < arg2);
    }

    public static void maior(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 > arg2);
    }

    public static void menorIgual(){
        int arg1 = (int) stack.pop();
        int arg2= (int) stack.pop();
        stack.push(arg1 <= arg2);
    }

    public static void maiorIgual(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 >= arg2);
    }

    public static void igual(){
        int arg1 = (int) stack.pop();
        int arg2 = (int) stack.pop();
        stack.push(arg1 == arg2);
    }

    public static void and(){
        boolean arg1 = (boolean) stack.pop();
        boolean arg2 = (boolean) stack.pop();
        stack.push(arg1 && arg2);
    }

    public static void or(){
        boolean arg1 = (boolean) stack.pop();
        boolean arg2 = (boolean) stack.pop();
        stack.push(arg1 || arg2);
    }

    public static void mkap(int n){
        Deque<Object> controlStack = new ArrayDeque<>();
        Object f = stack.pop();
        for(int i = 0; i < n; i++) {
            controlStack.push(stack.pop());
        }
        Mkap c = new Mkap((Func) f,n, controlStack);
        stack.push(c);
    }

    public static void apply(int n){
        Deque<Object> controlStack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            controlStack.push(stack.pop());
        }
        Mkap c = (Mkap) controlStack.getLast();
        if(c.f.nargs <= c.args+n){
            for(int i = 0; i < c.controlStack.size(); i++){
                stack.push(c.controlStack.pop());
            }
            Secd.call(c.f);
        } else{
            Mkap newC = new Mkap((Func) c.f,c.f.nargs+1, controlStack);
            stack.push(newC);
        }
    }

    public static void construct(int tag, int arity){
        Deque<Object> controlStack = new ArrayDeque<>();
        for(int i = 0; i < arity; i++) {
            controlStack.push(stack.pop());
        }
        Construct cons = new Construct(tag, arity, controlStack);
        printStack();
        stack.push(cons);
    }

    // imprime o topo da pilha
    public static void print() {
        System.out.println("-------------------------------");
        System.out.println(stack.getLast());
    }

    public static void printN(int n) {
        System.out.println("-------------------------------");
        Deque<Object> auxStack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            auxStack.push(stack.pop());
        }
        for(Object item: auxStack){
            System.out.println(item);
        }
        for(int i = 0; i < n; i++){
            stack.push(auxStack.pop());
        }
    }

    public static void printCons(Construct item, Deque<Object> elements){
        for(Object it: ((Construct) item).stack){
            if(it instanceof Construct){
                printCons(((Construct) it),elements);
            } else {
                elements.addLast(it);
            }
        }
    }

    public static void printStack() {
        System.out.println("-------------------------------");
        StringBuilder result = new StringBuilder();
        Deque<Object> elements = new ArrayDeque<>();

        for(Object item: stack){
            if(item instanceof Construct){
                result.append("[");
                printCons((Construct) item,elements);
                while (!elements.isEmpty()) {
                    result.append(elements.removeLast());
                    if (!elements.isEmpty()) {
                        result.append(",");
                    }
                }
                result.append("]");
                System.out.println(result.toString());
            } else {
                System.out.println(item);
            }
        }
    }

}
