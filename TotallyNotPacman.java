public class TotallyNotPacman {
	public static void printLevel(int[][] level) {
		for(int i = 0; i < level.length; i++) {
			for (int j = 0; j < level[i].length; j++) {
				if (level[i][j] == 0)
					System.out.print(" ");
				else if (level[i][j] == 1)
					System.out.print("X");
				else if (level[i][j] == 2)
					System.out.print("*");
				else if (level[i][j] == 3)	
					System.out.print("+");
			}
			System.out.println();
		}
	}
	
	public static boolean isUnderThreat(int[][] level, int playerRow, int playerColumn) {
		
		//checks every row from the first one up to the character's row for enemies
		for(int i = 0; i < playerRow; i++) {
			if (level[i][playerColumn] == 2) {
					//checks from the found enemy's row to the character's row for walls
					for(int j = i + 1; j < playerRow; j++) {
						if (level[j][playerColumn] == 1) 
							break;
					}	
			return true;
			}
		}
		
		//checks every row from the character's row to the last row for enemies
		for(int i = playerRow + 1; i < level.length; i++) {
			if (level[i][playerColumn] == 2) {
					//checks from the character's row to the enemy's row for walls
					for(int j = playerRow + 1; j < i; j++) {
						if (level[j][playerColumn] == 1) 
							break;
					}	
			return true;
			}
		}
		
		//checks every column from the first one up to the character's column for enemies
		for(int i = 0; i < playerColumn; i++) {
			if (level[playerRow][i] == 2) {
				//checks every column from the found enemy's column to the character's column for walls
				for (int j = i + 1; j < playerColumn; j++) {
					if (level[playerRow][j] == 1)
						break;
				}
			return true;
			}
		}
		
		//checks every column from the character's column to the last column for enemies
		for(int i = playerColumn + 1; i < level[playerRow].length; i++) {
			if (level[playerRow][i] == 2) {
				//checks every column from the character's column to the found enemy's column for walls
				for (int j = playerColumn + 1; j < i; j++) {
					if (level[playerRow][j] == 1)
						break;
				}
			return true;
			}
		}
	return false;	
	}
	
	public static void main(String[] args) {
	int[][] x = { {1, 1, 2, 1, 0, 1, 1}, {1, 1, 0, 2, 0, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {0, 3, 0, 2, 1, 0, 1}};
	printLevel(x);
	System.out.println("It is " + isUnderThreat(x, 5, 1) + " that the main character is under threat.");
	}

}
