package com.nowon.bullti.domain.entity.chatbot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatBotIntentionRepository extends JpaRepository<ChatBotIntention, Long>{

	Optional<ChatBotIntention> findByNameAndUpper(String token, ChatBotIntention upper);

}
