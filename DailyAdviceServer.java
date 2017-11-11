import java.io.*;
import java.net.*;


public class DailyAdviceServer {

    String [] adviceList = {"Ешьте меньшими порциями",
                    "Купите облегчающие джинсы. Нет, они не делают вас полнее.",
                    "Два слова: не годится.",
                    "Будьте честны хотя бы сегодня. ",
                    "Скажите начальнику всё, что вы на самом ",
                    "деле о нём думаете",
                    "Возможно, вам стоит подобрать другую причёску"};
    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
