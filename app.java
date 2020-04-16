import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
class app {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>(Arrays.asList("nouuur", "marwen", "faress", "blabla"));
		Iterator<String> iter = names.iterator();
		while (iter.hasNext()) {
			new MyFrame(iter.next(), names);
		}
	}

}
