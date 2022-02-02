package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Podcast implements Content{
    private String title;
    private List<String> contributors;
    private List<User> clickers=new ArrayList<>();

    public Podcast(String title, List<String> contributors) {
        this.title = title;
        this.contributors = contributors;
    }

    @Override
    public boolean isPremiumContent() {
        return false;
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

    public List<String> getSpeakers() {
        return contributors;
    }
}
