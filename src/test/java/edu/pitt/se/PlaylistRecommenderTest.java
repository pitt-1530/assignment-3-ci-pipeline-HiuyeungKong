package edu.pitt.se;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    public void classifyEnergy() {
        List<Integer> bpms = List.of(150, 145, 155);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void classifyEnergyNullInput() {
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void isValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Summer Night"));
    }

    @Test
    public void isValidTrackTitleSpecialChar() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Party!"));
    }

    @Test
    public void normalizeVolumeAboveRange() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
    }

    @Test
    public void normalizeVolumeBelowRange() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-20));
    }
}
