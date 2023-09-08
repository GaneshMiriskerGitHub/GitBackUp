package package3_2D_Array;

public class P5_Word_Search { // back tracking , or Graph DFS something
	
	public static boolean exist(char[][] board, String word) {
		
        
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				
			}
		}
		
    }

	public static void main(String[] args) {

		char[][] board = {
				{ 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		
		String word = "ABCCED";
		
		System.out.println(exist(board, word));

	}

}
