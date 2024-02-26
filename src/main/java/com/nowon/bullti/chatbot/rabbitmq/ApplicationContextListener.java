package com.nowon.bullti.chatbot.rabbitmq;

import java.util.Vector;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//어플리케이션 종료 시 실행 되는 클래스
@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationContextListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
    	//SimpleMessageListenerContainer 종료
    	Vector<SimpleMessageListenerContainer> containers = RabbitMQService.simpleMessageListenerContainerActivateList;
    	log.debug(">>리스너 컨테이너 종료"+containers);
    	containers.forEach(container->container.stop());
    }
}