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

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class WebSocketHandler extends TextWebSocketHandler {

	//로그인한 인원 전체
	private static List<WebSocketSession> sessions = new ArrayList<>();
	//1:1로 할 경우
	private Map<String, WebSocketSession> userSessionsMap = new HashedMap<String, WebSocketSession>();
	
	/* Client가 접속 시 호출되는 메서드, 서버에 접속이 성공 했을 때 */
	//String senderId = (String) session.getAttributes().get("sessionId");
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		String senderId = getId(session); //현재 접속한 사람 empNo
		userSessionsMap.put(senderId, session);
	}

	/* 소켓에 메세지를 보냈을 때 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//protocol : cmd , 댓글작성자, 게시글 작성자 , seq (reply , user2 , user1 , 12)
		String senderId = getId(session);
		//자바스크립트에서 넘어온 msg
		String msg = message.getPayload(); 
		//메세지가 비어있지 않을 때
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = msg.split(",");
			
			if(strs != null && strs.length == 6) {
				String cmd = strs[0]; //댓글인지 게시글인지	
				String caller = strs[1]; //메세지 남긴 사람 이름
				String receiver = strs[2]; //메세지 받는 사람 이름
				String receiverNo = strs[3]; //메세지 받는 사람 사원번호
				String postNo = strs[4]; //게시글 번호
				String postTitle = strs[5]; //게시글 제목
				
				//작성자가 로그인 해서 있다면
				WebSocketSession boardWriterSession = userSessionsMap.get(receiverNo); //메세지를 받을 세션 조회
				
				//댓글 (cmd == reply)
				if ("reply".equals(cmd) && boardWriterSession != null) {
					TextMessage tmpMsg = new TextMessage(caller + 
							"님이 <a id=freeTitle data-no="+postNo+" href=javascript:void(0); onClick=freeTitle()>["+postTitle+"]</a>게시글에 댓글을 남겼습니다.");
					//"<a type='external' href='/mentor/menteeboard/menteeboardView?seq="+seq+"&pg=1'>" + seq + "</a> 번 게시글에 댓글을 남겼습니다."
					boardWriterSession.sendMessage(tmpMsg);
				}
			}else if(strs != null && strs.length == 1) {
				//모든 유저에게 보낸다 - 브로드 캐스팅
				String cmd = strs[0];
				for (WebSocketSession sess : sessions) {
					sess.sendMessage(new TextMessage("게시글 관리자님이 <a type='external' href='/noticeList class='link-danger'>공지게시글</a>에 긴급공지를 등록했습니다."));
				}
			}
		}
	}

	/* Client가 접속 해제 시 호출되는 메서드, 연결 해제될 때 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		userSessionsMap.remove(getId(session));
	}
	
	//웹소켓 ID 가져오기
	private String getId(WebSocketSession session) {
		//String senderId = (String) session.getAttributes().get("sessionId");
		String httpSession = (String) session.getAttributes().get("empNo");
		//EmpVO loginUser = (EmpVO)httpSession.get("id");
//		log.info(loginUser);
//		
		if(httpSession == null) {
			return session.getId();
		}else {
			return httpSession;
		}
	}
	
	
}
