
public class BigNumArithmetic {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    public LList add(LList first, LList second) {
        LList result;
        int x, y, overflow;
        first.moveToStart();
        second.moveToStart();
        while (!first.isAtEnd() || !second.isAtEnd()) {
            if (first.isAtEnd())
                x = 0;
            else
                x = first.getValue();
            if (second.isAtEnd())
                y = 0;
            else
                y = second.getValue();
            int temp = x + y;
            result.append(temp % 10);
            overflow = temp / 10;
        }
        return result;
    }


    public LList multiply(LList first, LList second) {
        LList result;
        int x, y, overflow;
        first.moveToStart();
        second.moveToStart();
        while (!first.isAtEnd()) {
            while (!second.isAtEnd()) {
                x = first.getValue();
                y = second.getValue();
                
            }
        }
        return result;
    }

}
