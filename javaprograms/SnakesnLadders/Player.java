class Player {
	private String name;
	private int score;
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
}