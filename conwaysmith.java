package ucsd;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class conwaysmith {
	
	private static final int MATCH_SCORE = 2;
	private static final int GAP_PENALTY = -1;
	
	
	
	public Tuple scoreSimilarity(String str1, String str2) {
		if (str1 == null || str2 == null) {
			throw new IllegalArgumentException("Invalid null argument");
		}
		int maxScore = 0;
		str1 = str1.trim().toUpperCase();
		str2 = str2.trim().toUpperCase();
		if (str1.length() == 0 || str2.length() == 0) {
			throw new IllegalArgumentException("Invalid empty string argument");
		}
		// create score matrix
		int[][] scoreMatrix = new int[str1.length()+1][str2.length()+1];
		ArrayList<Position>[][] list = new ArrayList[str1.length()+1][str2.length()+1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				list[i][j] = new ArrayList<Position>();
			}
		}
		int maxIdxRow = 0;
		int maxIdxCol = 0;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				int leftScore = 0;
				int upScore = 0;
				int diagScore = 0;
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					leftScore = Math.max(leftScore, scoreMatrix[i][j-1] + GAP_PENALTY);
					upScore = Math.max(upScore, scoreMatrix[i-1][j] + GAP_PENALTY);
					diagScore = Math.max(diagScore, scoreMatrix[i-1][j-1] + MATCH_SCORE);
					list[i][j].add(new Position(i-1,j-1));
				} else {
					leftScore = Math.max(leftScore, scoreMatrix[i][j-1] + GAP_PENALTY);
					upScore = Math.max(upScore, scoreMatrix[i-1][j] + GAP_PENALTY);
					diagScore = Math.max(diagScore, scoreMatrix[i-1][j-1] + GAP_PENALTY);
				}
				int bestScore = Math.max(leftScore, Math.max(upScore, diagScore));
				if (bestScore == leftScore) list[i][j].add(new Position(i, j-1));
				if (bestScore == upScore) list[i][j].add(new Position(i-1, j));
				if (bestScore == diagScore) list[i][j].add(new Position(i-1, j-1));
				scoreMatrix[i][j] = bestScore;
				if (bestScore > maxScore) {
					maxIdxRow = i;
					maxIdxCol = j;
					maxScore = bestScore;
				}
			}
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		//StringBuilder sb = new StringBuilder("");
		while (scoreMatrix[maxIdxRow][maxIdxCol] > 0) {
			int bestScore = 0;
			for (Position p : list[maxIdxRow][maxIdxCol]) {
				bestScore = Math.max(0, scoreMatrix[p.i][p.j]);
			}
			if (scoreMatrix[maxIdxRow-1][maxIdxCol] == bestScore 
					&& list[maxIdxRow][maxIdxCol].contains(new Position(maxIdxRow-1,maxIdxCol))) {
				sb1.insert(0, str1.charAt(--maxIdxRow));
				sb2.insert(0, '-');
			} else 
			if (scoreMatrix[maxIdxRow-1][maxIdxCol-1] == bestScore 
				&& list[maxIdxRow][maxIdxCol].contains(new Position(maxIdxRow-1,maxIdxCol-1))) {
				sb1.insert(0, str1.charAt(--maxIdxRow));
				sb2.insert(0, str2.charAt(--maxIdxCol));
			} else {
					sb1.insert(0, '-');
					sb2.insert(0, str2.charAt(--maxIdxCol));
			}
		}
		return new Tuple(maxScore, sb1.toString(), sb2.toString());
	}
	
	private class Position {
		public int i;
		public int j;
		public Position(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public boolean equals(Object p) {
			if (p == this) {
				return true;
			}
			Position pos = (Position) p;
			return pos.i == i && pos.j == j;
		}
	}
	
	public class Tuple {
		public int score;
		public String str1;
		public String str2;
		public List<String> substrings = new LinkedList<>();
		public Tuple(int score, String str1, String str2) {
			this.score = score;
			this.str1 = str1;
			this.str2 = str2;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					sb.append(str1.charAt(i));
				} else if (sb.length() > 3) {
					substrings.add(sb.toString());
					sb = new StringBuilder();
				} else {
					sb = new StringBuilder();
				}
			}
			if (sb.length() > 3) {
				substrings.add(sb.toString());
			}
		}
	}
	
}
