package com.spotify.music.service;

import com.spotify.music.event.MetricMusicPlaylistProducer;
import com.spotify.music.model.Music;
import com.spotify.music.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicService {

    private final MetricMusicPlaylistProducer metricMusicPlaylistProducer;
    private final MusicRepository musicRepository;

    public MusicService(MetricMusicPlaylistProducer metricMusicPlaylistProducer, MusicRepository musicRepository) {
        this.metricMusicPlaylistProducer = metricMusicPlaylistProducer;
        this.musicRepository = musicRepository;
    }

    public void save(Music music) {
        musicRepository.save(music);
    }


    public List<Music> getAll() {
        return musicRepository.findAll();
    }

    public Music getById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }


    public void deleteById(Long id) {
        musicRepository.deleteById(id);
    }

    public void update(Music music) {
        if(musicRepository.existsById(music.getMusicId())){
            musicRepository.save(music);
        }
    }

    public String getMetricsMusic(Long musicId) {
        String operationId = UUID.randomUUID().toString();
        metricMusicPlaylistProducer.sendMessage(new MetricMusicPlaylistProducer.MetricMusicPlaylistData(musicId,operationId));
        return operationId;
    }


}
