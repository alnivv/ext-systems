import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;

public class testIO {

    public static void main(String[] args) {
        final String fileName = "C:\\Users\\pleha\\Desktop\\temp\\first.txt";    // Подставить имя текстового файла

        readFile(fileName, "UTF-8");          // Читаем в кодировке UTF-8
        System.out.println();
        readFile(fileName, "windows-1251");   // Читаем в кодировке Windows-1251
    }

    private static void readFile(String fileName, String charset) {
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charset));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
