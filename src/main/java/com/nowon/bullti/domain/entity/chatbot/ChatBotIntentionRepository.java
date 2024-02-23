package com.nowon.bullti.domain.entity.chatbot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatBotIntentionRepository extends JpaRepository<ChatBotIntention, Long>{

	Optional<ChatBotIntention> findByNameAndUpper(String token, ChatBotIntention upper);


    // 해당 행의 name 값만을 반환하는 쿼리 메서드
    @Query("SELECT c.name FROM ChatBotIntention c WHERE c.upper.no = :upperNo")
    List<String> findNamesByUpperNo(@Param("upperNo") long upperNo);


	Optional<ChatBotIntention> findByName(String Name);

}
