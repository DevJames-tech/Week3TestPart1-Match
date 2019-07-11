package com.example.week3testpart1_matchoccurances;

import java.util.Stack;

public class MatchChars {

    public boolean checkString(String strToMatch) {

        char Array[] = {'(', ')', '{', '}', '[', ']'};
        char toMatchArray[] = strToMatch.toCharArray();
        // read chosen string into a character array for iteration
        //stack chosen for easy adding and removing of its elements(push,Pop)
        Stack<Character> myStack = new Stack();

        //iterates through the array
        for (Character inArr : toMatchArray) {

            //compares items in array to chosen chars
            if (inArr == '{' || inArr == '[' || inArr == '(') {

                // if there is a match push onto the stack
                myStack.push(inArr);
            }
            //check for every version of the brackets, for either cases if equal check the stack iff its empty return false else remove the ele
            else if(inArr == ']') {

                if (myStack.isEmpty() || myStack.peek() != '[') {
                    return false;
                }
                myStack.pop();
            }
            else if(inArr == ')') {

                if (myStack.isEmpty() ||  myStack.peek() != '('){

                    return false;
                }

                myStack.pop();
            }
            else if (inArr == '}') {

                if (myStack.isEmpty() ||  myStack.peek() != '{'){

                    return false;
                }

                myStack.pop();
            }
        }
        //reset the stack
        return myStack.size() == 0;
    }



    public static void main(String[] args){
        MatchChars meChars = new MatchChars();
        String testString = " ({})[] "; //Should return true;
        // String testString2 = "[]{]}"; //Should return false


        System.out.println( meChars.checkString(testString));
        //System.out.println(meChars.checkString(testString2));
    }

}