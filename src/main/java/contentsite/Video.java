package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Video implements Content{
    private String title;
    private int length;
    private List<User> clickers=new ArrayList<>();

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean isPremiumContent() {
        return length>15;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(clickers);
    }

    @Override
    public void click(User user) {
        clickers.add(user);
    }
}
