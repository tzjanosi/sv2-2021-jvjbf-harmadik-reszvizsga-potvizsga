package contentsite;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContentService {
    private Set<User> userSet=new LinkedHashSet<>();
    private Set<Content> contentSet=new LinkedHashSet<>();

    public void registerUser(String name, String password){
        User user=new User(name,password);
        if(userSet.contains(user)){
            throw new IllegalArgumentException("Username is already taken: "+name);
        }
        userSet.add(user);
    }

    public void addContent(Content content){
        if(isContentWithThisTitle(content.getTitle())){
            throw new IllegalArgumentException("Content name is already taken: "+content.getTitle());

        }
        contentSet.add(content);

    }
    public void logIn(String username, String password){
        String tempPass=new User(username, password).getPassword();
        User candidate=findUserByUserName(username);
        if(candidate.getPassword().equals(tempPass)){
            candidate.setLogIn(true);
        }
        else{
            throw new IllegalArgumentException("Password is Invalid!");
        }


    }
    private User findUserByUserName(String username){
        for(User user:userSet){
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        throw new IllegalArgumentException("Username is wrong!");
    }

    boolean isContentWithThisTitle(String title){
        for(Content content:contentSet){
            if(content.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    public void clickOnContent(User user, Content content){
        if(!user.isLogIn()){
            throw new IllegalStateException("Log in to watch this content!");
        }
        if(!user.isPremiumMember() && content.isPremiumContent()){
            throw new IllegalStateException("Upgrade for Premium to watch this content!");
        }

        content.click(user);
    }

    public Set<User> getAllUsers() {
        return userSet;
    }

    public Set<Content> getAllContent() {
        return contentSet;
    }
}
