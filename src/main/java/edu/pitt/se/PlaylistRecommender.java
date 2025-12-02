package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list must not be null or empty");
        }

        double average = bpms.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Unable to compute BPM average"));

        if (average >= 140) {
            return "HIGH";
        }
        if (average >= 100) {
            return "MEDIUM";
        }
        return "LOW";
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
        if (title == null) {
            return false;
        }

        String trimmed = title.trim();
        if (trimmed.isEmpty() || title.length() > 30) {
            return false;
        }

        return title.matches("^[A-Za-z ]{1,30}$");
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
        if (volumeDb < 0) {
            return 0;
        }
        if (volumeDb > 100) {
            return 100;
        }
        return volumeDb;
    }
}
