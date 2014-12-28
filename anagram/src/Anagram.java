
import java.util.ArrayList;

import java.util.*;


public class Anagram {
    private String word;

    public Anagram( String word ){
        this.word = word.trim();
    }

    private String sortString(String strToSort){
        char[] ar = strToSort.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }

    public List<String> areAnagrams( List<String> potentialAnagrams ){

        // remove duplicates
        Set<String> anagramSet = new HashSet<String>(potentialAnagrams);
        List<String> localPotentialAnagrams = new ArrayList<String>(anagramSet);

        // remove empties
        for (String word : potentialAnagrams) {
            if ( word.trim().equals("") ) {
                localPotentialAnagrams.remove(word);
            }
        }

        // remove root word
        for (String word : potentialAnagrams) {
            if( word.equals( this.word ) )
                localPotentialAnagrams.remove(word);
        }

        // find anagrams
        List<String> anagrams = new ArrayList<String>();
        for( String word : localPotentialAnagrams ) {
            if( sortString(word).equals( sortString(this.word) ) )
                anagrams.add( word.trim() );
        }

        return anagrams;
    }
}
