package model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMapperJSON implements NotesMapper {

    @Override
    public String map(List<Note> list) {
        List<Map<String, String>> result = new ArrayList<>();
        Gson gson = new Gson();

        for (Note note : list) {
            Map<String, String> map = new HashMap<>();
            map.put("id", note.getId());
            map.put("head", note.getHead());
            map.put("text", note.getText());
            result.add(map);
        }

        return gson.toJson(result);
    }

    @Override
    public List<Note> map(String text) throws Exception {
        Gson gson = new Gson();
        List<Note> list = new ArrayList<>();

        List<Map<String, String>> listGSON;

        try {
            listGSON = gson.fromJson(text, ArrayList.class);

            if (listGSON == null) {
                return list;
            }

            for (Map<String, String> map : listGSON) {
                String id = map.get("id");
                String head = map.get("head");
                String textNote = map.get("text");

                Note note = new Note(id, head, textNote);
                list.add(note);
            }
        } catch (Exception e) {
            throw new Exception("Файл некорректный");
        }
        return list;
    }
}