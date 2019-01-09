package org.world.origin.socket;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年10月9日
 * *********************************************
 * </pre>
 */
//@Configuration
//注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
//@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	/**
	 * 表示注册STOMP协议的节点，并指定映射的URL
	 * @date 2017年10月9日
	 * @author darwin du
	 * @param stompEndpointRegistry
	 */
	@Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。 
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();
    }

	/**
	 * 用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
	 * @date 2017年10月9日
	 * @author darwin du
	 * @param registry
	 */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }

}
