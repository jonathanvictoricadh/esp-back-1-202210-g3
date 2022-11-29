package com.spotify.playlist.event;

import com.spotify.playlist.config.RabbitMQConfig;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class MetricMusicPlaylistConsumer {

    private static final Logger log = LoggerFactory.getLogger(MetricMusicPlaylistConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PLAYLIST)
    public void receiveMessage(final MetricMusicPlaylistData message) {
        log.info("Received message as a generic AMQP 'Message' wrapper: {}", message.operationId);
    }

    @Getter
    @Setter
    public static class MetricMusicPlaylistData {
        private Long musicId;
        private String operationId;
    }

}
