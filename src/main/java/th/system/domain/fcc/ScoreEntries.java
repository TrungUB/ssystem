package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.ScoreEntry;

public class ScoreEntries implements Entities<ScoreEntry> {
    private Map<String, ScoreEntry> scoreEntriesMap;
    
    public ScoreEntries(List<ScoreEntry> scoreEntries) {
        scoreEntriesMap = new HashMap<>();
        if (scoreEntries != null) {
            scoreEntries.forEach(e -> add(e));
        }
    }
    
    @Override
    public List<ScoreEntry> getAll() {
        return new ArrayList<>(scoreEntriesMap.values());
    }
    
    @Override
    public ScoreEntries add(ScoreEntry entry) {
        scoreEntriesMap.put(entry.getSubjectId(), entry);
        return this;
    }

    @Override
    public boolean isEmpty() {
        return scoreEntriesMap.isEmpty();
    }

    @Override
    public boolean contains(String subjectId) {
        return scoreEntriesMap.containsKey(subjectId);
    }
    
    @Override
    public ScoreEntry findById(String subjectId) {
        return scoreEntriesMap.get(subjectId);
    }

    @Override
    public Entities<ScoreEntry> delete(String id) {
        scoreEntriesMap.remove(id);
        return this;
    }
}
