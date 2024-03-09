package Labs.Week2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression)
    {
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] elements = expression.split(" "); // if we have ( 1 + ( 2 + 4 ) ) we will split it into (, 1, +, ...)

        for (String element : elements) {
            if (element.equals("(")) {
                continue;   // if we get "(" this is bracket and we are only pass this element and search for next one
            } else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/") || element.equals("^") || element.equals("√") || element.equals("%")) {
                operators.push(element); // pushing into operator stack
            } else if (element.equals(")") && operators.peek().equals("√")) {
                operators.pop();
                Double value = values.pop();
                values.push(Math.sqrt(value)); // ako je vrh steka korijen i zagrada ")" izvodimo operaciju kvadratnog korijena
                                               // tako sto se iz steka izdvoji operator i vrijednost a rezultat se vraca na stek vrijednost
            } else if (element.equals(")") && !operators.peek().equals("√")) {
                String operator = operators.pop();
                Double value2 = values.pop();
                Double value1 = values.pop(); // ako vrh steka nije korijen onda se izvodi aritmeticka operacija izvlacenjem
                                              // dvije vrijednost iz steka vrijednosti i jedan operator iz steka operatora
                                              // a rezultat se vraca na stek vrijednosti

                switch (operator) {
                    case "+" :
                        values.push(value1 + value2);
                        break;
                    case "-" :
                        values.push(value1 - value2);
                        break;
                    case "*" :
                        values.push(value1 * value2);
                        break;
                    case "/" :
                        values.push(value1 / value2);
                        break;
                    case "^" :
                        values.push(Math.pow(value1, value2));
                        break;
                    case "%" :
                        values.push(value1 % value2);
                        break; // prolazimo i ispitujemo koji je operator i za svaki posebno pisemo njegovu ulogu tj. operaciju
                }
            } else {
                double number = Double.parseDouble(element);
                values.push(number);
            }
        }
        return values.pop();

    }
}
