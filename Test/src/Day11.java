import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Day11 {
    public static void main(String[] args) throws IOException {
    //io流
        FileOutputStream fos=new FileOutputStream("d://te.txt");
        fos.write("97".getBytes(StandardCharsets.UTF_8));
        fos.close();

    }
}
