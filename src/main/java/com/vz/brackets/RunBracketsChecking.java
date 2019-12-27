package com.vz.brackets;

public class RunBracketsChecking {

    public static void main(String[] args) {

	String bracketsSequence = "([)]({)})(";

	System.out.printf("%s\nThe brackets sequence validity is: %s\n",
            bracketsSequence,
            checkBracketsSequenceValidityOnHumanLogicBased(bracketsSequence));
    }

    public static boolean checkBracketsSequenceValidityOnHumanLogicBased(String braces) {
        if (braces == null || braces.length() <= 1) {
            return false;
        } else if (braces.charAt(0) == ')' || braces.charAt(0) == ']' || braces.charAt(0) == '}') {
            return false;
        }

        boolean result = false;
        int countOpenR = 0;//(
        int countCloseR = 0;//)
        int countOpenS = 0;//[
        int countCloseS = 0;//]
        int countOpenC = 0;//{
        int countCloseC = 0;//}

        for (int i = 0; i < braces.length(); i++) {
            int innerCountOpenR = 0;//(
            int innerCountCloseR = 0;//)
            int innerCountOpenS = 0;//[
            int innerCountCloseS = 0;//]
            int innerCountOpenC = 0;//{
            int innerCountCloseC = 0;//}
            switch (braces.charAt(i)) {
                case '(':
                    countOpenR++;
                    for (int j = i + 1; j < braces.length(); j++) {
                        if (braces.charAt(j) == ')' && innerCountOpenR == innerCountCloseR && innerCountOpenS == innerCountCloseS && innerCountOpenC == innerCountCloseC) {
                            countCloseR++;
                            break;
                        } else if (braces.charAt(j) == '(') {
                            innerCountOpenR++;
                        } else if (braces.charAt(j) == '[') {
                            innerCountOpenS++;
                        } else if (braces.charAt(j) == '{') {
                            innerCountOpenC++;
                        } else if (braces.charAt(j) == ')') {
                            innerCountCloseR++;
                        } else if (braces.charAt(j) == ']') {
                            innerCountCloseS++;
                        } else if (braces.charAt(j) == '}') {
                            innerCountCloseC++;
                        }
                    }
                    break;
                case '[':
                    countOpenS++;
                    for (int k = i + 1; k < braces.length(); k++) {
                        if (braces.charAt(k) == ']' && innerCountOpenR == innerCountCloseR && innerCountOpenS == innerCountCloseS && innerCountOpenC == innerCountCloseC) {
                            countCloseS++;
                            break;
                        } else if (braces.charAt(k) == '(') {
                            innerCountOpenR++;
                        } else if (braces.charAt(k) == '[') {
                            innerCountOpenS++;
                        } else if (braces.charAt(k) == '{') {
                            innerCountOpenC++;
                        } else if (braces.charAt(k) == ')') {
                            innerCountCloseR++;
                        } else if (braces.charAt(k) == ']') {
                            innerCountCloseS++;
                        } else if (braces.charAt(k) == '}') {
                            innerCountCloseC++;
                        }
                    }
                    break;
                case '{':
                    countOpenC++;
                    for (int l = i + 1; l < braces.length(); l++) {
                        if (braces.charAt(l) == '}' && innerCountOpenR == innerCountCloseR && innerCountOpenS == innerCountCloseS && innerCountOpenC == innerCountCloseC) {
                            countCloseC++;
                            break;
                        } else if (braces.charAt(l) == '(') {
                            innerCountOpenR++;
                        } else if (braces.charAt(l) == '[') {
                            innerCountOpenS++;
                        } else if (braces.charAt(l) == '{') {
                            innerCountOpenC++;
                        } else if (braces.charAt(l) == ')') {
                            innerCountCloseR++;
                        } else if (braces.charAt(l) == ']') {
                            innerCountCloseS++;
                        } else if (braces.charAt(l) == '}') {
                            innerCountCloseC++;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if (countOpenR != countCloseR || countOpenS != countCloseS || countOpenC != countCloseC ||
                (countOpenR + countCloseR + countOpenS + countCloseS + countOpenC + countCloseC) == 0) {
            return false;
        } else {
            result = true;
        }

        return result;
    }
}
