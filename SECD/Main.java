public class Main {
  public static void main(String[] args) {
    Secd.pushO(10);
    Secd.pushO(10);
    Secd.add();
    Secd.push(0);
    Secd.push(1);
    Secd.add();
    Secd.drop(1);
    Secd.push(0);
    Secd.push(1);
    Secd.add();
    Secd.drop(1);
    Secd.printStack();
  }
}
