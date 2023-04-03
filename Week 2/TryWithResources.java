import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileInputStream fin = new FileInputStream("Notes.txt");
			FileOutputStream fout = new FileOutputStream("CopyFile.txt");){
			int x;
			while((x=fin.read())!= -1)
				fout.write(x);
			System.out.println("FILE COPIED SUCCESSFULLY WITH RESOURCE TRY!");
		}catch(FileNotFoundException e){
			System.out.println("Exception caught :"+ e.getMessage());
		}catch(IOException e){
			System.out.println("Exception caught :"+ e.getMessage());
		}
    }
}
