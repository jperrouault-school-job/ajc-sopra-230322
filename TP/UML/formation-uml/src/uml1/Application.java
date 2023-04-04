package uml1;

public class Application {
	public static void main(String[] args) {
		for (Os o : Os.values()) {
			System.out.println(o);
			System.out.println(o.getAnnee());
		}
		
		System.out.println("----------");
		
		Os os = Os.WINDOWS;
		System.out.println(os.getAnnee());
	}
}
