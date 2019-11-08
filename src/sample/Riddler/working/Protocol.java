package sample.Riddler.working;

public class Protocol {

    private static final int BEGIN = 0;
    private static final int QUESTION = 1;
    private static final int VALIDATION = 2;
    private static final int QUIT = 3;

    private static final int NUMRIDDLES = 5;

    private int state = BEGIN;
    private int currentRiddle = 0;

    private String[] riddles = {
            "I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?",
            "The more you take, the more you leave behind. What am I?",
            "What room do ghosts avoid?",
            "What belongs to you, but other people use it more than you?",
            "My life can be measured in hours, I serve by being devoured. Thin, I am quick. Fat, I am slow. Wind is my foe. What am I?"
    };
    private String[] answers = {
            "Fire",
            "Footsteps",
            "The living room",
            "Your name",
            "A candle"
    };
    public String processInput(String theInput) {
        String theOutput = null;
        if (state == BEGIN){
            System.out.println("WAITING");
            theOutput = "Welcome to the riddleFactory, do you want to begin?";
            state = QUESTION;
        }
        else if (state == QUESTION){
            if(theInput.equalsIgnoreCase("Yes")
                    || theInput.equalsIgnoreCase("Y")){
                theOutput = riddles[currentRiddle];
                state = VALIDATION;
            }else if (theInput.equalsIgnoreCase("No")
                    || theInput.equalsIgnoreCase("N")){
                theOutput = "Bye";
                state = QUIT;
            }
        }
        else if (state == VALIDATION){
            if(theInput.equalsIgnoreCase(answers[currentRiddle])){
                System.out.println("CORRECT ANSWER");
                theOutput = answers[currentRiddle]
                        + " was the correct answer! Want another? (Yes/No)";
                currentRiddle++;
            }else {
                theOutput = "Wrong answer, try again? (Yes/No)";
                System.out.println("WRONG ANSWER");
            }
            state = QUESTION;
        }
        return theOutput;
    }
}
