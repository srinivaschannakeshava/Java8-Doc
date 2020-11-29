package in.srini91.learn.java8.lambda;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Paths;

public class FileFilterEx {

	public static void main(String[] args) {
		// Normal way of writing anonymous class
		FileFilter javaFileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		// Lambda way of writing anonymous class
		FileFilter javaLamdaFileFilter = (File pathName) -> pathName.getName().endsWith(".java");

		File file = Paths.get("C:\\th135e\\Learning\\workspace\\javaWebApp\\src\\main\\java\\in\\srini\\learn")
				.toFile();
		File[] javaFilesOnly = file.listFiles(javaFileFilter);
		for (File f : javaFilesOnly) {
			System.out.println(f);
		}
	}
}
