import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class SocketServer {

    public static void main(String[] args) {
//        System.out.println(System.nanoTime());
        Configuration config = new Configuration();
        // ���������setHostname��������ֻ��ͨ�����������ʣ�����ͨ��IP����
        //config.setHostname("localhost");
        config.setPort(9010); // ���ü����˿�

        final SocketIOServer server = new SocketIOServer(config);
        // ���������ͨ�ļ����¼�
        server.addConnectListener(client -> {
            System.out.println(client.getSessionId().toString()+"������");
        });

        // ������ӶϿ��ļ����¼�
        server.addDisconnectListener(client -> {
            System.out.println(client.getSessionId().toString()+"�ѶϿ�");
        });
                /*
        *
        * new DataListener<String>() {
            @Override
            public void onData(SocketIOClient socketIOClient, String s, AckRequest ackRequest) throws Exception {

            }
        }*/
        // ����ı����͵��¼�������
        server.addEventListener("send_text", String.class, (client, message, ackSender) -> {
            System.out.println(client.getSessionId().toString()+"�����ı���Ϣ��"+message);
            client.sendEvent("receive_text", "���������Ҳ���������û����˭��Ҳ������");
        });
        // ���ͼ���͵��¼�������
        server.addEventListener("send_image", JSONObject.class, (client, json, ackSender) -> {
            String desc = String.format("%s�����Ϊ%d", json.getString("name"), json.getIntValue("seq"));
            System.out.println(client.getSessionId().toString()+"����ͼƬ��Ϣ��"+desc);
            client.sendEvent("receive_image", json);
        });
        server.addEventListener("send_image", JSONObject.class, new DataListener<JSONObject>() {
            @Override
            public void onData(SocketIOClient socketIOClient, JSONObject jsonObject, AckRequest ackRequest) throws Exception {

            }
        });
        server.start(); // ����Socket����
    }

}
