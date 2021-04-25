import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket ("api.openweathermap.org", 80);
        InputStream response = socket.getInputStream();
        OutputStream request = socket.getOutputStream();

        byte [] data = ("GET /data/2.5/weather?q=Finland&appid=fa11a742a4d2e48ad88945dcea73facb HTTP/1.1\n"
        + "Host: api.openweathermap.org\n\n").getBytes();

        request.write(data);

        int c;

        while((c = response.read()) != -1){
            System.out.print((char) c);
        }

        socket.close();

    }
}
