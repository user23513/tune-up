package co.up.tune.webSocket.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import co.up.tune.emp.vo.EmpVO;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class WebSocketHandler extends TextWebSocketHandler {

	//로그인한 인원 전체
	private static List<WebSocketSession> sessions = new ArrayList<>();
	//1:1로 할 경우
	private Map<String, WebSocketSession> userSessionsMap = new HashedMap<String, WebSocketSession>();
	
	 /* Client가 접속 시 호출되는 메서드 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("소켓 연결");
		sessions.add(session);
		log.info(currentUserName(session)); //현재 접속한 사람
		String senderId = currentUserName(session);
		userSessionsMap.put(senderId, session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("ssesion"+currentUserName(session));
		String msg = message.getPayload(); //자바스크립트에서 넘어온 msg
		log.info("msg="+msg);
		
		if(!StringUtils.isEmpty(msg)) {
			log.info("if문 들어옴?");
			String[] strs = msg.split(",");
			if(strs != null && strs.length == 6) {
				String cmd = strs[0];
				String replyWriter = strs[1];
				String boardWriter = strs[2];
				String bno = strs[3];
				String title = strs[4];
				String bgno = strs[5];
				log.info("length성공?"+cmd);
				
				WebSocketSession replyWriterSession = userSessionsMap.get(replyWriter);
				WebSocketSession boardWriterSession = userSessionsMap.get(boardWriter);
				log.info("boardWriterSession="+userSessionsMap.get(boardWriter));
				log.info("boardWirterSession"+boardWriterSession);
				
				//댓글
				if ("reply".equals(cmd) && boardWriterSession != null) {
					log.info("onmessage되나?");
					TextMessage tmpMsg = new TextMessage(replyWriter + "님이 "
							+ "<a href='/board/readView?bno="+ bno +"&bgno="+bgno+"'  style=\"color: black\">"
							+ title+" 에 댓글을 달았습니다!</a>");
					boardWriterSession.sendMessage(tmpMsg);
				}
			}
		}
	}

	/* Client가 접속 해제 시 호출되는 메서드드 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("Socket 끊음");
		sessions.remove(session);
		userSessionsMap.remove(currentUserName(session),session);
	}
	
	private String currentUserName(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		EmpVO loginUser = (EmpVO) httpSession.get("login");
		
		if(loginUser == null) {
			String mid = session.getId();
			return mid;
		}
		
		String mid = loginUser.getId();
		return mid;
	}
	
	
}
