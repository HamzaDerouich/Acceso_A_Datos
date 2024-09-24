package ficheros.ejercicios;

import java.io.File;
import java.util.Comparator;

public class ComparatorTamaño implements Comparator<File> {

	 @Override
	    public int compare(File o1, File o2) {
	        return Long.compare(o2.length(), o1.length());
	    }
}
