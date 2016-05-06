package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.ScoreEntry;

public class ScoreEntries {
    private List<ScoreEntry> scoreEntries;
    private Map<String, ScoreEntry> scoreEntriesMap;
 
    public ScoreEntries(List<ScoreEntry> scoreEntries) {
        this.scoreEntries = new ArrayList<>(scoreEntries);
        scoreEntriesMap = new HashMap<>();
        this.scoreEntries.forEach(e -> scoreEntriesMap.put(e.getSubjectId(), e));
    }
    
    public List<ScoreEntry> getAll() {
        return new ArrayList<>(scoreEntries);
    }

    public ScoreEntries addEntry(ScoreEntry entry) {
        if(!scoreEntriesMap.containsKey(entry.getSubjectId())) {
            scoreEntries.add(entry);
        }
        scoreEntriesMap.put(entry.getSubjectId(), entry);    
        return this;
    }
}
