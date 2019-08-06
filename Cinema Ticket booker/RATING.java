
public enum RATING {
	G(0), P(12), M(16), U(150);						//Variables allowed to be used for enum
	
	private int age;
	
	private RATING(int minAge)						//Constructor for enum
	{
		this.age = minAge;
	}
	
	public int getAge() {							//Method to get age
		return age;
	}
}
