//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Subject subject = new Subject();
        subject.attach(new ConcreteObserver1());
        subject.attach(new ConcreteObserver2());

        subject.setState("New State 1");
        subject.setState("New State 2");

        Context context = new Context();

        State startState = new StartState();
        startState.doAction(context);
        System.out.println("Current State: " + context.getState());

        State stopState = new StopState();
        stopState.doAction(context);
        System.out.println("Current State: " + context.getState());

        Context1 context1 = new Context1(new OperationAdd());
        System.out.println("10 + 5 = " + context1.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context1.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context1.executeStrategy(10, 5));


        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();

        ComputerPart keyboard = new Keyboard();
        ComputerPart monitor = new Monitor();
        ComputerPart mouse = new Mouse();

        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
        keyboard.accept(visitor);
        monitor.accept(visitor);
        mouse.accept(visitor);
    }
}