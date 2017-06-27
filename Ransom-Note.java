mport java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) 
    {
        magazineMap = new HashMap<String,Integer>();
        noteMap = new HashMap<String,Integer>();
        
            mapit(magazineMap,magazine);
            mapit(noteMap, note);
       
    }
    
    public void mapit(Map<String, Integer> hmap, String val)
    {
            if(val==null)
                {
                return;
            }
        
        String[] word_array = val.split("\\s+");
        
        for( String word: word_array)
        {
            if(!hmap.containsKey(word))
            {
                hmap.put(word,1);    
            }
            else
            {
                Integer a= hmap.get(word);
                if (a == null) 
                    a = 0;
                hmap.put(word, a + 1);
            }
        }
        
    }
    
    public boolean solve() 
    { 
        for (String key : noteMap.keySet()) 
        {
            if (!magazineMap.containsKey(key)) 
                return false;

            int magazineCount = magazineMap.get(key);
            int noteCount = noteMap.get(key);

            if (magazineCount < noteCount) 
                return false;
        }

        return true;
    
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

