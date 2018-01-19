package org.jee8ng.chat.boundary;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author prashantp.org
 */
@ServerEndpoint(value = "/chat")
public class ChatEndpoint {

    private static final Set<Session> SESSIONS = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void open(final Session session) {
        SESSIONS.add(session);
    }

    @OnMessage
    public void message(final Session session, String msg) {
        System.out.println("msg: " +msg);
        SESSIONS.stream().filter(Session::isOpen)
                .forEach(s -> {
                    try {
                        s.getBasicRemote().sendObject(msg);
                    } catch (Exception ex) {
                        Logger.getLogger(ChatEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
    }

    @OnClose
    public void close(Session session) {
        SESSIONS.remove(session);
    }

}
