import java.io.*;

public class TrieNode{

    TrieNode Trie[];
    Boolean endOfWord; 

    public TrieNode () {
        Trie = new TrieNode[123];

        for(int i = 0; i < 123; i++)
        {
            Trie[i] = null;
        }
        endOfWord = false;
    }


}