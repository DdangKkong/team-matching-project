package zerobase.matching.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

//    @Autowired
//    private StompHandler stompHandler;
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // addEndpoint : 소켓 연결 URI -> Socket연결을 위한 것
        // setAllowedOriginPatterns : CORS 설정
        // withSockJS : 소켓을 지원하지 않는 브라우저이면 SockJS 사용하도록 설정
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*")
//                .withSockJS()
        ;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 내장 브로커 사용
        // queue(sub)는 1:1 , topic은 1:N  채팅방에 구독을 한다는 생각
        registry.enableSimpleBroker("/sub", "/topic");

        // 해당 prefix가 붙은 경로일 때, 메세지 핸들러로 전달, pub
        // 채팅방 구독한 인원들에게 메세지 전달
        registry.setApplicationDestinationPrefixes("/pub");
    }
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) { // 핸들러 등록
//        // connect / disconnect 인터셉터
//        registration.interceptors(stompHandler);
//    }
}
