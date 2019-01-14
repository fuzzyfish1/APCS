package chapter5;

public class VendingMachine {

    private int numCans, numTokens;

    public VendingMachine(int numCans, int numTokens) {
        this.numCans = numCans;
        this.numTokens = numTokens;
    }

    public VendingMachine() {
        this(0, 0);
    }

    public void fillUp(int inputCans) {
        if(inputCans > 0) {
            numCans += inputCans;
        } else {
            System.out.println("Please enter greater than 0 cans.");
        }
    }

    public void insertToken(int inputTokens) {
        if(inputTokens > 0) {
            int returnCans = 0;
            int returnTokens = 0;
            if (numCans >= inputTokens) {
                numTokens += inputTokens;
                numCans -= inputTokens;
                returnCans = inputTokens;
            } else if (numCans > 0) {
                System.out.println("Sorry, not enough cans.");
                returnCans = numCans;
                returnTokens = inputTokens - numCans;
                numTokens += numCans;
                numCans = 0;
            } else {
                System.out.println("Sorry, no cans left.");
                returnTokens = inputTokens;
            }
            System.out.println(report(inputTokens, returnCans, returnTokens));
        } else {
            System.out.println("Please insert greater than 0 tokens.");
        }
    }

    public void insertToken() {
        insertToken(1);
    }

    public int getCanCount() {
        return numCans;
    }

    public int getTokenCount() {
        return numTokens;
    }

    private String report(int tokens, int cans, int returnTokens) {
        return "Tokens Inserted: " + tokens + ", Cans Deployed: " + cans + ", Tokens Returned: " + returnTokens;
    }
}
