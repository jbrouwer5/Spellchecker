import java.io.File;
import java.util.Scanner;

public class Spellchecker{

public static void showSuggestions(TrieNode prefixTree, String res){
    if (prefixTree.endOfWord) {
        System.out.print(res + ", ");
    }

    for (int i = 0; i < 123; i++) {

        if (prefixTree.Trie[i] != null) {
            showSuggestions(prefixTree.Trie[i], (res + (char)i)); 
        }
    } 
}

public static void insert(TrieNode prefixTree, String insertion){

    TrieNode pointer = prefixTree; 
    for (int i = 0; i < insertion.length(); i++){
        if (pointer.Trie[(int)insertion.charAt(i)] == null){
            pointer.Trie[insertion.charAt(i)] = new TrieNode(); 
        }

        pointer = pointer.Trie[insertion.charAt(i)]; 
    }

    pointer.endOfWord = true; 
} 

public static Boolean checkPresent(TrieNode prefixTree, String string){
     
    TrieNode pointer = prefixTree; 

    for (int i = 0; i < string.length(); i++){

        if (pointer.Trie[string.charAt(i)] == null){

            if (i == string.length() - 1){
                System.out.println("Suggestions:\n"); 
            }
            else{
                System.out.println("Did you mean?\n"); 
            }
        
            showSuggestions(prefixTree, string.substring(0, i));
            System.out.println("");
            return false; 
        }

        pointer = pointer.Trie[string.charAt(i)]; 
    }

    if (pointer.endOfWord == true) {
        return true; 
    }

    System.out.println("Suggestions:\n");
    showSuggestions(prefixTree, string); 
    System.out.println("");

    return false; 
}

public static void main (String[] args) throws Exception {
    TrieNode root = new TrieNode(); 

    File file = new File("words_alpha.txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
        insert(root, sc.nextLine()); 
    }
      
    sc.close(); 

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Feel free to type\n");

    

    while (true) {
        String input = myObj.nextLine();
        
        if (checkPresent(root, input)){
            System.out.println("Valid word\n"); 
        } 
    }
}

}