package com.spotify.music.event;

import com.spotify.music.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MetricMusicPlaylistProducer {

    private static final Logger log = LoggerFactory.getLogger(MetricMusicPlaylistProducer.class);

    private final RabbitTemplate rabbitTemplate;


    public MetricMusicPlaylistProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MetricMusicPlaylistData data) {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_METRIC_PLAYLIST, data);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MetricMusicPlaylistData {
        private Long musicId;
        private String operationId;
    }


}