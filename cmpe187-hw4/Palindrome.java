package hw4;
import java.io.*;
import java.util.Stack;
/**
 * @author ledao
 * @version 1.0
 * Palindrome.java checks if a string is a palindrome and its length without using recursion.
 */
public class Palindrome
{
    private static final String FILENAME = "./hw4/palindromes.txt";
    public static void main(String args[])
    {
        // attempted to read from a file
        BufferedReader br = null;
        FileReader fr = null;

        try
        {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null)
            {
                System.out.println(line);
                if (is_palindrome(line))
                {
                    System.out.println("This is a palindrome.");
                    System.out.println("Length = " + line.length() + "\n");
                }
                else
                {
                    System.out.println("This is not a palindrome\n");
                }
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Check if a string is a palindrome
     * @param p input string
     * @return true if string is a palindrome, false if it is not.
     */
    private static boolean is_palindrome(String p)
    {
        String copy = p;
        String result = "";
        copy = p.replaceAll("[^a-zA-Z]", "");
        copy = copy.toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<copy.length(); i++)
        {
            char c = copy.charAt(i);
            stack.push(c);
        }

        for (int i=0; i<copy.length(); i++)
        {
            result = result + stack.pop().toString();
        }
        return(result.equals(copy));
    }

}
