package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.ScoreEntry;

public class ScoreEntries {
    private Map<String, ScoreEntry> scoreEntriesMap;
    
    public ScoreEntries(List<ScoreEntry> scoreEntries) {
        scoreEntriesMap = new HashMap<>();
        if (scoreEntries != null) {
            scoreEntries.forEach(e -> addEntry(e));
        }
    }
    
    public List<ScoreEntry> getAll() {
        return new ArrayList<>(scoreEntriesMap.values());
    }
    
    public ScoreEntries addEntry(ScoreEntry entry) {
        scoreEntriesMap.put(entry.getSubjectId(), entry);
        return this;
    }

    public boolean isEmpty() {
        return scoreEntriesMap.isEmpty();
    }

    public boolean containsSubject(String subjectId) {
        return scoreEntriesMap.containsKey(subjectId);
    }
    
    public ScoreEntry findEntryById(String subjectId) {
        return scoreEntriesMap.get(subjectId);
    }
}
