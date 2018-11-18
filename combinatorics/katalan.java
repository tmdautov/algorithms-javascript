/*
Числа Каталана встречаются в большом количестве задач комбинаторики. n-ое число Каталана — это:
— Количество корректных скобочных последовательностей
Количество корректных скобочных последовательностей, состоящих из n открывающих и n закрывающих скобок. Для n = 3, возможные варианты:
((())), 
()(()), 
()()(), 
(())(), 
(()())
— Count the number of possible Binary Search Trees with n keys
— Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves


*/

class CatalnNumber { 
  
    // A recursive function to find nth catalan number 
  
    int catalan(int n) { 
        int res = 0; 
          
        // Base case 
        if (n <= 1) { 
            return 1; 
        } 
        for (int i = 0; i < n; i++) { 
            res += catalan(i) * catalan(n - i - 1); 
        } 
        return res; 
    } 
  
    public static void main(String[] args) { 
        CatalnNumber cn = new CatalnNumber(); 
        for (int i = 0; i < 10; i++) { 
            System.out.print(cn.catalan(i) + " "); 
        } 
    } 
} 
