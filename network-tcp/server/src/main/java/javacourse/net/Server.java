package javacourse.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(25225);

        Map<String, Greeatable> handlers = loadHandlers();

        System.out.println("Server is started");

        while (true) {
            Socket client = socket.accept();
            new SimpleServer(client, handlers).start();
        }

    }

    private static Map<String, Greeatable> loadHandlers() {
        Map<String, Greeatable> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader().getResourceAsStream("server.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            for(Object command : properties.keySet()) {
                String className = properties.getProperty(command.toString());
                Class<Greeatable> cl = (Class<Greeatable>) Class.forName(className);
                Greeatable handler = cl.getConstructor().newInstance();
                result.put(command.toString(),handler);
            }
        }


        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        return result;
    }

}

class SimpleServer  extends Thread {

    private Socket client;
    private Map<String, Greeatable> handlers;


    public SimpleServer(Socket client, Map<String, Greeatable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    public void run() {
        handleRequest();
    }
        private  void handleRequest() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));


                String request = br.readLine();
                String[] lines = request.split("\\s+");
                String command = lines[0];
                String userName = lines[1];
                System.out.println("Server got string 1: " + command);
                System.out.println("Server got string 2: " + userName);
//                Thread.sleep(2000);

                String response = buildResponse(command, userName);
                bw.write(response);
                bw.newLine();
                bw.flush();

                br.close();
                bw.close();

                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        private String buildResponse(String command, String userName) {
        Greeatable handler = handlers.get(command);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hello, " + userName;

    }
}




































